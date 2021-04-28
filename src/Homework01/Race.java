package Homework01;

public class Race {
    public static void main(String[] args) {

        String tempWinEvent = " это получилось";
        String tempLossEvent = " это не получилось";
        String eventName;
        String eventResult;

        Cat cat1 = new Cat("Васька", 2, 200);
        Cat cat2 = new Cat( "Мурка", 3, 150);
        Human human = new Human("Александр", 0.5f, 600);
        Human human2 = new Human("Ольга", 0.4f, 350);
        Robot robot = new Robot("РОБОТ №1", 1, 400);
        Robot robot1 = new Robot("РОБОТ №2", 2, 150);


        Group[] arr = {cat1, cat2, human, human2, robot,robot1};
        float jumpLength = 2.5f;
        float runLength = 250;
        float swimLength = 8;

        for (int i = 0; i < arr.length; i++) {
            String nameString = arr[i].getType() + " " + arr[i].getName() + " может ";

            eventName = "Перепрыгнуть через стену " + arr[i].getMaxJump() + " м. Пытается прыгнуть на ";
            eventResult = (arr[i].jump(jumpLength)) ? tempWinEvent : tempLossEvent;
            result(nameString, eventName, jumpLength, eventResult);

              }
    }

    private static void result(String nameGroup, String event, float eventLength, String resultEvent) {
        System.out.println( nameGroup+ event + eventLength + " м и" + resultEvent);
    }
}
