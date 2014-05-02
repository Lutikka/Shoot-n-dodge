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
    /**
     * arvo seinien x koordinaateille pelissä
     */
    private float floatMaxX;
    
    /**
     * arvo seinien y koordinaateille pelissä
     */
    private float floatMaxY;
    
    /**
     * Konstruktori
     * 
     * @param floatMaxX Pelinsisäinen maksimi ikkunan koko x
     * @param floatMaxY Pelinsisäinen maksimi ikkunan koko y
     */
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
    /**
     * Tarkistaa kaikki Projectilen ja pelin seinien väliset kollisiot
     * 
     * @param p Tarkistettava projektiili
     * @return tmp palauttaa boolean tauluko kollisioista. True arvo tarkoittaa 
     * että kollisio tapahtui.
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
    
     /**
     * Tarkistaa kaikki Shipin ja pelin seinien väliset kollisiot
     * 
     * @param s Tarkistettava Ship
     * @return tmp palauttaa boolean tauluko kollisioista. True arvo tarkoittaa 
     * että kollisio tapahtui.
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
    /**
     *
     * @param x X koordinaatti
     * @return totuusarvo kollisiosta.
     * Arvo True tarkoittaa että kollisio tapahtui.
     */
    public boolean checkLeftWallCollision(float x){
        if(x<0)
            return true;
        
        return false;
    }
    
    /**
     *
     * @param y Y koordinaatti
     * @return totuusarvo kollisiosta.
     * Arvo True tarkoittaa että kollisio tapahtui.
     */
    public boolean checkUpWallCollision(float y){
        return checkLeftWallCollision(y);
    }
    /**
     *
     * @param x X koordinaatti
     * @return totuusarvo kollisiosta.
     * Arvo True tarkoittaa että kollisio tapahtui.
     */
    public boolean checkRightWallCollision(float x){
        if(x>floatMaxX)
            return true;
        return false;
    }
    /**
     *
     * @param y Y koordinaatti
     * @return totuusarvo kollisiosta.
     * Arvo True tarkoittaa että kollisio tapahtui.
     */
    public boolean checkDownWallCollision(float y){
        if(y>floatMaxY)
            return true;
        return false;
    }
    
   
    
    /**
     * Ei käytössä.
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkShipToShipCollisions(Ship s1, Ship s2){
        
        //TODO
        
        return false;
    }
    
    /**
     * Tarkistaa Projectilen ja Shipin väliset kollisiot
     * @param p Projectile p
     * @param s Ship s
     * @return
     */
    public boolean checkProjectileToShipCollisions(Projectile p, Ship s){
       if(p.getPos().getX()>(s.getPos().getX()-(s.getSize().getWidth()/2)))
       if(p.getPos().getX()<(s.getPos().getX()+(s.getSize().getWidth()/2))) 
       if(p.getPos().getY()>(s.getPos().getY()-(s.getSize().getHeight()/2)))    
       if(p.getPos().getY()<(s.getPos().getY()+(s.getSize().getHeight()/2)))    
           return true;
        return false;
    }

    /**
     *
     * @return floatMaxX
     */
    public float getFloatMaxX() {
        return floatMaxX;
    }

    /**
     *
     * @return floatMaxY
     */
    public float getFloatMaxY() {
        return floatMaxY;
    }
    
    
}
