package Woche4;
public class aufgabeZweiIterative {

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

    /**
     * checks if the appointed position in the board can be moved
     * @param stick current status of the board
     * @param pos current position
     * @return true if it can be moved, false otherwise
     */
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

    /**
     * moved the selected slot if possible
     * @param stick current status of the board
     * @param pos current position
     * @param on set to true to insert a ring, false to remove one
     * @return board state after moving
     */
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

    /**
     * prints the current board state
     * @param stick current status of the board
     */
    static void printStick(byte stick){
        System.out.println(String.format("%8s", Integer.toBinaryString(stick & 0xFF)).replace(' ', '0'));
    }

    /**
     * solves the board up to the rings-th position
     * @param stick current status of the board
     * @param rings desired position to solve the board to
     * @return solved board
     */
    static byte solve(byte stick, int rings) { //1111 1111
        //canMove() left to right iteration, switches bit value
        for (int i = rings; i > 0; i--) {
            if (canMove(stick,i)) {
                if (isOnStick(stick,i)) {
                    stick = move(stick,i,false);
                    printStick(stick);
                }
                else {
                    stick = move(stick,i,true);
                    printStick(stick);
                }
            }
        }

        //prevents @98 loop after recursion
        if (isSolved(stick, rings)){
            return stick;
        }
        //switches bit value at pos 0
        if (isOnStick(stick,0)){
            stick = move(stick,0,false);
            printStick(stick);
        } else {
            stick = move(stick,0,true);
            printStick(stick);
        }

        //recursion
        if (!isSolved(stick,rings))
            solve(stick, rings);

        return stick;
    }

    /**
     * recursive method for solve()
     * @param stick current status of the board
     * @param rings desired position to solve the board to
     * @return true if the first rings-rings are solved, false otherwise
     */
    static boolean isSolved(byte stick, int rings){
        for (int i = rings; i >= 0; i--) {
            if (isOnStick(stick,i))
                return false;
        }
        return true;
    }

    /**
     * unsolves the board up to the rings-th position
     * @param stick current status of the board
     * @param rings desired position to unsolve the board to
     * @return unsolved board
     */
    static byte unsolve(byte stick, int rings) { //1111 1111
        //checks canMove() from left to right, resets bit value
        for (int i = rings; i > 0; i--) {
            if (canMove(stick,i)) {
                if (isOnStick(stick,i)) {
                    stick = move(stick,i,false);
                    printStick(stick);
                }
                else {
                    stick = move(stick,i,true);
                    printStick(stick);
                }
            }
        }

        if (isUnsolved(stick,rings)){
            return stick;
        }

        //resets bit value at pos 0
        if (isOnStick(stick,0)){
            stick = move(stick,0,false);
            printStick(stick);
        } else {
            stick = move(stick,0,true);
            printStick(stick);
        }

        if (!isUnsolved(stick,rings))
            unsolve(stick, rings);

        return stick;
    }

    /**
     * recursive method for unsolve()
     * @param stick current status of the board
     * @param rings desired position to solve the board to
     * @return true if the first rings-rings are unsolved, false otherwise
     */
    static boolean isUnsolved(byte stick, int rings){
        for (int i = rings; i >= 0; i--) {
            if (!isOnStick(stick,i))
                return false;
        }
        return true;
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

        printStick(bTest);
        String s2 = String.format("%8s", Integer.toBinaryString(res1 & 0xFF)).replace(' ', '0');
        System.out.println("BITWISE SHIFT BY "+ iPos +": " + s2);

        /**
         * isOnStick() TEST CONSOLE
         */
        System.out.print("isOnStick() TEST for "); printStick(bTest);
        for (int i = 0; i < 8; i++) {
            System.out.println("POS " + i + " "+ isOnStick(bTest,i));
        }

        /**
         * canMove() TEST CONSOLE
         */
        byte moveTest = (byte) 191;
        System.out.print("canMove() TEST for ");
        printStick(moveTest);
        System.out.println("canMove: " + canMove(moveTest,7));

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
         * printStick() AND solve(), unsolve() TEST CONSOLE
         * Remove the 2 comments to see the steps in console
         */
        System.out.print("solve() TEST with ");
        printStick((byte) 0);
        //solve((byte) 0,7);
        System.out.print("unsolve() TEST with ");
        printStick((byte) 255);
        System.out.println("remember to remove the comments in source code");
        //unsolve((byte) 255, 7);
    }
}
