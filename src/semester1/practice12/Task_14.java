package semester1.practice12;

import java.util.*;

public class Task_14 {

    static class MutableTag {
        private String label;

        public MutableTag(String label) {
            this.label = label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MutableTag)) return false;

            MutableTag tag = (MutableTag) o;
            return Objects.equals(label, tag.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public static void main(String[] args) {
        MutableTag tag = new MutableTag("java");

        Set<MutableTag> tags = new HashSet<>();
        tags.add(tag);

        System.out.println("До зміни: " + tags.contains(tag));

        tag.setLabel("kotlin");

        System.out.println("Після зміни: " + tags.contains(tag));
        System.out.println("Видалення: " + tags.remove(tag));
        System.out.println("Розмір множини: " + tags.size());

        System.out.println("\nПравильний спосіб:");

        MutableTag safeTag = new MutableTag("java");
        Set<MutableTag> safeTags = new HashSet<>();

        safeTags.add(safeTag);
        safeTags.remove(safeTag);

        safeTag.setLabel("kotlin");

        safeTags.add(safeTag);

        System.out.println("Множина: " + safeTags);
        System.out.println("Пошук: " + safeTags.contains(safeTag));
    }
}
