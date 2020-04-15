
package gramain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*klasa odpowiadająca za panele,które pojawiają się po skończonym poziomu, 
zawiera różne konstruktory w zależności od przesyłanych parametrów*/
public class Wygransko extends JPanel {
    
    public Image img1;
    public JLabel wygrana,wygrana1,procent,pkt,wydales;
    public JButton koniec;
    
    public Wygransko(Image img1){
        
        this.img1 =img1;
        Dimension size = new Dimension(img1.getWidth(null), img1.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
           
        wygrana=new JLabel();
        wygrana.setBounds(50,150,300,300);
        wygrana.setIcon(new ImageIcon("images/gifo.gif"));
        add(wygrana);
        
        wygrana1=new JLabel();
        wygrana1.setBounds(700,320,300,300);
        wygrana1.setIcon(new ImageIcon("images/gifo.gif"));
        add(wygrana1);
        
        koniec = new JButton();
        koniec.setIcon(new ImageIcon("images/koniec1.png"));
        koniec.setOpaque(false);
        koniec.setContentAreaFilled(false);
        koniec.setBounds(960, 10, 50, 50);
        koniec.setFocusPainted(true);
        koniec.setBorderPainted(false);
        add(koniec);
        koniec.addActionListener(new Koniec());
       
    }
    
    public Wygransko(Image img1,double statystyka, double punkty){
        this.img1 =img1;
        Dimension size = new Dimension(img1.getWidth(null), img1.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        
        koniec = new JButton();
        koniec.setIcon(new ImageIcon("images/koniec1.png"));
        koniec.setOpaque(false);
        koniec.setContentAreaFilled(false);
        koniec.setBounds(960, 10, 50, 50);
        koniec.setFocusPainted(true);
        koniec.setBorderPainted(false);
        add(koniec);
        koniec.addActionListener(new Koniec());

        pkt=new JLabel("Punktowo: "+punkty);
        pkt.setBounds(390,230,350,40);
        pkt.setFont(new Font("Helvetica", Font.BOLD, 30));
        add(pkt);
        procent=new JLabel("Procentowo: "+statystyka+"%");
        procent.setBounds(390,260,350,40);
        procent.setFont(new Font("Helvetica", Font.BOLD, 30));
        add(procent);

       
    }
    
    public Wygransko(Image img1, int wydano){
        this.img1 =img1;
        Dimension size = new Dimension(img1.getWidth(null), img1.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
           
        wygrana=new JLabel();
        wygrana.setBounds(50,150,300,300);
        wygrana.setIcon(new ImageIcon("images/gifo.gif"));
        add(wygrana);
        
        wygrana1=new JLabel();
        wygrana1.setBounds(700,320,300,300);
        wygrana1.setIcon(new ImageIcon("images/gifo.gif"));
        add(wygrana1);
        
        int ile=250-wydano;
        wydales=new JLabel("Wydałeś łącznie: "+ile+"zł");
        wydales.setFont(new Font("Helvetica", Font.BOLD, 30));
        wydales.setBounds(370,456,450,40);
        
        add(wydales);
        
        koniec = new JButton();
        koniec.setIcon(new ImageIcon("images/koniec1.png"));
        koniec.setOpaque(false);
        koniec.setContentAreaFilled(false);
        koniec.setBounds(960, 10, 50, 50);
        koniec.setFocusPainted(true);
        koniec.setBorderPainted(false);
        add(koniec);
        koniec.addActionListener(new Koniec());
       
    }
    
     public void paintComponent(Graphics g) {
        g.drawImage(img1, 0, 0, null);
    }
     public class Koniec implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            setVisible(false);
            GraMain.f.getContentPane().add(new Poziomy(new ImageIcon("images/tlopoziom.png").getImage()));
        }
    }
    
}
