package Lesson06.home;
import java.io.*;
import java.util.Random;

public class Homework06 {
    private static final Random RND = new Random();
    private static final int MAX_LENGTH = 100;
    private static final int CHAR_BOUND_L = 65;
    private static final int CHAR_BOUND_H = 90;
    private static final int FILES_AMOUNT = 3;
    private static final int WORDS_AMOUNT = 5;
    private static final int WORD_LENGTH = 10;
    private static final String SEARCH = "FIND_ME";

    private static FileOutputStream fos;
    private static FileInputStream fis;

    private static String generateSymbols(int amount) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < amount; i++)
            sequence.append((char) (CHAR_BOUND_L + RND.nextInt(CHAR_BOUND_H - CHAR_BOUND_L)));
        return sequence.toString();
    }

    private static void writeFileContents(String Test, int length) {
        try {
            fos = new FileOutputStream(Test);
            fos.write(generateSymbols(length).getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.err.println("Something wrong " + Test + " Reason: " + e.getCause());
        }
    }

    private static void writeFileContents(String Test, int words, int length) {
        try {
            fos = new FileOutputStream(Test);
            for (int i = 0; i < words; i++) {
                if (RND.nextInt(WORDS_AMOUNT) == WORDS_AMOUNT / 2)
                    fos.write(SEARCH.getBytes());
                else
                    fos.write(generateSymbols(length).getBytes());
                fos.write(' ');
            }
            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.err.println("Something wrong " + Test + " Reason: " + e.getCause());
        }

    }

    private static void mergeFiles(String inputTest1, String inputTest2, String Result) {
        try {
            fos = new FileOutputStream(Result);
            int ch;
            fis = new FileInputStream(inputTest1);
            while ((ch = fis.read()) != -1)
                fos.write(ch);
            fis.close();

            fis = new FileInputStream(inputTest2);
            while ((ch = fis.read()) != -1) {
                fos.write(ch);
            }
            fis.close();

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.err.println("Something wrong. Reason: " + e.getCause());
        }
    }

    private static boolean searchInFile(String Test, String search) throws IOException {
        fis = new FileInputStream(Test);
        byte[] searchSequence = search.getBytes();
        int ch;
        int i = 0; //FINFIND_ME
        while ((ch = fis.read()) != -1) {
            if (ch == searchSequence[i]) {
                i++;
            } else {
                i = 0;
                if (ch == searchSequence[i]) {
                    i++;
                }
            }
            if (i == searchSequence.length) {
                fis.close();
                return true;
            }
        }
        fis.close();
        return false;
    }

    private static String[] searchMatch(String[] test, String search) throws IOException {
        String[] list = new String[test.length];
        int count = 0;
        File path = new File(new File(".").getCanonicalPath());
        File[] dir = path.listFiles();
        for (int i = 0; i < dir.length; i++) {
            if (dir[i].isDirectory()) {
                continue;
            }
            for (int j = 0; j < test.length; j++) {
                if (dir[i].getName().equals(test[j])) {
                    if (searchInFile(dir[i].getName(), search)) {
                        list[count] = dir[i].getName();
                        count++;
                        break;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

        String[] test = new String[FILES_AMOUNT];
        for (int i = 0; i < test.length; i++)
            test[i] = "TEST-" + i + ".txt";

        //1 задание
        for (int i = 0; i < test.length; i++)
            if (i < 2)
                writeFileContents(test[i], MAX_LENGTH);
            else
                writeFileContents(test[i], WORDS_AMOUNT, WORD_LENGTH);
        System.out.println("Задание №1: Test-0 и Test-1.");


        //2 задание
        mergeFiles(test[0], test[1], "RESULT.txt");
        System.out.println("Задание №2: RESULT = Test-0 + Test-1.");

        //3 задание
        try {
            System.out.println("В файле Test_2 есть ли совпадение? " + searchInFile(test[2], SEARCH));
            //#4
            System.out.println("Задание №3 проверка совпадения слова во всех файлах!");
            String[] result = searchMatch(test, SEARCH);
            for (int i = 0; i < result.length; i++)
                if (result[i] != null)
                    System.out.println("Файл " + result[i] + " содержит искомое слово " + SEARCH);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
