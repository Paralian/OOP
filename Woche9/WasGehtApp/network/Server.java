package WasGehtApp.network;

import message.Message;
import network.Node;
import user.User;

public class Server implements network.Node {
    private Node[] nodes;
    private int numberOfNodes;

    public Server(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        this.nodes = new Node[numberOfNodes];
    }

    @Override
    public void receive(Message message) {

    }

    @Override
    public void send(Message message) {

    }

    @Override
    public void connect(Node receiver) throws Exception {

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
