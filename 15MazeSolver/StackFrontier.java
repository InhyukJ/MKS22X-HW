public class StackFrontier implements Frontier {
    private ArrayList<Location> fStack;
    
    public StackFrontier {
	fStack = new ArrayList<Location>();
    }

    public void add(Location loc) {
	fStack.add(loc);
    }

    public Location remove() {
	return fStack.remove(fStack.size - 1);
    }
}
