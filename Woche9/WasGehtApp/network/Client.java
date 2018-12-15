package network;

import message.AudioMessage;
import message.ImageMessage;
import message.Message;
import message.TextMessage;
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

    public void send(User recipient, data.Data data, data.Audio audio)  {
        AudioMessage audioMessage = new AudioMessage(user, recipient, data, audio);
        send(audioMessage);
    }

    public void send(User recipient, data.Data data, data.Image image, String description)  {
        ImageMessage imageMessage = new ImageMessage(user, recipient, data, image, description);
        send(imageMessage);
    }

    public void send(User recipient, String transferRepresentation)  {
        TextMessage textMessage = new TextMessage(user, recipient, transferRepresentation);
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
