import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
  Used to undo moves in the game
 *
 *  @author  ankit, roy, yash
 *  @version May 26, 2020
 *  @author  Period: 4
 *  @author  Assignment: Connect-4-Project (1)
 *
 *  @author  Sources: us
 */
public class Undo
{
    /**
     * undos the move, sees if its possible
     * @return boolean if it's possible to move
     */
    public static boolean undoMove() //SHOULD ONLY BE CALLED AFTER BOTH THE HUMAN AND COMPUTER MOVE!!!
    {
        boolean boardIsEmpty = true;
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                if (Main.getBoard()[i][j].getColorCode() != 0)
                {
                    boardIsEmpty = false;
                    break;
                }
            } 
        }

        if (boardIsEmpty)
        {
            JFrame f=new JFrame();  
            JOptionPane.showMessageDialog(f,"There is nothing to undo!");  
            return false;
        }

        int computerLastRow = Main.getRow(Main.sizeOfAllMoves() - 1 );
        int computerLastCol = Main.getCol(Main.sizeOfAllMoves() - 1 );

        int humanLastRow = Main.getRow(Main.sizeOfAllMoves() - 2 );
        int humanLastCol = Main.getCol(Main.sizeOfAllMoves() - 2 );

        Main.getBoard()[computerLastRow][computerLastCol].setColor( 0 );
        Main.getBoard()[humanLastRow][humanLastCol].setColor( 0 );

        Main.getAllMoves().remove( Main.sizeOfAllMoves() - 1 ); //undo computer's move
        Main.getAllMoves().remove( Main.sizeOfAllMoves() - 1 ); //undo human's move

        Main.decrementPiecesPlayed(); //undo computer's move
        Main.decrementPiecesPlayed(); //undo human's move
        return true;
    }
}