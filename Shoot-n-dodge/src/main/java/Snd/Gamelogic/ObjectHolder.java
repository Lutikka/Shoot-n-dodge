/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

import java.util.ArrayList;

/**
 *
 * @author Lutikka
 */
public class ObjectHolder {

    ArrayList<Ship> ships; 
    
    public ObjectHolder() {
        ships = new ArrayList<Ship>();
    }
    
    public void update(){
        for (Ship ship : ships) {
            ship.update();
        }
    }
    
    public void draw(){
        for (Ship ship : ships) {
            ship.draw();
        }
    }
    
    public void addShip(Ship s){
        ships.add(s);
    }
}
