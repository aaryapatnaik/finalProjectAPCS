import java.awt.*;
import javax.swing.*;

public class Board {
    private final int height = 28;
    private final int width = 28;
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
        // manually enter all the inside wall cells
        // first row of walls
        for (int i = 2; i <= 5; i++) {
            for (int j = 2; j <= 4; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 7; i <= 11; i++) {
            for (int j = 2; j <= 4; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 13; i <= 14; i++) {
            for (int j = 1; j <= 4; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 16; i <= 20; i++) {
            for (int j = 2; j <= 4; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 22; i <= 25; i++) {
            for (int j = 2; j <= 4; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        // second row of walls
        for (int i = 2; i <= 5; i++) {
            for (int j = 6; j <= 7; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 7; i <= 7; i++) {
            for (int j = 6; j <= 7; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 9; i <= 17; i++) {
            for (int j = 6; j <= 7; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 19; i <= 20; i++) {
            for (int j = 6; j <= 7; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 22; i <= 25; i++) {
            for (int j = 6; j <= 7; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        // third row of walls
        for (int i = 7; i <= 8; i++) {
            for (int j = 8; j <= 8; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 13; i <= 14; i++) {
            for (int j = 8; j <= 8; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 19; i <= 20; i++) {
            for (int j = 8; j <= 8; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        // fourth row of walls
        for (int i = 1; i <= 5; i++) {
            for (int j = 9; j <= 10; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 7; i <= 11; i++) {
            for (int j = 9; j <= 10; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 16; i <= 20; i++) {
            for (int j = 9; j <= 10; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 22; i <= 26; i++) {
            for (int j = 9; j <= 10; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        // fifth row of walls
        for (int i = 4; i <= 5; i++) {
            for (int j = 10; j <= 13; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 7; i <= 8; i++) {
            for (int j = 10; j <= 13; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 19; i <= 20; i++) {
            for (int j = 10; j <= 13; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 22; i <= 23; i++) {
            for (int j = 10; j <= 13; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        // sixth row of walls
        for (int i = 1; i <= 5; i++) {
            for (int j = 12; j <= 13; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 22; i <= 25; i++) {
            for (int j = 12; j <= 13; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        // THIS WOULD BE HALF WAY THROUGH THE BOARD (still haven't added walls for the spawning point)
        // seventh row of walls
        for (int i = 1; i <= 5; i++) {
            for (int j = 15; j <= 16; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 22; i <= 25; i++) {
            for (int j = 15; j <= 16; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        // eighth row of walls
        for (int i = 4; i <= 5; i++) {
            for (int j = 15; j <= 19; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 7; i <= 8; i++) {
            for (int j = 15; j <= 19; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 19; i <= 20; i++) {
            for (int j = 15; j <= 19; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 22; i <= 23; i++) {
            for (int j = 15; j <= 19; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        // ninth row of walls
        for (int i = 1; i <= 5; i++) {
            for (int j = 18; j <= 19; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 22; i <= 25; i++) {
            for (int j = 18; j <= 19; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 10; i <= 17; i++) {
            for (int j = 18; j <= 19; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        // tenth row of walls
        gameBoard[17][13] = new Cell(true,false);
        gameBoard[17][14] = new Cell(true,false);
        //eleventh row of walls
        for (int i = 7; i <= 8; i++) {
            for (int j = 18; j <= 19; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 19; i <= 20; i++) {
            for (int j = 18; j <= 19; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        //twelfth row of walls
        for (int i = 13; i <= 14; i++) {
            for (int j = 20; j <= 22; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        // thirteenth row of walls
        for (int i = 2; i <= 5; i++) {
            for (int j = 21; j <= 22; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 7; i <= 11; i++) {
            for (int j = 21; j <= 22; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 16; i <= 20; i++) {
            for (int j = 21; j <= 22; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 22; i <= 25; i++) {
            for (int j = 21; j <= 22; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        // fourteenth row of walls
        for (int i = 4; i <= 5; i++) {
            for (int j = 23; j <= 25; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 22; i <= 23; i++) {
            for (int j = 23; j <= 25; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        // fifteenth row of walls
        for (int i = 1; i <= 2; i++) {
            for (int j = 24; j <= 25; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 25; i <= 26; i++) {
            for (int j = 24; j <= 25; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 10; i <= 17; i++) {
            for (int j = 24; j <= 25; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        // sixteenth row of walls
        for (int i = 7; i <= 8; i++) {
            for (int j = 24; j <= 27; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 19; i <= 20; i++) {
            for (int j = 24; j <= 27; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        // seventeenth row of walls
        for (int i = 13; i <= 14; i++) {
            for (int j = 26; j <= 27; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        // eighteenth row of walls
        for (int i = 2; i <= 11; i++) {
            for (int j = 27; j <= 27; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }
        for (int i = 16; i <= 25; i++) {
            for (int j = 27; j <= 27; j++) {
                gameBoard[j][i] = new Cell(true,false);
            }
        }

        // adding big food cells 
        gameBoard[3][1] = new Cell (false, false, true);
        gameBoard[3][26] = new Cell (false, false, true);
        gameBoard[20][1] = new Cell (false, false, true);
        gameBoard[20][26] = new Cell (false, false, true);

        // spawning point walls 
        for (int i = 10; i <=17; i++) {
            gameBoard[12][i] = new Cell (true,false);
            gameBoard[16][i] = new Cell (true,false);
        }
        for (int i = 12; i <=16; i++) {
            gameBoard[i][10] = new Cell (true,false);
            gameBoard[i][17] = new Cell (true,false);
        }

        // remove food from spawning point
        for (int i = 13; i <= 15; i++) {
            for (int j = 11; j <=16; j++) {
                gameBoard[i][j] = new Cell (false, false);
            }
        }
        
        // opening in spawning point for exit
        gameBoard[12][13] = new Cell(false,false);
        gameBoard[12][14] = new Cell(false,false);

        // remove food from sides
        for (int i = 1; i <= 4; i++) {
            for (int j = 10; j <= 12; j++) {
                gameBoard[j][i] = new Cell(false,false);
            }
        }
        for (int i = 1; i <= 12; i++) {
            gameBoard[1][i] = new Cell(false,true);
        }
        gameBoard[13][1] = new Cell(true,false);
        gameBoard[15][1] = new Cell(true,false);

        

        for (int i = 23; i <= 26; i++) {
            for (int j = 10; j <= 12; j++) {
                gameBoard[j][i] = new Cell(false,false);
            }
        }
        for (int i = 1; i <= 4; i++) {
            for (int j = 16; j <= 18; j++) {
                gameBoard[j][i] = new Cell(false,false);
            }
        }
        for (int i = 23; i <= 26; i++) {
            for (int j = 16; j <= 18; j++) {
                gameBoard[j][i] = new Cell(false,false);
            }
        }
        for (int i = 1; i <= 5; i++) {
            for (int j = 14; j <= 14; j++) {
                gameBoard[j][i] = new Cell(false,false);
            }
        }
        for (int i = 22; i <= 26; i++) {
            for (int j = 14; j <= 14; j++) {
                gameBoard[j][i] = new Cell(false,false);
            }
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

    /* returns a cell given an x and y location */
    public Cell getCell(int x, int y) {
        return gameBoard[x][y];
    }

    /* display board 
    board.drawBoard(g);
    */
    public void drawBoard(Graphics g, Component c) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; i++) {
                if ((gameBoard[i][j]).getContainsFood()) {
                    ImageIcon img = new ImageIcon("finalProjectAPCS/Media/smallLasagna.png");
                    img.paintIcon(c, g, j*25, i*25);
                }
                if ((gameBoard[i][j]).getContainsBigFood()) {
                    ImageIcon img = new ImageIcon("finalProjectAPCS/Media/bigLasagna.png");
                    img.paintIcon(c, g, j*25, i*25);
                }
            }
        }
    }

}