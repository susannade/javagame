//komentarz adama 
package gramain;

import javax.swing.JFrame;

/*ustawienie frame */ 
public class GraMain extends JFrame {
  
    public static JFrame f;
    static int gameWidth=1024;
    static int gameHeight=798;
  
    GraMain() {
       super();
        f = new JFrame("BuyItYourself");
        f.setVisible(true);
        f.setSize(gameWidth, gameHeight);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new ImagePanel("images/tlo.png"));    
        f.setResizable(false);

    } 
    
    public static void main(String[] args) {
        GraMain og = new GraMain();     
    }
    
}