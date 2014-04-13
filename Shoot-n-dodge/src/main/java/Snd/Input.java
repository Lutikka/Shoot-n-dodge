package Snd;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

/**
 * Luokka kuuntelee JFramesta tulevia InputEventejä ja laittaa ne talteen
 * odottamaan seuraavaa handleInput() kutsua, jolloin InputEvent:eistä seuraavat 
 * peliloogiset tapahtumat käsitellään käyttäen KeyBinds luokkaa
 * 
 * @author Lutikka
 */
public class Input implements KeyListener, MouseListener {

    
    /**
     *Globaali enumit
     */
    public static final int PRESSED = 1;
    public static final int RELEASED = 2;
    public static final int TYPED = 3;
    public static final int CLICKED = 3;
    public static final int ENTERED = 4;
    public static final int EXITED = 5;
    
    /*
     * Kaikki InputEventit lisätään tähän listaan odottamaan käsittelyä   * 
     */
    private volatile LinkedList<InputEvent> eList = new LinkedList<InputEvent>();
    
    /*
     * Input tyypi lisätään tähän samanaikaisesti InputEventin kanssa
     */
    private volatile LinkedList<Integer> eTypeList = new LinkedList<Integer>();
    /**
     * Syötteen käsittelyyn tarvittava instanssi KeyBinds luokasta
     */
    private KeyBinds kb;

    /**
     * 
     * @param kb KeyBinds luokka
     */
    public Input(KeyBinds kb) {
        this.kb=kb;
    }

    /**
     * Poistaa tähän mennessä kasaantuneen käsittelemättömän syötteen
     */
    public void DiscardInput(){
       eList = new LinkedList<InputEvent>();
       eTypeList = new LinkedList<Integer>();
    }

    /*
     * Handles all input using keybinds since last call
     */
    /**
     * Käsittelee kaikki InputEventit käyttäen KeyBinds luokkaa
     * syöte --> toiminto vuorovaikutuksen aikaansaamiseksi
     */
    public  void HandleInput() {
        System.out.println(eList.size());
        while (!eList.isEmpty()) {
            InputEvent ie = eList.poll();
            int et = eTypeList.poll();
            if (KeyEvent.class.isAssignableFrom(ie.getClass())) {
                KeyEvent ke = (KeyEvent) ie;
                HandleKeyEvent(ke, et);
            } else if (MouseEvent.class.isAssignableFrom(ie.getClass())) {
                MouseEvent me = (MouseEvent) ie;
                HandleMouseEvent(me, et);
            }
        }
    }

    private void HandleMouseEvent(MouseEvent me, int et) {
        kb.MouseEvent(me, et);
    }

    private void HandleKeyEvent(KeyEvent ke, int et) {
        kb.KeyEvent(ke, et);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        eList.addLast(e);
        eTypeList.addLast(PRESSED);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        eList.addLast(e);
        eTypeList.addLast(RELEASED);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        eList.addLast(e);
        eTypeList.addLast(TYPED);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("yeaa");
        eList.addLast(e);
        eTypeList.addLast(CLICKED);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        eList.addLast(e);
        eTypeList.addLast(ENTERED);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        eList.addLast(e);
        eTypeList.addLast(EXITED);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("aasdasd");
        eList.addLast(e);
        eTypeList.addLast(PRESSED);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        eList.addLast(e);
        eTypeList.addLast(RELEASED);
    }
}
