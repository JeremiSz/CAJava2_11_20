package assessment;

import javax.swing.*;
import java.awt.*;

public class TestAlbum {
    public static void main(String[] args) {
        Song song1 = new Song("Sugar Baby Love", "Rubettes", "Pop", 136, 1977);
        Song song2 = new Song("Living on a Prayer", "Bon Jovi", "Rock", 184, 1985);
        Song song3 = new Song("Blue Suede Shoes", "Elvis Presley", "Pop", 157, 1963);
        Song song4 = new Song("Someone Like You", "Adele", "Pop", 223, 2013);
        Song song5 = new Song("House of Fun", "Madness", "Pop", 178, 1984);

        Song[] songs = {song1,song2,song3,song4,song5};

        Album album = new Album("Now that’s what I call music 98",songs, "Universal Music", 2016);

        String output = "Name: " + album.getName() +
                "\nProducer: " + album.getProducer() +
                "\nRelease Year: " + album.getReleaseYear()+
                "\nNumber of tracks: " + album.getNumberOfTracks()+
                "\nTotal Playing Time: " + album.getPlayingTime() + " seconds" +
                "\n\t\t\tAlbum Tracks\n" +
                String.format("%-15s%-20s%-13s","Track Number","Title","Artist");
        for (int i = 0; i < album.getNumberOfTracks(); i++) {
            output += "\n" +  String.format("%-15d,%-20s,%-12s",album.getTracks()[i].getTrackNumber(),
                    album.getTracks()[i].getTitle(),album.getTracks()[i].getArtist());
        }

        TextArea area = new TextArea(output);
        JOptionPane.showMessageDialog(null,area,"Album Information",JOptionPane.INFORMATION_MESSAGE);
        String target = JOptionPane.showInputDialog("Which track would you like to Play?");
        playAlbumCheck(target,album);

        int result = JOptionPane.showConfirmDialog(null,"Would you like to shuffle?");

        if(result == JOptionPane.YES_OPTION)
            album.shuffle();
        System.exit(0);
    }
    private static void playAlbumCheck(String target,Album album){
        if(target == null || target.length() < 1){
            JOptionPane.showMessageDialog(null,"Invalid number","not a number",JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (int i = 0; i < target.length(); i++) {
            if(!Character.isDigit(target.charAt(i)))
                JOptionPane.showMessageDialog(null,"Invalid number","not a number",JOptionPane.ERROR_MESSAGE);
                return;
        }
        album.playTrack(Integer.valueOf(target));
    }
}
