package tilitoli;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    Game game; 
    JLabel topInfo = new JLabel();
    JLabel info = new JLabel();
    JPanel gamePanel;
            
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
        //Game game = new Game();
        game = new Game();
        game.log();
        
        
        //JLabel topInfo = new JLabel();
        topInfo.setText("Rendezd növekvő sorrendbe a számokat!");
        //JLabel info = new JLabel();
        info.setText("Mozgatások száma: "+ game.getNrOfMove());
        
        //JPanel gamePanel = new JPanel();
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3,3));
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topInfo, BorderLayout.NORTH);
        //top.add(topInfo);
        getContentPane().add(info, BorderLayout.SOUTH );
        //getContentPane().add(top, BorderLayout.NORTH);
        //getContentPane().add(top);
        getContentPane().add(gamePanel, BorderLayout.CENTER);
        

        //showGame(game);
        gamePanel.setMinimumSize(new Dimension(400, 450));
        gamePanel.setBackground(Color.black);
        gamePanel = showGame(gamePanel, game);
        getContentPane().add(gamePanel, BorderLayout.CENTER);
        
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
     * @return a JPanel of the game;
     * @param game The dattabase of current game;
     * @param panel The JPanel where the game will be set;
     */
    private JPanel showGame(JPanel panel, Game game) {
        //JButton button = new JButton();
        //top.add(button);
        //this.add(button);
        for(int idx = 0; idx<game.getGame().size(); ++idx ){
            //button.setText(Integer.toString((int) game.getGame().get(idx)));
            //panel.add(button);
            addButton(panel, Integer.toString((int) game.getGame().get(idx)), game);
            //System.out.println("LOG \t "+idx+"\t"+panel);
        }
        return panel;
    }
    
    /**
     * Add button to panel. It can be used by each button to set Listener too.
     * @param panel
     * @param value
     * @param game 
     */
    private void addButton(JPanel panel, String value, Game game){
        JButton button = new JButton();
        if(!value.equals("9")){
            //panel.add(button);
            //System.out.println("LOG \t"+button );
            button.setText(value);
            button.setBackground(Color.orange);
            
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //(JButton) e.getSource().setText("lol");
                    //this.setText("LOL");
                    JButton tmp = (JButton) e.getSource();
                    //tmp.setText("LOL");
                    //System.out.println("gomb: " + tmp.getText());
                    if(game.moveIfPossible(tmp.getText())){
                        tmp.setBackground(Color.green);
                        refreshGUI();
                    } else {
                        /*JLabel tmpLabel = new JLabel();
                        tmpLabel.setText("NEM MOZGATHATÓ");
                        setInfo(tmpLabel);*/
                        tmp.setBackground(Color.red);
                        
                    }
                    //game.moveIfPossible(tmp.getText());
                }
            });
        } else {
            button.setBackground(Color.black);
        }
        panel.add(button);
    }

    public JLabel getInfo() {
        return info;
    }

    public void setInfo(JLabel info) {
        this.info = info;
    }
    
    /**
     * Refresh the GUI by deleting the old panel, and creating a new one.
     */
    public void refreshGUI(){
        gamePanel.removeAll();
        gamePanel.setLayout(new GridLayout(3,3));
        gamePanel.setBackground(Color.black);
        JPanel tmpPane = showGame(gamePanel, game) ;
        info.setText("Mozgatások száma: "+ game.getNrOfMove());
        //getContentPane().removeAll();
        getContentPane().add(info, BorderLayout.SOUTH );
        getContentPane().add(tmpPane, BorderLayout.CENTER);
        game.log();
        
        if(game.isItCompleted()){
            gamePanel.removeAll();
            gamePanel.setBackground(Color.green);
            JLabel winLabel = new JLabel();
            winLabel.setText("Győztél!");
            gamePanel.add(winLabel);
            getContentPane().add(gamePanel, BorderLayout.CENTER);
        }
    }
}