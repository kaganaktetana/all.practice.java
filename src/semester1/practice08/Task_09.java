package semester1.practice08;

public class Task_09 {
    public static void main(String[] args) {
        Employee employee = new Employee("Олександр", 25000);

        Developer developer = new Developer(
                "Тетяна",
                40000,
                "Java"
        );

        System.out.println(employee);
        System.out.println(developer);
    }
}

class Employee {
    private String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Працівник: " + name
                + ", зарплата: " + salary;
    }
}

class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, double salary,
                     String programmingLanguage) {

        super(name, salary);

        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "Розробник: " + getName()
                + ", зарплата: " + salary
                + ", мова програмування: " + programmingLanguage;
    }
}