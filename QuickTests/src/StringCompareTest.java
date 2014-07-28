import java.lang.*;
import java.io.*;
import java.util.*;


public class StringCompareTest {

    public static void main(String[] args){
	
	if("red".equals(args[0])){
	    System.out.println("The string given is equal to \"red\"! Jeej!");
	}
	else{
	    System.out.println(String.format("The string given is \"%s\".", args[0]));
	}
    }
}
