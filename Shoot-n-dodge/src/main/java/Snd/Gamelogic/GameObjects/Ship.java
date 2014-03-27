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



/**
 * 
 * @author Lutikka
 */
public abstract class Ship extends MovingObject implements Destroyable{
    private boolean alive;
    private int hp;
    private int maxHp;
    private Size size;
    private int team;
    static ObjectHolder oh;
  
    public Ship(float x,float y, float dx, float dy, int hp, int maxHp, float width, float height, ObjectHolder oh, int team) {
        super(x,y,dx,dy); 
        this.team=team;
        this.oh=oh;
        this.size = new Size(width,height);
        this.hp=hp;
        this.maxHp=maxHp;
        this.alive=true;
    }
    
    
    public void shoot(SpeedVector speedVec, int power){
        Projectile p = new Projectile(getPos().getX(),getPos().getY(),speedVec.getSpeedX(),speedVec.getSpeedY(),power,team);
        oh.addProjectile(p);
    }
    
    public void shootAt(Position pos, float speed, int power){
        SpeedVector s = new SpeedVector(getPos(),pos, speed);
        Projectile p = new Projectile(getPos().getX(),getPos().getY(),s.getSpeedX(),s.getSpeedY(), power, team);
        oh.addProjectile(p);
    }
    
    

    public int getTeam() {
        return team;
    }
    @Override
    public boolean isAlive(){
        return alive;
    }
    /*
     * Use negative values for subtraction
     */
    
    public void changeHp(int hp){
       this.hp+=hp;
       if(this.hp>maxHp)
           this.hp=maxHp;
       if(this.hp<=0)
           destroy();
       
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
    public void destroy(){
        alive=false;
    }
    

    @Override
    public void update() {
       super.update();
       
    }
    
    @Override
    public void draw(){
        //TODO
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
