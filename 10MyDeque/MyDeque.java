public class MyDeque {
    private String[] deAry;
    private int size, startIndex, endIndex;

    public Mydeque() {
	deAry = new String[10];
	size = 0;
	startIndex = 0;
	endIndx = 0;
    }

    private void calStart() {
	if (startIndex == 0) startIndex = size - 1;
	else {
 	    startIndex--;
	}
    }
	    
    
    public void addFirst(String str) {
	if (isFull()) reSize();
	else {
	    if (!(startIndex == endIndex && deAry[startIndex] == null)) calStart();
	    deAry[startIndex] = str;
	    size++;
	}
    }

    private void calLast() {
	if (endIndex == size - 1) endIndex = 0;
	else {
	    endIndex++;
	}
    }
    
    public void addLast(String str) {
	if (isFull()) reSize();
	else {
	    if (!(startIndex == endIndex && deAry[startIndex] == null)) calLast();
	    deAry[endIndex] = str;
	    size++;
	}
    }

    private boolean isFull() {
	return size == deAry.length();
    }

    private void reSize() {
	String[] newAry = new String[deAry.length * 2];
	if (startIndex > endIndex) {
	    for (int n = 0;n < deAry.length;n++) {
		newAry[n] = deAry[n];
	    }
	}
	else {
	    for (int n = startIndex;n < (deAry.length - startIndex);n++) {
		newAry[n + deAry.length] = deAry[n];
	    }
	    for (int n = 0;n <= endIndex;n++) {
		newAry[n] = deAry[n];
	    }
	}
    }
}
