/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

import Snd.Gamelogic.GameObjects.Projectile;
import Snd.Gamelogic.GameObjects.Ship;

/**
 *
 * Käytetään pelin sisäisten tarkistuksien tekemiseen
 * @author Lutikka
 */
public final class Check {
    private float floatMaxX;
    private float floatMaxY;
    
    public Check(float floatMaxX, float floatMaxY) {
        this.floatMaxX = floatMaxX;
        this.floatMaxY = floatMaxY;
    }
    
    /*
     * returns array of booleans. @value true indicates that a collision did happen 
     * against the corresponding wall
     * @0 left wall
     * @1 upper wall
     * @2 right wall
     * @3 down wall
     */
    public boolean[] checkWallCollisions(Projectile p){
        boolean[] tmp = new boolean[4];
        for (boolean b : tmp) {
            b=false;
        }
        tmp[0] = checkLeftWallCollision(p.getPos().getX());
        tmp[1] = checkUpWallCollision(p.getPos().getY());
        tmp[2] = checkRightWallCollision(p.getPos().getX());
        tmp[3] = checkDownWallCollision(p.getPos().getY());
               
       return tmp;
    }
    /*
     * returns array of booleans. value of true indicates that a collision did happen 
     * against the corresponding wall
     * @0 left wall
     * @1 upper wall
     * @2 right wall
     * @3 down wall
     */
     public boolean[] checkWallCollisions(Ship s){
        boolean[] tmp = new boolean[4];
         for (boolean b : tmp) {
             b=false;
         }
        tmp[0] = checkLeftWallCollision(s.getPos().getX()-(s.getSize().getWidth()/2));
        tmp[1] = checkUpWallCollision(s.getPos().getY()-(s.getSize().getHeight()/2));
        tmp[2] = checkRightWallCollision(s.getPos().getX()+(s.getSize().getWidth()/2));
        tmp[3] = checkDownWallCollision(s.getPos().getY()+(s.getSize().getHeight()/2));
               
        return tmp;
    }
    public boolean checkLeftWallCollision(float x){
        if(x<0)
            return true;
        
        return false;
    }
    
    public boolean checkUpWallCollision(float y){
        if(y<0)
            return true;
        
        return false;
    }
    public boolean checkRightWallCollision(float x){
        if(x>floatMaxX)
            return true;
        return false;
    }
    public boolean checkDownWallCollision(float y){
        if(y>floatMaxY)
            return true;
        return false;
    }
    
   
    
    public boolean checkShipToShipCollisions(Ship s1, Ship s2){
        
        //TODO
        
        return false;
    }
    
    public boolean checkProjectileToShipCollisions(Projectile p, Ship s){
       if(p.getPos().getX()>(s.getPos().getX()-(s.getSize().getWidth()/2)))
       if(p.getPos().getX()<(s.getPos().getX()+(s.getSize().getWidth()/2))) 
       if(p.getPos().getY()>(s.getPos().getY()-(s.getSize().getHeight()/2)))    
       if(p.getPos().getY()<(s.getPos().getY()+(s.getSize().getHeight()/2)))    
           return true;
        return false;
    }

    public float getFloatMaxX() {
        return floatMaxX;
    }

    public float getFloatMaxY() {
        return floatMaxY;
    }
    
    
}
