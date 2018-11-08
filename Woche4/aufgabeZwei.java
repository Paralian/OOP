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
        
    }

    public static void main(String[] args) {
        System.out.println(isOnStick((byte) 23,5));
        System.out.println(canMove((byte) 23,5));
        printStick(move((byte) 23,5,true));
    }
}
