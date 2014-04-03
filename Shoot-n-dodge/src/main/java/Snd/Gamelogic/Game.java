/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

import Snd.MyGraphics;

/**
 * Kapseloi pelilogiikan
 * @author Lutikka
 */
public class Game {
    
    private ObjectHolder objects;
    private AI ai;
    private Control ctrl;
    
    public Game(MyGraphics graphics){
        objects = new ObjectHolder();
        graphics.setInGameCoordinateMaxs(1f, 1f);
        ctrl = new Control(this, graphics);
        ai= new AI(ctrl);
    }
   
    public Control getCtrl() {
        return ctrl;
    }
    
    public void update(){
        ai.update();
        objects.update();
    }
    public void draw(){
        objects.draw();
        
    }

    public ObjectHolder getObjects() {
        return objects;
    }
    
}
