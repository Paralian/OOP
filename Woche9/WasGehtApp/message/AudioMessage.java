package WasGehtApp.message;

import data.Audio;
import data.Data;
import user.User;

public class AudioMessage extends AbstractDataMessage {
    private Audio audio;

    /**
     * Constructor
     */
    public AudioMessage(User sender, User recipient, Data data, Audio audio) {
        super(sender, recipient, data);
        this.audio = audio;
    }

    /**
     * Returns the information about the data object.
     * @return a String describing the data object
     */
    @Override
    public String getMediaInfo() {
        return null;
    }

    /**
     * Plays the voice message.
     */
    public void playVoiceMessage() {
        audio.play();
    }
}
