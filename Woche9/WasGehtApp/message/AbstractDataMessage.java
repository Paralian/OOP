package message;

import data.Data;
import user.User;

abstract class AbstractDataMessage extends AbstractMessage implements DataMessage {
    private data.Data data;

    /**
     * Constructor
     */
    protected AbstractDataMessage(User sender, User recipient, Data data) {
        super(sender, recipient);
        this.data = data;
    }

    /**
     * Returns the transfer representation of this message as a string.
     * @return the transfer representation of this message.
     */
    @Override
    public String getTransferRepresentation() {
        return data.getClass().getName() + " " + getMediaInfo() + " " + getDataObject();
    }

    /**
     * Returns the pretty printed representation of a message. This is a simple String in this case!
     * @return the pretty printed representation as string
     */
    @Override
    public String prettyPrint() {
        return getTransferRepresentation() + " " + data.prettyPrint();
    }

    /**
     * Returns the information about the data object.
     * @return a String describing the data object
     */
    public String getMediaInfo() {
        return null;
    }

    /**
     * Returns the data object;
     * @return the data object
     */
    public Data getDataObject() {
        return data;
    }
}
