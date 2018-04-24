/*
 * Mintaprogramok/8. fejezet
 * RadioButtonTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * �t�rva: 2015.11.15. 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class KeretezesFrame extends JFrame {
  Container cp = getContentPane();
  ButtonGroup bg = new ButtonGroup();                       //1
  JRadioButton rbVesett = new JRadioButton("V�sett");       //2
  JRadioButton rbKiemelt = new JRadioButton("Kiemelt");
  JRadioButton rbSullyesztett = new JRadioButton("S�llyesztett");
  JPanel pnValaszt = new JPanel();

  public KeretezesFrame() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Keretez�s pr�ba");
    cp.setLayout(new FlowLayout()); //�gy jobban l�tszik a szeg�ly
    
    bg.add(rbVesett);                                       //3
    pnValaszt.add(rbVesett);
    rbVesett.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnValaszt.setBorder(
          BorderFactory.createEtchedBorder());
      }        
    });

    bg.add(rbKiemelt);
    pnValaszt.add(rbKiemelt);
    rbKiemelt.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnValaszt.setBorder(
          BorderFactory.createRaisedBevelBorder());
      }        
    });

    bg.add(rbSullyesztett);
    pnValaszt.add(rbSullyesztett);
    rbSullyesztett.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnValaszt.setBorder(
          BorderFactory.createLoweredBevelBorder());
      }        
    });

    cp.add(pnValaszt);
    pack();
    setVisible(true);
  }
}

public class RadioButtonTest {
  public static void main (String args[]) {
    new KeretezesFrame();
  }
}
