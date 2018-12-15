import data.Audio;
import data.Data;
import data.Image;
import network.Client;
import user.User;

import static org.junit.Assert.*;

public class ClientTest {
    public static void main(String[] args) {
        Client client1 = new Client(new User(101, "Deadpool", "Wade", "Wilson"));
        Client client2 = new Client(new User(102, "Spiderman", "Peter", "Parker"));
        Data imageData = new Image();
        Data audioData = new Audio();
        client1.connect(client2);
        client2.connect(client1);

        client1.send(client2.getUser(), "Hello there");
        client2.send(client1.getUser(), imageData, new Image(), "BATMAN");
        System.out.println(imageData.prettyPrint());
        client1.send(client2.getUser(), audioData, new Audio());
        System.out.println(audioData.prettyPrint());
    }
}