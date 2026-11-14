package semester1.practice10;

class CargoContainer {
    protected String name;

    public CargoContainer(String name) {
        this.name = name;
    }
}

interface HazardousCargo {
    int getHazardClass();
}

interface RefrigeratedCargo {
    double getRequiredTempC();
}

class ElectronicsContainer extends CargoContainer {

    public ElectronicsContainer() {
        super("Електроніка");
    }
}

class ChemicalsContainer extends CargoContainer
        implements HazardousCargo {

    public ChemicalsContainer() {
        super("Хімікати");
    }

    @Override
    public int getHazardClass() {
        return 3;
    }
}

class FrozenFoodContainer extends CargoContainer
        implements RefrigeratedCargo {

    public FrozenFoodContainer() {
        super("Заморожені продукти");
    }

    @Override
    public double getRequiredTempC() {
        return -18.0;
    }
}

abstract class Task_32 {

    public static void inspectCargo(CargoContainer[] containers) {
        for (CargoContainer container : containers) {
            System.out.println("\nПеревірка: " + container.name);

            if (container instanceof HazardousCargo hazardous) {
                System.out.println(
                        "Відправити у спецбокс. Клас небезпеки: "
                                + hazardous.getHazardClass()
                );
            }

            if (container instanceof RefrigeratedCargo refrigerated) {
                System.out.println(
                        "Підключити до живлення. Температура: "
                                + refrigerated.getRequiredTempC() + " °C"
                );
            }

            if (!(container instanceof HazardousCargo)
                    && !(container instanceof RefrigeratedCargo)) {
                System.out.println("Стандартна перевірка вантажу");
            }
        }
    }

    public static void main(String[] args) {
        CargoContainer[] containers = {
                new ElectronicsContainer(),
                new ChemicalsContainer(),
                new FrozenFoodContainer()
        };

        inspectCargo(containers);
    }
}