import java.util.ArrayList;

public class RunningMedian {
    MyHeap min, max; 
    
    public RunningMedian() {
	min = new MyHeap(true); //top heap; minimum value is bottom of top half
	max = new MyHeap(false); //bottom heap; maximum value is top of the bottom half
    }

    public void add(int n) {
	if (n > min.peek()) min.add(n);
	else max.add(n);
	balance();
    }

    private void balance() {
	while (Math.abs(getDifference()) > 1) {
	    if (getDifference() > 1) max.add(min.remove());
	    else min.add(max.remove());
	}
    }

    private int getDifference() {
	return min.getSize() - max.getSize();
    }

    public double getMedian() {
	int maxT = max.peek();
	int minT = min.peek();

	if (max.getSize() == min.getSize()) return (maxT + minT) / 2;
	else if (max.getSize() > min.getSize()) return maxT * 1.0;
	else return minT * 1.0;
    }
}
