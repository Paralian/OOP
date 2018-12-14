package WasGehtApp.message;

import user.User;

abstract class AbstractMessage implements message.Message {
    private final user.User sender, recipient;

    /**
     * Constructor
     */
    protected AbstractMessage(User sender, User recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }

    /**
     * Returns the sender object.
     * @return the sender object
     */
    @Override
    public final User getSender() {
        return sender;
    }

    /**
     * Returns the recipient object.
     * @return the recipients object
     */
    @Override
    public final User getRecipient() {
        return recipient;
    }
}
