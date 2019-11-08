package model;

import engine.Cmd;
import engine.GameController;

import java.awt.event.KeyEvent;


public class HeroController
        implements GameController {
    private Cmd commandeEnCours = Cmd.IDLE;


    public Cmd getCommand() {
        return this.commandeEnCours;
    }


    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        switch (e.getKeyCode()) {
            case 40:
            case 83:
                this.commandeEnCours = Cmd.DOWN;
                break;
            case 38:
            case 90:
                this.commandeEnCours = Cmd.UP;
                break;
            case 39:
            case 68:
                this.commandeEnCours = Cmd.RIGHT;
                break;
            case 37:
            case 81:
                this.commandeEnCours = Cmd.LEFT;
                break;
            case 10:
                this.commandeEnCours = Cmd.ENTREE;
                break;
        }
    }


    public void keyReleased(KeyEvent e) {
        this.commandeEnCours = Cmd.IDLE;
    }

    public void keyTyped(KeyEvent e) {
    }
}


/* Location:              /home/mobis/Bureau/ACL_2019_MILLOTTE_MILLOTTE_TRABELSI_SARR/!/model/HeroController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.1
 */