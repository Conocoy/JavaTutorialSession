import java.io.*;
import java.util.Scanner;

public class StringToFile {
    
    public static void main(String[] args){
	
	File f = null;

	if(args.length == 0){
	    System.out.println("Using default file name \"default.txt\"");
	    f = new File("default.txt");
	} else {
	    System.out.println(String.format("Using the file \"%s\"",args[0]));
	    f = new File(args[0]);
	}

	if (f == null){
	    //should not be possible due to default file name
	    System.out.println("No file openend, exiting!");
	    return;
	}

	try{
	    PrintWriter pw = new PrintWriter(f);
	
	    System.out.println("Write lines to the opened file "+ f.getName() +", to close the file type \".q\"");
	
	    String inputString = "";
	    Scanner input = new Scanner(System.in);
	    int i = 0;
	    
	    while(true){

		System.out.print(String.format("line %03d: ",++i));
		inputString = input.nextLine();
		if(".q".equals(inputString)){
		    System.out.println("Closing the file and terminating the program!");
		    break;
		}
		
		pw.write(inputString+"\n");
	    }
	    
	    pw.close();

	} catch(FileNotFoundException e){
	}
	

    }
}
	
