package semester1.practice10;

interface Rechargeable {
    void chargeToFull();
}

class Laptop implements Rechargeable {
    @Override
    public void chargeToFull() {
        System.out.println("Ноутбук заряджено");
    }
}

class ElectricScooter implements Rechargeable {
    @Override
    public void chargeToFull() {
        System.out.println("Електросамокат заряджено");
    }
}

class SmartWatch implements Rechargeable {
    @Override
    public void chargeToFull() {
        System.out.println("Смартгодинник заряджено");
    }
}

class DesktopMonitor {
}

class WiredPrinter {
}

abstract class Task_26 {

    public static int chargeAllPossible(Object[] items) {
        int chargedCount = 0;

        for (Object item : items) {
            if (item instanceof Rechargeable r) {
                r.chargeToFull();
                chargedCount++;
            }
        }

        return chargedCount;
    }

    public static void main(String[] args) {
        Object[] warehouse = {
                new Laptop(),
                new ElectricScooter(),
                new SmartWatch(),
                new DesktopMonitor(),
                new WiredPrinter()
        };

        int result = chargeAllPossible(warehouse);

        System.out.println("Усього заряджено пристроїв: " + result);
    }
}