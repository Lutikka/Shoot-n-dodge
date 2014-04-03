/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic.GameObjects;

import Snd.Gamelogic.Destroyable;
import Snd.Gamelogic.ObjectHolder;
import Snd.Gamelogic.Position;
import Snd.Gamelogic.Size;
import Snd.Gamelogic.SpeedVector;
import Snd.MyGraphics;
import java.awt.Color;

/**
 *
 * @author Lutikka
 */
public class Ship extends MovingObject implements Destroyable {

    private boolean alive;
    private int hp;
    private int maxHp;
    private Size size;
    private int team;
    static ObjectHolder oh;
    static MyGraphics graphics;

    public Ship(float x, float y, float dx, float dy, int hp, int maxHp, float width, float height, ObjectHolder oh, MyGraphics graphics, int team) {
        super(x, y, dx, dy);
        this.team = team;
        this.oh = oh;
        this.graphics = graphics;
        this.size = new Size(width, height);
        this.hp = hp;
        this.maxHp = maxHp;
        this.alive = true;
    }

    public void shoot(SpeedVector speedVec, int power) {
        float x = getPos().getX();
        float y = getPos().getY();
        float speedX = speedVec.getSpeedX();
        float speedY = speedVec.getSpeedY();
        Projectile p = new Projectile(x, y, speedX, speedY, power, graphics, team);
        oh.addProjectile(p);
    }

    /*
     * Käytetään kun halutaan ampua tiettyä pistettä(pos) kohti vektorin pituudella speed
     */        
    public void shootAt(Position pos, float speed, int power) {
        SpeedVector s = new SpeedVector(getPos(), pos, speed);
        float x = getPos().getX();
        float y = getPos().getY();
        Projectile p = new Projectile(x, y, s.getSpeedX(), s.getSpeedY(), power,graphics, team);
        oh.addProjectile(p);
    }

    public int getTeam() {
        return team;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }
    /*
     * Use negative values for subtraction
     */

    public void changeHp(int hp) {
        this.hp += hp;
        if (this.hp > maxHp) {
            this.hp = maxHp;
        }
        if (this.hp <= 0) {
            destroy();
        }

    }
    /*
     * To be overrided
     */

    @Override
    public void destroyed() {
    }
    
    /*
     * Called when this ship is to be removed from game
     */
    @Override
    public void destroy() {
        alive = false;
    }

    @Override
    public void update() {
        super.update();

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
        graphics.drawRectangle(super.getPos(), size, c);     
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public Size getSize() {
        return size;
    }
}
