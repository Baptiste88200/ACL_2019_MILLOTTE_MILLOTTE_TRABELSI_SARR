package model;

public interface Personnage {

    void teleporterAleatoirement();

    void subirDegat(int degat);

    void attaquer(Personnage p);

    int getX();

    int getY();

    boolean enVie();

}
