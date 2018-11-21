package Woche6;

class TicTacToe{
    public int[][] box;

    /**
     * box format is [vertical][horizontal]
     */
    public TicTacToe() {
        box = new int[3][3];
    }

    public void print() {
        System.out.println("Current boardstate");
        String spacing = "      ";
        // x and y axis iteration
        for (int j = 0; j < box.length; j++) {
            for (int k = 0; k < box.length; k++) {
                System.out.print(box[j][k] + spacing);
            }
            System.out.println();
        }
    }

    /**
     * draws on the TicTacToe box, one move at a time
     * note: you can only mark on an empty box obviously
     * @param x x coor
     * @param y y coor
     * @param player the player making the move
     */
    public void mark(int x, int y, int player) {
        //throws OccupiedMark
        if (box[x][y] != 0){
            System.out.println("You can only mark an empty checkbox");
        }
        else if (player == 1) {
            box[x][y] = 1;
        }
        else if (player == 2) {
            box[x][y] = 2;
        }
    }

    /**
     * resets the playstate
     */
    public void reset() {
        box = new int[3][3];
    }

    /**
     * checks the player's wincon
     * @param player selected player
     * @return true if he/she a winner(3 checks in a line, diagonally counts)
     */
    public boolean hasWon(int player) {
        //horizontal check
        for (int j = 0; j < box.length; j++) {
            //horizontal iterator
            for (int i = 0; i < box.length; i++) {
                if (box[j][i] != player)
                    break;
            }
            return false;
        }
        //vertical check
        for (int j = 0; j < box.length; j++) {
            //vertical iterator
            for (int i = 0; i < box.length; i++) {
                if (box[i][j] != player)
                    break;
            }
            return false;
        }
        //diagonal check
        int a = 0;
        int b = 0;
        while (a < box.length && b < box.length) {
            if (box[a][b] != player) {
                a++;
                b++;
                break;
            }
            return false;
        }
        b = box.length;
        while (a < box.length && b < box.length) {
            if (box[a][b] != player) {
                a++;
                b--;
                break;
            }
            return false;
        }
        System.out.println("Player " + player + "has won !");
        return true;
    }

    /**
     * comments on methods' iterations
     * current iterations still works even with using nested box.length() twice because the board is always square
     * TODO: use the right bounds for the x and y arrays
     * @param args
     */
    public static void main(String[]args){
        TicTacToe tic = new TicTacToe();
        tic.print();
        tic.mark(1,1,1);
        tic.print();
        tic.mark(0,1,1);
        tic.mark(2,1,1);
        tic.print();
        tic.hasWon(1);
    }
}
