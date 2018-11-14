<<<<<<< HEAD
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
=======
package Woche4;

import static java.lang.Math.*;

public class aufgabeEins {
    /**
     * converts a positive decimal integer into a simple binary number
     * @param n decimal integer to convert
     * @return  converted binary number
     */
    static String toBinary(int n) {
        final int BASE = 2;
        String result = "";
        if (n >= 0) {
            int power = (int) (log(n) / log(BASE));             //  get max power of 2 so that pow(2, power) <= n
            while (power >= 0 && n >= 0) {
                if (n - pow(BASE, power) >= 0) {                //  check if n larger than current set power of 2
                    result = result + "1";                      //  subtraction positive -> top bit = 1
                    n = n - ((int) pow(BASE, power));           //  update n
                    power--;
                } else {
                    result = result + "0";                      //  subtraction not positive -> top bit = 0
                    power--;                                    //  try next smaller power of 2
                }
            }
        } else {
            return "please use toTwosComplement";
        }
        return result;
    }
    
    /**
     * converts a decimal integer into a number in base 8
     * @param n decimal integer to convert
     * @return converted octal number
     */
    static String toOctal(int n) {
        final int BASE = 8;
        String result = "";
        if (n < 0) {
            n = n * (-1);
            result = "-";
        }
        int power = (int) (log(n) / log(BASE));             //  get max power of 8 so that pow(8, power) <= n
        while (power >= 0 && n >= 0) {
            int i = 0;
            while (n - pow(BASE, power) >= 0) {
                i++;                                        //  count how many 8's there are
                n = n - ((int) pow(BASE, power));
            }
            power--;
            result = result + i;                            //  record the first number, go on for second etc.
        }
        
        return result;                          // *thinking* this may work for any base if you take it from method signature
    }
    
    /**
     * converts a decimal integer into a binary number in two's complement with 8 bits total
     * @param n decimal integer to convert
     * @return converted binary number in two's complement
     */
    static String toTwosComplement(byte n) {
        String result;
        final int BASE = 2;
        int power = 6;
        if (n >= 0) {
            result = "0";
        } else {
            n = (byte) (n + 128);
            result = "1";
        }
        while (power >= 0 && n >= 0) {
            if (n - pow(BASE, power) >= 0) {
                result = result + "1";
                n = (byte) (n - (pow(BASE, power)));
                power--;
            } else {
                result = result + "0";
                power--;
            }
        }
        return result;
    }
    
    //  BONUS: number n in b's base, works for base 2-16
    /**
     * converts a decimal integer into any base 2-16
     * @param n decimal integer for conversion
     * @param b base of conversion
     * @return converted number n in base b
     */
    
    static String toBaseX(int n, int b) {
        if (b < 2 || b > 16) {
            return "INVALID BASE";
        }
        final int BASE = b;
        String result = "";
        if (n == 0) {
            return "0";             // just simplifying the method for case zero
        } else if (n < 0) {
            n = n * -1;
            result = "-";
        }
        int power = (int) (log(n) / log(BASE));             //  get max power of BASE so that pow(BASE, power) <= n
        char c[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'}; // base digits
        while (power >= 0 && n >= 0) {
            int i = 0;
            while (n - pow(BASE, power) >= 0) {
                i++;                                        //  count how many BASE's there are in n
                n = n - ((int) pow(BASE, power));           //  update n
            }
            power--;                                        //  go to lower power
            result = result + c[i];                         //  record that first number, go on for the next etc.
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int a = 42;
        int b = 25;
        int n = -120;
        byte c = -128;
        byte d = 5;
        
        
        
        System.out.println(a + " in BIN1C is: " + toBinary(a));
        System.out.println("-- Why do mathematicians have trouble holding Halloween and Christmas apart?\n" +
                "-- Because OCT" + toOctal(b) + " = DEC25");
        System.out.println("103 in BIN1C is " + toBinary(103));
        System.out.println(c + " in BIN2C: " + toTwosComplement(c));
        System.out.println(d + " in BIN2C: " + toTwosComplement(d));
        System.out.println(n + " in BIN2C: " + toTwosComplement((byte) n));
        System.out.println("For comparison with toBinaryString() result: " + Integer.toBinaryString((n & 0xFF) + 256).substring(1));
        System.out.println("-42 in BaseX where X is 16: " + toBaseX(-42, 16));
>>>>>>> c04ffdb9313c7021d7b694e0ef34a170020edd6b
    }
}
