import java.util.*;

public class MyLinkedList {
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

    private boolean addAfter(int value) {
	LNode n = new LNode(value, start);
	start = n;
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
	if (current == null) addAfter(value);
	else {
	    LNode newNode = new LNode(value);
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
	LNode current = start;
	int n = 0;
	while (n < index) {
	    current = current.next;
	    n++;
	}
	int removed = current.value;
	remove(current);
	return removed;
    }

    public void add(int index, int value) {
	LNode newNode = new LNode(value);
	if (index == 0) {
	    newNode.next = start;
	    start.prev = newNode;
	    start = newNode;
	    size++;
	}
	else if (index == size) {
	    end.next = newNode;
	    newNode.prev = end;
	    end = newNode;
	    size++;
	}
	else {
	    LNode current = start;
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
    
    public static void main(String[]args) {
	MyLinkedList a = new MyLinkedList();
	a.add(10);
	a.add(10000);
	System.out.println(a);
	//a.add(2);
	//a.add(65);
    }
}
	
