public class KnightBoard {
    private int[][] board;
    private int numOfSquares;
    
    public KnightBoard(int startingRows, int startingCols) {
	board = new int[startingRows][startingCols];
	numOfSquares = startingRows * startingCols;
    }

    public void solve() {
	solveH(0, 0, 0);
    }

    private boolean solveH(int row, int col, int level) {
	if (level == numOfSquares) {
	    return true;
	}
	
    }

    public String toString() {
	String ans = "";
	for (intnt int[]row : board) {
	    for (int col : row) {
		if ()
	return ans;
    }

    public static void main(String[]args) {
	
    }
}
