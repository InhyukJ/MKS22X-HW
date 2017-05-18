public class FrontierQueue implements Frontier {
    private ArrayList<Location> fQueue;

    public FrontierQueue {
	fQueue = new ArrayList<Location>();
    }
    
    public void add(Location loc) {
	fQueue.add(0, loc);
    }

    public Location next() {
	return fQueue.remove(fQueue.length - 1);
    }
}
