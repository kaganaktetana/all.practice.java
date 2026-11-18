
package semester1.practice11;

public class Task_14 {

    static class SimpleArrayList {

        private Object[] data = new Object[10];

        private int size = 0;

        public void add(Object element) {

            if (size == data.length) {

                int newCapacity = data.length + (data.length >> 1);

                Object[] newData = new Object[newCapacity];

                System.arraycopy(data, 0, newData, 0, size);

                data = newData;
            }

            data[size++] = element;
        }

        public Object get(int index) {

            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }

            return data[index];
        }

        public int size() {
            return size;
        }

        public int getCapacity() {
            return data.length;
        }
    }

    public static void main(String[] args) {

        SimpleArrayList list = new SimpleArrayList();

        System.out.println("Початкова capacity: " + list.getCapacity());

        for (int i = 1; i <= 12; i++) {
            list.add(i);
        }

        System.out.println("Size: " + list.size());
        System.out.println("Capacity: " + list.getCapacity());

        System.out.println("Елемент з індексом 0: " + list.get(0));
        System.out.println("Елемент з індексом 11: " + list.get(11));
    }
}
