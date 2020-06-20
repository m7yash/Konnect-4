/**
  The Hard strategy class, uses simulation and monte carlo algorithm.
 *
 *  @author  ankit, roy, yash
 *  @version May 26, 2020
 *  @author  Period: 4
 *  @author  Assignment: Connect-4-Project (1)
 *
 *  @author  Sources: us
 */
public class Hard
{
    private static int mxval = -99999;
    private static int [] colval = new int[7];
    private static int [] colcolcol = new int[7];
    private static int total;
    private static int bestcol;
    private static int [][] gg;
    // player red. computer yellow
    // color code 1,   color code 2 respectively

    // this is for the COMPUTER to win
    /**
     * returns the best move determined by the AI
     * @param grid of cells
     * @return column, -1 if no available moves
     */
    public static int getBestMove(Cell [][] grid)
    {
    /*
      Algorithm: For each of at most seven not completely filled
      columns, the Computer places down a Yellow piece in that column;
      these are the possible choices for the computer's next move.
      For each of the computer's next possible moves,
      we will compute an associated value. The higher the value,
      the better this next move was. (roughly, Monte Carlo Method)
      For each of the next possible moves for the computer,
      do the following:
      _____________________________________________________________
      Add a yellow piece in the currenct column we are checking.
      First check if this is an immediate win.
      If not, call the simulate method 10 000 times.
      (so the first move in simulate will be red move).
      The simulate class will take the configuration and randomly
      enter red and yellow pieces alternatingly in any available column.
      It keeps doing this until there is a four in a row,
      or the entire board is filled.
      If Yellow (comp) wins in the simulation, then the simulation
      awards us +1 points. If Red (human) wins, then this is -1 points.
      If there are no wins after the simulation, returns 0.
      Run the simulation many times, get the sum.
      This will be the value for this move.
      _______________________________________________________________
      Now compare the values associated with each column, and pick
      the column corresponding with the highest value. This will
      be a good estimate for the best move.
    */

        gg = new int[6][7];
        for(int r = 0; r < 6; r++) {
            for(int c = 0; c < 7; c++) {
                gg[r][c] = 0;
                gg[r][c] = grid[r][c].getColorCode();
            }
        }
        bestcol = -1;
        total = 0;
        mxval = -99999;
        for(int i = 0; i < 7; i++) {
            colcolcol[i] = 0;
            colval[i] = 0;
        }
        for(int r = 0; r < 6; r++) {
            for(int c = 0; c < 7; c++) {
                if(gg[r][c] > 0) {
                    colcolcol[c]++;
                    total++;
                }
            }
        }

        if(total == 42) return -1; // not necessary becasue human player starts first and will be the first one to run out of moves if the board is completely full

        for(int c = 0; c < 7; c++) {
            if(colcolcol[c] == 6) continue;
            gg[5 - colcolcol[c]][c] = 2;   //yellow
           /* for(int i = 0; i < 6; i++) {
                for(int j = 0; j < 7; j++) {
                    System.out.print(gg[i][j] + " ");
                }
                System.out.println();
            }
            */
            if(TestingWin.fourInARow(5 - colcolcol[c], c, gg))
                return c;
            // fourInARow(int row, int col, Cell [][] board)
            for(int i = 1; i <= 2000; i++) {
                Simulate nsim = new Simulate(gg);
                colval[c] += nsim.getval();
            }
            gg[5 - colcolcol[c]][c] = 0;
        }

        for(int c = 0; c < 7; c++) {
            if(colcolcol[c] == 6) continue;
          //  System.out.println("col " + c + " = " + colval[c]);
            if(colval[c] > mxval) {
                bestcol = c;
                mxval = colval[c];
            }
        }

        return bestcol;
        // return -1 means the board is completely filled
        // will fix later
    }

}