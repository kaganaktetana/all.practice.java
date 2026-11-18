
package semester1.practice11;

import java.util.ArrayList;

public class Task_12 {

    public static void main(String[] args) {

        ArrayList<String> pipeline = new ArrayList<>();

        pipeline.add("Compile");
        System.out.println(pipeline + " | size = " + pipeline.size());

        pipeline.add("Package");
        System.out.println(pipeline + " | size = " + pipeline.size());

        pipeline.add("Deploy");
        System.out.println(pipeline + " | size = " + pipeline.size());

        // Вставка на початок
        pipeline.add(0, "Checkout Git");
        System.out.println(pipeline + " | size = " + pipeline.size());

        // Вставка між Compile та Package
        pipeline.add(2, "Run Unit Tests");
        System.out.println(pipeline + " | size = " + pipeline.size());
    }
}
