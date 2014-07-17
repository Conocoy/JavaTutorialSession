public class Puppy{

	int puppyAge = 0;
	String name = "NoName";

	public Puppy(){
	}
	
	public Puppy(String name){
		System.out.println("Passed Name is: " + name );
	}

	public void setAge(int age){
		puppyAge = age;
	}
	
	public int getAge(){
		System.out.println("Puppy's age is: " + puppyAge);
		return puppyAge;
	}
	
	public static void main(String[] args){
		Puppy myPuppy = new Puppy("Wookie");
		myPuppy.setAge(2);
		myPuppy.getAge();
		
		Puppy emptyPuppy = new Puppy();
		emptyPuppy.getAge();
	}


}