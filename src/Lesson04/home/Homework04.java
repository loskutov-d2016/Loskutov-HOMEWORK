package Lesson04.home;

public class Homework04 {

    //№1

    public static void main(String[] args) {
        Employee mainuser = new Employee("Лоскутов", "Дмитрий",
                "Сергеевич", "+79877127840",
                "Manager", 60000, 1990);
    //№4

        System.out.println("Please welcome our " + mainuser.getPosition() + ", " +
                mainuser.getName() + " " + mainuser.getSecondName() + " " + mainuser.getSurname() + ".");
    //№5

        Employee[] employees = {
                mainuser,
                new Employee("Волкова", "Александра",
                        "Владимировна", "+79877777777",
                        "Manager", 40000, 1993),
                new Employee("Рыбаков", "Владимир",
                        "Евгеньевич", "+79998254444",
                        "Manager", 50000, 1960),
                new Employee("Дроздов", "Андрей",
                        "Геннадьевич", "+79821117840",
                        "Manager", 38000, 1970),
                new Employee("Михайлов", "Михаил",
                        "Сергеевич", "+9882556784",
                        "Manager", 30000, 1995)
        };

        System.out.println("**********************************************");

        for (int i = 0; i < employees.length; i++)
            if (employees[i].getAge() > 40) {
                System.out.println(employees[i].getFullInfo());
            }

        System.out.println("**********************************************");

        for (int i = 0; i < employees.length; i++)
            System.out.println(employees[i].getFullInfo());

        increaseSalary(employees, 45, 5000);

        System.out.println("**********************************************");

        for (int i = 0; i < employees.length; i++)
            if (employees[i].isSalaryChanged)
                System.out.println(employees[i].getFullInfo());

    }
    //№6
    private static void increaseSalary(Employee[] emp, int age, float increment) {
        for (int i = 0; i < emp.length; i++) {
            if (emp[i].getAge() > age) {
                emp[i].setSalary(increment);
                emp[i].isSalaryChanged = true;
            }
        }
    }
}