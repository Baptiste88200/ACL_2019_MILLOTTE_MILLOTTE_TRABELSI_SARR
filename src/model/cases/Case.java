package model.cases;

import java.awt.*;

public interface Case {

    public boolean estTraversable();

    public void afficher(Graphics2D g, int x, int y);

}
