public class USACO {
    public int bronze(String filename) {
	private int R, C, E, N;
	private int[][] lake;
	File file = new File(filename);
	Scanner in = new Scanner(file);
	String[] index = in.nextLine().split(" ");
	R = index[1];
	C = index[2];
	E = index[3];
	N = index[4];
	lake = new int[R][C];
	for (int row = 0;row < R;row++) {
	    for (int col = 0;col < C;col++) {
		lake[row][col] = in.next(); //Integer.parseInt() or something
	    }
	}
	while (in.hasNextLine()) {
	    String[] direction = in.nextLine().split(" ");
	    command(direction[1], direction[2], direction[3]);
	}

	return;	    
    }
    
    private void command(int R_s, int C_s, int D_s) {
	for (int row = R_s;row < R_s + 3;R_s++) {
	    for (int col = C_s;col < C_s + 3;C_s++) {
		lake[row][col] 
    
    public int silver(String filename);
}
