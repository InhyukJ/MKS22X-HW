import java.util.ArrayList;

public class MyHeap {
    private ArrayList<String> heap;
    private int constant;
    private int size;

    public MyHeap() {
	heap = new ArrayList<String>();
	heap.add("filler");
	constant = 1;
	size = 0;
    }

    public MyHeap(boolean max) {
	this();
	if (!max) constant = -1;
    }

    public void add(String str) {
	/*
	int child = size;
	int parent = size / 2;
	while (compare(heap.get(parent), heap.get(child)) < 0) {
	    pushUp(child);
	    child = parent;
	    parent /= 2;
	}
	size++;
	*/
	heap.add(str);
	size++;
	int child = size;
	int parent = child / 2;
	while (parent >= 1 && compare(heap.get(parent), heap.get(child)) < 0) {
	    swap(parent, child);
	    child = parent;
	    parent = child / 2;
	}
    }

    public String remove() {
	String toRemove = heap.get(1);
	heap.set(1, heap.get(size));
	heap.remove(size);
	size--;
	moveDown();
	return toRemove;
    }

    private void swap(int ind1, int ind2) {
	String temp = heap.get(ind1);
	heap.set(ind1, heap.get(ind2));
	heap.set(ind2, temp);
    }

    public int compare(String str1, String str2) {
	return str1.compareTo(str2) * constant;
    }

    

    public String peek() {
	return heap.get(1);
    }

    private void moveDown() {
	int parent = 1;
	int child = 3;
	while (child <= size && compare(heap.get(parent), heap.get(child)) < 0) {
	    swap(parent, child);
	    parent = child;
	    child = parent * 2;
	}
    }

    public void printTree() {
	int powerTwo = 2;
	for (int n = 1;n <= size;n++) {
	    System.out.print(heap.get(n) + " ");
	    if (n == powerTwo - 1) { //1, 2, 4, 8, 16
		System.out.println();
		powerTwo *= 2;
	    }
	}
	System.out.println();
    }
	
    public static void main(String[]args) {
	MyHeap a = new MyHeap();
	String[] test1 = {"b","c","b","g","d","e","a"};
	for (String str : test1) {
	    a.add(str);
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
