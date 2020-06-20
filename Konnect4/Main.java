import java.util.ArrayList;

/**
 *  Main method that runs our game
 *
 *  @author  ankit, roy, yash
 *  @version May 26, 2020
 *  @author  Period: 4
 *  @author  Assignment: Connect-4-Project (1)
 *
 *  @author  Sources: us
 */
public class Main {
  private static Cell[][] board = new Cell[6][7];
  private static int level = 0; //default?  
  /**
 * 
 */
public static boolean gameIsOver = false;  
  private static int piecesPlayed = 0;
  /**
 * 
 */
public static ArrayList<Integer> allMoves = new ArrayList<>();
  private static int humanPoints = 0;
  private static int computerPoints = 0;
  // for example, if we have 35 as an element
  // row = 35/10 = 3
  // col = 35 % 10 = 5
  // if you have 3 -> row = 3 / 10 = 0, col = 3%10 = 3

  /**
 * main method
 * @param args String [] args
 */
public static void main(String[] args) {
    for (int i = 0; i < board.length; i++)
    {
      for (int j = 0; j < board[0].length; j++)
      {
        board[i][j] = new Cell();
      }
    }
    @SuppressWarnings("unused")
    GUI x = new GUI();

  }
  
  /**
 * increments human pionts
 */
public static void humanPointIncrement()
  {
      humanPoints++;
  }
  
  /**
 * increments number of computer poitns
 */
public static void computerPointIncrement()
  {
      computerPoints++;
  }

  /**
 * return if human wins
 * @return humanPoints
 */
public static int getHumanWins() {
      return humanPoints;
  }
  
  /**
 * see if computer wins
 * @return computers points
 */
public static int getComputerWins() {
      return computerPoints;
  }
  /**
 * clears all the moves in the arraylist
 */
public static void clearAllMoves ()
  {
    allMoves.clear();
  }

  /**
 * gets the size of the arraylist
 * @return int of the size of all Moves
 */
public static int sizeOfAllMoves () //should be same as getPiecesPlayed ()????
  {
    return allMoves.size();
  }

  /**
 * get the row
 * @param index index of where you want to get
 * @return the first digit, because AB is A is row, B is column
 */
public static int getRow (int index)
  {
      return allMoves.get(index) / 10;
  }

  /**
 * get the column
 * @param index the index
 * @return B as described, units digit
 */
public static int getCol (int index)
  {
      return allMoves.get(index) % 10;
  }

  /**
 * just returns the entire all moves arraylist
 * @return allMoves
 */
public static ArrayList<Integer> getAllMoves() 
  {
      return allMoves;
  }

  /**
 * get the pieces played
 * @return pieces Played pieces
 */
public static int getPiecesPlayed ()
  {
    return piecesPlayed;
  }

  /**
 * increments pieces played by one
 */
public static void incrementPiecesPlayed()
  {
    piecesPlayed++;
  }

  /**
 * sets the piecs played
 * @param x given x
 */
public static void setPiecesPlayed(int x)
  {
    piecesPlayed = x;
  }
  /**
 * piecesplayed goes down
 */
public static void decrementPiecesPlayed() //for undoing
  {
    piecesPlayed--;
  }

  /**
 * get the level
 * @return level given
 */
public static int getLevel()
  {
    return level;
  }

  /**
 * setting the level
 * @param difficulty given the integer
 */
public static void setLevel(int difficulty){
    level = difficulty; 
  }

  /**
 * get the board
 * @return tghe board
 */
public static Cell[][] getBoard()
  {
    return board;
  }
  
}