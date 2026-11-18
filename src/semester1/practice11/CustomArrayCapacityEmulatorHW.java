package semester1.practice11;

import java.util.ArrayList;

class CustomArrayCapacityEmulator<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;

    private int size = 0;

    private int resizeCount = 0;

    private int totalElementsCopied = 0;

    public CustomArrayCapacityEmulator() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacityInternal() {

        if (size == elementData.length) {

            int oldCapacity = elementData.length;

            int newCapacity = oldCapacity + (oldCapacity >> 1);

            if (newCapacity == 0) {
                newCapacity = 1;
            }

            Object[] newBuffer = new Object[newCapacity];

            System.arraycopy(
                    elementData,
                    0,
                    newBuffer,
                    0,
                    size
            );

            elementData = newBuffer;

            resizeCount++;

            totalElementsCopied += size;
        }
    }

    public void add(E element) {

        ensureCapacityInternal();

        elementData[size++] = element;
    }

    public void add(int index, E element) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некоректний індекс");
        }

        ensureCapacityInternal();

        System.arraycopy(
                elementData,
                index,
                elementData,
                index + 1,
                size - index
        );

        elementData[index] = element;

        size++;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некоректний індекс");
        }

        E oldElement = (E) elementData[index];

        int numMoved = size - index - 1;

        if (numMoved > 0) {

            System.arraycopy(
                    elementData,
                    index + 1,
                    elementData,
                    index,
                    numMoved
            );
        }

        elementData[--size] = null;

        return oldElement;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некоректний індекс");
        }

        return (E) elementData[index];
    }

    @SuppressWarnings("unchecked")
    public E set(int index, E element) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некоректний індекс");
        }

        E oldElement = (E) elementData[index];

        elementData[index] = element;

        return oldElement;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return elementData.length;
    }

    public int getResizeCount() {
        return resizeCount;
    }

    public int getTotalElementsCopied() {
        return totalElementsCopied;
    }

    public void trimToSize() {

        if (elementData.length != size) {

            Object[] newBuffer = new Object[size];

            System.arraycopy(
                    elementData,
                    0,
                    newBuffer,
                    0,
                    size
            );

            elementData = newBuffer;
        }
    }
}

public class CustomArrayCapacityEmulatorHW {

    public static void main(String[] args) {

        System.out.println(
                "================ ЕМУЛЯТОР ВНУТРІШНЬОЇ БУДОВИ ARRAYLIST ================"
        );

        var emulator = new CustomArrayCapacityEmulator<String>();

        System.out.println(
                "[ІНІЦІАЛІЗАЦІЯ]: size = "
                        + emulator.size()
                        + " | capacity = "
                        + emulator.getCapacity()
        );

        // Небезпека: var raw = new ArrayList<>();
        // Без типу String компілятор виводить тип Object.

        System.out.println("\n--- Додавання 35 елементів ---");

        for (int i = 1; i <= 35; i++) {

            int oldCapacity = emulator.getCapacity();

            emulator.add("Block-" + i);

            int newCapacity = emulator.getCapacity();

            if (newCapacity > oldCapacity) {

                System.out.println(
                        "[GROW #" + emulator.getResizeCount() + "] "
                                + "Переповнення при додаванні " + i
                                + "-го елемента! Ємність: "
                                + oldCapacity + " -> " + newCapacity
                                + " (System.arraycopy скопіював "
                                + (i - 1) + " елементів)"
                );
            }
        }

        System.out.println(
                "\nСтан після додавання 35 елементів: size = "
                        + emulator.size()
                        + " | capacity = "
                        + emulator.getCapacity()
                        + " | Вільний резерв: "
                        + (emulator.getCapacity() - emulator.size())
        );

        System.out.println(
                "\n--- Тестування вставки та видалення ---"
        );

        int beforeInsertSize = emulator.size();

        emulator.add(0, "HEADER");

        System.out.println(
                "Вставлено HEADER на індекс 0 (зсунуто праворуч "
                        + beforeInsertSize + " елементів)"
        );

        String removed = emulator.remove(5);

        System.out.println(
                "Видалено елемент " + removed
                        + " з індексу 5 (зсунуто ліворуч "
                        + (emulator.size() - 5)
                        + " елементів, останню комірку занулено)"
        );

        System.out.println(
                "Поточний стан: size = " + emulator.size()
                        + " | capacity = " + emulator.getCapacity()
                        + " | Перший: " + emulator.get(0)
                        + " | Останній: "
                        + emulator.get(emulator.size() - 1)
        );

        // Перевірка set()
        emulator.set(1, "UPDATED");

        System.out.println(
                "Після set(1, UPDATED): " + emulator.get(1)
        );

        System.out.println("\n--- Оптимізація пам'яті trimToSize() ---");

        int oldCapacity = emulator.getCapacity();

        emulator.trimToSize();

        System.out.println(
                "Викликано trimToSize(): буфер Object["
                        + oldCapacity + "] стиснуто до Object["
                        + emulator.getCapacity() + "]"
        );

        System.out.println(
                "\nФінальна телеметрія:"
                        + "\nsize = " + emulator.size()
                        + "\ncapacity = " + emulator.getCapacity()
                        + "\nКількість розширень = "
                        + emulator.getResizeCount()
                        + "\nКількість скопійованих елементів під час розширень = "
                        + emulator.getTotalElementsCopied()
        );

        System.out.println(
                "============================================================================="
        );
    }
}
