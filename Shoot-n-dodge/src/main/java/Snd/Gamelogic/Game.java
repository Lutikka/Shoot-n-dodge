/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

import Snd.Gamelogic.GameObjects.MovingObject;
import Snd.Gamelogic.GameObjects.Projectile;
import Snd.Gamelogic.GameObjects.Ship;
import Snd.MyGraphics;

/**
 * Kapseloi pelilogiikan
 * @author Lutikka
 */
public class Game {
    
    private ObjectHolder objects;
    private AI ai;
    private Control ctrl;
    private float boundX;
    private float boundY;
    
    /**
     *
     * @param graphics pelin piirtämiseen käytettävä grafiikka
     */
    public Game(MyGraphics graphics){
        boundX=1f;
        boundY=1f;
        objects = new ObjectHolder();
        graphics.setInGameCoordinateMaxs(boundX, boundY);
        MovingObject.setGraphics(graphics);
        Ship.setOh(objects);
        ctrl = new Control(this,graphics);
        ai= new AI(ctrl);
    }
   
    /**
     *
     * @return palauttaa pelin kontrolloimiseen käytettävän luokan
     */
    public Control getCtrl() {
        return ctrl;
    }
    
    /**
     * Päivittää pelin
     */
    public void update(){
        ai.update();
        objects.update();
    }
    /**
     * Piirtää pelin 
     */
    public void draw(){
        objects.draw();
        
    }

    /**
     *
     * @return
     */
    public ObjectHolder getObjects() {
        return objects;
    }

    public float getBoundX() {
        return boundX;
    }

    public float getBoundY() {
        return boundY;
    }
    
}
