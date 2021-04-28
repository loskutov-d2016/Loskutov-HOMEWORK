package Homework01;
import java.util.Random;

public class Group {
    private String type;
    private String name;
    private float maxRun;
    private float maxSwim;
    private float maxJump;
    private final Random random = new Random();

    Group(String type, String name, float maxJump, float maxRun) {
        float jumpDiff = random.nextFloat() * maxJump - (maxJump / 2);
        float runDiff = random.nextFloat() * maxRun - (maxRun / 2);

        this.type = type;
        this.name = name;
        this.maxJump = maxJump + jumpDiff; // 100 + ([0;1) * 100 - (100/2))
        this.maxRun = maxRun + runDiff;
    }

    String getName() {
        return this.name;
    }

    String getType() {
        return this.type;
    }

    float getMaxRun() {
        return this.maxRun;
    }


    float getMaxJump() {
        return this.maxJump;
    }

    protected boolean run(float distance) {
        return (distance <= maxRun);
    }

    protected boolean jump(float height) {
        return (height <= maxJump);
    }
}


