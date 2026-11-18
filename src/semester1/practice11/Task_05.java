
package semester1.practice11;

public class Task_05 {

    public static void testIntegerPool() {

        // Числа в діапазоні кешу
        Integer a = 100;
        Integer b = 100;

        System.out.println("100 через ==: " + (a == b));
        System.out.println("100 через equals(): " + a.equals(b));

        // Числа поза діапазоном кешу
        Integer x = 250;
        Integer y = 250;

        System.out.println("250 через ==: " + (x == y));
        System.out.println("250 через equals(): " + x.equals(y));
    }

    public static void main(String[] args) {
        testIntegerPool();
    }
}
