public class QueenBoard {
    private int[][]board;
    private int solutionCount;

    public QueenBoard(int size) {
	board = new int[size][size];
	solutionCount = 0;
	resetBoard();
    }

    public boolean solve() {
	return solveH(0);
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
    
    private void resetBoard() { //sets all values of board to 0
	for (int row = 0;row < board.length;row++) {
	    for (int col = 0;col < board[row].length;col++) {
		board[row][col] = 0;
	    }
	}
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
	    if (row - n >= 0 && col - n >= 0) { //Towards QII
		board[row - n][col - n] += 1;
	    }
	    if (row + n < board.length && col + n < board.length) { //Towards QIV
		board[row + n][col + n] += 1;
	    }
	    if (row + n < board.length && col - n >= 0) { //Towards QIII
		board[row - n][col - n] += 1;
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
}
	    
	    
	
