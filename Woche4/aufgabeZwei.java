package Woche4;
public class aufgabeZwei {
    /**
     * 1. 1st ring can always be removed/added
     * 2. if n-2 is removed and n-1 is present then n can be added/removed
     * 3. 1 ring per move
     */
    int iCount = 8;
    boolean isOnStick(byte stick, int pos){
        if (pos == 0){
            return true;
        }
        return false;
    }
    boolean canMove(byte stick, int pos);
    byte move(byte stick, int pos, boolean on);
    void printStick(byte stick);
    byte solve(byte stick, int rings);
    byte unsolve(byte stick, int rings);
}
