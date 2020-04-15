package gramain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ImageIcon;

/* klasa odpowiadająca za panel z wyborem poziomów oraz pokazaniem zasad*/
public class Poziomy extends JPanel
{
    public JButton p1,p2,p3,p4,wyswietl;
    private Image img1;
    public JLabel zasady;
    int koniecczasu = 30;
    
    public Poziomy(Image img1){
        this.img1 =img1;
         Dimension size = new Dimension(img1.getWidth(null), img1.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);       
        
        koniecczasu=10000;
        p1 = new JButton();
        p1.setIcon(new ImageIcon("images/button3.png"));
        p1.setOpaque(false);
        p1.setContentAreaFilled(false);
        p1.setBounds(322, 50, 350, 71);
        p1.setFocusPainted(true);
        p1.setBorderPainted(false);
        p1.addActionListener(new P1());
        
        p2 = new JButton();
        p2.setIcon(new ImageIcon("images/button4.png"));
        p2.setOpaque(false);
        p2.setContentAreaFilled(false);
        p2.setBounds(322, 140, 350, 71);
        p2.setFocusPainted(true);
        p2.setBorderPainted(false);
        p2.addActionListener(new P2());
        
        p3 = new JButton();
        p3.setIcon(new ImageIcon("images/button5.png"));
        p3.setOpaque(false);
        p3.setContentAreaFilled(false);
        p3.setBounds(322, 230, 350, 71);
        p3.setFocusPainted(true);
        p3.setBorderPainted(false);
        p3.addActionListener(new P3());
        
        p4 = new JButton();
        p4.setIcon(new ImageIcon("images/buttonwroc.png"));
        p4.setOpaque(false);
        p4.setContentAreaFilled(false);
        p4.setBounds(800, 710, 213, 43);
        p4.setFocusPainted(true);
        p4.setBorderPainted(false);
        p4.addActionListener(new Pwroc());
        
        wyswietl = new JButton();
        wyswietl.setIcon(new ImageIcon("images/button6.png"));
        wyswietl.setOpaque(false);
        wyswietl.setContentAreaFilled(false);
        wyswietl.setBounds(330, 320, 350, 71);
        wyswietl.setFocusPainted(true);
        wyswietl.setBorderPainted(false);
        wyswietl.addActionListener(new Wyswietl());
        
        zasady = new JLabel();
        zasady.setIcon(new ImageIcon("images/zasady.png"));
        zasady.setBounds(80,390,840,280);
        
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(wyswietl);
        add(zasady);
        zasady.setVisible(false);
        
    }
     public void paintComponent(Graphics g) {
        g.drawImage(img1, 0, 0, null);
    }
     /*powort do panelu glownego */
     public class Pwroc implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            setVisible(false);
            GraMain.f.getContentPane().add(new ImagePanel(new ImageIcon("images/tlo.png").getImage()));

        }
    }
     /*wybor poziomu pierwszego */ 
     public class P1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            setVisible(false);
            GraMain.f.getContentPane().add(new PoziomPierwszy(new ImageIcon("images/poziom.png").getImage()));
        }
    }
     /*wybor poziomu drugiego */
     public class P2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            setVisible(false);
            GraMain.f.getContentPane().add(new PoziomDrugi(new ImageIcon("images/poziom1.png").getImage()));
        }
    }
     /*wybor poziomu trzeciego */
     public class P3 implements ActionListener {

        public void actionPerformed(ActionEvent e) {   
            setVisible(false);    
            GraMain.f.getContentPane().add(new PoziomTrzeci(new ImageIcon("images/trzeci.png").getImage()));
        }
    }
     /*wyswietlenie zasad */
     public class Wyswietl implements ActionListener {

        public void actionPerformed(ActionEvent e) {   
            zasady.setVisible(true);
        }
    }
}
