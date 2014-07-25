import java.lang.Math;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.List;
import java.util.ArrayList;
import java.lang.Number;

class GaussianDistro {
    
    //The function you want to integrate, this is hardcoded as making an interface is maybe a bit to hard.
    
    private double sigma;
    private double x_avg;
    
    //Default constructor, using the normalized Gaussian distro;
    GaussianDistro(){
	sigma = 1.0;
	x_avg = 0.0;
    }
    
    GaussianDistro(double x_avg,double sigma){
	this.x_avg = x_avg;
	this.sigma = sigma;
    }

    double getValue(double x){
	return 1/( Math.sqrt(2*Math.PI) * sigma) * Math.exp( -1* (x - x_avg)*(x - x_avg) / (2*sigma*sigma) );
    }

}

class Integrator implements Callable<Double> {
    private double xi;   //Initial value for x (lower bound)
    private double xf;   //Upper value for x (upper bound)
    private double dx;   //Stepsize, doing just Riemann integral
    private int nsteps;
    private GaussianDistro f;

    // I can make it later such that I include a wide variaty of preset functions, and then just loop over all those classes and do 
    //if( f instanceof FunctionClass):
    //     f = (FunctionClass)f; (cast to FunctionClass)

    Integrator(GaussianDistro f, double xi, double xf, double dx){
	this.f = f;
	this.xi = xi;
	this.xf = xf;
	this.dx = dx;
	nsteps = (int)((xf - xi) / dx);
    }
    
    public Double call(){
	System.out.println("Creating the thread with the integral from " + xi + " to " + xf);
	System.out.println("Stepsize is " + dx + " which leads to n = " + nsteps + " steps");
	double integral = 0.0;
	for(int i = 0; i < nsteps; i++){
	    //Good enough for now, could improve by 1/2 (f(x) + f(x+dx))
	    integral+=f.getValue(xi+i*dx)*dx;
	}
	
	return integral;
    }
}


public class IntegralTest {

    public static void main(String[] args){
	//Arguments are the number of threads, x_avg, sigma, xi, xf, dx.
	int nThreads = new Integer(args[0]);
	double x_avg = new Double(args[1]);
	double sigma = new Double(args[2]);
	double xi = new Double(args[3]);
	double xf = new Double(args[4]);
	double dx = new Double(args[5]);
    
	System.out.println("The function to integrate is a Gaussian distribution with <x> = " + x_avg + " and sigma = " + sigma);
	System.out.println("The integral runs from " + xi + " to " + xf + " with a stepsize of dx = " +dx);
    
	GaussianDistro gauss = new GaussianDistro(x_avg,sigma);

	//Now we need to calculate in how many pieces we must cut the integral:

	double widthIntervals = (xf - xi) / (double)nThreads; //double cast just to be sure
	
	ExecutorService service = Executors.newFixedThreadPool(nThreads);
	List<Future<Double>> listThreads = new ArrayList<Future<Double>>();

	for(int i = 0; i < nThreads; i++){
	    listThreads.add(service.submit(new Integrator(gauss,xi+i*widthIntervals, xi+(i+1)*widthIntervals, dx)));
	}

	double integral = 0.0;
	
	System.out.println("Now starting the integration process using " + nThreads + " threads.");
	
	for(Future<Double> future : listThreads){
	    try{
		integral+=future.get();
	    }
	    catch (InterruptedException e){
		System.out.println("Thread is interrupted, dumping stack trace");
		e.printStackTrace();
	    }
	    catch (ExecutionException e){
		System.out.println("Thread failed to execute, dumping stack trace");
		e.printStackTrace();
	    }
	}

	System.out.println("The result of this integration is: " + integral);
	service.shutdown();
    }
}
	
	    
