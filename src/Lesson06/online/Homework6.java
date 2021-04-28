package Lesson06.online;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Homework6 {
    static String ABC = "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ";
    static Random rnd = new Random();

    public static void main(String[] args) {
        createFile("TEST01.txt",createString(100));
        createFile("TEST02.txt",createString(100));
    }
    public static String createString(int len){
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++){
            sb.append(ABC.charAt(rnd.nextInt(ABC.length())));
        }
        return sb.toString();
    }

    public static void createFile(String fileName, String text){
        try{
            PrintWriter pw = new PrintWriter(fileName);
            pw.write(text);
            pw.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}