package message;

import user.User;

public interface Message {

    /**
     * Returns the sender object.
     * @return the sender object
     */
    User getSender();

    /**
     * Returns the recipient object.
     * @return the recipients object
     */
    User getRecipient();

    /**
     * Returns the transfer representation of this message as a string.
     * @return the transfer representation of this message.
     */
    String getTransferRepresentation();

    /**
     * Returns the pretty printed representation of a message. This is a simple String in this case!
     * @return the pretty printed representation as string
     */
    String prettyPrint();
}
