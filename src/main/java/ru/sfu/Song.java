package ru.sfu;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Song that implements AudioFile interface
 * Object can be created only using factory method createSong
 * @author Agapchenko V.V.
 */
public class Song implements AudioFile {
    /** Song sound track */
    private String melody;
    /** Lyrics of the song */
    private String lyrics;

    /**
     * Song private constructor, sets melody and lyrics
     * @param melody Song sound track
     * @param lyrics Lyrics of the song
     */
    private Song(String melody, String lyrics) {
        this.melody = melody;
        this.lyrics = lyrics;
    }

    /**
     * Song factory method, sets melody and lyrics
     * @param melody Song sound track
     * @param lyrics Lyrics of the song
     * @return New Song object
     */
    public static Song createSong(String melody,
                                  String lyrics) {
        return new Song(melody, lyrics);
    }

    /**
     * Method called after creating Song Bean and dependency injection
     */
    @PostConstruct
    private void initMethod() {
        System.out.println("Song initialization");
    }

    /**
     * Method called before destroying Song Bean
     */
    @PreDestroy
    private void destroyMethod() {
        System.out.println("Song destruction");
    }

    /**
     * Method of AudioFile interface
     * @return Melody and lyrics of the Song
     */
    public String getAudio() {
        return String.format("%s %s %s", melody, lyrics, melody);
    }
}
