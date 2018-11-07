package Woche4;
public class aufgabeZwei {
    /**
     * 1. 1st ring can always be removed/added
     * 2. if n-2 is removed and n-1 is present then n can be added/removed
     * 3. 1 ring per move
     * n-2(0) n-1(1) = n-1.canMove;
     */
    int iCount = 8;

    /**
     *
     * @param stick Status of the stick in byte, e.g (byte) 255 = 11111111
     * @param pos current appointed position
     * @return true if 0, else false
     */
    static boolean isOnStick(byte stick, int pos){
        if ((stick >> pos & 1) == 0)
            return true;
        return false;
    }
    /*
        boolean canMove(byte stick, int pos){
            if ()
                return true;
            return false;
        }

        byte move(byte stick, int pos, boolean on);
        void printStick(byte stick);
        byte solve(byte stick, int rings);
        byte unsolve(byte stick, int rings);
        */
    public static void main(String[] args) {
        byte bTest = (byte) 200;
        String s1 = String.format("%8s", Integer.toBinaryString(bTest & 0xFF)).replace(' ', '0');
        int iPos = 0;
        System.out.println(s1);

        int res1 = bTest >> iPos;
        int res2 = bTest >> iPos & 1;

        String s2 = String.format("%8s", Integer.toBinaryString(res1 & 0xFF)).replace(' ', '0');
        String s3 = String.format("%8s", Integer.toBinaryString(res2 & 0xFF)).replace(' ', '0');
        System.out.println("BITWISE SHIFT BY "+ iPos +": " + s2);
        System.out.println("then " + s3);

        for (int i = 0; i < 8; i++) {
            System.out.println("POS " + i + " "+ isOnStick(bTest,i));

        }
    }
}
