package encapsulation_and_access_control.assigment_problems;

import java.util.Arrays;

/**
 * Week 7 - Problem 2 : The Playlist
 * getSongs() returns a fresh copy every time, so editing the returned array
 * can never change what the Playlist actually stores.
 */
public class Playlist {

    private final String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.songCount = 0;
    }

    public void addSong(String title) {
        if (songCount == songs.length) {
            System.out.println("Playlist is full - cannot add " + title);
            return;
        }
        songs[songCount] = title;
        songCount++;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);   // a brand new array, not the original
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println(Arrays.toString(copy));

        copy[0] = "Hacked";                       // mutate the COPY
        System.out.println(Arrays.toString(p.getSongs()));   // playlist is untouched
        System.out.println("Song count: " + p.getSongCount());
    }
}
