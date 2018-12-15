package message;

import data.Data;
import data.Image;
import user.User;

public class ImageMessage extends AbstractDataMessage {
    private Image image;
    private String mediaInfo;

    /**
     * Constructor
     */
    public ImageMessage(User sender, User recipient, Data data, Image image, String mediaInfo) {
        super(sender, recipient, data);
        this.image = image;
        this.mediaInfo = mediaInfo;
    }

    /**
     * Returns the information about the data object.
     * @return a String describing the data object
     */
    @Override
    public String getMediaInfo() {
        return mediaInfo;
    }
}
