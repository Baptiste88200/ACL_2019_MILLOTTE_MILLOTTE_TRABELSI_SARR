package model.menu;

import engine.Cmd;
import engine.GameController;

import java.awt.event.KeyEvent;

public class MenuController implements GameController {
    private Cmd cmd;

    public MenuController() {
        this.cmd = Cmd.IDLE;


    }

    @Override
    public Cmd getCommand() {
        return cmd;
    }

    public void setCommand(Cmd cmd) {
        this.cmd = cmd;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE)
            cmd = Cmd.ECHAP;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        cmd = Cmd.IDLE;
    }
}
