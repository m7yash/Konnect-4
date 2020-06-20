import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *  visual interface of our konnect4 game
 *
 *  @author  ankit, roy, yash
 *  @version May 26, 2020
 *  @author  Period: 4
 *  @author  Assignment: Connect-4-Project (1)
 *
 *  @author  Sources: us
 */
public class GUI
{
    public static JFrame  jFrame;
    public static JPanel panell;
    public static JLabel humanscore;
    public static JLabel computerscore;

    /**
     * constructor that asks user for difficulty
     */
    public GUI()
    {
        jFrame = new JFrame( "Konnect4" );
        jFrame.setSize( 300, 300 );
        jFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        jFrame.setLayout( null );
        JLabel label = new JLabel( "Welcome to Konnect4" );
        label.setBounds( 65, 35, 300, 40 );
        label.setFont( new Font( "Serif", Font.PLAIN, 20 ) );
        jFrame.add( label );
        JLabel label2 = new JLabel( "Please select your difficulty" );
        label2.setBounds( 75, 85, 200, 20 );
        label2.setFont( new Font( "Serif", Font.PLAIN, 14 ) );
        jFrame.add( label2 );
        JButton easy = new JButton( "Easy" );
        easy.setBounds( 95, 120, 95, 30 );
        easy.setBackground( Color.green );
        easy.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                jFrame.setVisible( false );
                Main.setLevel( 0 );
                initializeGame();
            }
        } );
        jFrame.add( easy );
        JButton medium = new JButton( "Medium" );
        medium.setBounds( 95, 150, 95, 30 );
        medium.setBackground( Color.yellow );
        medium.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                jFrame.setVisible( false );
                Main.setLevel( 1 );
                initializeGame();
            }
        } );
        jFrame.add( medium );
        JButton hard = new JButton( "Hard" );
        hard.setBounds( 95, 180, 95, 30 );
        hard.setBackground( Color.red );
        hard.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                jFrame.setVisible( false );
                Main.setLevel( 2 );
                initializeGame();
            }
        } );
        jFrame.add( hard );
        Dimension locationOfJFrame = Toolkit.getDefaultToolkit()
            .getScreenSize();
        jFrame.setLocation( locationOfJFrame.width / 2 - 300 / 2,
            locationOfJFrame.height / 2 - 300 / 2 );
        jFrame.setVisible( true );
    }

    /**
     * displays the scoreboard
     * @param panel is the panel to display on 
     */
    public static void scoreBoard(JPanel panel) {
       
            
            humanscore = new JLabel("Player Wins: " + Main.getHumanWins());
             computerscore = new JLabel("Computer Wins: " + Main.getComputerWins());
          
            humanscore.setBounds( 800, 300, 100, 100 );
            humanscore.setFont( new Font( "Serif", Font.PLAIN, 20 ) );
            computerscore.setBounds( 800, 350, 100, 100 );
            computerscore.setFont( new Font( "Serif", Font.PLAIN, 20 ) );
            panel.add( humanscore );
            panel.add( computerscore );
        
    }
    
    /**
     * remove the labels to prevent duplication
     * @param panel is the panel to remove the scoreBoard on
     */
    public static void removeLabels(JPanel panel) {
        
        panel.remove( humanscore );
        panel.remove( computerscore );
        
    }
    /**
     * initializes the board
     */
    @SuppressWarnings("serial")
    public void initializeGame()
    {
        final JFrame jFrame = new JFrame( "Konnect4" );
        jFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        jFrame.setVisible( true );
        jFrame.setSize( 1000, 1000 );

        Dimension locationOfJFrame = Toolkit.getDefaultToolkit()
            .getScreenSize();
        jFrame.setLocation( locationOfJFrame.width / 2 - 800 / 2,
            locationOfJFrame.height / 2 - 700 / 2 );
        JButton b1 = new JButton( "Place" );
        b1.setBounds( 55, 70, 80, 80 );
        b1.setBackground( Color.white );
        b1.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                jFrame.revalidate();
                jFrame.repaint();
                if ( PlayerMove.pMove( 0 ) )
                {
                    jFrame.revalidate();
                    jFrame.repaint();
                    ComputerMove.cMove();
                }
                jFrame.revalidate();
                jFrame.repaint();
            }
        } );

        jFrame.add( b1 );
        JButton b2 = new JButton( "Place" );
        b2.setBounds( 155, 70, 80, 80 );
        b2.setBackground( Color.white );
        b2.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                jFrame.revalidate();
                jFrame.repaint();
                if ( PlayerMove.pMove( 1 ) )
                {
                    ComputerMove.cMove();
                    jFrame.revalidate();
                    jFrame.repaint();
                }
                jFrame.revalidate();
                jFrame.repaint();
            }
        } );
        jFrame.add( b2 );
        JButton b3 = new JButton( "Place" );
        b3.setBounds( 255, 70, 80, 80 );
        b3.setBackground( Color.white );
        b3.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                jFrame.revalidate();
                jFrame.repaint();
                if ( PlayerMove.pMove( 2 ) )
                {
                    jFrame.revalidate();
                    jFrame.repaint();
                    ComputerMove.cMove();
                }
                jFrame.revalidate();
                jFrame.repaint();
            }
        } );
        jFrame.add( b3 );
        JButton b4 = new JButton( "Place" );
        b4.setBounds( 355, 70, 80, 80 );
        b4.setBackground( Color.white );
        b4.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                jFrame.revalidate();
                jFrame.repaint();
                if ( PlayerMove.pMove( 3 ) )
                {
                    jFrame.revalidate();
                    jFrame.repaint();
                    ComputerMove.cMove();
                }
                jFrame.revalidate();
                jFrame.repaint();
            }
        } );
        jFrame.add( b4 );
        JButton b5 = new JButton( "Place" );
        b5.setBounds( 455, 70, 80, 80 );
        b5.setBackground( Color.white );
        b5.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                jFrame.revalidate();
                jFrame.repaint();
                if ( PlayerMove.pMove( 4 ) )
                {
                    jFrame.revalidate();
                    jFrame.repaint();
                    ComputerMove.cMove();
                }
                jFrame.revalidate();
                jFrame.repaint();
            }
        } );
        jFrame.add( b5 );
        JButton b6 = new JButton( "Place" );
        b6.setBounds( 555, 70, 80, 80 );
        b6.setBackground( Color.white );
        b6.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                jFrame.revalidate();
                jFrame.repaint();
                if ( PlayerMove.pMove( 5 ) )
                {
                    jFrame.revalidate();
                    jFrame.repaint();
                    ComputerMove.cMove();
                }
                jFrame.revalidate();
                jFrame.repaint();
            }
        } );
        jFrame.add( b6 );
        JButton b7 = new JButton( "Place" );
        b7.setBounds( 655, 70, 80, 80 );
        b7.setBackground( Color.white );
        b7.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                jFrame.revalidate();
                jFrame.repaint();
                if ( PlayerMove.pMove( 6 ) )
                {
                    jFrame.revalidate();
                    jFrame.repaint();
                    ComputerMove.cMove();
                }
                jFrame.revalidate();
                jFrame.repaint();
            }
        } );
        jFrame.add( b7 );
        JButton undo = new JButton( "Undo" );
        undo.setBounds( 755, 70, 80, 80 );
        undo.setBackground( Color.blue );
        undo.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                Undo.undoMove();
                jFrame.revalidate();
                jFrame.repaint();
            }
        } );
        jFrame.add( undo );
        JButton res = new JButton( "Reset" );
        res.setBounds( 855, 70, 80, 80 );
        res.setBackground( Color.green );
        res.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                // first, clear the main board
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
                jFrame.revalidate();
                jFrame.repaint();
            }
        } );
        jFrame.add( res );
        
       
        panell = new JPanel()
        {
            
            @Override
            public void paintComponent( Graphics g )
            {
               
                super.paintComponent( g );
                g.setColor( Color.WHITE );
                
                for ( int c = 0; c < 7; c++ )
                {
                    for ( int r = 0; r < 6; r++ )
                    {
                       
                        g.fillOval(55 + 100 * c, 200 + 90 * r, 80, 80);
                    }
                }

                for ( int i = 0; i < Main.sizeOfAllMoves(); i++ )
                {

                    int r = Main.getRow( i );
                    int c = Main.getCol( i );

                    if ( i % 2 == 0 )
                    {
                        g.setColor( Color.RED );
                        
                    }
                    else
                    {

                        g.setColor( Color.YELLOW );
                       
                    }
                    g.fillOval(55 + 100 * c, 200 + 90 * r, 80, 80);
                  

                }

                
            }
        };
        
        jFrame.add( panell );
        scoreBoard(panell);
        jFrame.revalidate();
        jFrame.repaint();
        

    }

}
