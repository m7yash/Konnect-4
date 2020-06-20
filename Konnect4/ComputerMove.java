import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
  Represents the computer player, gets the best move depending
  on what strategy the computer is using
 *
 *  @author  ankit, roy, yash
 *  @version May 26, 2020
 *  @author  Period: 4
 *  @author  Assignment: Connect-4-Project (1)
 *
 *  @author  Sources: us
 */
public class ComputerMove
{
    /**simulating the computer's move
     * 
     * @return true if it's possible to move
     */
    public static boolean cMove() // NOTE: DOESN'T CHECK FOR 4INAROW ANYMORE
    {
        int col;
        if ( Main.getLevel() == 0 ) // easy
        {
            col = Easy.getBestMove( Main.getBoard() );
        }
        else if ( Main.getLevel() == 1 ) // medium
        {
            col = Medium.getBestMove( Main.getBoard() );
        }
        else // hard
        {
            col = Hard.getBestMove( Main.getBoard() );
        }

        int r = 0;
        int c = col;
        boolean putInBottomRow = true;
        for ( int i = 1; i < 6; i++ )
        {
            if ( Main.getBoard()[i][col].getColorCode() != 0 ) // if cell is not
                                                               // white
            {
                putInBottomRow = false;
                r = i - 1;
                Main.allMoves.add( r * 10 + col );
                Main.getBoard()[r][c].setColor( Color.YELLOW );// converts cell
                                                               // right above it
                                                               // to yellow
                break;
            }
        }
        if ( putInBottomRow )
        {
            r = 5;
            Main.allMoves.add( r * 10 + col );
            Main.getBoard()[r][c].setColor( Color.YELLOW );
        }
        boolean checkIfDraw = true;
        if ( TestingWin.fourInARow( r, c, Main.getBoard() ) )
        {
            checkIfDraw = false;
            Main.computerPointIncrement();
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog( f, "YOU LOST :(" );
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
        }
        else
        {
            Main.incrementPiecesPlayed();
        }
        if ( Main.getPiecesPlayed() == 42 && checkIfDraw )
        {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog( f, "Draw" );
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
        }
        return true; // represents that move was successful
    }
}
