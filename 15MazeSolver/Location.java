public class Location implements Comparable<Location> {
    private int row, col;
    private int distToStart;
    private int distToGoal;
    private Location previous;
    private boolean aStar;

    public Location(int r, int c, Location prev, int toStart, int toGoal, boolean star) {
	row = r;
	col = c;
	distToStart = toStart;
	distToGoal = toGoal;
	aStar = star;
    }
    
    public int getToStart() {
	return distToStart;
    }

    public int getToGoal() {
	return distToGoal;
    }

    public int CompareTo(Location other) {
	if (aStar) {
	    (distToStart + distToGoal) - (other.getToStart() + other.getToGoal());
	}
	else {
	    distToGoal - other.getToGoal();
	}
    }
}
	
