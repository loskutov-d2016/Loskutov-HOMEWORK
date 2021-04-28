package Lesson05.home;

public class Bird extends Animal{

    Bird(String name, float maxJump, float maxRun, float maxSwim) {
        super("Птица", name, maxJump, maxRun, maxSwim);
    }

    @Override
    protected int swim(float distance) {
        return Animal.SWIM_NONE;
    }
}