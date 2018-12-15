import message.TextMessage;
import network.Client;
import org.junit.Test;
import user.User;

import static org.junit.Assert.*;

public class TextMessageTest {
    private Client client1 = new Client(new User(101, "Jedi Master", "Obi-Wan", "Kenobi"));
    private Client client2 = new Client(new User(102, "General", "Grievous", ""));
    private TextMessage textMessage = new TextMessage(client1.getUser(), client2.getUser(), "Hello there.");

    @Test
    public void getTransferRepresentation() {
        assertEquals("Hello there.", textMessage.getTransferRepresentation());
    }

    @Test
    public void prettyPrint() {
        assertEquals("Jedi Master -> General: Hello there.", textMessage.prettyPrint());
    }

    @Test
    public void getSender() {
        assertEquals(client1.getUser(), textMessage.getSender());
    }

    @Test
    public void getRecipient() {
        assertEquals(client2.getUser(), textMessage.getRecipient());
    }
}