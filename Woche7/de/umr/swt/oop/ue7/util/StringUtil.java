package de.umr.swt.oop.ue7.util;

public class StringUtil {
    /**
     * gets a new string which is a copy of a given string within a given range
     * @param string is the given string
     * @param startIndex index at which the substring begins (inclusive)
     * @param endIndex index at which the substring extends to (exclusive)
     * @return the substring
     */
    public static String substring(String string, int startIndex, int endIndex) {
        if ((startIndex < 0) || (startIndex >= string.length()) || (string == null)) {
            return null;
        }
        if (endIndex > string.length()) {
            return substring(string, startIndex, string.length());
        } else {
            String result = "";
            for (int i = startIndex; i < endIndex; i++) {
                result = result + string.charAt(i);
            }
            return result;
        }
    }
}
