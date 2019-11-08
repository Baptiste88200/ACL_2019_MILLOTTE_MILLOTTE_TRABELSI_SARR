package model.cases;

import java.awt.*;

public interface SpecialCase extends Case {
    void setType(int paramInt);

    void afficher(Graphics2D paramGraphics2D, int paramInt1, int paramInt2);
}
