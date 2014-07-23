import java.util.*;
import java.lang.*;

class ArrayListTest{

    public static void main(String[] args){
	
	ArrayList al = new ArrayList();

	System.out.println("Contents of al: " + al);

	String[] str = {"A","B","C"};
	
	for(String s : str){
	    al.add(s);
	}
	
	System.out.println("Contents of al: " + al);
	al.add(1);
	al.add(5.123);
	al.add(0xA4);
	System.out.println("Contents of al: " + al);
    
	
	Iterator it = al.iterator();
	while(it.hasNext()){

	    Object element = it.next();
	    
	    System.out.print("Content of ArrayList al: " + element);
	    if(element instanceof String){
		System.out.println(" is a String instance");
	    }
	    if(element instanceof Integer){
		System.out.println(" is a int instance");
	    }
	    if(element instanceof Double){
		System.out.println(" is a double instance");
	    }
	    if(element instanceof Float){
		System.out.println(" is a float instance");
	    }
	    if(element instanceof Byte){
		System.out.println(" is a byte instance");
	    }
	    if(element instanceof Character){
		System.out.println(" is a char instance");
	    }

	}
	
    }

}
