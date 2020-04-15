package gramain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.event.MouseEvent;

/*klasa z poziomem drugim */
public class PoziomDrugi extends JPanel {

    private Image img3, koszyk;
    public JLabel label, labelkwota;
    public JButton koniec, koniec2, sklep1, sklep2, sklep3, zaplac, cena, potwierdz;
    public JButton[] przyciskipieniadz = new JButton[12];
    public JButton[] sklepy = new JButton[3];
    public Image piekarnia, sklep, supermarket, odziezowy;
    boolean piek = false, zaplata = false, ilezaplacic = false, market = false, odziez = false, wyswietlanie;
    boolean c, pol1 = false, pol2 = false, pol3 = false, pol4 = false, pol5 = false, pol6 = false, pol7 = false, pol8 = false, pol9 = false;
    public Image[] rzeczy1 = new Image[9];
    public Image[] rzeczy2 = new Image[9];
    public Image[] rzeczy3 = new Image[9];
    public int x, y;
    Random kasa = new Random();
    public double pieniadz;
    double kwota;

    public PoziomDrugi(Image img3) {

        this.img3 = img3;
        Dimension size = new Dimension(img3.getWidth(null), img3.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);

        piekarnia = new ImageIcon("images/piekarnia.png").getImage();
        supermarket = new ImageIcon("images/market1.png").getImage();
        odziezowy = new ImageIcon("images/odziez.png").getImage();
        koszyk = new ImageIcon("images/kosz.png").getImage();
        sklep = new ImageIcon("images/sklep.png").getImage();

        rzeczy1[0] = new ImageIcon("images/p1.png").getImage();
        rzeczy1[1] = new ImageIcon("images/p2.png").getImage();
        rzeczy1[2] = new ImageIcon("images/p3.png").getImage();
        rzeczy1[3] = new ImageIcon("images/p4.png").getImage();
        rzeczy1[4] = new ImageIcon("images/p5.png").getImage();
        rzeczy1[5] = new ImageIcon("images/p6.png").getImage();
        rzeczy1[6] = new ImageIcon("images/p7.png").getImage();
        rzeczy1[7] = new ImageIcon("images/p8.png").getImage();
        rzeczy1[8] = new ImageIcon("images/p9.png").getImage();

        rzeczy2[0] = new ImageIcon("images/r1.png").getImage();
        rzeczy2[1] = new ImageIcon("images/r2.png").getImage();
        rzeczy2[2] = new ImageIcon("images/r3.png").getImage();
        rzeczy2[3] = new ImageIcon("images/r4.png").getImage();
        rzeczy2[4] = new ImageIcon("images/r5.png").getImage();
        rzeczy2[5] = new ImageIcon("images/r6.png").getImage();
        rzeczy2[6] = new ImageIcon("images/r7.png").getImage();
        rzeczy2[7] = new ImageIcon("images/r8.png").getImage();
        rzeczy2[8] = new ImageIcon("images/r9.png").getImage();

        rzeczy3[0] = new ImageIcon("images/o1.png").getImage();
        rzeczy3[1] = new ImageIcon("images/o2.png").getImage();
        rzeczy3[2] = new ImageIcon("images/o3.png").getImage();
        rzeczy3[3] = new ImageIcon("images/o4.png").getImage();
        rzeczy3[4] = new ImageIcon("images/o5.png").getImage();
        rzeczy3[5] = new ImageIcon("images/o6.png").getImage();
        rzeczy3[6] = new ImageIcon("images/o7.png").getImage();
        rzeczy3[7] = new ImageIcon("images/o8.png").getImage();
        rzeczy3[8] = new ImageIcon("images/o9.png").getImage();

        for (int i = 0; i < sklepy.length; i++) {
            sklepy[i] = new JButton();
            add(sklepy[i]);
            sklepy[i].setOpaque(false);
            sklepy[i].setContentAreaFilled(false);
            sklepy[i].setFocusPainted(true);
            sklepy[i].setBorderPainted(false);
        } /*petla z przyciskami sklepow */

        sklepy[0].setIcon(new ImageIcon("images/pbutton.png"));
        sklepy[0].setBounds(5, 250, 340, 313);
        sklepy[1].setIcon(new ImageIcon("images/sbutton.png"));
        sklepy[1].setBounds(330, 250, 340, 313);
        sklepy[2].setIcon(new ImageIcon("images/obutton.png"));
        sklepy[2].setBounds(650, 250, 340, 313);

        koniec = new JButton();
        koniec.setIcon(new ImageIcon("images/koniec1.png"));
        koniec.setOpaque(false);
        koniec.setContentAreaFilled(false);
        koniec.setBounds(960, 10, 50, 50);
        koniec.setFocusPainted(true);
        koniec.setBorderPainted(false);

        koniec2 = new JButton();
        koniec2.setIcon(new ImageIcon("images/koniec2.png"));
        koniec2.setOpaque(false);
        koniec2.setContentAreaFilled(false);
        koniec2.setBounds(960, 710, 50, 50);
        koniec2.setFocusPainted(true);
        koniec2.setBorderPainted(false);

        zaplac = new JButton();
        zaplac.setIcon(new ImageIcon("images/zaplata.png"));
        zaplac.setOpaque(false);
        zaplac.setContentAreaFilled(false);
        zaplac.setBounds(20, 700, 250, 65);
        zaplac.setFocusPainted(true);
        zaplac.setBorderPainted(false);

        cena = new JButton();
        cena.setIcon(new ImageIcon("images/cena.png"));
        cena.setOpaque(false);
        cena.setContentAreaFilled(false);
        cena.setBounds(20, 550, 250, 65);
        cena.setFocusPainted(true);
        cena.setBorderPainted(false);

        label = new JLabel(" ");
        label.setBounds(20, 625, 350, 80);
        label.setFont(new Font("Helvetica", Font.BOLD, 25));
        label.setForeground(Color.WHITE);

        labelkwota = new JLabel(" ");
        labelkwota.setBounds(652, 530, 350, 30);
        labelkwota.setFont(new Font("Helvetica", Font.BOLD, 25));
        labelkwota.setForeground(Color.WHITE);

        potwierdz = new JButton();
        potwierdz.setIcon(new ImageIcon("images/zaplac.png"));
        potwierdz.setOpaque(false);
        potwierdz.setContentAreaFilled(false);
        potwierdz.setBounds(648, 450, 250, 65);
        potwierdz.setFocusPainted(true);
        potwierdz.setBorderPainted(false);

        for (int i = 0; i < przyciskipieniadz.length; i++) {
            przyciskipieniadz[i] = new JButton();
            add(przyciskipieniadz[i]);
            przyciskipieniadz[i].setVisible(false);
            przyciskipieniadz[i].setOpaque(false);
            przyciskipieniadz[i].setContentAreaFilled(false);
            przyciskipieniadz[i].setFocusPainted(true);
            przyciskipieniadz[i].setBorderPainted(false);
        }/*petla dla ustawienia przyciskow banknotow/monet */

        przyciskipieniadz[0].setIcon(new ImageIcon("images/1grn.png"));
        przyciskipieniadz[0].setBounds(335, 485, 65, 65);
        przyciskipieniadz[1].setIcon(new ImageIcon("images/2grn.png"));
        przyciskipieniadz[1].setBounds(247, 470, 73, 73);
        przyciskipieniadz[2].setIcon(new ImageIcon("images/5grn.png"));
        przyciskipieniadz[2].setBounds(155, 460, 81, 81);
        przyciskipieniadz[3].setIcon(new ImageIcon("images/10grn.png"));
        przyciskipieniadz[3].setBounds(72, 465, 66, 66);
        przyciskipieniadz[4].setIcon(new ImageIcon("images/20grn.png"));
        przyciskipieniadz[4].setBounds(439, 563, 81, 81);
        przyciskipieniadz[5].setIcon(new ImageIcon("images/50grn.png"));
        przyciskipieniadz[5].setBounds(340, 558, 88, 88);
        przyciskipieniadz[6].setIcon(new ImageIcon("images/1n.png"));
        przyciskipieniadz[6].setBounds(234, 551, 98, 96);
        przyciskipieniadz[7].setIcon(new ImageIcon("images/2n.png"));
        przyciskipieniadz[7].setBounds(126, 550, 97, 96);
        przyciskipieniadz[8].setIcon(new ImageIcon("images/5n.png"));
        przyciskipieniadz[8].setBounds(4, 540, 105, 103);
        przyciskipieniadz[9].setIcon(new ImageIcon("images/10n.png"));
        przyciskipieniadz[9].setBounds(416, 668, 186, 93);
        przyciskipieniadz[10].setIcon(new ImageIcon("images/20n.png"));
        przyciskipieniadz[10].setBounds(216, 664, 194, 98);
        przyciskipieniadz[11].setIcon(new ImageIcon("images/50n.png"));
        przyciskipieniadz[11].setBounds(4, 657, 206, 104);

        add(label);
        add(labelkwota);
        add(koniec);
        add(zaplac);
        add(cena);
        add(potwierdz);
        add(koniec2);

        zaplac.setVisible(false);
        cena.setVisible(false);
        potwierdz.setVisible(false);
        label.setVisible(false);
        labelkwota.setVisible(false);

        koniec.addActionListener(new Koniec());
        koniec2.addActionListener(new Koniec2());
        zaplac.addActionListener(new Zaplata());
        cena.addActionListener(new Cena());
        potwierdz.addActionListener(new Potwierdz());

        for (int i = 0; i < sklepy.length; i++) {
            sklepy[i].addActionListener(new Sklepy());

        }

        for (int i = 0; i < przyciskipieniadz.length; i++) {
            przyciskipieniadz[i].addActionListener(new IleJeszcze());
        }
    }
    /* sprawdzenie, ktory obszar zostal klikniety, klikniecie danego obszaru ustawia jeden z 9 booleanow na true, reszte na false */

