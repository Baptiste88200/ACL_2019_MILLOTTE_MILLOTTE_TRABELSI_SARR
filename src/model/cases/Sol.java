package model.cases;

import model.Constantes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Sol
        implements SpecialCase {
       private int type = -1;


    private boolean traversable = true;


    
    public void setTraversable(boolean traversable) {
        this.traversable = traversable;
    }


    
    public boolean estTraversable() {
        return this.traversable;
    }


    public void afficher(Graphics2D g, int x, int y) {
        
        URL url = null;
        
        switch (this.type) {

            case 10:
                
                url = getClass().getResource("/img/tresor.jpeg");
                break;
            case 11:
                
                url = getClass().getResource("/img/magique.jpeg");
                break;
            case 12:
                
                g.setColor(Constantes.PIEGE_COLOR);
                break;
            case 13:
                
                g.setColor(Constantes.PASSAGE_COLOR);
                break;
            default:
                
                g.setColor(Color.WHITE);
                break;
        }
        
        if (url == null) {
            
            g.fillRect(x * 40, y * 40, 40, 40);
            
            g.setColor(Color.BLACK);
            
            g.drawRect(x * 40, y * 40, 40, 40);
        } else {
            
            int i = x * 40;
            
            int j = y * 40;
            try {
                
                g.drawImage(ImageIO.read(url), i, j, 40, 40, null);
                
            } catch (IOException e) {
                
                e.printStackTrace();
            }
        }
    }


    
    public void setType(int type) {
        this.type = type;
    }
}


/* Location:              /home/mobis/Bureau/ACL_2019_MILLOTTE_MILLOTTE_TRABELSI_SARR/!/model/cases/Sol.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.1
 */