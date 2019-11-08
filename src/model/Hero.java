package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Hero
        implements Personnage {
    private int x;
    private int y;
    private int score;
    private DIRECTION d;

    private enum DIRECTION {
        HAUT, BAS, GAUCHE, DROITE;
    }

    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
        this.d = DIRECTION.DROITE;
        System.out.println("Direction " + this.d.toString());
    }

    public void afficher(Graphics2D g) {
        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", 3, 13));
        g.drawString("Score:" + this.score + " Tresor:" + Character.MIN_VALUE + " magique :" + Character.MIN_VALUE, 10, 15);
        URL url = getClass().getResource("/img/heroDROITE.png");
        switch (this.d) {
            case GAUCHE:
                url = getClass().getResource("/img/heuroGAUCHE.png");
                break;
            case DROITE:
                url = getClass().getResource("/img/heroDROITE.png");
                break;
            case HAUT:
                url = getClass().getResource("/img/heroHAUT.png");
                break;
            case BAS:
                url = getClass().getResource("/img/heroBAS.png");
                break;
        }

        int i = this.x * 40;
        int j = this.y * 40;
        try {
            g.drawImage(ImageIO.read(url), i, j, 40, 40, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void deplacerGauche() {
        this.x--;
        this.d = DIRECTION.GAUCHE;
    }

    public void deplacerDroite() {
        this.x++;
        this.d = DIRECTION.DROITE;
    }

    public void deplacerHaut() {
        this.y--;
        this.d = DIRECTION.HAUT;
    }

    public void deplacerBas() {
        this.y++;
        this.d = DIRECTION.BAS;
    }


    public int getX() {
        return this.x;
    }


    public int getY() {
        return this.y;
    }


    public int getScore() {
        return this.score;
    }


    public void attaquer(Personnage monstre) {
        int[][] tab = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};


        for (int[] c : tab) {
            if (getX() + c[0] == monstre.getX() && getY() + c[1] == getY()) {
                monstre.subirDegat();
                break;
            }
        }
        if (monstre.getX() == this.x && monstre.getY() == this.y) {
            subirDegat();
        }
    }


    public void subirDegat() {
        this.score--;
    }


    public boolean enVie() {
        return (this.score > 0);
    }
}


/* Location:              /home/mobis/Bureau/ACL_2019_MILLOTTE_MILLOTTE_TRABELSI_SARR/!/model/Hero.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.1
 */