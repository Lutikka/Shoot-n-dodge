/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

/**
 * 
 * @author Lutikka
 */
public class Game {
    
    private ObjectHolder objects;
    
    public Game(){
        objects = new ObjectHolder();
    }
    
    public void update(){
        objects.update();
    }
    public void draw(){
        objects.draw();
        
    }
}
