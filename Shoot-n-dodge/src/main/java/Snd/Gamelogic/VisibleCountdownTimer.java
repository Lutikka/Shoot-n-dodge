/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

import Snd.MyGraphics;

/**
 *
 * @author Lutikka
 */
public class VisibleCountdownTimer extends CountdownTimer{

    private float x;
    private float y;
    private static MyGraphics graphics;
        
    
    
    public VisibleCountdownTimer(int secs, float x, float y) {
        super(secs);
        this.x=x;
        this.y=y;
    }

    public VisibleCountdownTimer(long msecs, float x, float y) {
        super(msecs);
        this.x=x;
        this.y=y;
    }
    
    public static final void setGraphics(MyGraphics graphics){
         VisibleCountdownTimer.graphics=graphics;
    }
    
    public void draw(){
        graphics.drawString(x, y, toString());
    }
    
}
