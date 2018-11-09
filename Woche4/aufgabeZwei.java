package Woche4;

import static java.lang.Integer.toBinaryString;
import static java.lang.Math.*;

public class aufgabeZwei {
    static boolean isOnStick(byte stick, int pos) {      // pos = [1,8]
        return ((~stick & (1 << (pos - 1))) == (1 << (pos - 1)));             // invert stick, pass through AND-mask of position
    }
    
    static boolean canMove(byte stick, int pos) {               // pos movable if pos-1 on and pos-2 to 0 off
        return (pos == 1) || ((isOnStick(stick, pos - 1)) && (((~stick >>> pos - 2) << pos - 2) == ~stick));     // ~stick & mask == mask?
    }
    
    static byte move(byte stick, int pos, boolean on) {
        if (canMove(stick, pos)) {
            if (isOnStick(stick, pos) && !on) {
                stick = (byte) ~(~stick & ~(1 << (pos - 1)));     // ring on stick & movable -> take ring off
            } else {
                stick = (byte) (stick | (1 << (pos - 1)));       // ring not on stick, stick ringable -> put ring on
            }
        }
        return stick;
    }
    
    static void printStick(byte stick) {
        System.out.println(toBinaryString((stick & 0xFF) + 256).substring(1));
    }
    
    static byte solve(byte stick, int rings) {
        if (rings == 1) {
            stick = move(stick, 1, false);
            printStick(stick);
            return stick;
        }
        if (rings == 2) {
            stick = move(stick, 2, false);
            printStick(stick);
            stick = solve(stick, 1);
            return stick;
        } else {
            stick = solve(stick, rings - 2);
            stick = move(stick, rings, false);
            printStick(stick);
            stick = unsolve(stick, rings - 2);
            stick = solve(stick, rings - 1);
            return stick;
        }
    }
    
    static byte unsolve(byte stick, int rings) {
        if (rings == 1) {
            stick = move(stick, 1, true);
            printStick(stick);
            return stick;
        }
        if (rings == 2) {
            stick = unsolve(stick, 1);
            stick = move(stick, 2, true);
            printStick(stick);
            return stick;
        } else {
            stick = unsolve(stick, rings - 1);
            stick = solve(stick, rings - 2);
            stick = move(stick, rings, true);
            printStick(stick);
            stick = unsolve(stick, rings - 2);
            return stick;
        }
    }
    
    public static void main(String[] args) {
        solve((byte) 0, 3);
    }
}
