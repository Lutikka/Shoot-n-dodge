/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

import java.util.ArrayList;

/**
 * Pitää sisällään kaikki pelissä olevat objektit
 * @author Lutikka
 */
public class ObjectHolder {

    private ArrayList<Ship> ships; 
    
    public ObjectHolder() {
        this.ships = new ArrayList<Ship>();
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
        this.ships.add(s);
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }
    
    
}
