/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd;

import Snd.Gamelogic.Game;

/**
 * Luokka pitää sisällään kaikki peliin liittyvät komponentit ja hoitaa
 * peliloopin pyörittämisen.
 * @author Lutikka
 */
public class Main {
    
    private boolean running;
    private Game game;
    private MyGraphics graphics;
    public static void main(String[] args) {
        Main m = new Main(); //purkka?
        m.init();
        m.start();
    }
    
    public void init(){
        //init Main asd
        running=true;
        //init Graphics
        graphics = new MyGraphics("Peli",800,600);
        //init SoundManager
        
        //init Gamelogic
        game = new Game(graphics);
        
    }
    
    private void update(){
        game.update();
    }
    
    private void draw(){
        game.draw();
    }
    

    public Game getGame() {
        return game;
    }

    public boolean isRunning() {
        return running;
    }
    public void start(){
        
        
        while(running){
            
            update();
            
            graphics.drawingStart();
            draw();
            
            graphics.drawingEnd();           
           
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                
            }
        }
    }
    
}
