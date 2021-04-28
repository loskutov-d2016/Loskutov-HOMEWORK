package Lesson05.home;

public class Marathon {

    public static void main(String[] args) {

        String tempWinEvent = " это получилось";
        String tempLossEvent = " это не получилось";
        String eventName;
        String eventResult;

        Cat cat1 = new Cat("Васька", 2, 200, 1);
        Dog dog = new Dog("Вкусеслав", 0.5f, 500, 10);
        Dog dog1 = new Dog("Шарик", 0.5f, 400, 10);
        Dog dog2 = new Dog("Шар", 0.5f, 600, 10);
        Horse horse = new Horse("Олег", 3, 1500, 100);
        Bird bird = new Bird("Жаклин", 0.2f, 5, 1);

        Animal[] arr = {cat1, dog1, dog2, dog, horse,bird};
        float jumpLength = 2.5f;
        float runLength = 250;
        float swimLength = 8;

        for (int i = 0; i < arr.length; i++) {
            String nameString = arr[i].getType() + " " + arr[i].getName() + " может ";

            eventName = "прыгнуть на " + arr[i].getMaxJump() + " м. Пытается прыгнуть на ";
            eventResult = (arr[i].jump(jumpLength)) ? tempWinEvent : tempLossEvent;
            result(nameString, eventName, jumpLength, eventResult);


            eventName = "пробежать на " + arr[i].getMaxRun() + " м. Пытается пробежать на ";
            eventResult = arr[i].run(runLength) ? tempWinEvent : tempLossEvent;
            result(nameString, eventName, runLength, eventResult);

            int swimResult = arr[i].swim(swimLength);
            eventName = "проплыть на " + arr[i].getMaxSwim() + " м. Попытка проплыть на ";
            eventResult = (swimResult == Animal.SWIM_OK) ? tempWinEvent : tempLossEvent;

            if (swimResult == Animal.SWIM_NONE)
                eventResult = " это не получилось, т.к. не умеет плавать";
            result(nameString, eventName, swimLength, eventResult);
        }
    }

    private static void result(String nameAnimal, String event, float eventLength, String resultEvent) {
        System.out.println(nameAnimal + event + eventLength + " м и" + resultEvent);
    }

}
