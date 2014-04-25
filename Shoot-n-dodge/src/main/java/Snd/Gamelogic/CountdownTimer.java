/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

/**
 *
 * @author Lutikka
 */
public class CountdownTimer {
    
    /**
     * time left
     */
    public long timer;
    /**
     * System time at last update
     */
    public long lastUpdate;
    
    public CountdownTimer(int secs){
        timer=secs*1000;
        lastUpdate=System.currentTimeMillis();
    }
    
    public CountdownTimer(long msecs){
        timer=msecs;
        lastUpdate=System.currentTimeMillis();
    }
    public void addMillis(int msecs){
        timer+=msecs;
    }
    
    public void update(){
        long time = lastUpdate;
        lastUpdate = System.currentTimeMillis();
        timer-= lastUpdate-time;
    }

    public long getTimer() {
        return timer;
    }
    @Override
    public String toString() {
        return ""+timer/1000+"."+Math.abs(timer)/100%10;
    }
    
    
    
}
