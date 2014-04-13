/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

import Snd.Gamelogic.GameObjects.Ship;
import Snd.MyGraphics;

/**
 *
 * Luokalla controlloidaan pelin tapahtumia
 * @author Lutikka
 */
public class Control {
    
    private Game game;
    private MyGraphics graphics;
    private Ship playerShip;
    private boolean running;
    
    /**
     * player ship control variables
     */
    private float maxSpeed;
    private boolean shooting;
    private Position target;
    private boolean movingLeft;
    private boolean movingUp;
    private boolean movingRight;
    private boolean movingDown;

    /**
     * Konstruktoi Controllin
     * 
     * @param game kontrolloitava peli
     * @param graphics peli grafiikat
     */
    public Control(Game game, MyGraphics graphics) {
        this.game = game;
        this.graphics = graphics;      
        this.running=false;
        initPlayerVariables();
    }
    
    /**
     * Initialisoi asioita
     */
    private void initPlayerVariables(){
        maxSpeed=0.005f;
        shooting=false;
        movingLeft=false;
        movingRight=false;
        movingUp=false;
        movingDown=false;
    }
    
    /**
     * Päivittää Controllin suorittaen mahdolliset pelaajan toiminnot
     */
    public void update(){
        playerActions();
    }
    
    /**
     * Mahdollisten pelaajan toimintojen läpikäynti ja suoritus
     */
    private void playerActions(){
        if(isRunning()){  
            if(shooting){
            playerShip.shootAt(target, 0.005f, 1);
            shooting=false;
            }
            if(!movingLeft&&!movingRight){
                playerShip.getSpeedVec().setSpeedX(0);
            }
            if(!movingUp&&!movingDown){
                playerShip.getSpeedVec().setSpeedY(0);
            }
            if(movingLeft){
                playerShip.getSpeedVec().setSpeedX(-maxSpeed);             
            }
            if(movingRight){
                playerShip.getSpeedVec().setSpeedX(maxSpeed);               
            }            
            if(movingUp){
                playerShip.getSpeedVec().setSpeedY(-maxSpeed);            
            }
            if(movingDown){
                playerShip.getSpeedVec().setSpeedY(maxSpeed);
            }
        }
    }
    
    /**
     * Pelin aloitus metodi... Käytössä toistaiseksi
     */
    public void start(){
        playerShip= addShip(0.5f,0.8f,0f,0f,1,5,0.04f,0.04f,0);                
        running=true;       
    }
    
    /**
     * 
     * @return Punaisten Shipien määrä
     */
    public int getEnemyShipCount(){
        int count = game.getObjects().getShips().size()-1;
        return count;
    }
    
    /**
     * Lisää peliin Ship objectin
     * 
     * @param x x pos
     * @param y y pos
     * @param dx x speed
     * @param dy y speed
     * @param hp
     * @param maxHp
     * @param width
     * @param height
     * @param team
     * @return 
     */
    public Ship addShip(float x, float y, float dx, float dy,int hp, int maxHp,float width, float height,int team){
        Ship s = new Ship(x,y,dx,dy,hp,maxHp,width,height,team);
        game.getObjects().addShip(s);
        return s;
    }
    
    /**
     * Laittaa pelaajan aluksen ampumaan pisteeseen (x,y).
     * @param x X koordinaatti
     * @param y Y koordinaatti
     */
    public void playerShootAt(float x, float y){
        if(isRunning()){          
            shooting=true;
            target = new Position(x,y);
        }
    }
    
    /**
     * Laittaa pelaajan aluksen ampumaan käyttöliittymän koordinaattijärjestelmää
     * käyttäen pisteeseen (x,y).
     * 
     * @param x X koordinaatti
     * @param y Y koordinaatti
     */
    public void playerShootAt(int x, int y){
        if(isRunning()){          
            shooting=true;
            float[] tmp = graphics.translateToInGameCoordinates(x, y);
            target = new Position(tmp[0],tmp[1]);
        }
    }
    
    /**
     * Metodi pelaajan liikuttamiseen vasemmalle
     */
    public void playerMoveLeft(){
        if(isRunning()){
            movingRight=false;
            movingLeft=true;
        }   
    }
    
    /**
     *Metodi pelaajan liikuttamiseen ylös
     */
    public void playerMoveUp(){
        if(isRunning()){
            movingDown=false;
            movingUp=true;
        }   
    }
    
    /**
     *Metodi pelaajan liikuttamiseen oikealle
     */
    public void playerMoveRight(){
        if(isRunning()){
            movingLeft=false;
            movingRight=true;
        }   
    }
    
    /**
     *Metodi pelaajan liikuttamiseen alas
     */
    public void playerMoveDown(){
        if(isRunning()){
            movingUp=false;
            movingDown=true;
        }   
    }
    /**
     *Metodi pelaajan liikuttamiseen vasen
     */
    public void playerStopMoveLeft(){
        if(isRunning()){         
            movingLeft=false;
        }   
    }
    
    /**
     *Metodi pelaajan liikuttamiseen ylös
     */
    public void playerStopMoveUp(){
        if(isRunning()){
            movingUp=false;
        }   
    }
    
    /**
     *Metodi pelaajan liikuttamiseen oikealle
     */
    public void playerStopMoveRight(){
        if(isRunning()){
            movingRight=false;
        }   
    }
    
    /**
     *Metodi pelaajan liikuttamiseen alas
     */
    public void playerStopMoveDown(){
        if(isRunning()){        
            movingDown=false;
        }   
    }

    /**
     *
     * @return
     */
    public boolean isRunning() {
        return running;
    }

    /**
     *
     * @return
     */
    public Ship getPlayerShip() {
        return playerShip;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Game getGame() {
        return game;
    }

    
   
    
    
}
