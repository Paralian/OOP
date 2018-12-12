package data;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Audio implements Data {

    /**
     * Plays the audio file.
     */
    public void play() {
        try {
            File soundFile = new File( "bin" );
            Clip clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

            clip.open(audioInputStream);
            clip.start();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String prettyPrint() {
        return "Here's to Adam.";
    }
}
