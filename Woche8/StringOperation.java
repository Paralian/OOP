public class StringOperation {
    /**
     * replaces all the occurrences of a substring in a string with another substring
     * @param source is the original string
     * @param search is the substring to be replaced
     * @param replace is the replacing substring
     * @return a new string resulting from the replacing operation
     */
    static String replace(String source, String search, String replace) {
        String result = source;
        int i = source.indexOf(search);
        while (i != -1) {
            result = result.substring(0, i) + replace + result.substring(i + search.length());
            i = result.indexOf(search);
        }
        return result;
    }

    /**
     * checks if a string is a palindrome
     * @param string the string to be tested
     * @return true if yes, else false
     */
    static boolean isPalindrome(String string) {
        String modifiedString = string.toUpperCase();
        String[] puncMarkArr = new String[]{" ", ".", "?", "!", ",", ";", ":", "\"", "'"};
        for (String puncMark : puncMarkArr) {
            modifiedString = replace(modifiedString, puncMark, "");
        }
        return modifiedString.equals(new String(new StringBuilder(modifiedString).reverse()));
    }

    /**
     * checks if the characters of a word are sorted in an ascending or descending order
     * @param string is the word whose characters are to be checked
     * @param ascending is the order: ascending if true, descending if false
     * @return true if yes, else false
     */
    static boolean isSorted(String string, boolean ascending) {
        String modifiedString = string.toUpperCase();
        for (int i = 0; i < modifiedString.length() - 1; i++) {
            int compareValue = modifiedString.substring(i, i+1).compareTo(modifiedString.substring(i+1, i+2));
            if ((ascending && (compareValue > 0)) || (!ascending && (compareValue < 0))) {
                return false;
            }
        }
        return true;
    }
}
