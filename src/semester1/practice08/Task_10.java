package semester1.practice08;

public class Task_10 {
    public static void main(String[] args) {
        Dog dog = new Dog(
                "Бім",
                3,
                15.5,
                "Лабрадор"
        );

        Cat cat = new Cat(
                "Мурка",
                2,
                4.2,
                true
        );

        System.out.println(dog);
        System.out.println(dog.fetchStick());

        System.out.println();

        System.out.println(cat);
        System.out.println(cat.purr());
    }
}

class Animal {
    private String name;
    private int age;
    private double weight;

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Ім'я: " + name
                + ", вік: " + age
                + ", вага: " + weight + " кг";
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, double weight, String breed) {
        super(name, age, weight);

        this.breed = breed;
    }

    public String fetchStick() {
        return getName() + " приносить палицю!";
    }

    @Override
    public String toString() {
        return "Собака: " + getName()
                + ", вік: " + getAge()
                + ", вага: " + getWeight() + " кг"
                + ", порода: " + breed;
    }
}

class Cat extends Animal {
    private boolean isIndoor;

    public Cat(String name, int age, double weight, boolean isIndoor) {
        super(name, age, weight);

        this.isIndoor = isIndoor;
    }

    public String purr() {
        return getName() + " муркоче: мур-мур!";
    }

    @Override
    public String toString() {
        return "Кіт: " + getName()
                + ", вік: " + getAge()
                + ", вага: " + getWeight() + " кг"
                + ", хатній: " + (isIndoor ? "так" : "ні");
    }
}