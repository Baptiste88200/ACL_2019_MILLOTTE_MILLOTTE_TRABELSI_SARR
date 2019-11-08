package model.cases;

import java.awt.*;

public interface Case {
    boolean estTraversable();

    void afficher(Graphics2D paramGraphics2D, int paramInt1, int paramInt2);
}
