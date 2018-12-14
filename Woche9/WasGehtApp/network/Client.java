package WasGehtApp.network;

import WasGehtApp.message.AudioMessage;
import WasGehtApp.message.ImageMessage;
import WasGehtApp.message.TextMessage;
import message.Message;
import network.Node;
import user.User;

public class Client implements Node {
    private User user;
    private Node node;

    /**
     * Constructor
     */
    public Client(User user) {
        this.user = user;
    }

    @Override
    public void receive(Message message) {
        System.out.println(message.getSender().getId() + ": " + message.getTransferRepresentation());
    }

    @Override
    public void send(Message message) {
        node.receive(message);
    }

    public void send(User sender, User recipient, data.Data data, data.Audio audio)  {
        AudioMessage audioMessage = new AudioMessage(sender, recipient, data, audio);
        send(audioMessage);
    }

    public void send(User sender, User recipient, data.Data data, data.Image image, String description)  {
        ImageMessage imageMessage = new ImageMessage(sender, recipient, data, image, description);
        send(imageMessage);
    }

    public void send(User sender, User recipient, String transferRepresentation)  {
        TextMessage textMessage = new TextMessage(sender, recipient, transferRepresentation);
        send(textMessage);
    }

    @Override
    public void connect(Node node) {
        this.node = node;
    }

    @Override
    public int getId() {
        return user.getId();
    }

    @Override
    public User getUser() {
        return user;
    }
}
