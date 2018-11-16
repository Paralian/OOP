package Woche5;

public class aufgabeZwei {
    
    /**
     * checks if this board is valid, i.e. every line has the same length
     *
     * @param board the playing board
     * @return TRUE if the board is OK, otherwise FALSE
     */
    
    static boolean isValid(boolean[][] board) {
        for (int y = 0; y < board.length - 1; y++) {
            if (board[y].length == board[y + 1].length) {       // if previous check passed, check next
                continue;
            } else return false;                                // if any line is of a different length, get out, no need to check any further
        }
        return true;
    }
    
    /**
     * prints current state of this board, line for line, X for dead cells and O for alive.
     *
     * @param board boolean array of cells currently alive/dead
     * @var x = width of board
     * @var y = height of board
     */
    static void printArray(boolean[][] board) {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                System.out.print(board[y][x] ? "O" : "X");    // marks cell as alive or dead
            }
            System.out.print("\n");
        }
    }
    
    /**
     * counts living neighbors around this cell
     * by setting 8 neighbor cells as combinations of left-right-up-down movement (with diagonal movement like up+right)
     * and checking them for alive cells
     *
     * @param board playing board in current state
     * @param x     column position
     * @param y     row position
     * @return number of neighbors who are alive in current state of this board
     */
    static int countLivingNeighbors(boolean[][] board, int x, int y) {
        int neighbors = 0;
        int l, r, u, d;
        if (x == 0) {                            // checks for left cells (L FOR LEFT), connects to opposite end
            l = board[y].length - 1;
        } else l = x - 1;
        if (x == board[y].length - 1) {          // checks for right side (R FOR RIGHT), connects to left border if necessary
            r = 0;
        } else r = x + 1;
        if (y == 0) {                            // checks for upper cells (U FOR UP), connects to lower border if necessary
            u = board.length - 1;
        } else u = y - 1;
        if (y == board.length - 1) {             // checks for lower cells (D FOR DOWN), connects to top border if necessary
            d = 0;
        } else d = y + 1;
        
        int[][] hood = {
                {u, l}, {u, x}, {u, r},                     // sets positions of 8 neighbors on the board: {yPos, xPos}
                {y, l}, {y, r},
                {d, l}, {d, x}, {d, r}};
        for (int cell = 0; cell < 8; cell++) {              // iterates through the 8 positions
            /*  yPos = hood[cell][0];
                xPos = hood[cell][1];
            */
            if (board[hood[cell][0]][hood[cell][1]]) {      // checks if neighbor at yPos/xPos is alive
                neighbors++;
            }
            if (neighbors > 3)
                break;                 // breaks the calculation since it doesn't depend on any specific # of neighbors over 3
        }
        return neighbors;
    }
    
    /**
     * calculates the next state of current cell via calculating the number of living neighbors
     * and setting a cell to "alive" if there are exactly 3 living neighbors,
     * keeping it alive if there are 2 to 3 neighbors,
     * otherwise killing the cell #ripInPeperonis
     *
     * @param board the playing board in current state
     * @param x     X-coordinate of the cell
     * @param y     Y-coordinate of the cell
     * @return TRUE if the cell will be alive, FALSE otherwise
     */
    static boolean getNextState(boolean[][] board, int x, int y) {
        boolean nextState;
        int family = countLivingNeighbors(board, x, y);
        if ((family < 2) || (family > 3)) {                 // overpopulation kills. foreveralones die also.
            nextState = false;
        } else if (family == 3) {                           // three is a crowd exactly tailored to the needs of reproduction
            nextState = true;
        } else {
            nextState = board[y][x];                        // staying alive if the family is balanced
        }
        return nextState;
    }
    
    /**
     * looks at every cell on current board, determines its next state using nextState()
     * and returns the next board with all cells in their new state
     *
     * @param board the playing board in current state
     * @return the next generation of the playing board
     */
    static boolean[][] calculateNextGeneration(boolean[][] board) {
        boolean[][] nextBoard = new boolean[board.length][board[0].length];
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                nextBoard[y][x] = getNextState(board, x, y);
            }
        }
        board = nextBoard;
        return board;
    }
    
    /**
     * wraps the methods for playing n cycles (generations) off of a set board
     *
     * @param n     number of cycles (generations) to play
     * @param board the starting board
     */
    static void play(int n, boolean[][] board) {
        if (isValid(board)) {
            printArray(board);
            System.out.print("\n");
            while (n > 0) {
                board = calculateNextGeneration(board);
                printArray(board);
                System.out.print("\n");
                n--;
            }
        } else System.out.println("INVALID BOARD");
    }
    
    /**
     * creates boards from binary arrays consisting of 0s and 1s
     *
     * @param binBoard a board in 0/1 format, 0 for FALSE and 1 for TRUE
     * @return a boolean board compliant to the specs
     */
    static boolean[][] constructBoard(int[][] binBoard) {
        int height = binBoard.length;
        int width = binBoard[0].length;
        boolean[][] board = new boolean[height][width];
        for (int y = 0; y < binBoard.length; y++) {
            for (int x = 0; x < binBoard[0].length; x++) {
                if (binBoard[y][x] == 0) {
                    board[y][x] = false;
                } else board[y][x] = true;
            }
        }
        return board;
    }
    
    public static void main(String[] args) {
        /*
            for simplicity first a binary board is made and then converted into boolean.
            that way it can be edited without the hassle of spelling true/false every time
            and having a misaligned 2D array.
         */
        
        int[][] binBoard =
                {
                        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
        
        boolean[][] board = constructBoard(binBoard);
        play(5, board);
    }
}
