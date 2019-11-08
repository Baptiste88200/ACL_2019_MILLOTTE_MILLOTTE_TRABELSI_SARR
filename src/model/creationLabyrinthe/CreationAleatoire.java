package model.creationLabyrinthe;

import model.cases.Case;
import model.cases.Mur;
import model.cases.Sol;

public class CreationAleatoire
        implements CreationLabyrinthe {
    public Case[][] creerLabyrinthe(int largeur, int hauteur) {
        
        Case[][] labyrinthe = new Case[largeur][hauteur];
        
        boolean[][] tab = new boolean[largeur][hauteur];

        
        int k = 0, max = largeur * hauteur * 3, x = 0, y = hauteur / 2;
        
        tab[x][y] = true;
        
        while (k < max) {
            
            int rand = (int) (Math.random() * 4.0D);
            
            switch (rand) {
                case 0:
                    
                    x++;
                    break;
                case 1:
                    
                    x--;
                    break;
                case 2:
                    
                    y++;
                    break;
                case 3:
                    
                    y--;
                    break;
            }
            
            x = Math.max(0, x);
            
            x = Math.min(largeur - 1, x);
            
            y = Math.max(0, y);
            
            y = Math.min(hauteur - 1, y);
            
            tab[x][y] = true;
            
            k++;
        }

        
        for (int i = 0; i < largeur; i++) {
            
            for (int j = 0; j < hauteur; j++) {
                
                if (tab[i][j]) {
                    
                    labyrinthe[i][j] = (Case) new Sol();
                } else {
                    
                    labyrinthe[i][j] = (Case) new Mur();
                }
            }
        }

        
        return labyrinthe;
    }
}


/* Location:              /home/mobis/Bureau/ACL_2019_MILLOTTE_MILLOTTE_TRABELSI_SARR/!/model/creationLabyrinthe/CreationAleatoire.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.1
 */