public class Singleton {

	public static String name = "default";

	// This method is used in example 1, example 2 has a somewhat nicer method
	// private static Singleton singleton = new Singleton();

	private static Singleton singleton = null;
	
	//Private constructor prevents any other instantiation
	private Singleton(){}
	
	public static Singleton getInstance(){
		if(singleton == null){
			singleton = new Singleton();
		}
		return singleton;
	}
			
	protected static void demoMethod(){
		System.out.println("demoMethod for singleton class");
	}

	protected static void printName(){
		System.out.println(name);
	}
	
	protected static void editName(String newname){
		name = newname;
	}
	
}