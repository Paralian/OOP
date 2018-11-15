public class conwayGame {
    /**
     * checks if a board is valid
     * @param board is the given board
     * @return true if all of the inner arrays have the same length, else false
     */
    static boolean isValid(boolean[][] board) {
        int length = board[0].length;
        for (boolean[] innerArray : board) {
            if (length != innerArray.length) {
                return false;
            }
        }
        return true;
    }

    /**
     * prints the current state of a board, O for living cells, X for dead cells
     * @param board is the given board
     */
    static void printArray(boolean[][] board) {
        String temp = "";
        for (boolean[] innerArray : board) {
            for (boolean cell : innerArray) {
                if (cell) {
                    temp = temp + "O";
                } else {
                    temp = temp + "X";
                }
            }
        }
        for (int x = 0; x < board.length; x++) {
            for (int y = x; y < temp.length(); y += board[0].length) {
                System.out.print(temp.charAt(y) + " ");
            }
            System.out.println();
        }
    }

    /**
     * gets the neighbors of a particular cell in a board
     * @param board  is the given board
     * @param x is the x-Coordinate of the selected cell
     * @param y is the y-Coordinate of the selected cell
     * @return an array of neighbors of the selected cell
     */
    static boolean[] getNeighbors(boolean[][] board, int x, int y) {
        int up = y - 1, down = y + 1, left = x - 1, right = x + 1;
        if (x == 0) {
            left = board.length - 1;
        }
        if (x == board.length - 1) {
            right = 0;
        }
        if (y == 0) {
            up = board[0].length - 1;
        }
        if (y == board[0].length -1) {
            down = 0;
        }
        return new boolean[]{board[left][up], board[x][up], board[right][up], board[left][y], board[right][y], board[left][down], board[x][down], board[right][down]};
    }

    /**
     * counts the number of living neighbors of a particular cell in a board
     * @param board is the given board
     * @param x is the x-Coordinate of the selected cell
     * @param y is the y-Coordinate of the selected cell
     * @return the number of living neighbors of the selected cell
     */
    static int countLivingNeighbors(boolean[][] board, int x, int y) {
        int livingCount = 0;
        for (boolean neighbor : getNeighbors(board, x, y)) {
            if (neighbor) {
                livingCount++;
            }
        }
        return livingCount;
    }

    /**
     * gets the next state of a particular cell in a board
     * @param board is the given board
     * @param x is the x-Coordinate of the selected cell
     * @param y is the y-Coordinate of the selected cell
     * @return true if the cell lives, false if it dies
     */
    static boolean getNextState(boolean[][] board, int x, int y) {
        if (!board[x][y] && (countLivingNeighbors(board, x, y) == 3)) {
            return true;
        }
        if (board[x][y] && (countLivingNeighbors(board, x, y) < 2)) {
            return false;
        }
        if (board[x][y] && ((countLivingNeighbors(board, x, y) == 3) || (countLivingNeighbors(board, x, y) == 2))) {
            return true;
        }
        if (board[x][y] && (countLivingNeighbors(board, x, y) > 3)) {
            return false;
        }
        return board[x][y];
    }

    /**
     * calculates the next state of a board
     * @param board is the given board
     * @return the next generation board
     */
    static boolean[][] calculateNextGeneration(boolean[][] board) {
        boolean[][] nextBoard = new boolean[board[0].length][board.length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                nextBoard[x][y] = getNextState(board, x, y);
            }
        }
        return nextBoard;
    }

    public static void main(String[] args) {
        boolean[] innerArray1 = {false, false, true, false, false, false, false, false, false, false};
        boolean[] innerArray2 = {true, false, true, false, false, false, false, false, false, false};
        boolean[] innerArray3 = {false, true, true, false, false, false, false, false, false, false};
        boolean[] innerArray4 = {false, false, false, false, false, false, false, false, false, false};
        boolean[][] board = {innerArray1, innerArray2, innerArray3, innerArray4, innerArray4, innerArray4, innerArray4, innerArray4, innerArray4, innerArray4};
        System.out.println("Ist das Spielfeld valid? " + isValid(board));
        System.out.println("Hier ist das Spielfeld: ");
        printArray(board);
        System.out.println();
        for (int i = 1; i < 6; i++) {
            System.out.println("Die nächste" + i + "-te Generation:");
            board = calculateNextGeneration(board);
            printArray(board);
            System.out.println();
        }
    }
}
