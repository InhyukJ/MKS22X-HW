import java.io.*;
import java.util.*;

public class Maze {
    private char[][] maze;
    private boolean animate;

    public Maze(String filename) throws FileNotFoundException {
	File infile = new File(filename);
	Scanner inf = new Scanner(infile);
	int rows = 1;
	char[][] board = char[][];
	while (inf.hasNextLine()) {
	    String line = inf.nextLine();
	    for (char letter : line) {
		
	}
	for (int row = 0;row < )

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
