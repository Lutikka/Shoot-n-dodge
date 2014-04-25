package Snd;

import Snd.Gamelogic.Position;
import Snd.Gamelogic.Size;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 * Luokkaa käytetään pelin grafiikka käyttöliittymän piirtämiseen
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
    private Canvas canvas;

    /**
     * Konstruktoi luokan ja initialisoi kaiken tarpeellisen
     *
     * @param title Ikkunassa näkyvä nimi
     * @param windowWidth Ikkunan leveys
     * @param windowHeight Ikkunan korkeus
     */
    public MyGraphics(String title, int windowWidth, int windowHeight) {
        super(title);
        this.windowHeight= windowHeight;
        this.windowWidth= windowWidth;
        super.setIgnoreRepaint(true);
        this.setSize(windowWidth, windowHeight);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        
        canvas = new Canvas();
        canvas.setIgnoreRepaint(true);
        canvas.setSize(windowWidth, windowHeight);       

        this.add(canvas);
        super.pack();
        
        canvas.setFocusable(true);
        canvas.enableInputMethods(true);
               
        this.setVisible(true);
        
        
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

    /**
     * Kutsutaan ennen jokaisen kuvan piirtoa
     */
    public void drawingStart() {
        g2d = bi.createGraphics();
        drawBackground();
    }

    /**
     * Kutsutaan kun kuvan piirtäminen on suoritettu.
     * Näyttää piirretyn kuvan
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

    /**
     * piirtää perus taustavärin
     */
    private void drawBackground() {
        Color c = g2d.getColor();
        g2d.setColor(background);
        g2d.fillRect(0, 0, windowWidth, windowHeight);
        g2d.setColor(c);
    }

    /**
     * Piirtää laation paikkaan Position pos kokoa Size size värillä Color c.
     * 
     * Huom peli käyttää float arvoja käyttöliittymä integerejä
     * 
     * @param pos pelinsisäinen positio
     * @param size pelinsisäinen laatikon koko
     * @param c väri
     */
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
    
    /**
     * Piirtää laation käyttäen käyttöliittymän koordinaattijärjestelmää
     * 
     * @param x X koordinaatti
     * @param y Y koordinaatti
     * @param width Laatikon leveys
     * @param height Laatikon korkeus
     * @param c Laatikon väri
     */
    public void drawRect(int x, int y, int width, int height, Color c){
        g2d.setColor(c);
        g2d.drawRect(x, y, width, height);
    }
    
    /**
     * Piirtää tekstiä 
     * @param x
     * @param y
     * @param text 
     */
    public void drawString(float x, float y, String text){
        int i = Math.round((x * windowWidth) / xMax);
        int j = Math.round((y * windowHeight) / yMax);
        int halfWidth= text.length()*3;
        int halfHeight= 4;
        g2d.setFont(new Font(Font.DIALOG,Font.PLAIN,10));
        g2d.setColor(Color.RED);
        g2d.drawString(text, i-halfWidth, j-halfHeight);
      }
    /**
     * Kääntää käyttöliittymän koordinaatit pelinsisäisiksi
     * 
     * @param x
     * @param y
     * @return float taulukko jossa float[0] on x koordinaatti ja 
     * float[1] y koordinaatti.
     */
    public float[] translateToInGameCoordinates(int x, int y){
        float i = (x*xMax)/windowWidth;
        float j = (y*yMax)/windowHeight;
        return new float[]{i,j};
    }
   
    /**
     * Asettaa maksimi ikkuna koon pelinsisäisellä koordinaattijärjestelmällä.
     * Tarvitaan pelin piirtämiseen ja koordinaatti käännöksiin.
     * Tulee asettaa ennen pelin piirtämistä
     * 
     * @param xMax Maksimi x koko
     * @param yMax Maksimi y koko
     */
    public void setInGameCoordinateMaxs(float xMax, float yMax) {
        this.yMax = yMax;
        this.xMax = xMax;
    }
    
  
    
    public Canvas getCanvas(){
        return canvas;
    }
}
