/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

import java.util.Timer;

/**
 * Pelin tekoäly/ohjaus
 * @author Lutikka
 */
public class AI{
    
    /**
     * pelin kontrolli luokka
     */
    private Control ctrl;
    /**
     * kuinka paljon seuraavalla kerralla tehdään aluksia
     */
    private int nextSpawnAmount;
    /**
     * aluksia viime tarkistuksella
     */
    private int lastCount;
    /**
     * näkyvä ajastin jäljellä olevasta peli ajasta
     */
    private VisibleCountdownTimer timer;
    /**
     * Konstruktori
     * @param ctrl Control
     */
    public AI(Control ctrl) {
        this.ctrl = ctrl;
        
    }
    
    /**
     * Piirtää timerin yms.
     */
    public void draw(){
        if(timer!=null)
        timer.draw();
        
    }
    
    /**
     * Tarkistaa onko peli päättynyt
     */
    public void checkEndConditions(){
        if(!ctrl.getPlayerShip().isAlive())
            ctrl.setRunning(false);
        if(timer.getTimer()<0)
            ctrl.setRunning(false);
    }
    
    /**
     * Aloittaa uuden pelin
     */
    public void start(){
            ctrl.getGame().getObjects().removeAllObjects();
            ctrl.start();
            timer = new VisibleCountdownTimer(40,0.5f,0.5f);
            ctrl.addShip(0.5f,0.2f,0.0000f,0.000f,1,5,0.10f,0.10f,1);
            nextSpawnAmount=2;
            lastCount=1;
    }
    
    /**
     * Päivittää AI:n
     */
    public void update(){
        if(!ctrl.isRunning()){
            start();
        }
        checkEndConditions();
        
        if(ctrl.isRunning()){
            timer.addMillis((lastCount-ctrl.getEnemyShipCount())*500);
            lastCount=ctrl.getEnemyShipCount();
            if(ctrl.getEnemyShipCount()==0){               
                for (int i = 0; i < nextSpawnAmount; i++) {
                    spawnShipRandomly();
                }
                lastCount=nextSpawnAmount;
                nextSpawnAmount=nextSpawnAmount*2;             
            }
            timer.update();
        }
        ctrl.update();
    }
    
    /**
     * Luo vihollis aluksen satunnaiseen paikkaan pelialueella
     */
    public void spawnShipRandomly(){
        float x = (float)Math.random();
        float y = (float)Math.random();
        ctrl.addShip(x,y,0.0000f,0.000f,1,5,0.02f,0.02f,1);
    }
    
    
}
