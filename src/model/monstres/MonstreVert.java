package model.monstres;

import model.Labyrinthe;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;


public class MonstreVert
        extends Monstre {
    
    public MonstreVert(int x, int y, Labyrinthe labyrinthe) {
        super(x, y, labyrinthe);
    }


    public void afficher(Graphics2D g) {
        
        URL url = getClass().getResource("/img/monstre.jpg");
        
        System.out.println(url);
        
        int i = this.x * 40;
        
        int j = this.y * 40;
        try {
            
            g.drawImage(ImageIO.read(url), i, j, 40, 40, null);
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}


/* Location:              /home/mobis/Bureau/ACL_2019_MILLOTTE_MILLOTTE_TRABELSI_SARR/!/model/monstres/MonstreVert.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.1
 */