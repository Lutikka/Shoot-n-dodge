/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

/**
 *
 * @author Lutikka
 */
public class AI{
    
    private Control ctrl;

    public AI(Control ctrl) {
        this.ctrl = ctrl;
    }
    
    public void update(){
        ctrl.update();
    }
    
    
    
}
