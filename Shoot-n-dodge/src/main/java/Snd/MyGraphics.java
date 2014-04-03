/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd;

import Snd.Gamelogic.Position;
import Snd.Gamelogic.Size;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 * Luokkaa käytetään pelin grafiikan käyttöliittymän piirtämiseen
 * @author Lutikka
 */
public class MyGraphics extends JFrame {

    private BufferStrategy buffer;
    private BufferedImage bi;
    private Graphics2D g2d;
    private Graphics graphics;
    private Color background;
    private float xMax;
    private float yMax;
    private int windowWidth;
    private int windowHeight;
    

    public MyGraphics(String title, int windowWidth, int windowHeight) {
        super(title);
        this.windowHeight= windowHeight;
        this.windowWidth= windowWidth;
        super.setIgnoreRepaint(true);
        super.setSize(windowWidth, windowHeight);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canvas canvas = new Canvas();
        canvas.setIgnoreRepaint(true);
        canvas.setSize(windowWidth, windowHeight);
        

        super.add(canvas);
        super.pack();
        super.setVisible(true);
        super.setFocusable(true);

        canvas.createBufferStrategy(2);
        buffer = canvas.getBufferStrategy();

        GraphicsEnvironment graphEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice graphDevice = graphEnv.getDefaultScreenDevice();
        GraphicsConfiguration graphConfig = graphDevice.getDefaultConfiguration();

        //off-screen drawing buffer
        bi = graphConfig.createCompatibleImage(windowWidth, windowHeight);

        graphics = null;
        g2d = null;
        background = Color.BLACK;
    }

    /*
     * Called before drawing each frame
     */
    public void drawingStart() {
        g2d = bi.createGraphics();
        drawBackground();
    }

    /*
     * Called after drawing each frame
     */
    public void drawingEnd() {
        graphics = buffer.getDrawGraphics();
        graphics.drawImage(bi, 0, 0, null);

        if (!buffer.contentsLost()) {
            buffer.show();
        }
        if (graphics != null) {
            graphics.dispose();
        }
        if (g2d != null) {
            g2d.dispose();
        }
    }

    private void drawBackground() {
        Color c = g2d.getColor();
        g2d.setColor(background);
        g2d.fillRect(0, 0, windowWidth, windowHeight);
        g2d.setColor(c);
    }

    public void drawRectangle(Position pos, Size size, Color c) {
        int x = Math.round((pos.getX() * windowWidth) / xMax);
        int y = Math.round((pos.getY() * windowHeight) / yMax);
        int sizeX = Math.round((size.getWidth() * windowWidth) / xMax);
        int sizeY = Math.round((size.getHeight() * windowHeight) / yMax);
        Color cr = g2d.getColor();
        g2d.setColor(c);
        g2d.fillRect(x - (sizeX / 2), y - (sizeY / 2), sizeY, sizeY);
        
        g2d.setColor(cr);

    }
    
    public void drawRect(int x, int y, int width, int height, Color c){
        g2d.setColor(c);
        g2d.drawRect(x, y, width, height);
    }

    public void setInGameCoordinateMaxs(float xMax, float yMax) {
        this.yMax = yMax;
        this.xMax = xMax;
    }
}
