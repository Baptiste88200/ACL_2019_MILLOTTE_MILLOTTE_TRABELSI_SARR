package model.factory;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageFactory {

    private static ImageIcon sol1 = new ImageIcon("./ressources/img/sol1.jpeg");
    private static ImageIcon sol2 = new ImageIcon("./ressources/img/sol2.jpeg");
    private static ImageIcon sol3 = new ImageIcon("./ressources/img/sol3.jpeg");
    private static ImageIcon mur = new ImageIcon("./ressources/img/mur.jpeg");
    private static ImageIcon caseMagique = new ImageIcon("./ressources/img/caseMagique.jpeg");
    private static ImageIcon piege = new ImageIcon("./ressources/img/piege.jpeg");
    private static ImageIcon passage = new ImageIcon("./ressources/img/passage.jpeg");

    public static Image getSol(int id){
        switch (id){
            case 1:
                return sol1.getImage();
            case 2:
                return sol2.getImage();
            case 3:
                return sol3.getImage();
        }
        return sol1.getImage();
    }

    public static Image getMur(){
        return mur.getImage();
    }

    public static Image getCaseMagique(){
        return caseMagique.getImage();
    }

    public static Image getPiege(){
        return piege.getImage();
    }

    public static Image getPassage(){
        return passage.getImage();
    }

}
