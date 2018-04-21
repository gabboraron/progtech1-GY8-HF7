package tilitoli;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.*;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * GUI for the game
 * @author Burian Sándor
 */
public class Gui extends JFrame{
    
    /**
     * Create main window, add eventlistener to close.
     */
    public Gui() {
        setTitle("Tili-toli játék");
        setSize(400, 450);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                showExitConfirmation();
            }

        });
        //URL url = Window.class.getResource("icon.png");
        //setIconImage(Toolkit.getDefaultToolkit().getImage(url));
        JLabel label = new JLabel();
        label.setText("Rendezd növekvő sorrendbe a számokat!");
        
        JPanel top = new JPanel();
        
        //top.setLayout(new BorderLayout());
        top.add(label);
        getContentPane().add(top);
        
        Game game = new Game();
        game.log();
        //showGame(game);
        showGame(game);
        
        //setSize(400, 450);
    }
    
    /**
     * Pop up a window to be sure to quit.
     */
    private void showExitConfirmation() {
        int n = JOptionPane.showConfirmDialog(this, "Valóban ki akar lépni?",
                "Megerősítés", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            doUponExit();
        }
    }
    
    /**
     * Exit.
     */
    protected void doUponExit() {
        this.dispose();
    }

    /**
     * Show the current state of game
     * @param game The dattabase of current game;
     */
    private void showGame(Game game) {
        JButton button = new JButton();
        //top.add(button);
        this.add(button);
    }
}