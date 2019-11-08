package model.cases;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;


public class Mur
        implements Case {
    
    public boolean estTraversable() {
        return false;
    }


    public void afficher(Graphics2D g, int x, int y) {
        
        URL url = getClass().getResource("/img/mur.jpeg");
        
        int i = x * 40;
        
        int j = y * 40;
        try {
            
            g.drawImage(ImageIO.read(url), i, j, 40, 40, null);
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}

