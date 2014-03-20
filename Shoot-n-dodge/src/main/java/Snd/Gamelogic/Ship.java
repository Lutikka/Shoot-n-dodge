/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;



/**
 *
 * @author Lutikka
 */
public abstract class Ship extends MovingObject implements Destroyable{
    private boolean alive;
    private int hp;
    private int maxHp;
  
    public Ship(float x,float y, float dx, float dy, int hp, int maxHp) {
        super(x,y,dx,dy);     
        this.hp=hp;
        this.maxHp=maxHp;
        this.alive=true;
    }
    
    @Override
    public boolean isAlive(){
        return alive;
    }
    /*
     * Use negative values for subtraction
     */
    @Override
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

    @Override
    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public int getHp() {
        return hp;
    }
}
