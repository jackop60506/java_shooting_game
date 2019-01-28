 
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
 
public class Graphics2DDemo09 extends JPanel {
	 BufferedImage img;
    public static void main(String[] args) {
        Frame frame = new Frame("AWTDemo");
        frame.addWindowListener(new AdapterDemo());
        frame.setSize(200, 200);
         
        Graphics2DDemo09 canvas = new Graphics2DDemo09();
        frame.add(canvas, BorderLayout.CENTER);
         
        frame.setVisible(true);
    }
     
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	AffineTransform at = new AffineTransform();

        // 4. translate it to the center of the component
        at.translate(100, 50);

        // 3. do the actual rotation
        //at.rotate(Math.PI/3);

        // 2. just a scale because this image is big
        at.scale(0.5, 0.5);

        // 1. translate the object so that you rotate it around the 
        //    center (easier :))
        at.translate(-100, -50);

        // draw the image
        Graphics2D g2d = (Graphics2D) g;
       
        try{
        	img =ImageIO.read(new File("D:/java_p/MyFinalP/pic/plane1.png"));
        }catch(Exception e){
        	
        }
        
        		g2d.drawImage(img, at, null);
        		g.drawRect(0, 0, 100, 100);

    }   
   
}
 
class AdapterDemo extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}