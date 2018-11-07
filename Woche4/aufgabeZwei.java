package Woche4;

import static java.lang.Math.*;

public class aufgabeZwei {
    static boolean isOnStick(byte stick, int pos) {      // pos = [0,7]
        return ((~stick & (1 << pos)) != 0);             // invert stick, pass through AND-mask of position
    }
    
    static boolean canMove(byte stick, int pos) {
        return ((~stick & (byte) (pow(2, pos - 1))) == (byte) pow(2, pos - 1));     // ~stick & mask == mask?
    }
    
    static byte move(byte stick, int pos, boolean on) {
        if (canMove(stick, pos)) {
            if (isOnStick(stick, pos) && !on) {
                stick = (byte) ~(~stick & ~pos);     // ring on stick & movable -> take ring off
            }
            else{
                stick = (byte) (stick | pos);       // ring not on stick, stick ringable -> put ring on
            }
        }
        return stick;
    }
    
    static void printStick(byte stick) {
        String result = "";
        int power = 8;             //  get max power of 2 so that pow(2, power) <= n
        while (power >= 0 && stick >= 0) {
            if (stick - pow(2, power) >= 0) {
                result = result + "1";                      //  subtraction positive -> top bit = 1
                stick = (byte) (stick - (pow(2, power)));           //  subtract
                power--;
            } else {
                result = result + "0";                      //  subtraction not positive -> top bit = 0
                power--;                                    //  try next smaller power of 2
            }
        }
        System.out.println(result);
    }
    
    static byte solve(byte stick, int rings) {
        //TODO  printStick after every step
        return stick;
    }
    
    static byte unsolve(byte stick, int rings) {
        //TODO  printStick after every step
        return stick;
    }
    
    public static void main(String[] args) {
        byte stick = (byte) 255;
        int rings = 0;
        solve(stick, rings);
        unsolve(stick, rings);
        
    }
}
