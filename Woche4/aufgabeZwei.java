package Woche4;
public class aufgabeZwei {
    /**
     * 1. 1st ring can always be removed/added
     * 2. if n-2 is removed and n-1 is present then n can be added/removed
     * 3. 1 ring per move
     * n-2 -> 0(1) && n-1(0) = n.canMove;
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


    static boolean canMove(byte stick, int pos) {
        if (pos == 0)
            return true;
        if (pos == 1 && isOnStick(stick,0))
            return true;
        if (pos>= 2 && isOnStick(stick,pos-1)){
            for (int i = 0; i < pos-1; i++) {
                if (isOnStick(stick,i))
                    return false;
            }
            return true;
        }
        return false;
    }

    static byte move(byte stick, int pos, boolean on){
        if (canMove(stick, pos)){
            if (on) {//true, 1 -> 0, unset the bit
                stick = (byte) (stick & ~(1 << pos));
                return stick;
            }
            else {//false, 0 -> 1, set the bit
                stick = (byte) (stick | (1 << pos));
                return stick;
            }
        }
        return stick;
    }

    static void printStick(byte stick){
        System.out.println(String.format("%8s", Integer.toBinaryString(stick & 0xFF)));
    }

    static byte solve(byte stick, int rings){//all to 1
        //TODO:make pos.canMove -> rings recursive
        //TODO: scan canMove() after every move()
        for (int i = 0; i <= rings; i++) {
            if (isOnStick(stick,i)) {
                stick = move(stick, i, false);
                printStick(stick);
            }
            else {
                stick = move(stick,i,true);
                printStick(stick);
            }

        }
        return stick;
    }
    /*
        byte unsolve(byte stick, int rings);
        */
    public static void main(String[] args) {
        //TODO: test console cleanup
        /**
         * BYTE STRING CONVERSION TEST CONSOLE
         */
        byte bTest = (byte) 23;
        int iPos = 4;

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

        /**
         * canMove() TEST CONSOLE
         */
        byte moveTest = (byte) 191;
        printStick(moveTest);
        System.out.println("canMove " + canMove(moveTest,7));

        /**
         * isOnStick(), canMove(), move() TEST CONSOLE
         */
        byte bTest2 = (byte) 23;
        int iPos2 = 4;
        boolean on = true;

        String s4= String.format("%8s", Integer.toBinaryString(bTest2 & 0xFF)).replace(' ', '0');
        System.out.println(s4 + " pos " +iPos2+" is on stick: " +isOnStick(bTest,iPos2)
                +" can move: "+ canMove(bTest2,iPos2));
        byte res3 = move(bTest2,iPos2,on);
        System.out.println("res3: "+res3);
        String s5 = String.format("%8s", Integer.toBinaryString(res3 & 0xFF)).replace(' ', '0');
        System.out.println("moved string: "+s5);

        /**
         * printStick() TEST CONSOLE
         */
        printStick(bTest2);
        printStick(res3);
        /**
         * solve() AND unsolve() TEST CONSOLE
         */
        System.out.println("solve() TEST with " + s4);
        solve(bTest2,7);
    }
}
