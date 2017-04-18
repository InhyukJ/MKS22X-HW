import java.util.*;

public class MyLinkedList implements Iterable<Integer> {
    private LNode start, end;
    private int size;

    private class LNode {
	int value;
	LNode next, prev;

	public LNode(int n) {
	    value = n;
	}

	public LNode(int n, LNode node) {
	    value = n;
	    next = node;
	}

	public String toString() {
	    return value + "";
	}
    }

    public MyLinkedList() {
    }

    public int size() {
	return size;
    }

    private LNode getNthNode(int n) {
	LNode current = start;
	int counter = 0;
	while (counter < n) {
	    current = current.next;
	    counter++;
	}
	return current;
    }

    private boolean addAfter(LNode location, LNode toBeAdded) {
	if (location.next == null) {
	    end = toBeAdded;
	}
	location.next = toBeAdded;
	toBeAdded.prev = location;
	size++;
	return true;
    }
    
    private void remove(LNode target) {
	//LNode current = start;
	if (target.prev == null || target.next == null) {
	    if (size == 1) {
		start = null;
		end = null;
		size--;
	    }
	    else if (target.prev == null) {
		start = target.next;
		target.next.prev = null;
		size--;
	    }
	    else { //target.next == null
		end = target.prev;
		target.prev.next = null;
		size--;
	    }
	}
	else {
	    target.prev.next = target.next;
	    target.next.prev = target.prev;
	    size--;
	}
    }
    
    public String toString() {
	LNode current = start;
	String ans = "[";
	for (int n = 0;n < size;n++) {
	    if (current == null) return "Error";
	    if (n == size-1) return ans += current.value + "]"; 
	    else {
		ans += current.value + ", ";
		current = current.next;
	    }
	}
	return ans;
    }


    public boolean add(int value) {
	LNode current = start;
	LNode newNode = new LNode(value);
	if (current == null) {
	    start = newNode;
	    end = newNode;
	}
	else {
	    while(current.next != null) current = current.next;
	    current.next = newNode;
	    newNode.prev = current;
	    end = newNode;
	}
	size++;
	return true;
    }

    public int get(int index) {
	LNode current = start;
	int counter = 0;
	while (counter < index) {
	    current = current.next;
	    counter++;
	}
	return current.value;
    }

    public int set(int index, int newValue) {
	LNode current = start;
	int counter = 0;
	while (counter < index) {
	    current = current.next;
	    counter++;
	}
	int temp = current.value;
	current.value = newValue;
	return temp;
    }

    public int indexOf(int value) {
	LNode current = start;
	int counter = 0;
	while (current.value != value) {
	    counter++;
	    current = current.next;
	}
	return counter;
    }

    public int remove(int index) {
	LNode toBeRemoved = getNthNode(index);
	int removed = toBeRemoved.value;
	remove(toBeRemoved);
	return removed;
    }

    public void add(int index, int value) {
	LNode newNode = new LNode(value);
	LNode current = start;
	if (index == 0) {
	    start = newNode;
	    newNode.next = current;
	    current.prev = newNode;
	    size++;
	}
	else if (index == size) {
	    add(value);
	}
	else {
	    while (index != 0) {
		current = current.next;
		index--;
	    }
	    newNode.next = current;
	    current.prev.next = newNode;
	    newNode.prev = current.prev;
	    current.prev = newNode;
	    size++;
	}
    }

    public Iterator<Integer> iterator() {
	return new LinkedListIterator(this);
    }

    public class LinkedListIterator implements Iterator<Integer> {
	private int element;
	private MyLinkedList LList;

	public LinkedListIterator(MyLinkedList list) {
	    LList = list;
	    element = 0;
	}

	public Integer next() {
	    if (hasNext()) {
		int ans = LList.get(element);
		element++;
		return ans;
	    }
	    else {
		throw new NoSuchElementException();
	    }
	}

	public boolean hasNext() {
	    return element < LList.size();
	}

	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }
    
    public static void main(String[]args) {
	MyLinkedList a = new MyLinkedList();
	for (int i = 0;i < 20;i++) {
	    a.add(i);
	}
	System.out.println("The data is:");
	System.out.println(a);
	System.out.println();

	System.out.println("Regular Loop:");
	for (int i = 0;i < a.size();i++) {
	    System.out.print(a.get(i) + " ");
	}
	System.out.println();

	System.out.println("Iterable Loop:");
	for (Integer i : a) {
	    System.out.print(i + " ");
	}
	System.out.println();
    }
}
	
