import java.util.*;

public class FrontierQueue<Location> implements Frontier, Queue<Location> {
    private Location[] fQueue;

    public FrontierQueue {
	fQueue = new Location[];
    }

    public void add(Location loc) {
	fQueue.add(loc);
    }

    public Location next() {
	fQueue.remove(fQueue.length - 1);
    }
}
