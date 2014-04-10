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

    /**
     * Konstruktoi luokan
     */
    public ObjectHolder() {
        this.ships = new ArrayList<Ship>();
        this.projectiles = new ArrayList<Projectile>();
        this.check = new Check(1f, 1f);
    }

    /**
     * Metodi Projectile kollisioiden tarkistamiseen
     * @see Check.checkWallCollisions(Projectile)
     * @see Check.checkProjectileToShipCollisions(Projectile, Ship)
     */
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
    
    /**
     * Metodi Ship kollisioiden tarkistamiseen
     * @see Check.checkWallCollisions(Ship)
     */
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

    /**
     * Päivittää pelin tarkistaen kollisiot ja poistaen tuhoutuneen Shipit ja Projectilet
     */
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

    /**
     * Piirtää pelin
     */
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

    /**
     * lisää Shipin peliin
     * @param s Ship
     */
    public void addShip(Ship s) {
        this.ships.add(s);
    }

    /**
     *
     * @return
     */
    public ArrayList<Ship> getShips() {
        return ships;
    }

    /**
     *
     * @return
     */
    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    /**
     * Lisää Projectilen peliin
     * @param p Projectile
     */
    public void addProjectile(Projectile p) {
        this.projectiles.add(p);
    }
}
