package model.cases;

import java.awt.*;

public interface Case {

    boolean estTraversable();

    void afficher(Graphics2D g, int x, int y);

}
