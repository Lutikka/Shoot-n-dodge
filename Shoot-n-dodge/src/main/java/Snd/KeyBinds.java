package Snd;

import Snd.Gamelogic.Control;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Luokka joka liittää napit ja painikkeet tapahtumiksi pelissä
 * @author Lutikka
 */
public class KeyBinds {

    /*
     * Game luokasta saatu Control luokka.
     * Käytetään tapahtumien aikaansaamiseksi
     */
    private Control c;

    /**
     *
     * @param c Game luokasta saatu Control luokka.
     *
     */
    public KeyBinds(Control c) {
        this.c = c;
    }

    /**
     * suorittaa KeyEventiin ja EventTypeen liittyvän toiminnon
     * 
     * @param ke KeyEvent
     * @param et EventType
     *
     */
    public void KeyEvent(KeyEvent ke, int et) {
        int key = ke.getKeyCode();
        if (key == KeyEvent.VK_W) {
            if (et == Input.PRESSED) {
                c.playerMoveUp();
            } 
        } else if (key == KeyEvent.VK_S) {
            if (et == Input.PRESSED) {
                c.playerMoveDown();
            } 
        } else if (key == KeyEvent.VK_A) {
            if (et == Input.PRESSED) {
                c.playerMoveLeft();
            } 
        } else if (key == KeyEvent.VK_D) {
            if (et == Input.PRESSED) {                
                c.playerMoveRight();
            } 
        }

    }

    /**
     * suorittaa MouseEventiin ja EventTypeen liittyvän toiminnon
     * 
     * @param me
     * @param et
     */
    public void MouseEvent(MouseEvent me, int et) {
        int x;
        int y;
        x = me.getX();
        y = me.getY();
        int button = me.getButton();
        if (button == MouseEvent.BUTTON1) {
            if (et == Input.PRESSED) {
                c.playerShootAt(x, y);
            }
        }
    }
}
