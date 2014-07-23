import java.util.*;
import java.lang.*;

public class VectorTest{

    public static void main(String[] args){
	
	Vector v1 = new Vector(10);
	
	String[] stringArray = {"a","b","c"};
	
	Vector<String> v2 = new Vector<String>(Arrays.asList(stringArray));

	//First did i < v1.size(), but as this vector is still empty, this returns 0..., so should make the vector with int final nElements = 10 or something.
	for(int i = 0; i < 10; i++){
	    int j = 2*i;
	    v1.add(j);
	}

	printVector(v1,"v1");
	printVector(v2,"v2");

	Integer[] intArray = {1,3,5,7,9};

	v1.addAll(8,Arrays.asList(intArray)); 

	printVector(v1,"new v1");
    }


    public static void printVector(Vector v, String s){
	System.out.print(s + " = {");
	Iterator vItr = v.iterator();
	int i = 0;
	while(vItr.hasNext()){
	    if(i++ == 0){
		System.out.print(vItr.next());
	    }
	    else {
		System.out.print(", ");
		System.out.print(vItr.next());
	    }
	}
	System.out.println("}");
	
    }
	


}
