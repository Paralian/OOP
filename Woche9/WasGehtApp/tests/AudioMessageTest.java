import data.Audio;
import data.Data;
import message.AudioMessage;
import network.Client;
import org.junit.Test;
import user.User;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AudioMessageTest {
    Client client1 = new Client(new User(101, "Commissioner", "James", "Gordon"));
    Client client2 = new Client(new User(102, "Batman", "Bruce", "Wayne"));
    Data data = new Audio();
    Audio audio = new Audio();
    AudioMessage audioMessage = new AudioMessage(client1.getUser(), client2.getUser(), data, audio);

    @Test
    public void playVoiceMessage() {
        // audioMessage.playVoiceMessage();
        // TODO: Provide an audio file in bin and check the file path in Class Audio
    }

    @Test
    public void getTransferRepresentation() {
        assertEquals("data.Audio " + null + " " + data, audioMessage.getTransferRepresentation());
    }

    @Test
    public void prettyPrint() {
        assertEquals("data.Audio " + null + " " + data + " " + "Here's to Adam.", audioMessage.prettyPrint());
    }

    @Test
    public void getMediaInfo() {
        assertEquals(null, audioMessage.getMediaInfo());
    }

    @Test
    public void getDataObject() {
        assertEquals(data, audioMessage.getDataObject());
    }
}