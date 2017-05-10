import java.util.ArrayList;

public class MyHeap {
    private ArrayList<Integer> heap;
    private int constant;
    private int size;

    public MyHeap() {
	heap = new ArrayList<Integer>();
	heap.add(100100101);
	constant = 1;
	size = 0;
    }

    public MyHeap(boolean max) {
	this();
	if (!max) constant = -1;
    }

    public int getSize() {
	return size;
    }
    
    public void add(int n) {
	Integer i = new Integer(n);
	heap.add(i);
	size++;
	int child = size;
	int parent = child / 2;
	while (parent >= 1 && compare(heap.get(parent).intValue(), heap.get(child).intValue()) < 0) {
	    swap(parent, child);
	    child = parent;
	    parent = child / 2;
	}
    }

    public int remove() {
	Integer i = heap.get(1);
	heap.set(1, heap.get(size));
	heap.remove(size);
	size--;
	moveDown();
	return i.intValue();
    }

    private void swap(int ind1, int ind2) {
	Integer temp = heap.get(ind1);
	heap.set(ind1, heap.get(ind2));
	heap.set(ind2, temp);
    }

    public int compare(int int1, int int2) {
	return (int1 - int2) * constant;
    }

    

    public int peek() {
	return heap.get(1).intValue();
    }

    private void moveDown() {
	int parent = 1;
	int child = 2;
	while (child <= size && compare(heap.get(parent).intValue(), heap.get(child).intValue()) < 0) {
	    if (compare(heap.get(child).intValue(), heap.get(child+1).intValue()) < 0) {
		child++;
		swap(parent, child);
		parent = child;
		child = parent * 2 - 1;
	    }
	    else {
		swap(parent, child);
		parent = child;
		child = parent * 2;
	    }
	}
    }

    public void printTree() {
	int powerTwo = 2;
	for (int n = 1;n <= size;n++) {
	    System.out.print(heap.get(n).intValue() + " ");
	    if (n == powerTwo - 1) { //1, 2, 4, 8, 16
		System.out.println();
		powerTwo *= 2;
	    }
	}
	System.out.println();
    }
	
    public static void main(String[]args) {
	MyHeap a = new MyHeap();
	int[] test1 = {1, 5, 6, 2, 7, 3, 9};
	for (int n : test1) {
	    a.add(n);
	}
	a.printTree();
	a.remove();
	a.printTree();
	System.out.println();
	
	a.remove();
	a.printTree();
	System.out.println();
    }
}