    public void sprawdzenie() {

        if (x > 0 && x < 159 && y > 0 && y < 159) {
            pol1 = true;
            pol2 = false;
            pol3 = false;
            pol4 = false;
            pol5 = false;
            pol6 = false;
            pol7 = false;
            pol8 = false;
            pol9 = false;
            ilezaplacic = false;
        }

        if (x > 165 && x < 324 && y < 159) {
            pol2 = true;
            pol1 = false;
            pol3 = false;
            pol4 = false;
            pol5 = false;
            pol6 = false;
            pol7 = false;
            pol8 = false;
            pol9 = false;
            ilezaplacic = false;
        }
        if (x > 330 && x < 489 && y < 159) {
            pol3 = true;
            pol1 = false;
            pol2 = false;
            pol4 = false;
            pol5 = false;
            pol6 = false;
            pol7 = false;
            pol8 = false;
            pol9 = false;
            ilezaplacic = false;
        }
        if (x < 159 && y > 165 && y < 324) {
            pol4 = true;
            pol1 = false;
            pol3 = false;
            pol2 = false;
            pol5 = false;
            pol6 = false;
            pol7 = false;
            pol8 = false;
            pol9 = false;
            ilezaplacic = false;
        }
        if (x > 165 && x < 324 && y > 165 && y < 324) {
            pol5 = true;
            pol1 = false;
            pol3 = false;
            pol4 = false;
            pol2 = false;
            pol6 = false;
            pol7 = false;
            pol8 = false;
            pol9 = false;
            ilezaplacic = false;
        }
        if (x > 330 && x < 489 && y > 165 && y < 324) {
            pol6 = true;
            pol1 = false;
            pol3 = false;
            pol4 = false;
            pol5 = false;
            pol2 = false;
            pol7 = false;
            pol8 = false;
            pol9 = false;
            ilezaplacic = false;
        }
        if (x < 159 && y > 330 && y < 489) {
            pol7 = true;
            pol1 = false;
            pol3 = false;
            pol4 = false;
            pol5 = false;
            pol6 = false;
            pol2 = false;
            pol8 = false;
            pol9 = false;
            ilezaplacic = false;
        }
        if (x > 165 && x < 324 && y > 330 && y < 489) {
            pol8 = true;
            pol1 = false;
            pol3 = false;
            pol4 = false;
            pol5 = false;
            pol6 = false;
            pol7 = false;
            pol2 = false;
            pol9 = false;
            ilezaplacic = false;
        }
        if (x > 330 && x < 489 && y > 330 && y < 489) {
            pol9 = true;
            pol1 = false;
            pol3 = false;
            pol4 = false;
            pol5 = false;
            pol6 = false;
            pol7 = false;
            pol8 = false;
            pol2 = false;
            ilezaplacic = false;
        }
    }
    /* zaokraglenie */

