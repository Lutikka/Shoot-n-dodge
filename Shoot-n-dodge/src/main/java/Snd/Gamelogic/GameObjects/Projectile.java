/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic.GameObjects;

import Snd.Gamelogic.Destroyable;

/**
 *
 * @author Lutikka
 */
public class Projectile extends MovingObject implements Destroyable{
    
    int power;
    private boolean alive;
    private int team;

    public Projectile(float x, float y, float dx, float dy, int power, int team) {
        super(x, y, dx, dy);
        this.power=power;
        alive=true;
    }
    

    public int getTeam() {
        return team;
    }

    public int getPower() {
        return power;
    }

    @Override
    public void destroy() {
        alive=false;
    }

    @Override
    public void destroyed() {
        //todo
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    
    
}
