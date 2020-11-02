package assessment;

public class Song {
    private static int trackID = 0;
    private int trackNumber;
    private String title;
    private String artist;
    private String genre;
    private int duration;
    private int releaseYear;

    public Song(String title,String artist,String genre,int duration,int releaseYear){
        this.setTitle(title);
        this.setArtist(artist);
        this.setGenre(genre);
        this.setDuration(duration);
        this.setReleaseYear(releaseYear);
        this.trackNumber = trackID++;
    }

    private void setTrackNumber(int trackNumber){
        this.trackNumber = trackNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setArtist(String artist){
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "trackNumber=" + getTrackNumber() +
                ", title='" + getTitle() + '\'' +
                ", artist='" + getArtist() + '\'' +
                ", genre='" + getGenre() + '\'' +
                ", duration=" + getDuration() +
                ", releaseYear=" + getReleaseYear() +
                '}';
    }
}
