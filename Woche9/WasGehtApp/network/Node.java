package network;

import message.Message;
import user.User;

public interface Node {
    /**
     * receives a Message
     * @param message
     */
    void receive(Message message);
    /**
     * sends a Message
     * @param message
     */
    void send(Message message);

    /**
     * Connect to a Node
     * @param receiver
     */
    void connect(Node receiver) throws Exception;

    /**
     * Returns the ID/Number of a Node.
     * @return the ID/Number
     */
    int getId();

    /**
     * Returns the user of a Node.
     * @return the user
     */
    User getUser();
}
