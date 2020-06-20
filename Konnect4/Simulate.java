/**
 *  simulate method used in the Hard level strategy to simulate what the computer should do
 *
 *  @author  ankit, roy, yash
 *  @version May 26, 2020
 *  @author  Period: 4
 *  @author  Assignment: Connect-4-Project (1)
 *
 *  @author  Sources: us
 */
public class Simulate
{
    private int [][] simb;   // actually pretty useless
    private int [] colc;
    private int tot;

    // white = 0
    // yellow = 1
    // red = 2
    /**
     * @param arr is the array of the board that we want to simulate on
     */
    public Simulate(int [][] arr) // color codes
    {
        tot = 0;
        colc = new int[7];
        for(int i = 0; i < 7; i++) {
            colc[i] = 0;
        }
        simb = new int [6][7];
        for(int r = 0; r < 6; r++) {
            for(int c = 0; c < 7; c++) {
                simb[r][c] = 0;
            }
        }
        for(int r = 0; r < 6; r++) {
            for(int c = 0; c < 7; c++) {
                simb[r][c] = arr[r][c];
                if(simb[r][c] != 0)
                {
                    colc[c]++;
                    tot++;
                }
            }
         //   System.out.println();
        }
    }

     
    /*
     * simulates playing a game by randomly entering pieces of alternating color
     * @return returns 1 if Yellow (computer) won, 0 if draw, -1 if red won
     */
    public int getval() {
        int color = 1; // start with red
        while(tot < 42) {
            int c = getRand();
            if(colc[c] < 6) {
                simb[5 - colc[c]][c] = color; // red

                if(TestingWin.fourInARow(5 - colc[c], c, simb)) {
                    if(color == 1) return -1;
                    if(color == 2) return 1;
                }

                colc[c]++;
                if(color==1) color=2;
                else color = 1;
                tot++;

            }
        }
        return 0; // draw
    }

    /**
     * returns random integer in the range 0 - 6 inclusiv
     * @return random number 0 - 6 inclusiv
     */
    public int getRand() {   // returns integer in the range 0 - 6 inclusiv
        //int zeroToSixRandom = (int) (7 * Math.random());
        return (int)(Math.random() * 7);
    }
}