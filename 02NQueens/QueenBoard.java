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

    public void countSolutions() {
	countSol(0);
    }

    private boolean countSol(int col) {
	if (col >= board.length) {
	    return true;
	}
	for (int row = 0;row < board.length;row++) {
	    if (board[row][col] == 0) {
		addQueen(row, col);
		if (countSol(col + 1)) {
		    solutionCount++;
		    return true;
		}
		else {
		    removeQueen(row, col);
		}
	    }
	}
	return false;
    }

    public int getCount() {
	return solutionCount;
    }

    private void addQueen(int row, int col) { //Given a location, sets board[row][col] to -1, adds +1 to all 8 directions
	board[row][col] = -1;
	int n = 0;
	while (n < board.length) { //horizontal + vertical
	    if (n != row) {
		board[n][col] += 1;
	    }
	    if (n != col) {
		board[row][n] += 1;
	    }
	    if (row + n < board.length && col + n < board.length) { //Towards QIV
		board[row + n][col + n] += 1;
	    }
	    if (row - n >= 0 && col + n < board.length) { //Towards QI
		board[row + n][col + n] += 1;
	    }
	}
    }

    private void removeQueen(int row, int col) { //Given a location, sets  board[row][col] to 0, adds -1 to all 8 directions
	board[row][col] = 0;
	int n = 0;
	while (n < board.length) { //horizontal + vertical
	    if (n != row) {
		board[n][col] += -1;
	    }
	    if (n != col) {
		board[row][n] += -1;
	    }
	    if (row - n >= 0 && col - n >= 0) { //Towards QII
		board[row - n][col - n] += -1;
	    }
	    if (row + n < board.length && col + n < board.length) { //Towards QIV
		board[row + n][col + n] += -1;
	    }
	    if (row + n < board.length && col - n >= 0) { //Towards QIII
		board[row - n][col - n] += -1;
	    }
	    if (row - n >= 0 && col + n < board.length) { //Towards QI
		board[row + n][col + n] += -1;
	    }
	}
    }

    public String toString() {
	String ans = "";
	for (int row = 0;row < board.length;row++) {
	    for (int col : board[row]) {
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
	QueenBoard n = new QueenBoard(4);
	n.solve();
	System.out.println(n);
    }
}
	    
	    
	
