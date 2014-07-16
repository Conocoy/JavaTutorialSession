public class SingletonDemo {

	public static void main(String[] args){
		Singleton s1 = Singleton.getInstance();
		s1.demoMethod();
		s1.printName();
		s1.editName("blaat!");
		s1.printName();
		
		System.out.println("Making a second Singleton instance if possible");
		Singleton s2 = Singleton.getInstance();
		s2.printName();
		
		System.out.println(s1);
		System.out.println(s2);
		
		//Should return the same 'memory' adres, althoug in Java memory adres has no meaning I just read somewhere...
	}
}