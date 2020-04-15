package gramain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.ImageIcon;

/*klasa z trzecim poziomem */
public class PoziomTrzeci extends JPanel {

    private Image img4;
    public Image piekarnia, koszyk;
    public JButton koniec, koniec2, lol, sprawdz;
    public JLabel[] rzeczy1 = new JLabel[20];
    public JLabel p1, portfel;
    public JLabel[] cena = new JLabel[20];
    public boolean[] czy = new boolean[20];
    boolean piek = false;
    Random kasa = new Random();
    public int[] pieniadz = new int[20];
    int ilemasz, dowydania;
    public int x, y;
    private int diffX, diffY;

    public PoziomTrzeci(Image img4) {
        
        this.img4 = img4;
        Dimension size = new Dimension(img4.getWidth(null), img4.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);

        for (int i = 0; i < pieniadz.length; i++) {
            pieniadz[i] = kasa.nextInt(100);
            cena[i] = new JLabel("Koszt to: " + pieniadz[i]);
            cena[i].setBackground(Color.white);
            add(cena[i]);
        } // petla losujaca ceny dla produktow, przypisanie każdej ceny dla osobnych JLabeli 
        
        cena[0].setBounds(30, 110, 100, 25);
        cena[1].setBounds(180, 110, 100, 25);
        cena[2].setBounds(30, 240, 100, 25);
        cena[3].setBounds(186, 240, 100, 25);
        cena[4].setBounds(30, 375, 100, 25);
        cena[5].setBounds(190, 375, 100, 25);
        cena[6].setBounds(30, 500, 100, 25);
        cena[7].setBounds(196, 500, 100, 25);
        cena[8].setBounds(30, 670, 100, 25);
        cena[9].setBounds(168, 650, 100, 25);
        cena[10].setBounds(720, 110, 100, 25);
        cena[11].setBounds(860, 110, 100, 25);
        cena[12].setBounds(730, 250, 100, 25);
        cena[13].setBounds(870, 250, 100, 25);
        cena[14].setBounds(730, 375, 100, 25);
        cena[15].setBounds(880, 375, 100, 25);
        cena[16].setBounds(730, 500, 100, 25);
        cena[17].setBounds(880, 530, 100, 25);
        cena[18].setBounds(750, 660, 100, 25);
        cena[19].setBounds(880, 680, 100, 25); // ustawienie cen na/pod produktem

        

        for (int i = 0; i < rzeczy1.length; i++) {
            rzeczy1[i] = new JLabel();
            add(rzeczy1[i]);
        } // dodanie produktów

        rzeczy1[0].setIcon(new ImageIcon("images/r4.png"));
        rzeczy1[0].setBounds(0, 0, 159, 159);
        rzeczy1[1].setIcon(new ImageIcon("images/p8.png"));
        rzeczy1[1].setBounds(175, 0, 159, 159);
        rzeczy1[2].setIcon(new ImageIcon("images/r5.png"));
        rzeczy1[2].setBounds(0, 130, 159, 159);
        rzeczy1[3].setIcon(new ImageIcon("images/r6.png"));
        rzeczy1[3].setBounds(161, 129, 159, 159);
        rzeczy1[4].setIcon(new ImageIcon("images/r7.png"));
        rzeczy1[4].setBounds(0, 278, 159, 159);
        rzeczy1[5].setIcon(new ImageIcon("images/p7.png"));
        rzeczy1[5].setBounds(152, 280, 159, 159);
        rzeczy1[6].setIcon(new ImageIcon("images/r8.png"));
        rzeczy1[6].setBounds(0, 408, 159, 159);
        rzeczy1[7].setIcon(new ImageIcon("images/r9.png"));
        rzeczy1[7].setBounds(160, 400, 159, 159);
        rzeczy1[8].setIcon(new ImageIcon("images/p1.png"));
        rzeczy1[8].setBounds(0, 550, 159, 159);
        rzeczy1[9].setIcon(new ImageIcon("images/p2.png"));
        rzeczy1[9].setBounds(145, 520, 159, 159);
        rzeczy1[10].setIcon(new ImageIcon("images/p9.png"));
        rzeczy1[10].setBounds(695, 0, 159, 159);
        rzeczy1[11].setIcon(new ImageIcon("images/p3.png"));
        rzeczy1[11].setBounds(830, 0, 159, 159);
        rzeczy1[12].setIcon(new ImageIcon("images/p6.png"));
        rzeczy1[12].setBounds(696, 120, 159, 159);
        rzeczy1[13].setIcon(new ImageIcon("images/p5.png"));
        rzeczy1[13].setBounds(850, 120, 159, 159);
        rzeczy1[14].setIcon(new ImageIcon("images/r3.png"));
        rzeczy1[14].setBounds(694, 250, 159, 159);
        rzeczy1[15].setIcon(new ImageIcon("images/d1.png"));
        rzeczy1[15].setBounds(857, 260, 159, 159);
        rzeczy1[16].setIcon(new ImageIcon("images/r2.png"));
        rzeczy1[16].setBounds(720, 390, 159, 159);
        rzeczy1[17].setIcon(new ImageIcon("images/r1.png"));
        rzeczy1[17].setBounds(875, 400, 159, 159);
        rzeczy1[18].setIcon(new ImageIcon("images/d2.png"));
        rzeczy1[18].setBounds(728, 520, 159, 159);
        rzeczy1[19].setIcon(new ImageIcon("images/p4.png"));
        rzeczy1[19].setBounds(875, 570, 159, 159); //ulozenie produktow oraz zaladowanie ich ikon

        ilemasz = 250;
        dowydania = 250;
        portfel = new JLabel("Twoja kwota do wykorzystania: " + ilemasz); //informacja na temat posiadanej kwoty
        portfel.setBounds(420, 20, 300, 25);
        add(portfel);

        koniec = new JButton();
        koniec.setIcon(new ImageIcon("images/koniec1.png"));
        koniec.setOpaque(false);
        koniec.setContentAreaFilled(false);
        koniec.setBounds(974, 10, 50, 50);
        koniec.setFocusPainted(true);
        koniec.setBorderPainted(false);
        add(koniec);
        koniec.addActionListener(new Koniec()); // przycisk wyjscia z gry 

        koniec2 = new JButton();
        koniec2.setIcon(new ImageIcon("images/koniec2.png"));
        koniec2.setOpaque(false);
        koniec2.setContentAreaFilled(false);
        koniec2.setBounds(960, 710, 50, 50);
        koniec2.setFocusPainted(true);
        koniec2.setBorderPainted(false);
        add(koniec2);
        koniec2.addActionListener(new Koniec2()); // przycisk powrotu do panelu Poziomy

        sprawdz = new JButton();
        sprawdz.setIcon(new ImageIcon("images/kup.png"));
        sprawdz.setOpaque(false);
        sprawdz.setContentAreaFilled(false);
        sprawdz.setBounds(420, 60, 140, 65);
        sprawdz.setFocusPainted(true);
        sprawdz.setBorderPainted(false);
        add(sprawdz);
        sprawdz.addActionListener(new Sprawdz()); // przycisk kupna rzeczy z koszyka

        for (int i = 0; i < rzeczy1.length; i++) {
            rzeczy1[i].addMouseListener(new Suwanie());
            rzeczy1[i].addMouseMotionListener(new Suwanie2());
        } 

    }

