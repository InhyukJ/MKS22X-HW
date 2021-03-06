import java.io.*;
import java.util.*;

public class Maze {
    private char[][] maze;
    private boolean animate;

    public Maze(String filename) {
	try {
	    File infile = new File(filename);
	    Scanner inf = new Scanner(infile);
	    int rows = 0;
	    int cols = 0;
	    String output = "";
	    while (inf.hasNextLine()) {
		String line = inf.nextLine();
		cols = line.length();
		rows++;
		output += line;
	    }
	    
	    if (output.indexOf('E') != -1) {
		if (output.indexOf('E', output.indexOf('E')+1) != -1) {
		    throw new IllegalArgumentException("There is more than one Exit");
		}
	    }
	    else {
		throw new IllegalArgumentException("There is no Exit");
	    }
	    
	    if (output.indexOf('S') != -1) {
		if (output.indexOf('S', output.indexOf('S')+1) != -1) {
		    throw new IllegalArgumentException("There is more than one Start");
		}
	    }
	    else {
		throw new IllegalArgumentException("There is no Start");
	    }
	    
	    maze = new char[rows][cols];
	    for (int n = 0;n < output.length();n++) {
		int tRow = n / cols;
		int tCol = n % cols;
		maze[tRow][tCol] = output.charAt(n);
	    }
	    
	    animate = false;
	}
	catch (FileNotFoundException e) {
	    System.out.println("Error: File not Found");
	    System.exit(0);
	}
    }
		
    private void wait(int millis){ //ADDED SORRY!
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    
    public void setAnimate(boolean b){
        animate = b;
    }
    
    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }
    
    
    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
	int startr=-1,startc=-1;
	//Initialize starting row and startint col with the location of the S. 
	for (int row = 0;row < maze.length;row++) {
	    for (int col = 0;col < maze[row].length;col++) {
		if (maze[row][col] == 'S') {
		    startr = row;
		    startc = col;
		}
	    }
	}
	maze[startr][startc] = ' ';//erase the S, and start solving!
	return solve(startr,startc);
    }
    
    /*
      Recursive Solve function:
      
      A solved maze has a path marked with '@' from S to E.
      
      Returns true when the maze is solved,
      Returns false when the maze has no solution.
      
      Postcondition:
      The S is replaced with '@' but the 'E' is not.
      All visited spots that were not part of the solution are changed to '.'
      All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
	if (maze[row][col] == 'E') {
	    return true;
	}
	if (maze[row][col] == ' ') {
	    maze[row][col] = '@';
	    if (solveHel(row, col)) {
		return true;
	    }
	    else {
		maze[row][col] = ' ';
	    }
	}
        return false; //so it compiles
    }

    private boolean solveHel(int row, int col) {
	return ((row + 1 < maze.length && solve(row + 1, col)) ||      //Down
		(row - 1 >= 0 && solve(row - 1, col)) ||                //Up
		(col + 1 < maze[row].length && solve(row, col + 1)) || //Right
		(col - 1 >= 0 && solve(row, col - 1)));                 //Left
    }

    public String toString() {
	String ans = "";
	for (int row = 0;row < maze.length;row++) {
	    for (int col = 0;col < maze[row].length;col++) {
		ans += maze[row][col];
	    }
	    ans += "\n";
	}
	return ans;
    }
    /*
    public static void main(String[]args) {
	Maze f = new Maze("data5.dat");
	f.setAnimate(true);
	f.solve();
	System.out.println(f);
    }
    */
}
