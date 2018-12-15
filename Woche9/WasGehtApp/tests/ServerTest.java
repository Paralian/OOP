import data.Audio;
import data.Data;
import data.Image;
import network.Client;
import network.Server;
import org.junit.Test;
import user.User;

import static org.junit.Assert.*;

public class ServerTest {
    public static void main(String[] args) throws Exception {
        Server s = new Server(3);

        Client a = new Client(new User(0, "A", "", ""));
        a.connect(s);
        s.connect(a);

        Client b = new Client(new User(1, "B", "", ""));
        b.connect(s);
        s.connect(b);

        Client c = new Client(new User(2, "C", "", ""));
        c.connect(s);
        s.connect(c);

        Data imageData = new Image();
        Data audioData = new Audio();

        a.send(s, imageData, new Image(), "BATMAN");
    }
}