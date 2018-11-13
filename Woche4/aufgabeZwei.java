public class aufgabeZwei {
    /**
     * checks if the ring at the selected position is on the stick
     * @param stick current state of the stick in byte, e.g (byte) 255 = 11111111
     * @param pos current selected position
     * @return true if yes, otherwise false
     */
    static boolean isOnStick(byte stick, int pos) {
        return ((stick >> (pos - 1)) & 1) == 0;
    }

    /**
     * checks if the ring at the selected position on the stick can be moved
     * @param stick current state of the stick
     * @param pos current selected position
     * @return true if yes, otherwise false
     */
    static boolean canMove(byte stick, int pos) {
        if (pos == 1) {
            return true;
        } else {
            if ((pos == 2) && !isOnStick(stick,1)) {
                return false;
            }
            for (int i = 1; i < pos - 1; i++) {
                if (isOnStick(stick, i)) {
                    return false;
                }
            }
            return isOnStick(stick, pos - 1);
        }
    }

    /**
     * moves the ring at the selected position on the stick if possible
     * @param stick current state of the stick
     * @param pos current selected position
     * @param on set to true to insert ring, false to remove
     * @return state of the stick after moving
     */
    static byte move(byte stick, int pos, boolean on) {
        if (canMove(stick,pos)) {
            if (!isOnStick(stick,pos) && on) {
                stick = (byte) (stick & ~(1 << (pos - 1)));
            }
            if (isOnStick(stick,pos) && !on) {
                stick = (byte) (stick | (1 << (pos - 1)));
            }
        }
        return stick;
    }

    /**
     * prints the current state of the stick
     * @param stick current state of the stick
     */
    static void printStick(byte stick) {
        System.out.println(Integer.toBinaryString((stick & 0xFF) + 256).substring(1));
    }

    /**
     * removes the first <rings> rings from the stick
     * @param stick current state of the stick
     * @param rings number of rings to be removed
     * @return state of the stick after removing
     */
    static byte solve(byte stick, int rings) {
        if (rings == 1) {
            stick = move(stick, 1,false);
            printStick(stick);
            return stick;
        }
        if (rings == 2) {
            stick = move(stick, 2,false);
            printStick(stick);
            stick = solve(stick, 1);
            return stick;
        } else {
            stick = solve(stick,rings - 2);
            stick = move(stick, rings,false);
            printStick(stick);
            stick = unsolve(stick,rings - 2);
            stick = solve(stick, rings - 1);
            return stick;
        }
    }

    /**
     * inserts the first <rings> rings to the stick
     * @param stick current state of the stick
     * @param rings number of rings to be inserted
     * @return state of the stick after inserting
     */
    static byte unsolve(byte stick, int rings) {
        if (rings == 1) {
            stick = move(stick, 1,true);
            printStick(stick);
            return stick;
        }
        if (rings == 2) {
            stick = unsolve(stick, 1);
            stick = move(stick, 2, true);
            printStick(stick);
            return stick;
        } else {
            stick = unsolve(stick,rings - 1);
            stick = solve(stick, rings - 2);
            stick = move(stick, rings,true);
            printStick(stick);
            stick = unsolve(stick, rings - 2);
            return stick;
        }
    }

    public static void main(String[] args) {
        solve((byte) 0,3);
        System.out.println();
        unsolve((byte) 15,4);
    }
}
