public class Dogs{

	public static void main(String[] args){
		Puppy myPuppy = new Puppy("Wookie");
		myPuppy.setAge(2);
		myPuppy.getAge();
		
		Puppy emptyPuppy = new Puppy();
		emptyPuppy.getAge();
	}

}