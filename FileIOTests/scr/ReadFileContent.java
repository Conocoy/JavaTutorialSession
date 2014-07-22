import java.io.*;

public class ReadFileContent {

    public static void main(String[] args) {
	
	// Import argument as names:

	if(args.length == 0){
	    System.out.println("No file name specified. Need file name(s) as input.");
	    return;
	}
	
	for(String fileName : args){
	    try{
		File f = new File(fileName);
		if(!f.exists()){
		    System.out.println(String.format("File %s does not exists.", fileName));
		}
		
		printLine();
		System.out.println(String.format("Printing file %s:", fileName));
		printLine();
		
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line = null;
		while( (line = br.readLine()) != null){
		    System.out.println(line);
		}
		printLine();
		br.close();
	    } catch( FileNotFoundException e){ //Not compiling because file names given by the arguments
	    } catch( IOException e){           //Not compiling because File f is null when compiling?
	    }
	}
	
    }

    static void printLine(){
	System.out.println("----------------------------------");
    }

}
	
