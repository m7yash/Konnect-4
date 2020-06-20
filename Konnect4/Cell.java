import java.awt.*;
/**
  The cell class that represents pieces on the board
 *
 *  @author  ankit, roy, yash
 *  @version May 26, 2020
 *  @author  Period: 4
 *  @author  Assignment: Connect-4-Project (1)
 *
 *  @author  Sources: us
 */
public class Cell
{
    private Color colorOfCell = Color.WHITE;

    /**
     * Cell object constructor
      sets the color to white, empty
     */
    public Cell ()
    {
        colorOfCell = Color.WHITE;
    }

    /**
     * TODO gets the color
     * @return colorOfCell
     */
    public Color getColor ()
    {
        return colorOfCell;
    }

    /**
     * get the color code
     * @return 0 / 1 / 2
     */
    public int getColorCode()
    {
        if (getColor().equals(Color.WHITE))
        {
            return 0;
        }
        else if (getColor().equals(Color.RED))
        {
            return 1;
        }
        else //yellow
        {
            return 2;
        }
    }

    /**
     * checks if two cells are equal color
     * @param other Cell
     * @return boolean
     */
    public boolean equals(Cell other)
    {
        return getColor() == other.getColor();
    }

    /**
     * sets the color of a cell
     * @param c Color of cell
     */
    public void setColor (Color c)
    {
        colorOfCell = c;
    }

    /**
     * sets the color of a cell
     * @param x integers 0 1 2
     */
    public void setColor (int x)
    {
        if (x == 0)
        {
            colorOfCell = Color.WHITE;
        }
        else if (x == 1)
        {
            colorOfCell = Color.RED;
        }
        else // i = 2
        {
            colorOfCell = Color.YELLOW;
        }
    }
}