package message;

import user.User;

public class TextMessage extends AbstractMessage {
    private final String transferRepresentation;

    /**
     * Constructor
     */
    public TextMessage(User sender, User recipient, String transferRepresentation) {
        super(sender, recipient);
        this.transferRepresentation = transferRepresentation;
    }

    /**
     * Returns the transfer representation of this message as a string.
     * @return the transfer representation of this message.
     */
    public String getTransferRepresentation() {
        return transferRepresentation;
    }

    /**
     * Returns the pretty printed representation of a message. This is a simple String in this case!
     * @return the pretty printed representation as string
     */
    public String prettyPrint() {
        return getSender().getUserName() + " -> " + getRecipient().getUserName() + ": " + getTransferRepresentation();
    }
}
