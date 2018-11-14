package Woche4;

import static java.lang.Integer.toBinaryString;

public class aufgabeZwei {
    /**
     * checks if ring at current position is on the stick
     * @param stick the playing stick in current state
     * @param pos position of the pointer, usage: (1<<--pos)
     * @return TRUE if ring is on stick, otherwise FALSE
     */
    static boolean isOnStick(byte stick, int pos) {      // pos = [1,8]
        return ((~stick & (1 << --pos)) == (1 << --pos));             // invert stick, pass through AND-mask of position
    }
    
    /**
     * checks if current position is OK for putting a ring on it or taking it off
     * @param stick the playing stick in current state
     * @param pos position of the pointer
     * @return TRUE if current position is suitable for re/moving a ring, FALSE otherwise
     */
    static boolean canMove(byte stick, int pos) {               // pos movable if pos-1 on and pos-2 to 0 off
        return (pos == 1) || ((isOnStick(stick, pos - 1)) && (((~stick >>> pos - 2) << pos - 2) == ~stick));     // ~stick & mask == mask?
    }
    
    /**
     * moves the ring at the set position on or off the ring
     * @param stick the playing stick in current state
     * @param pos position of the pointer, usage: (1<<--pos)
     * @param on TRUE for putting ring on, FALSE for taking ring off
     * @return stick with new ring or old ring removed
     */
    static byte move(byte stick, int pos, boolean on) {
        if (canMove(stick, pos)) {                              // check if movable
            if (on) {
                stick = (byte) (stick & ~(1 << --pos));         // ring on & removable -> take ring off
            } else {
                stick = (byte) (stick | (1 << --pos));          // ring off & can be added -> put ring on
            }
        }
        return stick;
    }
    
    /**
     * prints the current state of stick on console
     * @param stick the stick for printing
     */
    static void printStick(byte stick) {
        System.out.println(toBinaryString((stick & 0xFF) + 256).substring(1));
    }
    
    /**
     * solves the 00000000 stick into xxxx1111 stick
     * @param stick the starting stick
     * @param rings number of rings to be taken off of the stick at n rightmost positions
     * @return solved stick with n rightmost rings off
     */
    
    
    public static void main(String[] args) {
    
        System.out.println("\n");
        
    }
}
