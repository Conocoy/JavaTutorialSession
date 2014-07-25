import java.lang.Math;

class FunctionA {
    private final double x;
    private final double s;
    
    FunctionA(double x,double s){
	this.x = x;
	this.s = s;
    }

    double getValue(double x0){
	return 1 / (Math.sqrt(2*Math.PI)*s) * Math.exp(-1 * (x0-x)*(x0-x) / (2*s*s));
    }

}

public class SmallReturnTest {
    public static void main(String[] args){
	
	FunctionA a = new FunctionA(0.0,1.0); //normalizes gauss
	
	for(double i = 0.0; i < 1.0; i+=0.1){
	    System.out.println("Gauss( x = " + i + " ) = " + a.getValue(i));
	}
    }
}
