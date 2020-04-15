package gramain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

/*klasa z poziomem pierwszym*/
public class PoziomPierwszy extends JPanel {

    private Image img2;
    public JLabel label, pokazpunkty;
    public JButton k1, k2, k3, k4, k5, k6, k7, k8, koniec,koniec2;
    public Image jeden, dwa, piec, dziesiec, dwadziescia, piecdziesiat, sto, dwiescie;
    Timer timer;
    int koniecczasu = 20;
    boolean wygrana = false;

    Random kasa = new Random();
    public int pieniadz;
    public double punkty, klikniecia;
    public double wynik;

    /* klasa z poziomem pierwszym */ 
    public PoziomPierwszy(Image img2) {

        this.pieniadz = kasa.nextInt(7); // wylosowanie pierwszej liczby
        this.img2 = img2;
        Dimension size = new Dimension(img2.getWidth(null), img2.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);

        jeden = new ImageIcon("images/1.png").getImage();
        dwa = new ImageIcon("images/2.png").getImage();
        piec = new ImageIcon("images/5.png").getImage();
        dziesiec = new ImageIcon("images/10.png").getImage();
        dwadziescia = new ImageIcon("images/20.png").getImage();
        piecdziesiat = new ImageIcon("images/50.png").getImage();
        sto = new ImageIcon("images/100.png").getImage();
        dwiescie = new ImageIcon("images/200.png").getImage();

        k1 = new JButton();
        k1.setIcon(new ImageIcon("images/1b.png"));
        k1.setContentAreaFilled(false);
        k1.setBounds(20, 580, 150, 80);
        add(k1);
        k2 = new JButton();
        k2.setIcon(new ImageIcon("images/2b.png"));
        k2.setContentAreaFilled(false);
        k2.setBounds(190, 580, 150, 80);
        add(k2);
        k3 = new JButton();
        k3.setIcon(new ImageIcon("images/5b.png"));
        k3.setContentAreaFilled(false);
        k3.setBounds(360, 580, 150, 80);
        add(k3);
        k4 = new JButton();
        k4.setIcon(new ImageIcon("images/10b.png"));
        k4.setContentAreaFilled(false);
        k4.setBounds(530, 580, 150, 80);
        add(k4);
        k5 = new JButton();
        k5.setIcon(new ImageIcon("images/20b.png"));
        k5.setContentAreaFilled(false);
        k5.setBounds(20, 680, 150, 80);
        add(k5);
        k6 = new JButton();
        k6.setIcon(new ImageIcon("images/50b.png"));
        k6.setContentAreaFilled(false);
        k6.setBounds(190, 680, 150, 80);
        add(k6);
        k7 = new JButton();
        k7.setIcon(new ImageIcon("images/100b.png"));
        k7.setContentAreaFilled(false);
        k7.setBounds(360, 680, 150, 80);
        add(k7);
        k8 = new JButton();
        k8.setIcon(new ImageIcon("images/200b.png"));
        k8.setContentAreaFilled(false);
        k8.setBounds(530, 680, 150, 80);
        add(k8); /*buttony z pieniedzmi */
        
        koniec = new JButton();
        koniec.setIcon(new ImageIcon("images/koniec1.png"));
        koniec.setOpaque(false);
        koniec.setContentAreaFilled(false);
        koniec.setBounds(960, 10, 50, 50);
        koniec.setFocusPainted(true);
        koniec.setBorderPainted(false);
        add(koniec);
        koniec.addActionListener(new Koniec());
        
        koniec2 = new JButton();
        koniec2.setIcon(new ImageIcon("images/koniec2.png"));
        koniec2.setOpaque(false);
        koniec2.setContentAreaFilled(false);
        koniec2.setBounds(960, 710, 50, 50);
        koniec2.setFocusPainted(true);
        koniec2.setBorderPainted(false);
        add(koniec2);
        koniec2.addActionListener(new Koniec2());

        k1.addActionListener(new K1());
        k2.addActionListener(new K2());
        k3.addActionListener(new K3());
        k4.addActionListener(new K4());
        k5.addActionListener(new K5());
        k6.addActionListener(new K6());
        k7.addActionListener(new K7());
        k8.addActionListener(new K8());

        label = new JLabel("Jak ci idzie: " + wynik + "%");
        label.setBounds(730, 618, 350, 40);
        label.setFont(new Font("Helvetica", Font.BOLD, 25));
        label.setForeground(Color.black);
        add(label); // statystyka 

        pokazpunkty = new JLabel("Punkty: " + punkty);
        pokazpunkty.setBounds(730, 660, 350, 40);
        pokazpunkty.setFont(new Font("Helvetica", Font.BOLD, 25));
        pokazpunkty.setForeground(Color.black);
        add(pokazpunkty); //zobyte punkty

        JLabel czas = new JLabel();
        add(czas);
        czas.setBounds(730, 702, 350, 40);
        czas.setFont(new Font("Helvetica", Font.BOLD, 25));//wyswietlenie pozzostalego czasu
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                czas.setText("Masz jeszcze: " + koniecczasu--);
                if (koniecczasu == 0) {
                    timer.cancel();
                    wygrana = true;
                }
            }
        }, 0, 1000); /*ustawienie timera na sekund, gdy mija 20 sekund, wygrana jest true i wchodzi if z paintcomponent */
 
    }

    public void paintComponent(Graphics g) {

        g.drawImage(img2, 0, 0, null);
        if (wygrana == true) {
            setVisible(false);
            GraMain.f.getContentPane().add(new Wygransko(new ImageIcon("images/wygransko1.png").getImage(), wynik, punkty));
            repaint();
        }/*gdy timer.cancel zadziala to wyswietlany jest panel z wynikiem */
        if (pieniadz == 0) {
            g.drawImage(jeden, 400, 244, null);
        }
        if (pieniadz == 1) {
            g.drawImage(dwa, 400, 244, null);
        }
        if (pieniadz == 2) {
            g.drawImage(piec, 400, 244, null);
        }
        if (pieniadz == 3) {
            g.drawImage(dziesiec, 400, 244, null);
        }
        if (pieniadz == 4) {
            g.drawImage(dwadziescia, 400, 244, null);
        }
        if (pieniadz == 5) {
            g.drawImage(piecdziesiat, 400, 244, null);
        }
        if (pieniadz == 6) {
            g.drawImage(sto, 400, 244, null);
        }
        if (pieniadz == 7) {
            g.drawImage(dwiescie, 400, 244, null);
        } /*ify ktore wyswietlaja image pieniedzy w zaleznosci od wylosowanej liczby */

    }

    /*liczenie statystyki i ustawienie textu w labelach*/
    public void licz(double x, double y) {

        wynik = (x / y) * 10000;
        wynik = Math.round(wynik);
        wynik = wynik / 100;
        label.setText("Statystyka: " + wynik + "%");
        pokazpunkty.setText("Punkty: " + punkty);

    }
 
    /*koniec gry */
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
    
    /*losowanie nowej liczby, zwiekszenie ilosci punktow, zwiekszenie ilosci klikniec, wywolanie funkcji licz */
    public void poprawnie() {
        System.out.println("Kliknales poprawnie");
        pieniadz = kasa.nextInt(7);
        punkty++;
        klikniecia++;
        repaint();
        licz(punkty, klikniecia);
    }

    /*losowanie nowej liczby, zwiekszenie ilosci klikniec, wywolanie funkcji licz */
    public void niepoprawnie() {
        System.out.println("Kliknales niepoprawnie");
        pieniadz = kasa.nextInt(7);

        klikniecia++;
        repaint();
        licz(punkty, klikniecia);
    }
    
    /*klasy odpowiadajace za klikanie w buttony */
    public class K1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (pieniadz == 0) {
                poprawnie();
            } else {
                niepoprawnie();
            }
        } 
    }/*gdy klikniemy w ten przycisk i pieniadz rownal sie 0, wywolanie 
        funkcji poprawnie, w innym wypadku funkcja nieporpawnie, kolejne przyciski analogicznie */

    public class K2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (pieniadz == 1) {
                poprawnie();
            } else {
                niepoprawnie();
            }
        }
    }

    public class K3 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (pieniadz == 2) {
                poprawnie();
            } else {
                niepoprawnie();
            }
        }
    }

    public class K4 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (pieniadz == 3) {
                poprawnie();
            } else {
                niepoprawnie();
            }
        }
    }

    public class K5 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (pieniadz == 4) {
                poprawnie();
            } else {
                niepoprawnie();
            }
        }
    }

    public class K6 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (pieniadz == 5) {
                poprawnie();
            } else {
                niepoprawnie();
            }
        }
    }

    public class K7 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (pieniadz == 6) {
                poprawnie();
            } else {
                niepoprawnie();
            }
        }
    }

    public class K8 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (pieniadz == 7) {
                poprawnie();
            } else {
                niepoprawnie();
            }
        }
    }

}
