class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;
    
    ThreadDemo(String name){
	threadName = name;
	System.out.println(String.format("Creating thread \"%s\"", threadName));
    }
    
    public void run(){
	System.out.println(String.format("Running thread \"%s\"", threadName));
	try {
	    for(int i = 4; i > 0; i--){
		System.out.println("Thread:" + threadName + ",  " + i);
		Thread.sleep(50);
	    }
	}
	catch (InterruptedException e){
	    System.out.println("Thread " + threadName + " interrupted.");
	}
	System.out.println("Thread " + threadName + " exiting.");
    }
    
    public void start(){
	System.out.println(String.format("Starting thread \"%s\"", threadName));
	if (t == null){
	    t = new Thread(this, threadName);
	    t.start();
	}
    }

}

public class TestThreads {
    public static void main(String args[]){
	ThreadDemo T1 = new ThreadDemo("Thread nummero uno");
	ThreadDemo T2 = new ThreadDemo("Thread nummero dois");
	
	T1.start();
	T2.start();

    }
}
