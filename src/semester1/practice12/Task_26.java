package semester1.practice12;

import java.util.*;

public class Task_26 {

    public static void main(String[] args) {

        Playlist playlist = new Playlist();

        playlist.addSong(new Song("Believer", "Imagine Dragons", 204));
        playlist.addSong(new Song("Numb", "Linkin Park", 185));
        playlist.addSong(new Song("Shape of You", "Ed Sheeran", 234));
        playlist.addSong(new Song("Believer", "Imagine Dragons", 204));

        System.out.println("=== MUSIC PLAYLIST ===");

        for (Song song : playlist) {
            System.out.println(song);
        }

        System.out.println("\nКількість треків: "
                + playlist.getTracksCopy().size());

        // Підрахунок загальної тривалості
        int totalDuration = 0;

        for (Song song : playlist) {
            totalDuration += song.getDurationSec();
        }

        System.out.println("Загальна тривалість: "
                + totalDuration + " секунд");

        // Перевірка захисного копіювання
        Set<Song> copy = playlist.getTracksCopy();
        copy.clear();

        System.out.println("Після очищення копії плейлист: "
                + playlist.getTracksCopy());

        // Перевірка захисту через Iterator.remove()
        Iterator<Song> iterator = playlist.iterator();

        if (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        System.out.println("Після видалення з копії через Iterator: "
                + playlist.getTracksCopy());
    }

    // Незмінний клас Song
    public static final class Song {

        private final String title;
        private final String artist;
        private final int durationSec;

        public Song(String title, String artist, int durationSec) {
            this.title = title;
            this.artist = artist;
            this.durationSec = durationSec;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        public int getDurationSec() {
            return durationSec;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            if (!(obj instanceof Song song)) return false;

            return Objects.equals(title, song.title)
                    && Objects.equals(artist, song.artist);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, artist);
        }

        @Override
        public String toString() {
            return title + " - " + artist
                    + " (" + durationSec + " sec)";
        }
    }

    // Плейлист
    public static class Playlist implements Iterable<Song> {

        private final Set<Song> tracks = new LinkedHashSet<>();

        public void addSong(Song song) {
            tracks.add(song);
        }

        // Захисна копія
        public Set<Song> getTracksCopy() {
            return new LinkedHashSet<>(tracks);
        }

        // Ітератор по копії
        @Override
        public Iterator<Song> iterator() {
            return getTracksCopy().iterator();
        }
    }
}
