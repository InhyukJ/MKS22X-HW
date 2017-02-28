import java.io.*;
import java.util.*;

public class Maze {
    private char[][] maze;
    private boolean animate;

    public Maze(String filename) throws FileNotFoundException {
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

	maze = new char[rows][cols];
	for (int n = cols;n < line.length();n += cols) {
	    
		

    public Maze() throws FileNotFoundException {
	File infile = new File("Maze1.txt");
        Scanner inf = new Scanner(infile);
        int lineNumber = 1;
	String[][] board = new board[][];
        while(inf.hasNextLine()){
	    int nthline = 0;
            String line = inf.nextLine();
	    for (int n = 0;n < line.length();n++) {
		board[nthline][n] = line[n];
	    }
	    nthline++;
	}
	
	maze = board;
	startRow = 0;
	startCol = 0;
    }

    public solve() {
	findStart();
	solveH(startRow, startCol);
    }

    private void findStart() {
	for (int r = 0;r < maze.length;r++) {
	    for (int c = 0;c < maze[r].length;c++) {
		if (maze[r][c] == "S") {
		    startRow = r;
		    startCol = c;
		}
	    }
	}
    }

    private boolean solveH(int row, int col) {
	if (maze[row][col] == "E") {
	    return true;
	}
	if ()
