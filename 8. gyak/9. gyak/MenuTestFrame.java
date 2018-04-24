/**
 *
 * K�sz�tette: Keszthelyi Zsolt 2015.11.15.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuTestFrame extends JFrame
                            implements ActionListener {
  JMenuBar mb = new JMenuBar();
  JMenu mSzinezes = new JMenu("Sz�nez�s");
  JMenuItem miSzovegSzin = new JMenuItem("Sz�vegsz�n", 'z');
  JMenuItem miHatterSzin = new JMenuItem("H�tt�rsz�n", 'H');
  JMenuItem miSzoveg = new JMenuItem("Sz�veg", 'S');
  JMenuItem miKilep = new JMenuItem("Kil�p", 'K');
  JMenu mSugo = new JMenu("S�g�");
  JMenuItem miNevjegy = new JMenuItem("N�vjegy");
  JLabel lbSzoveg = new JLabel("JAVA");
    
  public MenuTestFrame() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setBounds(100, 50, 400, 300);
    setTitle("Men� teszt");
    getContentPane().add(lbSzoveg);
    lbSzoveg.setFont(new Font("Dialog", Font.BOLD, 30));
    lbSzoveg.setHorizontalAlignment(JLabel.CENTER);
    lbSzoveg.setOpaque(true);
        
    setJMenuBar(mb);
    mb.add(mSzinezes);
    mSzinezes.setMnemonic('S');
    mSzinezes.add(miSzovegSzin);
    mSzinezes.add(miHatterSzin);
    mSzinezes.addSeparator();
    mSzinezes.add(miSzoveg);
    mSzinezes.addSeparator();
    mSzinezes.add(miKilep);
    mb.add(mSugo);
    mSugo.add(miNevjegy);
    miSzovegSzin.addActionListener(this);
    miHatterSzin.addActionListener(this);
    miSzoveg.addActionListener(this);
    miKilep.addActionListener(this);
    miNevjegy.addActionListener(this);        
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == miSzovegSzin) {
      Color fg = JColorChooser.showDialog(this,
        "Sz�vegsz�n?", lbSzoveg.getForeground());
      if (fg != null)
        lbSzoveg.setForeground(fg);
    }
    else if (e.getSource() == miHatterSzin) {
      Color bg = JColorChooser.showDialog(this,
        "H�tt�rsz�n?", lbSzoveg.getBackground());
      if (bg != null)
        lbSzoveg.setBackground(bg);                       
    }
    else if (e.getSource() == miSzoveg) {
      String szoveg = JOptionPane.showInputDialog(this,
        "Sz�veg:");
      if (szoveg != null)
        lbSzoveg.setText(szoveg);
    }
    else if (e.getSource() == miKilep) {
      Object[] opciok = {"Igen", "Nem"};
      int valasz = JOptionPane.showOptionDialog(this,
        "Biztos kil�p?", "", JOptionPane.DEFAULT_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, opciok,
        opciok[1]);
      if (valasz == 0)
        System.exit(0);
    }
    else if (e.getSource() == miNevjegy) {
      JOptionPane.showMessageDialog(this, "N�vjegy", "",
        JOptionPane.INFORMATION_MESSAGE);
    }            
  }
    
  public static void main(String[] args) {
    new MenuTestFrame();
  }    
}
