
package mandelbrot;

/**
 *
 * @author bj.brassard
 */
public class Complex {
    
    private double x;
    private double y;
    
    public Complex(double u, double v){
        x = u;
        y = v;
    } // Complex(double, double)
    
    
    public double real(){
        return x;
    } // real()
    
    public double imag(){
        return y;
    } // imag()
    
    public Complex add(Complex w){
        return new Complex(x+w.real(), y+w.imag());
    } // add(Complex w)
    
    public Complex prod(Complex w){
        return new Complex(x*w.real() - y*w.imag(), 
                x*w.imag() + y*w.real());
    } // prod(Complex w)
    
} // Complex
