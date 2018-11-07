package Woche4;
public class aufgabeZwei {
    /**
     * 1. 1st ring can always be removed/added
     * 2. if n-2 is removed and n-1 is present then n can be added/removed
     * 3. 1 ring per move
     * n-2(1) n-1(0) = n.canMove;
     */
    int iCount = 8;

    /**
     *
     * @param stick Status of the stick in byte, e.g (byte) 255 = 11111111
     * @param pos current appointed position, STARTS AT 0 TO 7, NOT 1 TO 8
     * @return true if 0, else false
     */
    static boolean isOnStick(byte stick, int pos){
        if ((stick >> pos & 1) == 0)
            return true;
        return false;
    }

    static boolean canMove(byte stick, int pos){
        if (!isOnStick(stick,pos-2) && isOnStick(stick,pos-1) || pos == 0)
            return true;
        return false;
    }

    /*
        byte move(byte stick, int pos, boolean on);
        void printStick(byte stick);
        byte solve(byte stick, int rings);
        byte unsolve(byte stick, int rings);
        */
    public static void main(String[] args) {
        //Test console
        byte bTest = (byte) 200;
        int iPos = 0;
        //
        int res1 = bTest >> iPos;
        int res2 = bTest >> iPos & 1;

        String s1 = String.format("%8s", Integer.toBinaryString(bTest & 0xFF)).replace(' ', '0');
        String s2 = String.format("%8s", Integer.toBinaryString(res1 & 0xFF)).replace(' ', '0');
        String s3 = String.format("%8s", Integer.toBinaryString(res2 & 0xFF)).replace(' ', '0');
        System.out.println(s1);
        System.out.println("BITWISE SHIFT BY "+ iPos +": " + s2);
        System.out.println("then " + s3);

        for (int i = 0; i < 8; i++) {
            System.out.println("POS " + i + " "+ isOnStick(bTest,i));
        }
    }
}
