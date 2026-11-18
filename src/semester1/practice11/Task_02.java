
package semester1.practice11;

import java.util.ArrayList;

public class Task_02 {

    public static void showCompilerUnderTheHood() {

        // Autoboxing та Unboxing
        int a = 42;
        Integer boxed = a;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);

        int unboxed = list.get(0);

        System.out.println("Autoboxing: " + boxed);
        System.out.println("Unboxing: " + unboxed);

        // Явні виклики методів
        int a2 = 42;
        Integer boxed2 = Integer.valueOf(a2);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(Integer.valueOf(100));

        int unboxed2 = list2.get(0).intValue();

        System.out.println("Explicit boxing: " + boxed2);
        System.out.println("Explicit unboxing: " + unboxed2);

        // Double
        Double doubleBoxed = Double.valueOf(3.14);
        double doubleUnboxed = doubleBoxed.doubleValue();

        System.out.println("Double: " + doubleBoxed);
        System.out.println("Unboxed Double: " + doubleUnboxed);

        // Boolean
        Boolean booleanBoxed = Boolean.valueOf(true);
        boolean booleanUnboxed = booleanBoxed.booleanValue();

        System.out.println("Boolean: " + booleanBoxed);
        System.out.println("Unboxed Boolean: " + booleanUnboxed);
    }
}
