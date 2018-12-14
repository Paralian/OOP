package WasGehtApp.message;

import data.Data;
import data.Image;
import user.User;

public class ImageMessage extends AbstractDataMessage {
    private Image image;
    private String description;

    /**
     * Constructor
     */
    public ImageMessage(User sender, User recipient, Data data, Image image, String description) {
        super(sender, recipient, data);
        this.image = image;
        this.description = description;
    }

    /**
     * Returns the information about the data object.
     * @return a String describing the data object
     */
    @Override
    public String getMediaInfo() {
        return description;
    }
}
