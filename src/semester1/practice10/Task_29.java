package semester1.practice10;

class MediaItem {
    protected String title;
    protected double sizeMb;

    public MediaItem(String title, double sizeMb) {
        this.title = title;
        this.sizeMb = sizeMb;
    }
}

class VideoFile extends MediaItem {
    private int resolutionHeight;
    private int durationSec;

    public VideoFile(String title, double sizeMb,
                     int resolutionHeight, int durationSec) {
        super(title, sizeMb);
        this.resolutionHeight = resolutionHeight;
        this.durationSec = durationSec;
    }

    public boolean is4K() {
        return resolutionHeight >= 2160;
    }
}

class AudioFile extends MediaItem {
    private int bitrateKbps;

    public AudioFile(String title, double sizeMb, int bitrateKbps) {
        super(title, sizeMb);
        this.bitrateKbps = bitrateKbps;
    }

    public boolean isLossless() {
        return bitrateKbps >= 1000;
    }
}

class EBookFile extends MediaItem {
    private int pageCount;

    public EBookFile(String title, double sizeMb, int pageCount) {
        super(title, sizeMb);
        this.pageCount = pageCount;
    }
}

abstract class Task_29 {

    public static double calculateSpecialMediaSize(MediaItem[] media) {
        double totalSize = 0;

        for (MediaItem item : media) {
            if (item instanceof VideoFile video && video.is4K()) {
                totalSize += video.sizeMb;
            } else if (item instanceof AudioFile audio && audio.isLossless()) {
                totalSize += audio.sizeMb;
            }
        }

        return totalSize;
    }

    public static void main(String[] args) {
        MediaItem[] media = {
                new VideoFile("Фільм 4K", 2500, 2160, 7200),
                new VideoFile("Відео Full HD", 800, 1080, 3600),
                new AudioFile("Музика Lossless", 80, 1411),
                new AudioFile("Музика MP3", 12, 320),
                new EBookFile("Книга", 5, 300)
        };

        System.out.println(
                "Сумарний обсяг 4K-відео та Lossless-аудіо: "
                        + calculateSpecialMediaSize(media) + " МБ"
        );
    }
}