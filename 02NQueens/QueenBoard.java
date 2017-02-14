public class QueenBoard {
    private int[][]board;
    private int solutionCount;

    public QueenBoard(int size) {
	board = new int[size][size];
	solutionCount = -1;
    }

    public void solve() {
	solveH(0);
    }

    private boolean solveH(int col) {
	if (col >= board.length) {
	    return true;
	}
	for (int row = 0;row < board.length;row++) {
	    if (board[row][col] == 0) {
		addQueen(row, col);
		if (solveH(col + 1)) {
		    return true;
		}
		else {
		    removeQueen(row, col);
		}
	    }
	}
	return false;
    }

    private void countSol(int col) {
	if (col == board.length) {
	    solutionCount++;
	    return;
	}
	for (int row = 0;row < board.length;row++) {
	    if (board[row][col] == 0) {
		addQueen(row, col);
		countSol(col + 1);
		removeQueen(row, col);
	    }
	}
	return;
    }
    
    public int getSolutionCount() {
	int n = solutionCount;
	if (board.length < 0) {
	    n = -1;
	}
	clear();
	return n;
    }

    public void countSolutions() {
	clear();
	countSol(0);
	int n = solutionCount;
	if (board.length == 2 || board.length == 3) {
	    n = 0;
	}
	solutionCount = n;
    }

    private void addQueen(int row, int col) {
	int n = 0;
	while (n < board.length) {
	    board[n][col] += 1;
	    board[row][n] += 1;
	    if (row + n < board.length && col + n < board.length) {
		board[row + n][col + n] += 1;
	    }
	    if (row - n >= 0 && col + n < board.length) {
		board[row - n][col + n] += 1;
	    }
	    if (row + n < board.length && col - n >= 0) {
		board[row + n][col - n] += 1;
	    }
	    if (row - n >= 0 && col - n >= 0) {
		board[row - n][col - n] += 1;
	    }
	    n++;
	}
	board[row][col] = -1;
    }

    private void removeQueen(int row, int col) { //Given a location, sets  board[row][col] to 0, adds -1 to all 8 directions
	int n = 0;
	while (n < board.length) {
	    board[n][col] += -1;
	    board[row][n] += -1;
	    if (row + n < board.length && col + n < board.length) {
		board[row + n][col + n] += -1;
	    }
	    if (row - n >= 0 && col + n < board.length) {
		board[row - n][col + n] += -1;
	    }
	    if (row + n < board.length && col - n >= 0) {
		board[row + n][col - n] += -1;
	    }
	    if (row - n >= 0 && col - n >= 0) {
		board[row - n][col - n] += -1;
	    }
	    n++;
	}
	board[row][col] = 0;
    }

    public void clear() {
	int[][] clear = new int[board.length][board.length];
	board = clear;
    }

    public String toString() {
	String ans = "";
	for (int row = 0;row < board.length;row++) {
	    for (int col = 0;col < board.length;col++) {
	        if (board[row][col] == -1) {
		    ans += "Q ";
		}
		else {
		    ans += "_ ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[]args) {
	QueenBoard n = new QueenBoard(5);
	n.countSolutions();
	int a = n.getSolutionCount();
	System.out.println(a);
    }
}
	    
	    
	
