
package semester1.practice10;

abstract class AbstractBird {
    protected final String species;
    protected double weightKg;

    public AbstractBird(String species, double weightKg) {
        this.species = species;
        this.weightKg = weightKg;
    }

    public abstract String makeSound();
}

interface FlyableUnit {
    double getFlightSpeedKmh();
}

interface SwimmingUnit {
    double getDiveDepthMeters();
}

class Falcon extends AbstractBird implements FlyableUnit {

    public Falcon(double weightKg) {
        super("Сокіл", weightKg);
    }

    @Override
    public String makeSound() {
        return "Клекіт";
    }

    @Override
    public double getFlightSpeedKmh() {
        return 300;
    }
}

class EmperorPenguin extends AbstractBird implements SwimmingUnit {

    public EmperorPenguin(double weightKg) {
        super("Імператорський пінгвін", weightKg);
    }

    @Override
    public String makeSound() {
        return "Голосний крик";
    }

    @Override
    public double getDiveDepthMeters() {
        return 500;
    }
}

class CargoPlane implements FlyableUnit {

    @Override
    public double getFlightSpeedKmh() {
        return 850;
    }
}

abstract class Task_17 {

    public static void main(String[] args) {

        AbstractBird[] birds = {
                new Falcon(1.5),
                new EmperorPenguin(30)
        };

        System.out.println("Птахи:");

        for (AbstractBird bird : birds) {
            System.out.println(bird.makeSound());
        }

        FlyableUnit[] flyingObjects = {
                new Falcon(1.5),
                new CargoPlane()
        };

        System.out.println();
        System.out.println("Літаючі об'єкти:");

        for (FlyableUnit object : flyingObjects) {
            System.out.println(
                    "Швидкість: " + object.getFlightSpeedKmh() + " км/год"
            );
        }

        SwimmingUnit[] swimmers = {
                new EmperorPenguin(30)
        };

        System.out.println();
        System.out.println("Плавці:");

        for (SwimmingUnit swimmer : swimmers) {
            System.out.println(
                    "Глибина занурення: "
                            + swimmer.getDiveDepthMeters() + " м"
            );
        }
    }
}
