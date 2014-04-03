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
    
    //player ship variables
    private float maxSpeed;
    private boolean shooting;
    private Position target;
    private boolean movingLeft;
    private boolean movingUp;
    private boolean movingRight;
    private boolean movingDown;

    public Control(Game game, MyGraphics graphics) {
        this.game = game;
        this.graphics = graphics;      
        this.running=false;
        initPlayerVariables();
    }
    
    private void initPlayerVariables(){
        maxSpeed=0.001f;
        shooting=false;
        movingLeft=false;
        movingRight=false;
        movingUp=false;
        movingDown=false;
    }
    
    public void update(){
        if(!running){
            start();
        }
        playerActions();
    }
    
    private void playerActions(){
        if(isRunning()){  
            if(shooting){
            playerShip.shootAt(target, 0.050f, 1);
            shooting=false;
            }
            if(movingLeft){
                playerShip.getSpeedVec().setSpeedX(-maxSpeed);
                movingLeft=false;
            }
            if(movingRight){
                playerShip.getSpeedVec().setSpeedX(maxSpeed);
                movingLeft=false;
            }
            if(movingUp){
                playerShip.getSpeedVec().setSpeedY(-maxSpeed);
                movingLeft=false;
            }
            if(movingDown){
                playerShip.getSpeedVec().setSpeedY(maxSpeed);
                movingLeft=false;
            }
        }
    }
    
    public void start(){
        playerShip= new Ship(0.5f,0.8f,0f,0f,1,5,0.04f,0.04f,game.getObjects(),graphics,0);
        game.getObjects().addShip(playerShip);
        //test
        game.getObjects().addShip(new Ship(0.2f,0.2f,0.001f,0.001f,1,5,0.04f,0.04f,game.getObjects(),graphics,1));
        running=true;
        playerShootAt(0.22f,0.2f);
    }
    
    public void playerShootAt(float x, float y){
        if(isRunning()){          
            shooting=true;
            target = new Position(x,y);
        }
    }
    
    public void playerMoveLeft(){
        if(isRunning()){
            movingRight=false;
            movingLeft=true;
        }   
    }
    
    public void playerMoveUp(){
        if(isRunning()){
            movingDown=false;
            movingUp=true;
        }   
    }
    
    public void playerMoveRight(){
        if(isRunning()){
            movingLeft=false;
            movingRight=true;
        }   
    }
    
    public void playerMoveDown(){
        if(isRunning()){
            movingUp=false;
            movingDown=true;
        }   
    }

    public boolean isRunning() {
        return running;
    }

    public Ship getPlayerShip() {
        return playerShip;
    }

    
   
    
    
}
