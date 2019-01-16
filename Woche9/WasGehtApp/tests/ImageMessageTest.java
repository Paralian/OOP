import data.Data;
import data.Image;
import message.ImageMessage;
import network.Client;
import org.junit.Test;
import user.User;

import static org.junit.Assert.*;

public class ImageMessageTest {
    private Client client1 = new Client(new User(101, "Commissioner", "James", "Gordon"));
    private Client client2 = new Client(new User(102, "Batman", "Bruce", "Wayne"));
    private Data data = new Image();
    private Image image = new Image();
    private ImageMessage imageMessage = new ImageMessage(client1.getUser(), client2.getUser(), data, image, "BATMAN");

    @Test
    public void getMediaInfo() {
        assertEquals("BATMAN", imageMessage.getMediaInfo());
    }

    @Test
    public void getTransferRepresentation() {
        assertEquals("data.Image BATMAN " + data, imageMessage.getTransferRepresentation());
    }

    @Test
    public void prettyPrint() {
        assertEquals("data.Image BATMAN " + data + " " +
                "           *                        *           \n" +
                "       ****          *    *          ****       \n" +
                "     ****            ******            ****     \n" +
                "   ******            ******            ******   \n" +
                "  *********         ********         *********  \n" +
                " ********************************************** \n" +
                "************************************************\n" +
                "************************************************\n" +
                "************************************************\n" +
                " ********************************************** \n" +
                "  *****       ********************       *****  \n" +
                "    ****       ***    ****    ***       ****    \n" +
                "       **       *      **      *       **       \n", imageMessage.prettyPrint());
    }

    @Test
    public void getDataObject() {
        assertEquals(data, imageMessage.getDataObject());
    }
}