public class aufgabeZwei {
    static boolean isOnStick(byte stick, int pos) {
        return ((stick >> (pos - 1)) & 1) == 0;
    }

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
            if (!isOnStick(stick, pos - 1)) {
                return  false;
            }
            return true;
        }
    }

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

    static void printStick(byte stick) {
        System.out.println(Integer.toBinaryString((stick & 0xFF) + 256).substring(1));
    }

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
        solve((byte) 0,4);
        System.out.println();
        unsolve((byte) 15,4);
    }
}
