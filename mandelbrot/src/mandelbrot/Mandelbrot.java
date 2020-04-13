
package mandelbrot;

import javax.swing.JFrame;

public class Mandelbrot extends JFrame{
    private static final int S_WIDTH = 512;
    private static final int S_HEIGHT = 512;
    private static final String S_TITLE = "Simple";
    
    public Mandelbrot(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(S_WIDTH, S_HEIGHT);
        this.setTitle(S_TITLE);
        
        SimpleBitmap panel = new SimpleBitmap();
        pane.add(panel);
        
        this.setVisible(true);
        
    } // Mandelbrot()

    public static void main(String[] args) {
        Mandelbrot simple = new Mandelbrot();
    } // main(String[])
    
} // Mandelbrot
