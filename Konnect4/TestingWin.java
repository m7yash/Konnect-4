/**
  Test if there's a connect 4
 *
 *  @author  ankit, roy, yash
 *  @version May 26, 2020
 *  @author  Period: 4
 *  @author  Assignment: Connect-4-Project (1)
 *
 *  @author  Sources: us
 */
public class TestingWin
{

    /**
     * tests four in a row from the color code board
     * @param row row given
     * @param col column given
     * @param intBoard board of integers for colors
     * @return true false
     */
    public static boolean fourInARow(int row, int col, int[][] intBoard)
    {
        Cell [][] myCell = new Cell[10][10];
        for(int i=0;i<6;i++) {
            for(int j=0;j<7;j++) {
                myCell[i][j] = new Cell();
            }
        }

        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                myCell[i][j].setColor(intBoard[i][j]);
            }
        }
        return fourInARow(row, col, myCell);
    }

    /**
     * four in a row for general cell board at certain location check
     * @param row given roiw
     * @param col given column
     * @param board given Cell board
     * @return true false
     */
    public static boolean fourInARow(int row, int col, Cell [][] board)
    {
        if (verticalFour(row, col, board) || horizontalFour(row, col, board) || diagonalAFour(row, col, board) || diagonalBFour( row,  col, board))
        {
            Main.gameIsOver = true;
            /*
            if(verticalFour(row, col, board))
                System.out.println("VERTICAL FOUR");
            if(horizontalFour(row, col, board))
                System.out.println("HORIZONTAL FOUR");
            if(diagonalAFour(row, col, board))
                System.out.println("DIAGONAL A FOUR");
            if(diagonalBFour(row, col, board))
                System.out.println("DIAGONAL B FOUR");

             */

            return true;
        }
        return false;
    }

    /**
     * checks vertical four in a row
     * @param row given row
     * @param col given column
     * @param board board of cells
     * @return true or false
     */
    public static boolean verticalFour(int row, int col, Cell [][] board) {
        int color = board[row][col].getColorCode();
        int streak = 0;
        int maxStreak = 0;
        for (int i = 0; i < 6; i++)
        {
            if (board[i][col].getColorCode() == color)
            {
                streak++;
            }
            else
            {
                streak = 0;
            }
            if (streak > maxStreak)
            {
                maxStreak = streak;
            }
        }
        return maxStreak >= 4;
    }

    /**
     * checks horizontal four in a row
     * @param row given row
     * @param col given column
     * @param board board of cells
     * @return true or false
     */
    public static boolean horizontalFour(int row, int col, Cell [][] board)
    {
        int color = board[row][col].getColorCode();
        int streak = 0;
        int maxStreak = 0;
        for (int j = 0; j < 7; j++)
        {
            if (board[row][j].getColorCode() == color)
            {
                streak++;
            }
            else
            {
                streak = 0;
            }
            if (streak > maxStreak)
            {
                maxStreak = streak;
            }
        }
        return maxStreak >= 4;
    }

    /**
     * checks diagonal four going upper left to bottom right at certain location
     * @param row given row
     * @param col given column
     * @param board board given 
     * @return true or false
     */
    public static boolean diagonalAFour(int row, int col, Cell [][] board)
    {
        int color = board[row][col].getColorCode();
        int streak = 0;
        int maxStreak = 0;
        int sr = 0;       // (sr, sc) = top left
        int sc = 0;
        int er = 0;       // (er, ec) = top right
        int ec = 0;

        if(row - 3 >= 0 && col - 3 >= 0) {
            sr = row - 3;
            sc = col - 3;
        }
        else {
            sr = row - Math.min(row, col);
            sc = col - Math.min(row, col);
        }

        if(row + 3 <= 5 && col + 3 <= 6) {
            er = row + 3;
            ec = col + 3;
        }
        else {
            er = row + Math.min(5 - row, 6 - col);
            ec = col + Math.min(5 - row, 6 - col);
        }
        int i = sr;
        int j = sc;
        while (i <= er && j <= ec)
        //for(int i = sr, int j = sc; i < er, j < ec; i++, j++)
        {
            if (board[i][j].getColorCode() == color)
            {
                streak++;
            }
            else
            {
                streak = 0;
            }
            if (streak > maxStreak)
            {
                maxStreak = streak;
            }

            i++;
            j++;
        }
        return maxStreak >= 4;
    }

    /**
     * checks diagonalBfour later
     * @param row row left
     * @param col column given
     * @param board board given
     * @return true or false
     */
    public static boolean diagonalBFour(int row, int col, Cell[][] board)
    {
        int color = board[row][col].getColorCode();
        int streak = 0;
        int maxStreak = 0;
        int sr = 0;       // (sr, sc) = top right
        int sc = 0;
        int er = 0;       // (er, ec) = top left
        int ec = 0;

        if(row - 3 >= 0 && col + 3 <= 6) {
            sr = row - 3;
            sc = col + 3;
        }
        else {
            sr = row - Math.min(row, 6 - col);
            sc = col + Math.min(row, 6 - col);
        }

        if(row + 3 <= 5 && col - 3 >= 0) {
            er = row + 3;
            ec = col - 3;
        }
        else {
            er = row + Math.min(5 - row, col);
            ec = col - Math.min(5 - row, col);
        }
        int i = sr;
        int j = sc;
        while (i <= er && j >= ec) {
            //for(int i = sr, j = sc; i < er, j > ec; i++, j--) {
            if (board[i][j].getColorCode() == color)
            {
                streak++;
            }
            else
            {
                streak = 0;
            }
            if (streak > maxStreak)
            {
                maxStreak = streak;
            }

            i++;
            j--;
        }
        return maxStreak >= 4;
    }
}
