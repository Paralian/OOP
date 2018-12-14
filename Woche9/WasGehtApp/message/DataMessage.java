package message;

import data.Data;

public interface DataMessage extends message.Message {
    /**
     * Returns the information about the data object.
     * @return a String describing the data object
     */
    String getMediaInfo();

    /**
     * Returns the data object.
     * @return the data object
     */
    Data getDataObject();
}
