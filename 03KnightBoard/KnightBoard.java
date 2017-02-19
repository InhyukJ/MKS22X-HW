public class KnightBoard {
    private int[][] board;
    private int numOfSquares;
    
    public KnightBoard(int startingRows, int startingCols) {
	board = new int[startingRows][startingCols];
	numOfSquares = startingRows * startingCols;
    }

    public void solve() {
	solveH(0, 0, 1);
    }
    
    private boolean solveH(int row, int col, int level) {
	if (level - 1 == numOfSquares) {
	    return true;
	}
	if (board[row][col] == 0) { //need to make sure this is a valid place to put the knight
	    placeKnight(row, col, level);
	    if (solveHel(row, col, level + 1)) {
		return true;
	    }
	    else {
		removeKnight(row, col);
	    }
	}
	return false;
    }
    
    private boolean solveHel(int row, int col, int level) {
	//exceptions (( && ) && ), + -> board.length; - -> 0 needs it to work
	return ((row + 1 < board.length && col + 2 < board[row].length && solveH(row + 1, col + 2, level)) || //1
		(row + 1 < board.length && col - 2 >= 0 && solveH(row + 1, col - 2, level)) ||                //2
		(row - 1 >= 0 && col + 2 < board[row].length && solveH(row - 1, col + 2, level)) ||           //3
		(row - 1 >= 0 && col - 2 >= 0 && solveH(row - 1, col - 2, level)) ||                          //4
		(row + 2 < board.length && col + 1 < board[row].length && solveH(row + 2, col + 1, level)) || //5
		(row + 2 < board.length && col - 1 >= 0 && solveH(row + 2, col - 1, level)) ||                //6
		(row - 2 >= 0 && col + 1 < board[row].length && solveH(row - 2, col + 1, level)) ||           //7
		(row - 2 >= 0 && col - 1 >= 0 && solveH(row - 2, col - 1, level)));                           //8
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
	    ans += "\n";
	}
	return ans;
    }
    
    public static void main(String[]args) {
	KnightBoard a = new KnightBoard(5, 4);
	a.solve();
	System.out.println(a.solveH(0,0,1));
	System.out.println(a);
    }
}
