public class CheckClasses {
    public static void main(String[] args){
	try{
	    Class.forName(args[0]);
	    System.out.println(String.format("Class %s exists", args[0]));
	}
	catch (Exception e){
	    System.out.println(String.format("Class %s does not exist!", args[0]));
	}
    }
}
	      
