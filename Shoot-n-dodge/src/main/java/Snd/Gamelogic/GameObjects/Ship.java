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
 * Alus-peliobjektin luokka
 * @author Lutikka
 */
public class Ship extends MovingObject implements Destroyable {
    
    /**
     * totuusarvo siitä onko alus elossa
     */
    private boolean alive;
    /**
     * osumapisteet
     */
    private int hp;
    /**
     * osumapiste maksimi arvo
     */
    private int maxHp;
    /**
     * aluksen koko
     */
    private Size size;
    /**
     * aluksen tiimi
     */
    private int team;
    /**
     * luokka jossa alukset ja ammukset ovat.
     * Käytetään ammusten luomiseen
     */
    static ObjectHolder oh;

    /**
     * Konstruktori
     * 
     * @param x X koordinaatti
     * @param y Y koordinaatti
     * @param dx Nopeusvektorin x suuntainen komponentti
     * @param dy Nopeusvektorin y suuntainen komponentti
     * @param hp hp
     * @param maxHp maksimi hp
     * @param width leveys
     * @param height korkeus
     * @param team tiimi
     */
    public Ship(float x, float y, float dx, float dy, int hp, int maxHp, float width, float height, int team) {
        super(x, y, dx, dy);
        this.team = team;    
        this.size = new Size(width, height);
        this.hp = hp;
        this.maxHp = maxHp;
        this.alive = true;
    }
    
    /**
     * Asettaa staattisen ObjectHolderin.
     * Tämä tulee asettaa ennen Shipin muiden metodien kutsumista.
     * @param oh ObjectHolder
     */
    public final static void setOh(ObjectHolder oh) {
        Ship.oh = oh;
    }

    /**
     * Ampuu Shipin Positiosta käyttäen Nopeusvektoria speedVec voimalla power
     * 
     * @param speedVec Nopeusvektori ammuksen liikuttamiseen
     * @param power ammuksen voima
     */
    public void shoot(SpeedVector speedVec, int power) {
        float x = getPos().getX();
        float y = getPos().getY();
        float speedX = speedVec.getSpeedX();
        float speedY = speedVec.getSpeedY();
        Projectile p = new Projectile(x, y, speedX, speedY, power, team);
        oh.addProjectile(p);
    }
      
    /**
     * Käytetään kun halutaan ampua tiettyä Position pos kohti vektorin pituudella speed
     *
     * @param pos kohde positio
     * @param speed nopeus
     * @param power voima
     */
    public void shootAt(Position pos, float speed, int power) {
        SpeedVector s = new SpeedVector(getPos(), pos, speed);
        float x = this.getPos().getX();
        float y = this.getPos().getY();
        Projectile p = new Projectile(x, y, s.getSpeedX(), s.getSpeedY(), power, this.getTeam());
        oh.addProjectile(p);
    }

    /**
     * palauttaa aluksen tiimin
     * @return
     */
    public int getTeam() {
        return team;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    /**
     * Muuttaa Shipin hp arvoa int hp verran.
     * Tuhoaa aluksen jos hp menee alle 0.
     *
     * @param hp
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
    
    @Override
    public void destroyed() {
       SpeedVector sv = new SpeedVector(0.002f,0.002f);
       shoot(sv, 1);
       sv = new SpeedVector(0.002f,-0.002f);
       shoot(sv, 1);
       sv = new SpeedVector(-0.002f,-0.002f);
       shoot(sv, 1);
       sv = new SpeedVector(-0.002f,0.002f);
       shoot(sv, 1);
    }
    
    @Override
    public void destroy() {
        alive = false;
    }

    /**
     * päivittää aluksen
     */
    @Override
    public void update() {
        super.update();

    }

    /**
     * piirtää aluksen
     */
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

    /**
     *
     * @return maxHP
     */
    public int getMaxHp() {
        return maxHp;
    }

    /**
     *
     * @return hp
     */
    public int getHp() {
        return hp;
    }

    /**
     *
     * @return size
     */
    public Size getSize() {
        return size;
    }
}
