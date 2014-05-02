/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

import Snd.MyGraphics;

/**
 * Käyttöliittymässä näkyvä ajastin luokka
 * @author Lutikka
 */
public class VisibleCountdownTimer extends CountdownTimer{
    
    /**
     * ajastimen x koordinaatti ruudulla
     */
    private float x;
    /**
     * ajastimen y koordinaatti ruudulla
     */
    private float y;
    /**
     * ajastimen piirtämiseen käytettävä instanssi luokasta MyGraphics
     */
    static MyGraphics graphics;
        
    
    /**
     * Konstruktori
     * @param secs sekunteja
     * @param x x koordinaatti
     * @param y y koordinaatti
     */
    public VisibleCountdownTimer(int secs, float x, float y) {
        super(secs);
        this.x=x;
        this.y=y;
    }

    /**
     * Konstruktori
     * @param msecs sekunteja
     * @param x x koordinaatti
     * @param y y koordinaatti
     */
    public VisibleCountdownTimer(long msecs, float x, float y) {
        super(msecs);
        this.x=x;
        this.y=y;
    }
    
    /**
     * Asettaa piirtämiseen käytettävän grafiikka luokan
     */
    public static final void setGraphics(MyGraphics graphics){
         VisibleCountdownTimer.graphics=graphics;
    }
    
    /**
     * piirtää ajastimen ruudulle
     */
    public void draw(){
        graphics.drawString(x, y, toString());
    }
    
}
