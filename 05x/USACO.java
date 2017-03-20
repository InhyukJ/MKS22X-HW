import java.util.*;
import java.io.*;

public class USACO {
    public USACO() {}
    public int bronze(String filename) {
	Scanner in = null;
	try {
	    in = new Scanner(new File(filename));
	}
	catch (FileNotFoundException e) {
	    System.out.println("Error 404: File Not Found.");
	    System.exit(0);
	}

	Scanner header = new Scanner(in.nextLine());
	int row = Integer.parseInt(header.next());
	int col = Integer.parseInt(header.next());
	int Elevation = Integer.parseInt(header.next());
	int instructions = Integer.parseInt(header.next());

	int[][] field = new int[row][col];
	for (int r = 0;r < row;r++) {
	    for (int c = 0;c < col;c++) {
		field[r][c] = Integer.parseInt(in.next());
	    }
	}

	for (int ins = 0;ins < instructions;ins++) {
	    //Scanner direction = new Scanner(in.nextLine());
	    int R_s = Integer.parseInt(in.next());
	    int C_s = Integer.parseInt(in.next());
	    int Dig = Integer.parseInt(in.next());
	    stomp(R_s, C_s, Dig, field);
	}

	int volume = 0;
	for (int r = 0;r < field.length;r++) {
	    for (int c = 0;c < field[r].length;c++) {
		if (Elevation > field[r][c]) volume += Elevation - field[r][c];
	    }
	}
	return volume * 72 * 72;
    }

    private void stomp(int row, int col, int dig, int[][] field) {
	int high = 0;
	for (int r = 0;r < row;r++) {
	    for (int c = 0;c < col;c++) {
		if (field[row][col] > high) {
		    high = field[row][col];
		}
	    }
	}

	int lowered = high - dig;
	for (int r = 0;r < row;r++) {
	    for (int c = 0;c < col;c++) {
		if (field[row][col] > lowered) {
		    field[row][col] = lowered;
		}
	    }
	}
    }
    
    public int silver(String filename) { //int
	Scanner in = null;
	try {
	    in = new Scanner(new File(filename));
	}
	catch (FileNotFoundException e) {
	    System.out.println("Error 404: File Not Found");
	    System.exit(0);
	}

	Scanner header = new Scanner(in.nextLine());
	int row = Integer.parseInt(header.next());
	int col = Integer.parseInt(header.next());
	int steps = Integer.parseInt(header.next());
	if (steps == 0) return 0;

	int[][] field = new int[row][col];
	for (int r = 0;r < row;r++) {
	    String something = in.nextLine();
	    for (int c = 0;c < something.length();c++) {
		char smth = something.charAt(c);
		if (smth == '.') {
		    field[r][c] = 0;
		}
		if (smth == '*') {
		    field[r][c] = -1;
		}
	    }
	}
	
	int R1 = Integer.parseInt(in.next()) - 1;
	int C1 = Integer.parseInt(in.next()) - 1;
	int R2 = Integer.parseInt(in.next()) - 1;
	int C2 = Integer.parseInt(in.next()) - 1;
	return solve(R1, C1, R2, C2, steps, field); //return
    }
    
    private int solve(int r1, int c1, int r2, int c2, int st, int[][] field) {//int
	field[r1][c1] = 1;
	
	for (int step = 1;step <= st;step++) {
	    int[][] temp = new int[field.length][field[0].length];
	    for (int r = 0;r < field.length;r++) {
		for (int c = 0;c < field[r].length;c++) {
		    if (field[r][c] != -1) {
			temp[r][c] = sumCells(r, c, field);
		    }
		    else {
			temp[r][c] = -1;
		    }
		}
	    }
	    field = temp;
	}
	return field[r2][c2];   
    }
    private int sumCells(int r, int c, int[][] field) { //void
	int sum = 0;
	if (r + 1 < field.length && field[r+1][c] != -1) sum += field[r+1][c];
	if (r - 1 >= 0 && field[r-1][c] != -1) sum += field[r-1][c];
	if (c + 1 < field[r].length && field[r][c+1] != -1) sum += field[r][c+1];
	if (c - 1 >= 0 && field[r][c-1] != -1) sum += field[r][c-1];
	
	return sum;
    }
    /*
    public static void main(String[]args) {
	USACO x = new USACO();
	System.out.println(x.bronze("makelake.dat"));
	System.out.println(x.silver("ctravel.dat"));
    }
    */
}
