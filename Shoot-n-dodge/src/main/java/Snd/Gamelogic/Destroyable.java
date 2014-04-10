/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

/**
 *
 * @author Lutikka
 */
public interface Destroyable {
    
    /**
     *
     */
    public void destroyed();
    /**
     *
     * @return
     */
    public boolean isAlive();
    /**
     *
     */
    public void destroy();
}
