package model;

import java.awt.*;

public class Sprite {

    private int direction;
    private int i;
    private Image[][] sprites;

    public Sprite(Image b1, Image b2, Image h1, Image h2, Image g1, Image g2, Image d1, Image d2){
        direction = Constantes.DROITE;
        i = 1;
        sprites = new Image[][]{{b1,b2},{h1,h2},{g1,g2},{d1,d2}};
    }

    public Image getImage(){
        Image img = sprites[direction][i];
        i = 0;
        return img;
    }

    public void setDirection(int dir){
        i = Math.abs(i-1);
        direction = dir;
    }

}
