package Homework1;
import Homework1.Competitors.*;
import Homework1.obstacles.*;

public class MainClass {
    public static void main(String[] args) {

        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
        Obstacle[] obstacles = {new Cross(400), new Wall(2)};

        Team team = new Team("Команда №1", competitors);

        System.out.println("============created new team============");
        System.out.println(team.getTeamName());

        System.out.println("============greeting team members============");
        team.showResults();

        Course course = new Course(obstacles);

        System.out.println("============team goes to course============");
        course.doIt(team);

        System.out.println("============show team Results============");
        team.showResults();

        System.out.println("============team members finished course============");
        team.showMembersFinishedCourse();
    }
}