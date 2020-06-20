import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *  Represents a player move
 *
 *  @author  ankit, roy, yash
 *  @version May 26, 2020
 *  @author  Period: 4
 *  @author  Assignment: Connect-4-Project (1)
 *
 *  @author  Sources: none
 */
public class PlayerMove  //NOTE: DOESN'T CHECK FOR 4INAROW ANYMORE
{
    /**
     * boolean that simulates the player's click on a col and returns if its valid
     * @param col is the col where the player clicks
     * @return if the move was valid and happened (returns false if its blocked)
     */
    public static boolean pMove (int col)
    {
        if (Main.getBoard()[0][col].getColorCode() != 0)//column is already full
        {
            JFrame f=new JFrame();  
            JOptionPane.showMessageDialog(f,"you can't move there!");  
            return false; //represents move was unsuccessful
        }
        boolean putInBottomRow = true;
        int r = 0;
        int c = col;
        for (int i = 1; i < 6; i++)
        {
            if(Main.getBoard()[i][col].getColorCode() != 0) //if cell is not white
            {
                putInBottomRow = false;
                r = i - 1;
                Main.getAllMoves().add(r * 10 + col);
                Main.getBoard()[r][c].setColor(Color.RED);//converts cell right above it to red
                break;
            }
        }
        if (putInBottomRow)
        {
            r = 5;
            Main.getAllMoves().add(r * 10 + col);
            Main.getBoard()[r][col].setColor(Color.RED);
        }
        if (TestingWin.fourInARow(r, c, Main.getBoard()) )
        {
            //System.out.println("YOU WON!!!!");
            Main.humanPointIncrement();
            JFrame f=new JFrame();  
            JOptionPane.showMessageDialog(f,"YOU WON!!!!");  
            for ( int i = 0; i < Main.getBoard().length; i++ )
            {
                for ( int j = 0; j < Main.getBoard()[0].length; j++ )
                {
                    Main.getBoard()[i][j] = new Cell();
                }
            }
            // second, set the number of pieces played to 0
            Main.setPiecesPlayed( 0 );

            // third, remove everything from the arraylist
            Main.clearAllMoves();

            // fourth, make the board white
            GUI.jFrame.revalidate();
            GUI.jFrame.repaint();
            GUI.removeLabels( GUI.panell );
            GUI.scoreBoard( GUI.panell );
            
            return false;
        }
        Main.incrementPiecesPlayed();
        return true; //represents that move was successful
    }
}
