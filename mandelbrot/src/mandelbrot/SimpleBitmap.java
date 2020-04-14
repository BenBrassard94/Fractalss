package mandelbrot;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.JPanel;

/**
 *
 * @author bj.brassard
 */
public class SimpleBitmap extends JPanel {

    private static final int MAP_WIDTH = 512;
    private static final int MAP_HEIGHT = 512;
    private BufferedImage image;

    public SimpleBitmap() {

        int w = MAP_WIDTH;
        int h = MAP_HEIGHT;
        int imageType = BufferedImage.TYPE_INT_RGB;
        this.image = new BufferedImage(w, h, imageType);

    } // SimpleBitmap()

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int w = this.getWidth();
        int h = this.getHeight();

        AffineTransform scale = new AffineTransform();
        scale.setToScale(((double) w) / MAP_WIDTH, ((double) h)
                / MAP_HEIGHT);

        WritableRaster raster = this.image.getRaster();

        int[] b1 = {0, 0, 150};
        int[] b2 = {0, 0, 250};
        
        double xMin = 0;
        double xMax = MAP_WIDTH - 1;
        double yMin = 0;
        double yMax = MAP_HEIGHT - 1;
        
        double uMin = -2.0;
        double uMax = 2.0;
        double vMin = -2.0;
        double vMax = 2.0;
        
        for(int row = 0; row < MAP_HEIGHT; row++){
            double y = row;
            for(int column = 0; column < MAP_WIDTH; column++){
                double x = column;
                
                double u = uMin +(uMax - uMin) * (x - xMin)/(xMax - xMin);
                double v = vMin +(vMax - vMin) * (y - yMin)/(yMax - yMin);
                
                Complex c0 = new Complex(0.0, 0.0);
                Complex c1 = new Complex(u, v);
                
                int count = 0;
                
                while(c0.magnitudeSquared() < 4.0 && count < 64){
                    c0 = c0.prod(c0);
                    c0 = c0.add(c1);
                    count++;
                    
                } // while
                
                if(count == 64){
                    raster.setPixel(row, column, b2);
                } // if
                else {
                    raster.setPixel(row, column, b1);
                } // else
            } // for
        } // for
        g2d.drawImage(image, scale, this);

    } // paintComponent(Graphics)

} // SimpleBitmap
