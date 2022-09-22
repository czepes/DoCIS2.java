package ru.sfu;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * AudioPlayer that plays AudioFiles with a set volume level
 * @author Agapchenko V.V.
 */
@Component
public class AudioPlayer {
    /** Audio file that implements AudioFile interface */
    private AudioFile audioFile;
    /** Volume level */
    private short volumeLevel;

    /**
     * Default AudioPlayer constructor
     * Sets volume to 100
     */
    public AudioPlayer() {this.volumeLevel = 100;}

    /**
     * AudioPlayer constructor, sets volume level
     * If passed value more than 100 sets volume to 100
     * If passed value less than 0 sets volume to 0
     * @param volumeLevel Volume level
     */
    public AudioPlayer(short volumeLevel) {setVolume(volumeLevel);}

    /**
     * AudioPlayer constructor, sets audioFile
     * @param audioFile Object that implements AudioFile interface
     */
    @Autowired
    public AudioPlayer(@Qualifier("song") AudioFile audioFile) {
        this.volumeLevel = 100;
        this.audioFile = audioFile;
    }

    /**
     * AudioPlayer constructor, sets volume level and audioFile
     * If passed volume level more than 100 sets volume to 100
     * If passed volume level less than 0 sets volume to 0
     * @param volumeLevel Volume level
     * @param audioFile   Object that implements AudioFile interface
     */
    public AudioPlayer(short volumeLevel, AudioFile audioFile) {
        setVolume(volumeLevel);
        this.audioFile = audioFile;
    }

    /**
     * Method called after creating AudioFile Bean and dependency injection
     */
    @PostConstruct
    private void initMethod() {
        System.out.println("Audio Player initialization");
    }

    /**
     * Method called before destroying AudioPlayer Bean
     */
    @PreDestroy
    private void destroyMethod() {
        System.out.println("Audio Player destruction");
    }

    /**
     * Volume level setter
     * If passed volume level more than 100 sets volume to 100
     * If passed volume level less than 0 sets volume to 0
     * @param volume Volume level
     */
    @Autowired
    @Value("${audioPlayer.volume}")
    public void setVolume(short volume) {
        if (volume > 100)
            this.volumeLevel = 100;
        else if (volume < 0)
            this.volumeLevel = 0;
        else
            this.volumeLevel = volume;
    }

    /**
     * Audio file setter
     * @param audioFile Object that implements AudioFile interface
     */
    public void setAudioFile(AudioFile audioFile) {
        this.audioFile = audioFile;
    }

    /**
     * Method that plays audio track of audio file
     * Calls getAudio method of audioFile field
     */
    public void playAudio() {
        if (audioFile == null)
            System.out.println("No audio file");
        else
            System.out.printf(
                    "Track is playing on volume %d%%: %s \n",
                    volumeLevel,
                    audioFile.getAudio()
            );
    }
}
