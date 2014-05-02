/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

/**
 * Ajastin luokka
 * @author Lutikka
 */
public class CountdownTimer {
    
    /**
     * jäljellä oleva aika ajastimessa
     */
    public long timer;
    /**
     * Järjestelmän aika edellisellä päivitys kerralla
     */
    public long lastUpdate;
    
    /**
     * Kostruktori
     * @param secs sekunteja
     */
    public CountdownTimer(int secs){
        timer=secs*1000;
        lastUpdate=System.currentTimeMillis();
    }
    
    /**
     * Konstruktori
     * @param msecs millisekunteja
     */
    public CountdownTimer(long msecs){
        timer=msecs;
        lastUpdate=System.currentTimeMillis();
    }
    
    /**
     * lisää ajastimee annetun määrän millisekunteja
     * @param msecs millisekunteja
     */
    public void addMillis(int msecs){
        timer+=msecs;
    }
    
    /*
     * Päivittää ajastimen
     */
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
