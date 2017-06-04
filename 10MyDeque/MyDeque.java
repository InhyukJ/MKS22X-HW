import java.util.*;

public class MyDeque {
    private String[] deAry;
    private int size, startIndex, endIndex;

    public MyDeque() {
	deAry = new String[10];
	size = 0;
	startIndex = 0;
	endIndex = 0;
    }

    private void calStart() {
	if (startIndex == 0) startIndex = deAry.length - 1;
	else {
 	    startIndex--;
	}
    }
	    
    
    public void addFirst(String str) {
	if (str == null) throw new NullPointerException();
	if (isFull()) {
	    reSize();
	    calStart();
	    deAry[startIndex] = str;
	}
	else {
	    if (deAry[startIndex] != null) calStart();
	    deAry[startIndex] = str;
	}
	size++;
    }
    
    private void calLast() {
	if (endIndex == deAry.length - 1) endIndex = 0;
	else {
	    endIndex++;
	}
    }
    
    public void addLast(String str) {
	if (str == null) throw new NullPointerException();
	if (isFull()) {
	    reSize();
	    calLast();
	    deAry[endIndex] = str;
	}
	else {
	    if (deAry[endIndex] != null) calLast();
	    deAry[endIndex] = str;
	}
	size++;
    }
    
    private boolean isFull() {
	return size == deAry.length;
    }

    private void reSize() {
	String[] newAry = new String[deAry.length * 2];
	if (endIndex > startIndex) { //special case where it's in order
	    for (int n = 0;n < deAry.length;n++) {
		newAry[n] = deAry[n];
	    }
	    //startIndex will always be zero in this case
	}
	else {
	    for (int n = startIndex;n < deAry.length;n++) {
		newAry[n + deAry.length] = deAry[n];
	    }
	    startIndex += deAry.length;
	    for (int n = 0;n <= endIndex;n++) {
		newAry[n] = deAry[n];
	    }
	    //endIndex will remain the same
	}
	deAry = newAry;
    }

    public String removeFirst() {
	if (size == 0) throw new NoSuchElementException();
	String removed = deAry[startIndex];
	deAry[startIndex] = null;
	if (startIndex == deAry.length - 1) startIndex = 0;
	else {
	    startIndex++;
	}
	size--;
	return removed;
    }

    public String removeLast() {
	if (size == 0) throw new NoSuchElementException();
	String removed = deAry[endIndex];
	deAry[endIndex] = null;
	if (endIndex == 0) endIndex = deAry.length - 1;
	else {
	    endIndex--;
	}
	size--;
	return removed;
    }

    public String getFirst() {
	if (size == 0) throw new NoSuchElementException();
	return deAry[startIndex];
    }

    public String getLast() {
	if (size == 0) throw new NoSuchElementException();
	return deAry[endIndex];
    }

    public String toString() { //FOR DEBUGGING
	/*
	String ans = "[";
	if (startIndex > endIndex) {
	    for (int n = startIndex;n <= endIndex;n++) {
		if (n == endIndex) ans += deAry[n] + "]";
		else {ans += deAry[n] + ", ";}
	    }
	    return ans;
	}
	else {
	    for (int n = startIndex;n < deAry.length;n++) {
		ans += deAry[n] + ", ";
	    }
	    for (int n = 0;n <= endIndex;n++) {
		if (n == endIndex) ans += deAry[n] + "]";
		else {ans += deAry[n];}
	    }
	    return ans;
	}
	*/
	String ans = "[";
	for (int n = 0;n < deAry.length;n++) {
	    if (n == deAry.length-1) ans += deAry[n] + "]";
	    else {ans += deAry[n] + ", ";}
	}
	return ans;
    }
    /*
    public static void main(String[]args) {
	MyDeque a = new MyDeque();
	for (int n = 0;n < 10;n++) {
	    a.addLast(n+2 + "");
	}
	for (int n = 0;n < 3;n++) {
	    a.removeFirst();
	    a.addLast(12+n + "");
	}
	System.out.println(a);
	System.out.println("startIndex: " + a.startIndex);
	System.out.println("endIndex: " + a.endIndex);
	a.reSize();
	System.out.println();
	System.out.println(a);
	System.out.println("startIndex: " + a.startIndex);
	System.out.println("endIndex: " + a.endIndex);
    }
    */
}
