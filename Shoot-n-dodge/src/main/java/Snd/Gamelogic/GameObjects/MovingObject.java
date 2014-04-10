/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic.GameObjects;

import Snd.Gamelogic.SpeedVector;
import Snd.Gamelogic.Position;
import Snd.Gamelogic.Drawable;
import Snd.Gamelogic.Updateable;
import Snd.MyGraphics;

/**
 *
 * All in-game objects that move have this class as their super class.
 * Kaikilla pelinsisäisillä objecteilla, jotka liikkuvat,
 * on tämä luokka yliluokkanaan  
 * 
 * @author Lutikka
 */
public class MovingObject implements Updateable, Drawable {
    
     private Position pos; 
     private SpeedVector speedVec;
     /**
     * Objectin piirtämiseen
     */
    public static MyGraphics graphics;

    /**
     * Konstruktori
     * 
     * @param x X koordinaatti
     * @param y Y koordinaatti
     * @param dx Nopeusvektorin x suuntainen komponentti
     * @param dy Nopeusvektorin y suuntainen komponentti
     */
    public MovingObject(float x, float y, float dx, float dy) {
        this.speedVec = new SpeedVector(dx,dy);
        this.pos= new Position(x,y, speedVec);
        
    }
    

    /**
     * Asettaa staatisen grafiikka luokan kaikille MovingObjecteille.
     * Tämä tulee asettaa ennen MovingObjectin piirtämistä
     * @param graphics
     */
    public final static void setGraphics(MyGraphics graphics) {
        MovingObject.graphics = graphics;
    }

    /**
     * Overraidattava metodi. Piirtää objectin
     */
    @Override
    public void draw() {
       //
    }

    /**
     *
     */
    @Override
    public void update() {
       pos.update();
    }

    /**
     *
     * @return
     */
    public Position getPos() {
        return pos;
    }

    /**
     *
     * @return
     */
    public SpeedVector getSpeedVec() {
        return speedVec;
    }
    
     
     
}
