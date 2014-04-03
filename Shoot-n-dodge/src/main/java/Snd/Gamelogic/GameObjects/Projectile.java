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
    static MyGraphics graphics;

    public Projectile(float x, float y, float dx, float dy, int power, MyGraphics graphics, int team) {
        super(x, y, dx, dy);
        this.graphics = graphics;
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
