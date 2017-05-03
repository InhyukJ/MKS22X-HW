public class MyHeap {
    private ArrayList<String> heap;
    private int size;
    private int constant;

    public MyHeap {
	heap = new ArrayList<String>();
	size = 0;
	constant = 1;
    }

    public MyHeap(boolean max) {
	if (max) {
	    heap = new ArrayList<String>();
	    size = 0;
	    constant = 1;
	}
	else {
	    heap = new ArrayList<String>();
	    size = 0;
	    constant = -1;
	}
    }
}
