
package semester1.practice11;

import java.util.Arrays;

public class Task_11 {

    public static Object[] growArrayManually(Object[] oldData) {

        int newCapacity = oldData.length + (oldData.length >> 1);

        Object[] newData = new Object[newCapacity];

        System.arraycopy(oldData, 0, newData, 0, oldData.length);

        newData[10] = 11;

        System.out.println("Старий масив: " + Arrays.toString(oldData));
        System.out.println("Новий масив: " + Arrays.toString(newData));

        return newData;
    }

    public static void main(String[] args) {

        Object[] oldData = new Object[10];

        for (int i = 0; i < oldData.length; i++) {
            oldData[i] = i + 1;
        }

        growArrayManually(oldData);

        // Вставка елемента на індекс 2
        Object[] data = {1, 2, 3, 4, 5};

        Object[] newData = new Object[data.length + 1];

        System.arraycopy(data, 0, newData, 0, 2);

        newData[2] = 99;

        System.arraycopy(data, 2, newData, 3, data.length - 2);

        System.out.println("До вставки: " + Arrays.toString(data));
        System.out.println("Після вставки: " + Arrays.toString(newData));
    }
}
