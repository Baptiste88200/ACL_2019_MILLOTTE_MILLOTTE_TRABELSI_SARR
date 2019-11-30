package model.factory;

import model.Sprite;

import javax.swing.*;
import java.awt.*;

public class ImageFactory {

    private static ImageIcon sol1 = new ImageIcon("./ressources/img/sol1.jpeg");
    private static ImageIcon sol2 = new ImageIcon("./ressources/img/sol2.jpeg");
    private static ImageIcon sol3 = new ImageIcon("./ressources/img/sol3.jpeg");
    private static ImageIcon mur = new ImageIcon("./ressources/img/mur.jpeg");
    private static ImageIcon caseMagique = new ImageIcon("./ressources/img/caseMagique.jpeg");
    private static ImageIcon piege = new ImageIcon("./ressources/img/piege.jpeg");
    private static ImageIcon passage = new ImageIcon("./ressources/img/passage.jpeg");


    private static ImageIcon hero = new ImageIcon("./ressources/img/hero.png");


    public static Image getSol(int id) {
        switch (id) {
            case 1:
                return sol1.getImage();
            case 2:
                return sol2.getImage();
            case 3:
                return sol3.getImage();
        }
        return sol1.getImage();
    }

    public static Image getMur() {
        return mur.getImage();
    }

    public static Image getCaseMagique() {
        return caseMagique.getImage();
    }

    public static Image getPiege() {
        return piege.getImage();
    }

    public static Image getPassage() {
        return passage.getImage();
    }

    public static Image getHero() {
        return passage.getImage();
    }

    public static Sprite getSpriteHero(){
        return new Sprite(
                new ImageIcon("./ressources/img/hero/hero-b1.png").getImage(),
                new ImageIcon("./ressources/img/hero/hero-b2.png").getImage(),
                new ImageIcon("./ressources/img/hero/hero-h1.png").getImage(),
                new ImageIcon("./ressources/img/hero/hero-h2.png").getImage(),
                new ImageIcon("./ressources/img/hero/hero-g1.png").getImage(),
                new ImageIcon("./ressources/img/hero/hero-g2.png").getImage(),
                new ImageIcon("./ressources/img/hero/hero-d1.png").getImage(),
                new ImageIcon("./ressources/img/hero/hero-d2.png").getImage());
    }

    public static Sprite getSpriteMonstre1(){
        return new Sprite(
                new ImageIcon("./ressources/img/monstre1/monstre1-b1.png").getImage(),
                new ImageIcon("./ressources/img/monstre1/monstre1-b2.png").getImage(),
                new ImageIcon("./ressources/img/monstre1/monstre1-h1.png").getImage(),
                new ImageIcon("./ressources/img/monstre1/monstre1-h2.png").getImage(),
                new ImageIcon("./ressources/img/monstre1/monstre1-g1.png").getImage(),
                new ImageIcon("./ressources/img/monstre1/monstre1-g2.png").getImage(),
                new ImageIcon("./ressources/img/monstre1/monstre1-d1.png").getImage(),
                new ImageIcon("./ressources/img/monstre1/monstre1-d2.png").getImage());
    }




}
