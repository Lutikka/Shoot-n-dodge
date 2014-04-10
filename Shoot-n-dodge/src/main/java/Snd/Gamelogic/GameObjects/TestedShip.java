/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic.GameObjects;

import Snd.Gamelogic.ObjectHolder;
import Snd.MyGraphics;

/**
 * Used for jUnit test
 * @author Lutikka
 */
public class TestedShip extends Ship{

    /**
     *
     * @param x
     * @param y
     * @param dx
     * @param dy
     * @param hp
     * @param maxHp
     * @param width
     * @param height
     * @param team
     */
    public TestedShip(float x, float y, float dx, float dy, int hp, int maxHp, float width, float height, int team){           
        super(x, y, dx, dy, hp, maxHp, width, height, team);
    }
    
    
}
