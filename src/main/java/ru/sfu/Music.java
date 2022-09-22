package ru.sfu;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Music that implements AudioFile interface
 * @author Agapchenko V.V.
 */
@Component
public class Music implements AudioFile {
    /** Music sound track */
    private String melody;

    /**
     * Music constructor
     * @param melody Music sound track
     */
    @Autowired
    public Music(@Value("♪♫♪") String melody) {
        this.melody = melody;
    }

    /**
     * Method called after creating Music Bean and dependency injection
     */
    @PostConstruct
    private void initMethod() {
        System.out.println("Music initialization");
    }

    /**
     * Method called before destroying Music Bean
     */
    @PreDestroy
    private void destroyMethod() {
        System.out.println("Music destruction");
    }

    /**
     * Method of AudioFile interface
     * @return Melody of the Music
     */
    public String getAudio() {
        return String.format("%s %s %s", melody, melody, melody);
    }
}
