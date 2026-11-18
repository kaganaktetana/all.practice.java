
package semester1.practice11;

import java.util.ArrayList;

public class Task_01 {

    public static void demonstrateWrapperTwins() {

        Byte b = Byte.valueOf((byte) 10);
        Short s = Short.valueOf((short) 20);
        Integer i = Integer.valueOf(30);
        Long l = Long.valueOf(40L);
        Float f = Float.valueOf(5.5f);
        Double d = Double.valueOf(6.7);
        Character c = Character.valueOf('A');
        Boolean bool = Boolean.valueOf(true);

        // ArrayList<int> не компілюється,
        // оскільки колекції працюють лише з посилальними типами.
        // ArrayList<Integer> працює правильно.

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println(b + " - " + b.getClass().getSimpleName());
        System.out.println(s + " - " + s.getClass().getSimpleName());
        System.out.println(i + " - " + i.getClass().getSimpleName());
        System.out.println(l + " - " + l.getClass().getSimpleName());
        System.out.println(f + " - " + f.getClass().getSimpleName());
        System.out.println(d + " - " + d.getClass().getSimpleName());
        System.out.println(c + " - " + c.getClass().getSimpleName());
        System.out.println(bool + " - " + bool.getClass().getSimpleName());

        System.out.println("ArrayList<Integer>: " + numbers);
    }
}
