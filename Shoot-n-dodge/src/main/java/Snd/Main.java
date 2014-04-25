/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd;

import Snd.Gamelogic.Game;
import java.awt.Component;

/**
 * Luokka pitää sisällään kaikki peliin liittyvät komponentit ja hoitaa
 * peliloopin pyörittämisen.
 * @author Lutikka
 */
public class Main {
    
    /**
     * Sisältää tiedon pelin suoritustilasta
     */
    private boolean running;
    /**
     * Suoritettava peli/pelilogiikka
     */
    private Game game;
    /**
     * grafiikan ja ikkunan luomiseen
     */
    private MyGraphics graphics;
    /**
     * syötteen saamiseen ja sen eteenpäin lähettämiseen
     */
    private Input input;
    /**
     * Tästä peli initialisoidaan ja käynnistetään
     * @param args
     */
    public static void main(String[] args) {
        Main m = new Main(); //purkka?
        m.init();
        m.start();
    }
    
    /**
     * Initialisoi tarvittavat komponentit
     */
    public void init(){
        //init Main
        running=true;
        //init Graphics
        graphics = new MyGraphics("Shoot-n-Dodge",800,600);
        //init Gamelogic
        game = new Game(graphics);  
        //init Inputss
        KeyBinds kb= new KeyBinds(game.getCtrl());
        input = new Input(kb);
        graphics.getCanvas().addMouseListener(input);
        graphics.getCanvas().addKeyListener(input);
        
        }
              
    /**
     * hoitaa syötteen käsittelyn ja pelin tilan päivittämisen
     */
    private void update(){
        input.HandleInput();
        game.update();
    }
    
    /**
     * hoitaa pelin piirtämisen MyGraphics:in tarjoamaan ikkunaan
     */
    private void draw(){
        graphics.drawingStart();
        game.draw();
        graphics.drawingEnd();     
    }
    

    /**
     * 
     * @return peli
     */
    public Game getGame() {
        return game;
    }

    /**
     *
     * @return totuusarvo siitä pyöriikö peli
     */
    public boolean isRunning() {
        return running;
    }
    /**
     * Aloittaa pääpeliloopin pyörittämisen
     */
    public void start(){
        
        //poistaa kertyneen turhan inputin
        input.DiscardInput();
        while(running){
            
            
            update();       
            draw();
        
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                
            }
        }
    }
    
}
