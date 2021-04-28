package lesson01.home;

import static java.lang.System.*;

public class Homework01 {
    public static void main(String[] args) {
        calculate();
        CheckNumber();
        CheckNumber2();
        Welcome();
        Year();
    }
    //  Задание №1
    private static void calculate() {
        int a = 18;
        int b = 13;
        int c = 113;
        int d = 56;
        float result = (a + (b + (c * 1.0f / d)));
        System.out.println("Результат задания 1: " + result);
    }
    // Задание №2
    private static void CheckNumber(){
        int aa = 8;
        int bb = 10;
        if ((aa + bb) >= 10 && (aa + bb) <= 20) {
            System.out.println("Результат задания 2: True");
        } else {
            System.out.println("Результат задания 2: False");
        }
    }
    //Задание №3
    private static void CheckNumber2() {
        int cc = -1;
        if (cc >= 0) {
            System.out.println("Результат задания 3: True");
        } else {
            System.out.println("Результат задания 3: False");
        }
    }
    //Задание №4
    private static void Welcome() {
        String welcome = "Somename";
        System.out.println("Результат задания 4: " + welcome);
    }
    //Задание №5
    private static void Year() {
        int year = 2021;
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)){
            System.out.println("Результат задания 5: Год високосный? True");
        } else {
            System.out.println("Результат задания 5: Год високосный? False");
        }
    }
}
