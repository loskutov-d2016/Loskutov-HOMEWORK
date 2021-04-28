package Lesson03.home;
import java.util.Scanner;
import java.util.Random;


public class Homework03 {
    public static char[][] map;
    public static int sizeMapX;
    public static int sizeMapY;

    public static char human = 'X';
    public static char ai = '0';
    public static char empty = '*';

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void createMap(int sizeX, int sizeY) {
        sizeMapX = sizeX;
        sizeMapY = sizeY;
        map = new char[sizeMapY][sizeMapX];

        for (int y = 0; y < sizeMapY; y++) {
            for (int x = 0; x < sizeMapX; x++) {
                map[y][x] = empty;
            }
        }
    }

    public static void printMap() {
        System.out.println("--------------------");
        for (int y = 0; y < sizeMapY; y++) {
            for (int x = 0; x < sizeMapX; x++) {
                System.out.print(map[y][x] + " | ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public static void turnHuman() {
        int x, y;
        do {
            System.out.print("Please write your X - coordinates: ");
            x = scanner.nextInt() - 1;
            System.out.print("Please write your Y - coordinates: ");
            y = scanner.nextInt() - 1;
        } while (!validCell(y, x) || (!emptyCell(y, x)));
        map[x][y] = human;
    }

    public static boolean validCell(int y, int x) {
        return x >= 0 && x < sizeMapX && y >= 0 && y < sizeMapY;
    }

    public static boolean emptyCell(int y, int x) {
        return map[y][x] == empty;
    }

    public static void turnAi() {
        int x, y;
        do {
            x = random.nextInt(sizeMapX);
            y = random.nextInt(sizeMapY);

        } while (!emptyCell(y, x));
        map[y][x] = ai;
    }
    // нужно сделать через вектор, пока не разобрался.
    public static boolean checkWin(char player) {
        if (map[0][0] == player && map[0][1] == player && map[0][2] == player && map[0][3] == player) return true;
        if (map[0][4] == player && map[0][3] == player && map[0][2] == player && map[0][1] == player) return true;
        if (map[1][0] == player && map[1][1] == player && map[1][2] == player && map[1][3] == player) return true;
        if (map[1][4] == player && map[1][3] == player && map[1][2] == player && map[1][1] == player) return true;
        if (map[2][0] == player && map[2][1] == player && map[2][2] == player && map[2][3] == player) return true;
        if (map[2][4] == player && map[2][3] == player && map[2][2] == player && map[2][1] == player) return true;
        if (map[3][0] == player && map[3][1] == player && map[3][2] == player && map[3][3] == player) return true;
        if (map[3][4] == player && map[3][3] == player && map[3][2] == player && map[3][1] == player) return true;
        if (map[4][0] == player && map[4][1] == player && map[4][2] == player && map[4][3] == player) return true;
        if (map[4][4] == player && map[4][3] == player && map[4][2] == player && map[4][1] == player) return true;

        if (map[0][0] == player && map[1][0] == player && map[2][0] == player && map[3][0] == player) return true;
        if (map[4][0] == player && map[3][0] == player && map[2][0] == player && map[1][0] == player) return true;
        if (map[0][1] == player && map[1][1] == player && map[2][1] == player && map[3][1] == player) return true;
        if (map[4][1] == player && map[3][1] == player && map[2][1] == player && map[1][1] == player) return true;
        if (map[0][2] == player && map[1][2] == player && map[2][2] == player && map[3][2] == player) return true;
        if (map[4][2] == player && map[3][2] == player && map[2][2] == player && map[1][2] == player) return true;
        if (map[0][3] == player && map[1][3] == player && map[2][3] == player && map[3][3] == player) return true;
        if (map[4][3] == player && map[3][3] == player && map[2][3] == player && map[1][3] == player) return true;
        if (map[0][4] == player && map[1][4] == player && map[2][4] == player && map[3][4] == player) return true;
        if (map[4][4] == player && map[3][4] == player && map[2][4] == player && map[1][4] == player) return true;

        if (map[0][0] == player && map[1][1] == player && map[2][2] == player && map[3][3] == player) return true;
        if (map[4][4] == player && map[3][3] == player && map[2][2] == player && map[1][1] == player) return true;
        if (map[0][4] == player && map[1][3] == player && map[2][2] == player && map[3][1] == player) return true;
        if (map[4][0] == player && map[3][1] == player && map[2][2] == player && map[1][3] == player) return true;
        return false;
    }

//public static boolean checkWin(char player) {
//        if (map[0][0] == player && map[0][1] == player && map[0][2] == player) return true;
//        if (map[1][0] == player && map[1][1] == player && map[1][2] == player) return true;
//        if (map[2][0] == player && map[2][1] == player && map[2][2] == player) return true;
//
//        if (map[0][0] == player && map[1][0] == player && map[2][0] == player) return true;
//        if (map[0][1] == player && map[1][1] == player && map[2][1] == player) return true;
//        if (map[0][2] == player && map[1][2] == player && map[2][2] == player) return true;
//
//        if (map[0][0] == player && map[1][1] == player && map[2][2] == player) return true;
//        if (map[0][2] == player && map[1][1] == player && map[2][0] == player) return true;
//
//        return false;
//    }


    public static boolean isDrow() {
        for (int y = 0; y < sizeMapY; y++) {
            for (int x = 0; x < sizeMapX; x++) {
                if (map[y][x] == empty) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        createMap(5, 5);
        printMap();

        while (true) {
            turnHuman();
            printMap();
            if (checkWin(human)) {
                System.out.println("Human win!");
                break;
            }
            if (isDrow()) {
                System.out.println("Draw!");
                break;
            }

            turnAi();
            printMap();
            if (checkWin(ai)) {
                System.out.println("Ai win!");
                break;
            }
            if (isDrow()) {
                System.out.println("Draw!");
                break;
            }
        }
    }
}
