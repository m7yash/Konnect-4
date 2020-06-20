/**
Medium class, relies on hard class half the time, easy the other time.
 *  @author  ankit, roy, yash
 *  @version May 26, 2020
 *  @author  Period: 4
 *  @author  Assignment: Connect-4-Project (1)
 *
 *  @author  Sources: us
 */
public class Medium
{

    /**
     * returns best move
     * @param grid cell of grids
     * @return column of best move
     */
    public static int getBestMove(Cell [][] grid) {
        double chance = Math.random();
        if(chance > 0.5){
            return Easy.getBestMove(grid);
        }
        else{
            return Hard.getBestMove(grid);
        }
    }
}