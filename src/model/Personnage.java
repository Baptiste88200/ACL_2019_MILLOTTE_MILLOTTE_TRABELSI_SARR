
package model;

public interface Personnage {
    boolean enVie();

    int getScore();

    int getX();

    int getY();

    void attaquer(model.Personnage personnage);

    void subirDegat();
}