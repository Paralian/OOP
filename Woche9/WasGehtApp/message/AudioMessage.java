package message;

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
     * Plays the voice message.
     */
    public void playVoiceMessage() {
        audio.play();
    }
}
