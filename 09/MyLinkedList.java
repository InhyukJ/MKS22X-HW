public class MyLinkedList {
    private LNode start, end;
    private int size;

    private class LNode {
	int value;
	LNode next, prev;

	public LNode(int n) {
	    value = n;
	    next = null;
	    prev = null;
	}

	public LNode(int n, LNode node) {
	    value = n;
	    next = node;
	}
    }

    public MyLinkedList() {
	start = null;
	end = null;
	size = 0;
    }

    public boolean add1(int value) {
	LNode n = new LNode(value, start);
	start = n;
	return true;
    }

    public boolean add(int value) {
	LNode current = start;
	if (current == null) add1(value);
	else {
	    LNode newNode = new LNode(value);
	    while(current.next != null) current = current.next;
	    current.next = newNode;
	}
	size++;
	return true;
    }

    public int size() {
	return size;
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

    public static void main(String[]args) {
	MyLinkedList a = new MyLinkedList();
	a.add(10);
	a.add(10000);
	System.out.println(a);
	//a.add(2);
	//a.add(65);
    }
}
	