    public double dozaplaty() {

        pieniadz = kasa.nextDouble() * 10000;
        pieniadz = Math.round(pieniadz);
        pieniadz = pieniadz / 100;

        return pieniadz;
    }

    public void paintComponent(Graphics g) {

        g.drawImage(img3, 0, 0, null);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                x = me.getX();
                y = me.getY();
                dozaplaty();                
            }
        }); /*dodanie klikania */

        if (zaplata == true) {

            g.drawImage(sklep, 0, 0, null);
            zaplac.setVisible(false);
        } /*przejscie do 'kasy'  */

        /* if ktory sprawdza booleany i w zaleznosci od ich wartosci, wklada przedmiot do koszyka albo na polke, 
         kolejne if z 'market' i 'odiez' dzialaj analogicznie */
        if (piek == true) {

            g.drawImage(piekarnia, 0, 0, null);
            znikanie();
            if (pol1 == false) {
                g.drawImage(rzeczy1[0], 0, 0, null);
            }
            if (pol2 == false) {
                g.drawImage(rzeczy1[1], 165, 0, null);
            }
            if (pol3 == false) {
                g.drawImage(rzeczy1[2], 330, 0, null);
            }
            if (pol4 == false) {
                g.drawImage(rzeczy1[3], 0, 165, null);
            }
            if (pol5 == false) {
                g.drawImage(rzeczy1[4], 165, 165, null);
            }
            if (pol6 == false) {
                g.drawImage(rzeczy1[5], 330, 165, null);
            }
            if (pol7 == false) {
                g.drawImage(rzeczy1[6], 0, 330, null);
            }
            if (pol8 == false) {
                g.drawImage(rzeczy1[7], 165, 330, null);
            }
            if (pol9 == false) {
                g.drawImage(rzeczy1[8], 330, 330, null);
            }

            sprawdzenie();

            if (pol1 == true) {
                g.drawImage(rzeczy1[0], 600, 570, null);
            }
            if (pol2 == true) {
                g.drawImage(rzeczy1[1], 600, 570, null);
            }
            if (pol3 == true) {
                g.drawImage(rzeczy1[2], 600, 570, null);
            }
            if (pol4 == true) {
                g.drawImage(rzeczy1[3], 600, 570, null);
            }
            if (pol5 == true) {
                g.drawImage(rzeczy1[4], 600, 570, null);
            }
            if (pol6 == true) {
                g.drawImage(rzeczy1[5], 600, 570, null);
            }
            if (pol7 == true) {
                g.drawImage(rzeczy1[6], 600, 570, null);
            }
            if (pol8 == true) {
                g.drawImage(rzeczy1[7], 600, 570, null);
            }
            if (pol9 == true) {
                g.drawImage(rzeczy1[8], 600, 570, null);
            }
            g.drawImage(koszyk, 550, 650, null);
            repaint();

        }
        if (market == true) {

            g.drawImage(supermarket, 0, 0, null);
            znikanie();
            if (pol1 == false) {
                g.drawImage(rzeczy2[0], 0, 0, null);
            }
            if (pol2 == false) {
                g.drawImage(rzeczy2[1], 165, 0, null);
            }
            if (pol3 == false) {
                g.drawImage(rzeczy2[2], 330, 0, null);
            }
            if (pol4 == false) {
                g.drawImage(rzeczy2[3], 0, 165, null);
            }
            if (pol5 == false) {
                g.drawImage(rzeczy2[4], 165, 165, null);
            }
            if (pol6 == false) {
                g.drawImage(rzeczy2[5], 330, 165, null);
            }
            if (pol7 == false) {
                g.drawImage(rzeczy2[6], 0, 330, null);
            }
            if (pol8 == false) {
                g.drawImage(rzeczy2[7], 165, 330, null);
            }
            if (pol9 == false) {
                g.drawImage(rzeczy2[8], 330, 330, null);
            }

            sprawdzenie();

            if (pol1 == true) {
                g.drawImage(rzeczy2[0], 600, 570, null);
            }
            if (pol2 == true) {
                g.drawImage(rzeczy2[1], 600, 570, null);
            }
            if (pol3 == true) {
                g.drawImage(rzeczy2[2], 60, 570, null);
            }
            if (pol4 == true) {
                g.drawImage(rzeczy2[3], 600, 570, null);
            }
            if (pol5 == true) {
                g.drawImage(rzeczy2[4], 600, 570, null);
            }
            if (pol6 == true) {
                g.drawImage(rzeczy2[5], 600, 570, null);
            }
            if (pol7 == true) {
                g.drawImage(rzeczy2[6], 600, 570, null);
            }
            if (pol8 == true) {
                g.drawImage(rzeczy2[7], 600, 570, null);
            }
            if (pol9 == true) {
                g.drawImage(rzeczy2[8], 600, 570, null);
            }
            g.drawImage(koszyk, 550, 650, null);
            repaint();

        }

        if (odziez == true) {

            g.drawImage(odziezowy, 0, 0, null);
            znikanie();
            if (pol1 == false) {
                g.drawImage(rzeczy3[0], 0, 0, null);
            }
            if (pol2 == false) {
                g.drawImage(rzeczy3[1], 165, 0, null);
            }
            if (pol3 == false) {
                g.drawImage(rzeczy3[2], 330, 0, null);
            }
            if (pol4 == false) {
                g.drawImage(rzeczy3[3], 0, 165, null);
            }
            if (pol5 == false) {
                g.drawImage(rzeczy3[4], 165, 165, null);
            }
            if (pol6 == false) {
                g.drawImage(rzeczy3[5], 330, 165, null);
            }
            if (pol7 == false) {
                g.drawImage(rzeczy3[6], 0, 330, null);
            }
            if (pol8 == false) {
                g.drawImage(rzeczy3[7], 165, 330, null);
            }
            if (pol9 == false) {
                g.drawImage(rzeczy3[8], 330, 330, null);
            }

            sprawdzenie();

            if (pol1 == true) {
                g.drawImage(rzeczy3[0], 600, 570, null);
            }
            if (pol2 == true) {
                g.drawImage(rzeczy3[1], 600, 570, null);
            }
            if (pol3 == true) {
                g.drawImage(rzeczy3[2], 600, 570, null);
            }
            if (pol4 == true) {
                g.drawImage(rzeczy3[3], 600, 570, null);
            }
            if (pol5 == true) {
                g.drawImage(rzeczy3[4], 600, 570, null);
            }
            if (pol6 == true) {
                g.drawImage(rzeczy3[5], 600, 570, null);
            }
            if (pol7 == true) {
                g.drawImage(rzeczy3[6], 600, 570, null);
            }
            if (pol8 == true) {
                g.drawImage(rzeczy3[7], 600, 570, null);
            }
            if (pol9 == true) {
                g.drawImage(rzeczy3[8], 600, 570, null);
            }
            g.drawImage(koszyk, 550, 650, null);
            repaint();

        }

    }
    /*wyjscie z gry */

    public class Koniec implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            GraMain.f.setVisible(false);
            System.exit(0);
        }
    }
    /*powrot do wyboru poziomu */

    public class Koniec2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            setVisible(false);
            GraMain.f.getContentPane().add(new Poziomy(new ImageIcon("images/tlopoziom.png").getImage()));
        }
    }
    /* wyswietlenie ceny za przedmiot */

    public class Cena implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            label.setVisible(true);
            wyswietlanie = true;
            label.setText("Do zaplaty masz: " + pieniadz);
        }
    }
    /*sprawdzenie czy zostala wybrana dobra kwota do zaplaty, jesli tak przejscie do panelu z gratulacjami, w przeciwnym razie trzeba ponownie wybierac */

    public class Potwierdz implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (kwota == pieniadz) {
                setVisible(false);
                GraMain.f.getContentPane().add(new Wygransko(new ImageIcon("images/wygransko.png").getImage()));
            } else {
                kwota = 0;
                labelkwota.setText("Zapłac jeszcze raz ");
            }
        }
    }

    /*przycisk dzieki ktoremu przechodzimy do kasy */
    public class Zaplata implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            zaplata = true;
            piek = false;
            market = false;
            odziez = false;
            wyswietlanie = false;

            for (int i = 0; i < przyciskipieniadz.length; i++) {
                przyciskipieniadz[i].setVisible(true);
            }

            cena.setVisible(false);
            zaplac.setVisible(false);
            potwierdz.setVisible(true);
            labelkwota.setVisible(true);
            label.setBounds(700, 700, 350, 80);
        }
    }

    /*ukrycie przyciskow ze sklepami */
    public void znikanie() {
        for (int i = 0; i < sklepy.length; i++) {
            sklepy[i].setVisible(false);
        }
    }

    /*wybranie sklepu */
    public class Sklepy implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == sklepy[0]) {
                piek = true;
                zaplac.setVisible(true);
                cena.setVisible(true);
            }
            if (e.getSource() == sklepy[1]) {
                market = true;
                zaplac.setVisible(true);
                cena.setVisible(true);
            }
            if (e.getSource() == sklepy[2]) {
                odziez = true;
                zaplac.setVisible(true);
                cena.setVisible(true);
            }
        }
    }
    /*zaokraglenie */
    public void dokwoty() {
        kwota = kwota * 100;
        kwota = Math.round(kwota);
        kwota = kwota / 100;
    }

    /*onsluga przyciskow banknotow/monet, w zaleznosci ktory sie kliknie to jest to dodawane do kwoty ktoraa chcemy zaplacic */
    public class IleJeszcze implements ActionListener {

        public void actionPerformed(ActionEvent er) {

            if (er.getSource() == przyciskipieniadz[0]) {
                kwota = kwota + 0.01;
                dokwoty();
            }
            if (er.getSource() == przyciskipieniadz[1]) {
                kwota = kwota + 0.02;
                dokwoty();              
            }
            if (er.getSource() == przyciskipieniadz[2]) {
                kwota = kwota + 0.05;
                dokwoty();             
            }
            if (er.getSource() == przyciskipieniadz[3]) {
                kwota = kwota + 0.1;
                dokwoty();             
            }
            if (er.getSource() == przyciskipieniadz[4]) {
                kwota = kwota + 0.2;
                dokwoty();             
            }
            if (er.getSource() == przyciskipieniadz[5]) {
                kwota = kwota + 0.5;
                dokwoty();             
            }
            if (er.getSource() == przyciskipieniadz[6]) {
                kwota = kwota + 1;
                dokwoty();                
            }
            if (er.getSource() == przyciskipieniadz[7]) {
                kwota = kwota + 2;
                dokwoty();         
            }
            if (er.getSource() == przyciskipieniadz[8]) {
                kwota = kwota + 5;
                dokwoty();          
            }
            if (er.getSource() == przyciskipieniadz[9]) {
                kwota = kwota + 10;
                dokwoty();               
            }
            if (er.getSource() == przyciskipieniadz[10]) {
                kwota = kwota + 20;
                dokwoty();             
            }
            if (er.getSource() == przyciskipieniadz[11]) {
                kwota = kwota + 50;
                dokwoty();            
            }

        }
    }

}
