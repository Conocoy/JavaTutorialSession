public class TestStrings{

	public static void main(String args[]){
		String s1 = "This is really not immutable!!";
		String s2 = s1;
		String s3 = "This is really not immutable!!";
		String s4 = "This is really not immutable";
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s4));
		System.out.println(s1.equals(s4+"!!"));
	}
}