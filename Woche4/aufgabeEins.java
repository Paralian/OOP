package Woche4;

import static java.lang.Math.*;

public class aufgabeEins {
    static String toBinary(int n) {
        final int BASE = 2;
        String result = "";
        if (n > 0) {
            int power = (int) (log(n) / log(BASE));             //  get max power of 2 so that pow(2, power) <= n
            while (power >= 0 && n >= 0) {
                if (n - pow(BASE, power) >= 0) {
                    result = result + "1";                      //  subtraction positive -> top bit = 1
                    n = n - ((int) pow(BASE, power));           //  subtract
                    power--;
                } else {
                    result = result + "0";                      //  subtraction not positive -> top bit = 0
                    power--;                                    //  try next smaller power of 2
                }
            }
        } else {
            result = "should be 0 but n is not allowed to be 0 so 42 is the answer";
        }
        return result;
    }
    
    static String toOctal(int n) {
        final int BASE = 8;
        String result = "";
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

public static void main(String[]args){
        int a=42;
        int b=25;
        byte c=-128;
        byte d=5;
        
        System.out.println(a+" in binary is: "+toBinary(a));
        System.out.println("-- Why do mathematicians have trouble holding Halloween and Christmas apart?\n"+
        "-- Because OCT"+toOctal(b)+" = DEC25");
        System.out.println(c+" in 2C: "+toTwosComplement(c));
        System.out.println(d+" in 2C: "+toTwosComplement(d));
        }
        }
