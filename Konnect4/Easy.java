/**
  Easy strategy which is random
 *
 *  @author  ankit, roy, yash
 *  @version May 26, 2020
 *  @author  Period: 4
 *  @author  Assignment: Connect-4-Project (1)
 *
 *  @author  Sources: us
 */
public class Easy
{
    // returns a random column that isn't completely filled
    // returns -1 if the board is completely full

    private static int [] colcount = new int[7];
    private static int total = 0;



    /**
     * gets the best move determined by the AI, just random
     * @param grid Cells grid
     * @return a number for the column, -1 if impossible
     */
    public static int getBestMove(Cell [][] grid) {
        for(int i = 0; i < 7; i++) colcount[i] = 0;
        for(int r = 0; r < 6; r++) {
            for(int c = 0; c < 7; c++) {
                if(grid[r][c].getColorCode() > 0) {
                    colcount[c]++;
                    total++;
                }
            }
        }
        if(total == 42) return -1;    // not necessary since human player starts first and will thus be the first person to run out of moves like we will already check if 42 moves have already been made in the main method and immediately terminate the game after the 42nd move (which is made by the computer)
        while(true) {
            int ret = (int)(Math.random() * 7);
            if(colcount[ret] < 6) return ret;
        }
    }
}