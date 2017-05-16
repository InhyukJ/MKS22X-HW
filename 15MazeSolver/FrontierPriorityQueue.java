import java.util.*;

public class FrontierPriorityQueue<Location> implements Frontier, PriorityQueue<Location> {
    private PriorityQueue[] pQueue;
    
    public FrontierPriorityQueue() {
	pQueue = new PriorityQueue();
    }

    public void add(Location loc) {
	pQueue.add(loc);
    }

    public Location next() {
	return pQueue.remove(pQueue.length - 1);
    }
}

