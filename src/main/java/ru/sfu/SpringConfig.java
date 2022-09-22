package ru.sfu;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Configuration class for Spring Framework
 * @author Agapchenko V.V.
 */
@Configuration
@ComponentScan("ru.sfu")
@PropertySource("classpath:audioPlayer.properties")
public class SpringConfig {
    /**
     * Method that creates Bean of class Song
     * Uses factory method
     * @return Song object
     */
    @Bean
    public Song song() {
        return Song.createSong("♫♪♫", "...Singing...");
    }
}
