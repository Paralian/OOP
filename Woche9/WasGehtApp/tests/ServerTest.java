import data.Audio;
import data.Data;
import data.Image;
import network.Client;
import network.Server;
import user.User;

import static org.junit.Assert.*;

public class ServerTest {
    public static void main(String[] args) {
        Server s = new Server(3);
        Client a = new Client(new User(101, "Alice", "", ""));
        Client b = new Client(new User(102, "Bob", "", ""));
        Client c = new Client(new User(103, "Charle", "", ""));
        Data imageData = new Image();
        Data audioData = new Audio();

        a.connect(s);
        s.connect(a);
        b.connect(s);
        s.connect(b);
        c.connect(s);
        s.connect(c);

        a.send(c.getUser(), "Hi Charle!");
        b.send(a.getUser(), imageData, new Image(), "BATMAN");
        c.send(b.getUser(), audioData, new Audio());
    }
}