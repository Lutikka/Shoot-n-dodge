/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic.GameObjects;

import Snd.Gamelogic.Destroyable;
import Snd.Gamelogic.Size;
import Snd.MyGraphics;
import java.awt.Color;

/**
 *
 * Luokka pelissä oleville ammuksille
 * @author Lutikka
 */
public class Projectile extends MovingObject implements Destroyable{
    
    int power;
    private boolean alive;
    private int team;
    

    /**
     *
     * @param x X koordinaatti
     * @param y Y koordinaatti
     * @param dx Nopeusvektorin x suuntainen komponentti
     * @param dy Nopeusvektorin y suuntainen komponentti
     * @param power osumisvoima
     * @param team tiimi
     */
    public Projectile(float x, float y, float dx, float dy, int power, int team) {
        super(x, y, dx, dy);     
        this.power=power;
        this.team=team;
        alive=true;
    }
    

    /**
     *
     * @return
     */
    public int getTeam() {
        return team;
    }

    /**
     *
     * @return
     */
    public int getPower() {
        return power;
    }
    
    /**
     * Piirtää Projectilen
     */
    @Override
    public void draw() {
        if(graphics==null)
            return;
        Color c;
        if(team==0)
            c= Color.GREEN;
        else if(team==1)
            c= Color.RED;
        else c= Color.BLUE;
        
        Size s = new Size(0.005f,0.005f);
        graphics.drawRectangle(super.getPos(), s, c);     
    }

    /**
     *
     */
    @Override
    public void destroy() {
        alive=false;
    }

    /**
     *
     */
    @Override
    public void destroyed() {
        //todo
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isAlive() {
        return alive;
    }

    
    
}
