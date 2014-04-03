/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

import Snd.Gamelogic.GameObjects.Projectile;
import Snd.Gamelogic.GameObjects.Ship;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Pitää sisällään kaikki pelissä olevat objektit
 *
 * @author Lutikka
 */
public class ObjectHolder {

    private ArrayList<Ship> ships;
    private ArrayList<Projectile> projectiles;
    private Check check;

    public ObjectHolder() {
        this.ships = new ArrayList<Ship>();
        this.projectiles = new ArrayList<Projectile>();
        this.check = new Check(1f, 1f);
    }

    public void checkProjectileCollisions() {
        for (Projectile p : projectiles) {
            
            //projectile to wall collisions
            boolean tmp[] = check.checkWallCollisions(p);
            for (int i = 0; i < 4; i++) {
                //mahdollista muuta käyttöä myöhemmin
                if(tmp[i]==true)
                p.destroy();
            }
            
            //projectile to ship collisions
            for (Ship ship : ships) {
                if (check.checkProjectileToShipCollisions(p, ship)) {
                    if(p.getTeam()!=ship.getTeam()){
                    p.destroy();
                    ship.changeHp(-p.getPower());
                    }
                }
            }
        }
    }
    
    public void checkShipCollisions() {
        for (Ship ship : ships) {
            boolean tmp[] = check.checkWallCollisions(ship);
            if(tmp[0]==true){
                ship.getPos().setX(ship.getSize().getWidth()/2);
            }
            if(tmp[1]==true){
                ship.getPos().setY(ship.getSize().getHeight()/2);
            }
            if(tmp[2]==true){
                ship.getPos().setX(check.getFloatMaxX()-((float)ship.getSize().getWidth()/2));
            }
            if(tmp[3]==true){
                ship.getPos().setY(check.getFloatMaxY()-((float)ship.getSize().getWidth()/2));
            }
        }
    }

    public void update() {
        Stack<Projectile> removalStack = new Stack<Projectile>();
        Stack<Ship> removalStack2 = new Stack<Ship>();
        //update ships
        for (Ship ship : ships) {
            ship.update();
            if(!ship.isAlive()){
                removalStack2.add(ship);
            }
        }
        //check ship collisions
        checkShipCollisions();
        
        //update projectiles
        for (Projectile p : projectiles) {
            p.update();
            if(!p.isAlive()){
                removalStack.push(p);
            }
        }
        //check projectile collisions
        checkProjectileCollisions();
        
        //remove destroyed projectiles    
        for (Projectile p : removalStack) {
            p.destroyed();
            projectiles.remove(p);
        } 
        
        //remove destroyed ships
        for (Ship ship : removalStack2) {
            ship.destroyed();
            ships.remove(ship);
        }
    }

    public void draw() {
        //draw ships
        for (Ship ship : ships) {
            ship.draw();
        }

        //draw projectile
        
        for (Projectile p : projectiles) {
            p.draw();
        }
    }

    public void addShip(Ship s) {
        this.ships.add(s);
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public void addProjectile(Projectile p) {
        this.projectiles.add(p);
    }
}
