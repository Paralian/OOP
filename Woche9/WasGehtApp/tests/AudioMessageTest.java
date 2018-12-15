import data.Audio;
import data.Data;
import message.AudioMessage;
import network.Client;
import org.junit.Test;
import user.User;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AudioMessageTest {
    private Client client1 = new Client(new User(101, "Commissioner", "James", "Gordon"));
    private Client client2 = new Client(new User(102, "Batman", "Bruce", "Wayne"));
    private Data data = new Audio();
    private Audio audio = new Audio();
    private AudioMessage audioMessage = new AudioMessage(client1.getUser(), client2.getUser(), data, audio);

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
        assertNull(audioMessage.getMediaInfo());
    }

    @Test
    public void getDataObject() {
        assertEquals(data, audioMessage.getDataObject());
    }
}