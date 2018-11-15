public class aufgabeEins {
    /**
     * converts the given integer (decimal) to binary form
     * @param n the integer to be converted
     * @return binary form of the given integer
     */
    static String toBinary(int n) {
        String result ="";
        int i = n;
        if (i == 0) {
            return "0";
        }
        while (i != 0) {
            result = (i % 2) + result;
            i = i / 2;
        }
        return result;
    }

    /**
     * converts the given integer (decimal) to octal form
     * @param n the integer to be converted
     * @return octal form of the given integer
     */
    static String toOctal(int n) {
        String result ="";
        int i = n;
        if (i == 0) {
            return "0";
        }
        while (i != 0) {
            result = (i % 8) + result;
            i = i / 8;
        }
        return result;
    }

    /**
     * convert the given integer (decimal) to 2'complement form
     * @param n the integer to be converted
     * @return 2'complement form of the given integer
     */
    static String toTwosComplement(byte n) {
        String result = "0" + toBinary(n);
        result = result.replaceAll("-","");
        if (n >= 0) {
            return result;
        } else {
            String onesComplement = "";
            for (int i = result.length() - 1; i >= 0; i--) {
                if (result.charAt(i) == '1') {
                    onesComplement = "0" + onesComplement;
                } else {
                    onesComplement = "1" + onesComplement;
                }
            }
            System.out.println(n + " in Einerkomplement ist " + onesComplement);
            result = "";
            int carryOver = 1;
            for (int i = onesComplement.length() - 1; i >= 0; i--) {
                if (onesComplement.charAt(i) == '0') {
                    if (carryOver == 0) {
                        result = "0" + result;
                    } else {
                        result = "1" + result;
                        carryOver = 0;
                    }
                }
                if (onesComplement.charAt(i) == '1') {
                    if (carryOver == 0) {
                        result = "1" + result;
                    } else {
                        result = "0" + result;
                        carryOver = 1;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = -126;
        System.out.println("47 in Binaerdarstellung ist " + toBinary(47));
        System.out.println("172 in Oktaldarstellung ist " + toOctal(172));
        System.out.println(n + " in Zweierkomplement ist " + toTwosComplement((byte) n));
        System.out.println("Zum Vergleichen steht das Ergebnis des Befehls toBinaryString zur Verfuegung: " + Integer.toBinaryString((n & 0xFF) + 256).substring(1));
    }
}