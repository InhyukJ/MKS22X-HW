import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile {
    public static void main(String args[]) throws FileNotFoundException {
        //instead of a try/catch, you can throw the FileNotFoundException.
        File infile = new File("Maze1.txt");// can be a path"/full/path/to/file.txt" 
        Scanner inf = new Scanner(infile);
        int lineNumber = 1;
	String output = "";
        while(inf.hasNextLine()){
            String line = inf.nextLine();
	    if (!inf.hasNextLine()) {
		output += line;
	    }
	    else {
		output += line + "\n";
	    }
        }
	System.out.println(output);
  }
}
