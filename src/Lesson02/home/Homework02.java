package Lesson02.home;
import java.util.Arrays;

public class Homework02 {
    public static void main(String[] args) {
        //задание №1
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("1. Before:\t" + Arrays.toString(array1));
        change(array1);
        System.out.println("1. After:\t" + Arrays.toString(array1));
        //задание №2
        int[] arrInt = new int[8];
        fillIn(arrInt);
        System.out.println("2. Filled with cycle:\t" + Arrays.toString(arrInt));
        // задание №3
        int[] mas = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("3. Before:\t" + Arrays.toString(mas));
        doubling(mas);
        System.out.println("3. After:\t" + Arrays.toString(mas));
        //задание №4
        int side = 3;
        int [][] dArr = new int [side][side];
        crossFile(dArr);
        printArraySize2(dArr);
        //задание №5
        System.out.println("5. Maximum: " + findMax(mas));
        System.out.println("5. Minimum: " + findMin(mas));
        //задание №6
        int[] shiftArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("6. " + Arrays.toString(shiftArray));
        shifter(shiftArray, -3);
        System.out.println("-3" + Arrays.toString(shiftArray));
        shifter(shiftArray,6);
        System.out.println("+6" + Arrays.toString(shiftArray));
    }
    //задание №1
    public static void change(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
    }

    //задание №2
    public static void fillIn(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = i * 3 + 1;
    }

    //задание №3
    public static void doubling(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] < 6) {
                array[i] *= 2;
            }
    }

    //задание №4
    public static void crossFile(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }
    }

    public static void printArraySize2(int[][] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                System.out.print(inputArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    //задание №5
    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }

    //задание №6
    public static void shifter(int[] array, int value) {
        boolean direction;
        if (value < 0) {
            direction = true;
            value = -value;
        } else {
            direction = false;
        }
        value %= array.length;
        int lastIndex = array.length - 1;
        for (int i = 0; i < value; i++) {
            int temp = (direction) ? array[0] : array[lastIndex];
            for (int j = 0; j < lastIndex; j++) {
                if (direction)
                    array[j] = array[j + 1];
                else
                    array[lastIndex - j] = array[lastIndex - j - 1];
            }
            if (direction)
                array[lastIndex] = temp;
            else
                array[0] = temp;
        }
    }
}

