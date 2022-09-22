package ru.sfu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main class of the program
 * @author Agapchenko V.V.
 */
public class Main {
    /**
     * Enter point to the program
     * @param args Optional arguments
     */
    public static void main(String[] args) {
        // Getting context from configuration class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        // Getting audio player Bean from context
        AudioPlayer audioPlayer = context.getBean(
                "audioPlayer",
                AudioPlayer.class);
        // Calling method of Bean object
        audioPlayer.playAudio();
        // Closing context
        context.close();
    }
}
