package Homework1.Competitors;

public class Human implements Competitor{
    String name;
    int maxRunDistance;
    int maxJumpHeight;
    boolean onDistance;

    public boolean isOnDistance() {
        return onDistance;
    }

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 5000;
        this.maxJumpHeight = 20;
        this.onDistance = true;
    }

    public void run(int distance){
        if (distance <=maxRunDistance){
            System.out.println(name + " " + "справился с забегом");
        } else {
            System.out.println(name + " " + "не справился с забегом");
            onDistance = false;
        }
    }

    public void jump(int height){
        if (height <=maxJumpHeight){
            System.out.println(name + " " + " успешно справился с препятствием");
        } else {
            System.out.println(name + " " + " не смог преодолеть препятствие");
            onDistance = false;
        }
    }

    public void showResult(){
        System.out.println(name + ": " + onDistance);
    }

}