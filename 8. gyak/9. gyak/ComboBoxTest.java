/*
 * Mintaprogramok/8. fejezet
 * ComboBoxTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * M�dos�tva: 2015.11.15.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SzinekFrame extends JFrame implements ActionListener {
  Color[] colors = {Color.WHITE, Color.BLACK, Color.BLUE,   //1
    Color.CYAN, Color.GRAY, Color.GREEN, Color.RED};
  String[] colorStrings = {"feh�r", "fekete", "k�k",
    "t�rkiz", "sz�rke", "z�ld", "piros"};                   //2
  Container cp = getContentPane();
  JComboBox cbSzinek;

  public SzinekFrame() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Sz�nek");
    setBounds(300, 100, 200, 200);
    cp.setLayout(new FlowLayout());
    cp.setBackground(colors[0]);
    cp.add(cbSzinek = new JComboBox(colorStrings));
    cbSzinek.addActionListener(this);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {             //3
    cp.setBackground(colors[cbSzinek.getSelectedIndex()]);
  }
}

public class ComboBoxTest {
  public static void main (String args[]) {
    new SzinekFrame();
  }
}
