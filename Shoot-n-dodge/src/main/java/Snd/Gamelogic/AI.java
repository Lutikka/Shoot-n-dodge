/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

/**
 *a
 * @author Lutikka
 */
public class AI{
    
    private Control ctrl;
    private int nextSpawn;
    /**
     *
     * @param ctrl
     */
    public AI(Control ctrl) {
        this.ctrl = ctrl;
    }
    
    /**
     *
     */
    public void update(){
        if(!ctrl.isRunning()){
            ctrl.getGame().getObjects().removeAllObjects();
            ctrl.start();
            ctrl.addShip(0.5f,0.2f,0.0000f,0.000f,1,5,0.10f,0.10f,1);
            nextSpawn=2;
        }
        if(!ctrl.getPlayerShip().isAlive())
            ctrl.setRunning(false);
        
        if(ctrl.isRunning()){
            if(ctrl.getEnemyShipCount()==0){
                for (int i = 0; i < nextSpawn; i++) {
                    spawnShipRandomly();
                }
                nextSpawn=nextSpawn*2;
                System.out.println(nextSpawn);
            }
        }
        ctrl.update();
    }
    
    public void spawnShipRandomly(){
        float x = (float)Math.random();
        float y = (float)Math.random();
        ctrl.addShip(x,y,0.0000f,0.000f,1,5,0.02f,0.02f,1);
    }
    
    
}
