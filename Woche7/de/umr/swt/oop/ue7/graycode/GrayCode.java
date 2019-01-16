package de.umr.swt.oop.ue7.graycode;
import de.umr.swt.oop.ue7.util.StringUtil;

import java.util.Arrays;

public class GrayCode {
    private int codeLength;
    private String[] grayCode;
    private String[] searchArea;

    /**
     * Constructor of GrayCode
     * @param codeLength is the length of gray code
     */
    public GrayCode(int codeLength) {
        this.codeLength = codeLength;
        if (codeLength == 1) {
            this.grayCode = new String[]{"0", "1"};
        } else {
            GrayCode temp = new GrayCode(codeLength - 1);
            String[] result = new String[(int) Math.pow(2, codeLength)];
            for (int i = 0; i < temp.getGrayCode().length; i++) {
                result[i] = "0" + temp.getGrayCode()[i];
                result[result.length - 1 - i] = "1" + temp.getGrayCode()[i];
            }
            this.grayCode = result;
            resetSearchArea();
        }
    }

    /**
     * resets the search area back to the original gray code
     */
    public void resetSearchArea() {
        this.searchArea = Arrays.copyOf(grayCode, grayCode.length);
    }

    /**
     * gets the gray code
     * @return the String-Array representation of gray code
     */
    public String[] getGrayCode() {
        return grayCode;
    }

    /**
     * prints the gray code on a line
     */
    public void print() {
        for (String code : this.grayCode) {
            System.out.print(code + " ");
        }
    }

    /**
     * finds the index of a given code in gray code
     * @param code is the given code
     * @return the index of the given code in gray code
     */
    public int findCode(String code) {
        if (code.length() == 1) {
            if (searchArea[0].charAt(searchArea[0].length() - 1) == code.toCharArray()[0]) {
                resetSearchArea();
                return 0;
            } else {
                resetSearchArea();
                return 1;
            }
        }
        if (code.charAt(0) != searchArea[0].charAt(searchArea[0].length() - code.length())) {
            searchArea = Arrays.copyOfRange(searchArea, searchArea.length / 2, searchArea.length); // reduces the search area to the second half
            return searchArea.length + findCode(StringUtil.substring(code, 1, code.length()));
        } else {
            searchArea = Arrays.copyOfRange(searchArea, 0, searchArea.length / 2); // reduces the search area to the first half
            return findCode(StringUtil.substring(code, 1, code.length()));
        }
    }
}
