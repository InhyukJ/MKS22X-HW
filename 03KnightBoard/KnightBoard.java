public class KnightBoard {
    private int[][] board;
    private int numOfSquares;
    
    public KnightBoard(int startingRows, int startingCols) {
	board = new int[startingRows][startingCols];
	numOfSquares = startingRows * startingCols;
    }

    public void solve() {
	solveH(0, 0, 1); //choosing 
    }
    
    private boolean solveH(int row, int col, int level) {
	if (level == numOfSquares) {
	    return true;
	}
	/* Excluded because if a board is solvable you don't have to move the knight at the fist level
	if (level == 1 && !solveHel(row,col,level)) {
	    //If backtracking has failed up to the first level, place the first knight somewhere else
	    return solveH()
	*/
	if (board[row][col] == 0) { //need to make sure this is a valid place to put the knight
	    placeKnight(row, col, level);
	    if (solveHel(row, col, level)) {
		return true;
	    }
	    else {
		removeKnight(row, col);
		//Maybe return false??
	    }
	}
	return false;
    }
    
    private boolean solveHel(int row, int col, int level) {
	//exceptions (( && ) && ), + -> board.length; - -> 0 needs it to work
	return (solveH(row + 1, col + 2, level + 1) || //1
		solveH(row + 1, col - 2, level + 1) || //2
		solveH(row - 1, col + 2, level + 1) || //3
		solveH(row - 1, col - 2, level + 1) || //4
		solveH(row + 2, col + 1, level + 1) || //5
		solveH(row + 2, col - 1, level + 1) || //6
		solveH(row - 2, col + 1, level + 1) || //7
		solveH(row - 2, col - 1, level + 1));  //8
    }

    private void placeKnight(int row, int col, int level) {
	board[row][col] = level;
    }

    private void removeKnight(int row, int col) {
	board[row][col] = 0;
    }
	       
    public String toString() {
	String ans = "";
	for (int row = 0;row < board.length;row++) {
	    for (int col = 0;col < board[row].length;col++) {
		if (board[row][col] < 10) {
		    ans += " " + board[row][col] + " ";
		}
		else {
		    ans += (board[row][col] + " ");
		}
	    }
	}
	return ans;
    }
    
    public static void main(String[]args) {
	KnightBoard a = new KnightBoard(5, 4);
	a.solve();
	System.out.println(a);
    }
}
