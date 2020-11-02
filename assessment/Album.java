package assessment;

import javax.swing.*;
import java.util.Arrays;

public class Album {
    private String name;
    private Song[] tracks;
    private String producer;
    private int releaseYear;

    public Album(String name,Song[] tracks, String producer,int releaseYear){
        setName(name);
        setTracks(tracks);
        setProducer(producer);
        setReleaseYear(releaseYear);
    }

    public void setName(String name) {
        if(name == null || name.isEmpty())
            this.name = "No name specified";
        else
            this.name = name;
    }

    public void setTracks(Song[] tracks) {
        this.tracks = tracks;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public Song[] getTracks() {
        return tracks;
    }

    public String getProducer() {
        return producer;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
    public int getNumberOfTracks(){
        return tracks.length;
    }
    public int getPlayingTime(){
        int ouput = 0;
        for (int i = 0; i < tracks.length; i++) {
            ouput += tracks[i].getDuration();
        }
        return ouput;
    }
    public void playTrack(int song){
        if((song > tracks.length) || song <= 0)
            JOptionPane.showMessageDialog(null,"Invalid track",
                    "Bad Track Number",JOptionPane.ERROR_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"Now Playing: " +
                    tracks[--song]);

    }
    public void shuffle(){
        int length = tracks.length;
        Song[] ouput = new Song[length];
        boolean[] alreadyPicked = new boolean[length];
        int random;
        for (int i = 0; i < length; i++) {
            do{
                random = (int)(Math.random() * (length));
            }while (alreadyPicked[random]);
            ouput[i] = tracks[random];
            alreadyPicked[random] = true;
        }
        String output = "Shuffled playlist is as follows:\n\n";
        for (int i = 0; i < length; i++) {
            output += "\nTrack number " + ouput[i].getTrackNumber() +
            " Title " + ouput[i].getTitle() +
            " Artist :" + ouput[i].getArtist() +
            " Genre: " + ouput[i].getGenre()+
            " Release Year: " + ouput[i].getReleaseYear() +
            " Duration: " + ouput[i].getDuration();
        }
        JOptionPane.showMessageDialog(null,output,"Shuffled Playlist",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + getName() + '\'' +
                ", tracks=" + Arrays.toString(getTracks()) +
                ", producer='" + getProducer() + '\'' +
                ", releaseYear=" + getReleaseYear() +
                '}';
    }
}
