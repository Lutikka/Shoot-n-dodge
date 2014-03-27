/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

import Snd.Gamelogic.Updateable;

/**
 * Pitää sisällään tiedon Objektin positiosta pelissä
 * @author Lutikka
 */
public class Position implements Updateable {

    private float x;
    private float y;
    private SpeedVector speedVec;

    public Position(float x, float y, SpeedVector speedVec) {
        this.x = x;
        this.y = y;
        this.speedVec = speedVec;
    }
    
    public Position(float x, float y) {
        this.x = x;
        this.y = y;
        this.speedVec = null;
    }

    @Override
    public void update() {
        if(speedVec!=null){
        setX(this.x + speedVec.getSpeedX());
        setY(this.y + speedVec.getSpeedY());
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setPos(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public SpeedVector getSpeedVec() {
        return speedVec;
    }
    
}
