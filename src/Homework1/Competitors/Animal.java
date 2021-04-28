package Homework1.Competitors;
public abstract class Animal implements Competitor{
    String type;
    String name;
    int maxRunDistance;
    int maxJumpHeight;
    boolean onDistance;

    public boolean isOnDistance() {
        return onDistance;
    }

    public Animal(String type, String name, int maxRunDistance, int maxJumpHeight) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    public void run(int distance){
        if (distance <=maxRunDistance){
            System.out.println(type + " " + name + " " + "справился с забегом");
        } else {
            System.out.println(type + " " + name + " " + "не справился с забегом");
            onDistance = false;
        }
    }

    public void jump(int height){
        if (height <=maxJumpHeight){
            System.out.println(type + " " + name + " " + "успешно справился с препятствием");
        } else {
            System.out.println(type + " " + name + " " + "не смог преодолеть препятствие");
            onDistance = false;
        }
    }

    public void showResult(){
        System.out.println(type + " " + name + ": " + onDistance);
    }

}