    public void paintComponent(Graphics g) {
        g.drawImage(img4, 0, 0, null);

    }

    public class Suwanie implements MouseListener {

        public void mousePressed(MouseEvent e) {

            diffX = e.getX() - PoziomTrzeci.this.getX();
            diffY = e.getY() - PoziomTrzeci.this.getY();
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    /* funkcja sprawdza czy przedmiot jest w koszyku, jesli tak zwraca wartosc true i odejmuje od posiadanych pieniedzy aktualna cene produktu*/
    public void sprawdzobszar() {
        if (czy[0] == true) {
            dowydania = dowydania - pieniadz[0];
            System.out.println(dowydania);
            czy[0] = false;
        }
        if (czy[1] == true) {
            dowydania = dowydania - pieniadz[1];
            System.out.println(dowydania);
            czy[1] = false;
        }
        if (czy[2] == true) {
            dowydania = dowydania - pieniadz[2];
            System.out.println(dowydania);
            czy[2] = false;
        }
        if (czy[3] == true) {
            dowydania = dowydania - pieniadz[3];
            System.out.println(dowydania);
            czy[3] = false;
        }
        if (czy[4] == true) {
            dowydania = dowydania - pieniadz[4];
            System.out.println(dowydania);
            czy[4] = false;
        }
        if (czy[5] == true) {
            dowydania = dowydania - pieniadz[5];
            System.out.println(dowydania);
            czy[5] = false;
        }
        if (czy[6] == true) {
            dowydania = dowydania - pieniadz[6];
            System.out.println(dowydania);
            czy[6] = false;
        }
        if (czy[7] == true) {
            dowydania = dowydania - pieniadz[7];
            System.out.println(dowydania);
            czy[7] = false;
        }
        if (czy[8] == true) {
            dowydania = dowydania - pieniadz[8];
            System.out.println(dowydania);
            czy[8] = false;
        }
        if (czy[9] == true) {
            dowydania = dowydania - pieniadz[9];
            System.out.println(dowydania);
            czy[9] = false;
        }
        if (czy[10] == true) {
            dowydania = dowydania - pieniadz[10];
            System.out.println(dowydania);
            czy[10] = false;
        }
        if (czy[11] == true) {
            dowydania = dowydania - pieniadz[11];
            System.out.println(dowydania);
            czy[11] = false;
        }
        if (czy[12] == true) {
            dowydania = dowydania - pieniadz[12];
            System.out.println(dowydania);
            czy[12] = false;
        }
        if (czy[13] == true) {
            dowydania = dowydania - pieniadz[13];
            System.out.println(dowydania);
            czy[13] = false;
        }
        if (czy[14] == true) {
            dowydania = dowydania - pieniadz[14];
            System.out.println(dowydania);
            czy[14] = false;
        }
        if (czy[15] == true) {
            dowydania = dowydania - pieniadz[15];
            System.out.println(dowydania);
            czy[15] = false;
        }
        if (czy[16] == true) {
            dowydania = dowydania - pieniadz[16];
            System.out.println(dowydania);
            czy[16] = false;
        }
        if (czy[17] == true) {
            dowydania = dowydania - pieniadz[17];
            System.out.println(dowydania);
            czy[17] = false;
        }
        if (czy[18] == true) {
            dowydania = dowydania - pieniadz[18];
            System.out.println(dowydania);
            czy[18] = false;
        }
        if (czy[19] == true) {
            dowydania = dowydania - pieniadz[19];
            System.out.println(dowydania);
            czy[19] = false;
        }
    }

    public class Suwanie2 implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            int x = e.getXOnScreen() - diffX;
            int y = e.getYOnScreen() - diffY;
            
            if (e.getComponent() == rzeczy1[0]) {
                rzeczy1[0].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[0] = true;
                }
                else{
                    czy[0] = false;
                }
            }
            if (e.getComponent() == rzeczy1[1]) {
                rzeczy1[1].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[1] = true;
                }
                else{
                    czy[1] = false;
                }
            }
            if (e.getComponent() == rzeczy1[2]) {
                rzeczy1[2].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[2] = true;
                }
                else{
                    czy[2] = false;
                }
            }
            if (e.getComponent() == rzeczy1[3]) {
                rzeczy1[3].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[3] = true;
                }
                else{
                    czy[3] = false;
                }
            }
            if (e.getComponent() == rzeczy1[4]) {
                rzeczy1[4].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[4] = true;
                }
                else{
                    czy[4] = false;
                }
            }
            if (e.getComponent() == rzeczy1[5]) {
                rzeczy1[5].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[5] = true;
                }
                else{
                    czy[5] = false;
                }
            }
            if (e.getComponent() == rzeczy1[6]) {
                rzeczy1[6].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[6] = true;
                }
                else{
                    czy[6] = false;
                }
            }
            if (e.getComponent() == rzeczy1[7]) {
                rzeczy1[7].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[7] = true;
                }
                else{
                    czy[7] = false;
                }
            }
            if (e.getComponent() == rzeczy1[8]) {
                rzeczy1[8].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[8] = true;
                }
                else{
                    czy[8] = false;
                }
            }
            if (e.getComponent() == rzeczy1[9]) {
                rzeczy1[9].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[9] = true;
                }
                else{
                    czy[9] = false;
                }
            }
            if (e.getComponent() == rzeczy1[10]) {
                rzeczy1[10].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[10] = true;
                }
                else{
                    czy[10] = false;
                }
            }
            if (e.getComponent() == rzeczy1[11]) {
                rzeczy1[11].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[11] = true;
                }
                else{
                    czy[11] = false;
                }
            }
            if (e.getComponent() == rzeczy1[12]) {
                rzeczy1[12].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[12] = true;
                }
                else{
                    czy[12] = false;
                }
            }
            if (e.getComponent() == rzeczy1[13]) {
                rzeczy1[13].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[13] = true;
                }
                else{
                    czy[13] = false;
                }
            }
            if (e.getComponent() == rzeczy1[14]) {
                rzeczy1[14].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[14] = true;
                }
                else{
                    czy[14] = false;
                }
            }
            if (e.getComponent() == rzeczy1[15]) {
                rzeczy1[15].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[15] = true;
                }
                else{
                    czy[15] = false;
                }
            }
            if (e.getComponent() == rzeczy1[16]) {
                rzeczy1[16].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[16] = true;
                }
                else{
                    czy[16] = false;
                }

            }
            if (e.getComponent() == rzeczy1[17]) {
                rzeczy1[17].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[17] = true;
                }
                else{
                    czy[17] = false;
                }
            }
            if (e.getComponent() == rzeczy1[18]) {
                rzeczy1[18].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[18] = true;
                }
                else{
                    czy[18] = false;
                }
            }
            if (e.getComponent() == rzeczy1[19]) {
                rzeczy1[19].setBounds(x, y, 159, 159);
                if (x > 354 && x < 654 && y < 768 && y > 400) {
                    czy[19] = true;
                }
                else{
                    czy[19] = false;
                }
            } /* ify sprawdzaja, ktory komponent zostal klikniety, a nastepnie po poruszeniu myszy przesuwa go, gdy znajduje sie w obszarze zwraca wartosc true*/

        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }
/*wyjscie z gry */
    public class Koniec implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            GraMain.f.setVisible(false);
            System.exit(0);
        }
    }
/* wyjscie do wyboru poziomu */ 
    public class Koniec2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            setVisible(false);
            GraMain.f.getContentPane().add(new Poziomy(new ImageIcon("images/tlopoziom.png").getImage()));
        }
    }
    
/*wywolanie funkcji, ktora sprawdza czy produkty sa w koszyku i oblicza ile gracz wydal, gdy nie wydano 
    za duzo pojawia sie panel z informacja o poprawnym zakupie i ilosci wydanych pieniedzy, 
    w przeciwnym razie panel "resetuje sie", pojawienie nowych cen oraz produkty wracaja na polki*/
    public class Sprawdz implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            sprawdzobszar();
            if (dowydania >= 0 ) {
                
                setVisible(false);
                GraMain.f.getContentPane().add(new Wygransko(new ImageIcon("images/wygransko3.png").getImage(),dowydania));
                
            } else {
                setVisible(false);
                GraMain.f.getContentPane().add(new PoziomTrzeci(new ImageIcon("images/trzeci.png").getImage()));

            }

        }
    }

}
