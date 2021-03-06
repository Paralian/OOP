package network;

import message.Message;
import user.User;

public class Server implements Node {
    private Node[] clients;
    private int numberOfClients;

    public Server(int numberOfClients) {
        this.numberOfClients = numberOfClients;
        clients = new Node[numberOfClients];
    }

    @Override
    public void receive(Message message) {
        send(message);
    }

    @Override
    public void send(Message message) {
        for (int i = 0; i < numberOfClients; i++) {
            if (message.getRecipient().equals(clients[i].getUser())) {
                clients[i].receive(message);
                return;
            }
        }
    }

    @Override
    public void connect(Node receiver) {
        for (int i = 0; i < numberOfClients; i++){
            if (clients[i] == null) {
                clients[i] = receiver;
                break;
            }
        }
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public User getUser() {
        return null;
    }
}
