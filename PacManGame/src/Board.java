public class Board {
    private final int width = 28;
    private final int height = 28;
    Cell[][] gameBoard = new Cell[height][width];

    public Board() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int k = 0; k < gameBoard[i].length; k++) {
                gameBoard[i][k] = new Cell(false, true);
            }
        }
        for (int i = 0; i < gameBoard[0].length; i++) {
            gameBoard[0][i] = new Cell(true,false);
        }
        for (int i = 0; i < gameBoard[0].length; i++) {
            gameBoard[height-1][i] = new Cell(true,false);
        }
        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[i][0] = new Cell(true,false);
        }
        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[i][width-1] = new Cell(true,false);
        }
    }

    /* returns true if there is at least one cell that contains food, returns false otherwise */
    public boolean containsFood() {
        for (Cell[] row: gameBoard) {
            for (Cell column: row) {
                if (column.getContainsFood()) {
                    return true;
                }
            }
        }
        return false;
    }
}