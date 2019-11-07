package model;

import model.monstres.Monstre;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Hero implements Personnage{

    private int x,y;
    private int score;
    private enum DIRECTION{HAUT,BAS,GAUCHE,DROITE};
    private DIRECTION d;

    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
        d=DIRECTION.DROITE;
    }

    public void afficher(Graphics2D g){
        g.setColor(Color.RED);
        //g.fillOval(x*Constantes.tailleCase, y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
        g.setFont(new Font("TimesRoman", Font.BOLD+Font.ITALIC, 13));
        g.drawString("Score:"+score+" Tresor:"+0+" magique :"+0, 10, 15);
        URL url=getClass().getResource("/"+Constantes.IMAGE_HERO_D);
        switch (d){
            case GAUCHE:
                url=getClass().getResource("/"+Constantes.IMAGE_HERO_G);
                break;
            case DROITE:
                url=getClass().getResource("/"+Constantes.IMAGE_HERO_D);
                break;
            case HAUT:
                url=getClass().getResource("/"+Constantes.IMAGE_HERO_H);
                break;
            case BAS:
                url=getClass().getResource("/"+Constantes.IMAGE_HERO_B);
                break;

        }
            int i=x*Constantes.tailleCase;
            int j=y*Constantes.tailleCase;
        try {
            g.drawImage(ImageIO.read(url),i,j ,Constantes.tailleCase,Constantes.tailleCase,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void move(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public void deplacerGauche(){
        x--;
        d=DIRECTION.GAUCHE;
    }

    public void deplacerDroite(){
        x++;
        d=DIRECTION.DROITE;
    }

    public void deplacerHaut(){
        y--;
        d=DIRECTION.HAUT;
    }

    public void deplacerBas(){
        y++;
        d=DIRECTION.BAS;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public int getScore()
    {
        return score;
    }
    @Override
    public void attaquer(Personnage monstre)
    {
        int [][]tab=new int[][]{
                {0,0},
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };
        //les monstres est dans une case adj
        for(int[] c:tab) {
            if (getX() + c[0] == monstre.getX() && getY() + c[1] == getY()) {
                monstre.subirDegat();
                break;
            }
        }
        if (monstre.getX() == x && monstre.getY() == y)
            subirDegat();

    }
    @Override
    public void subirDegat()
    {
        score--;
    }

    @Override
    public boolean enVie() {
        return score>0;
    }




}
