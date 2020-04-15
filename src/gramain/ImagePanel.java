
package gramain;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.*;

/*panel glowny */ 
public class ImagePanel extends JPanel {

    private Image img;
    public JButton b1, b2;
    
    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
        
    }

    public ImagePanel(Image img) {
        
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null)); 
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);

        b1 = new JButton();
        b1.setIcon(new ImageIcon("images/button1.png"));
        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBounds(580, 710, 213, 43);
        b1.setFocusPainted(true);
        b1.setBorderPainted(false);
        b1.addActionListener(new B1());

        b2 = new JButton();
        b2.setIcon(new ImageIcon("images/button2.png"));
        b2.setOpaque(false);
        b2.setContentAreaFilled(false);
        b2.setBounds(800, 710, 213, 43);
        b2.setFocusPainted(true);
        b2.setBorderPainted(false);
        b2.addActionListener(new B2());
        
        add(b1);
        add(b2);
 
    }
    
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
/*rozpoaczecie gry=przejscie do wyboru poziomow */ 
    public class B1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            GraMain.f.getContentPane().add(new Poziomy(new ImageIcon("images/tlopoziom.png").getImage()));
        }
    }
/* wyjscie z gry*/
    private class B2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            GraMain.f.setVisible(false);
            System.exit(0);
        }
    }
}
