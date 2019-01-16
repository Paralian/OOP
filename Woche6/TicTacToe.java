public class TicTacToe {
    private static int[][] board = new int[3][3];

    /**
     * prints the current game board, O for player 1, X for player 2
     */
    private void print() {
        String temp = "";
        for (int[] innerArray : board) {
            for (int cell : innerArray) {
                if (cell == 0) {
                    temp = temp + "-";
                }
                if (cell == 1) {
                    temp = temp + "O";
                }
                if (cell == 2){
                    temp = temp + "X";
                }
            }
        }
        for (int y = 0; y < 3; y++) {
            for (int x = y; x < temp.length(); x += 3) {
                System.out.print(temp.charAt(x) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * marks a particular cell on board for the current active player
     * @param x is the x-coordinate of the chosen cell
     * @param y is the y-coordinate of the chosen cell
     * @param player is the current active player
     * @return false if the chosen cell does not exist or was marked, otherwise true
     */
    private boolean mark(int x, int y, int player) {
        if ((x < 0) || (x > 2) || (y < 0) || (y > 2) || (board[x][y] == 1) || (board[x][y] == 2)) {
            return false;
        } else {
            board[x][y] = player;
        }
        return true;
    }

    /**
     * resets the game board
     */
    private void reset() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = 0;
            }
        }
    }

    /**
     * checks if a player has won
     * @param player is the player in question
     * @return true if yes, otherwise false
     */
    private boolean hasWon(int player) {
        if (board[1][1] == player) {
            if (((board[1][0] == player) && (board[1][2] == player)) || ((board[0][1] == player) && (board[2][1] == player))) {
                return true;
            }
            if (((board[0][0] == player) && (board[2][2] == player)) || ((board[0][2] == player) && (board[2][0] == player))) {
                return true;
            }
        }
        if (board[0][0] == player) {
            if (((board[0][1] == player) && (board[0][2] == player)) || ((board[1][0] == player) && (board[2][0] == player))) {
                return true;
            }
        }
        if (board[2][2] == player) {
            return ((board[1][2] == player) && (board[0][2] == player)) || ((board[2][1] == player) && (board[2][0] == player));
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToe play = new TicTacToe();
        play.reset();
        play.print();
        System.out.println("Let the game begin!");
        play.mark(1, 1, 1);
        play.print();
        play.mark(1, 2, 2);
        play.print();
        play.mark(2, 0, 1);
        play.print();
        play.mark(0, 2, 2);
        play.print();
        play.mark(2, 2, 1);
        play.print();
        play.mark(0, 0, 2);
        play.print();
        play.mark(2, 1, 1);
        play.print();
        if (play.hasWon(1)) {
            System.out.println("We have a new TTT-Champion: Player ONE!");
        }
    }
}
