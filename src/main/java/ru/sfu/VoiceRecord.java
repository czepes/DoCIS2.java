package ru.sfu;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * VoiceRecording that implements AudioFile interface
 * @author Agapchenko V.V.
 */
@Component
public class VoiceRecord implements AudioFile {
    /** Recorded speech */
    private String speech;

    /**
     * VoiceRecord constructor, sets speech
     * @param speech Recorded speech
     */
    @Autowired
    public VoiceRecord(@Value("...Speaking...") String speech) {
        this.speech = speech;
    }

    /**
     * Method called after creating VoiceRecord Bean and dependency injection
     */
    @PostConstruct
    private void initMethod() {
        System.out.println("Voice Recording initialization");
    }

    /**
     * Method called before destroying VoiceRecord Bean
     */
    @PreDestroy
    private void destroyMethod() {
        System.out.println("Voice Recording destruction");
    }

    /**
     * Method of AudioFile interface
     * @return Recorded speech of the VoiceRecord
     */
    public String getAudio() {
        return speech;
    }
}
