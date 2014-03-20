/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

/**
 *
 * @author Lutikka
 */
public class MovingObject implements Updateable, Drawable {
    
     private Position pos; 
     private SpeedVector speedVec;

    public MovingObject(float x, float y, float dx, float dy) {
        this.speedVec = new SpeedVector(dx,dy);
        this.pos= new Position(x,y, speedVec);
    }
    
    

    @Override
    public void draw() {
       //
    }

    @Override
    public void update() {
       pos.update();
    }

    public Position getPos() {
        return pos;
    }

    public SpeedVector getSpeedVec() {
        return speedVec;
    }
    
     
     
}
