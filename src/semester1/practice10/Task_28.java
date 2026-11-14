package semester1.practice10;

abstract class ShipModule {
    protected String name;
    protected boolean damaged;

    public ShipModule(String name, boolean damaged) {
        this.name = name;
        this.damaged = damaged;
    }
}

class ShieldGenerator extends ShipModule {

    public ShieldGenerator(String name, boolean damaged) {
        super(name, damaged);
    }

    public void rechargeShields(int megajoules) {
        System.out.println("Щити заряджено на " + megajoules + " МДж");
    }
}

class WarpDrive extends ShipModule {

    public WarpDrive(String name, boolean damaged) {
        super(name, damaged);
    }

    public boolean checkAntimatterContainment() {
        return !damaged;
    }
}

class LifeSupportModule extends ShipModule {

    public LifeSupportModule(String name, boolean damaged) {
        super(name, damaged);
    }

    public double getOxygenPercent() {
        return damaged ? 45.0 : 100.0;
    }
}

abstract class Task_28 {

    public static void runShipInspection(ShipModule[] modules) {
        for (ShipModule module : modules) {
            System.out.println("\nПеревірка модуля: " + module.name);

            if (module instanceof ShieldGenerator shield) {
                shield.rechargeShields(100);
            } else if (module instanceof WarpDrive drive) {
                System.out.println(
                        "Герметичність антиматерії: "
                                + drive.checkAntimatterContainment()
                );
            } else if (module instanceof LifeSupportModule lifeSupport) {
                System.out.println(
                        "Рівень кисню: "
                                + lifeSupport.getOxygenPercent() + "%"
                );
            }

            System.out.println(
                    "Стан: " + (module.damaged ? "Пошкоджений" : "Справний")
            );
        }
    }

    public static void main(String[] args) {
        ShipModule[] modules = {
                new ShieldGenerator("Генератор щитів", false),
                new WarpDrive("Варп-двигун", true),
                new LifeSupportModule("Система життєзабезпечення", false)
        };

        runShipInspection(modules);
    }
}