public class Quick {
    public static int part(int[] data, int start, int end) {
	//-Choose a random element to be a pivot, and partition the array around it. 
	//-Only partition the elements from start to end inclusive.
	//-When done returns the index of the final position of the pivot element.      
	//    (Should be from start to end inclusive)
	//int pivot = (int)(Math.random() * (end-start) + start);
	int pivotElement = data[(int)(Math.random() * data.length)];
	int pIndex = 0; //partitionedIndex
	for (int n = start;start <= end;n++) {
	    if (pivotElement > data[n]) {
		int temp = data[pIndex];
		data[pIndex] = data[n];
		data[n] = temp;
		pIndex++;
	    }
	}
	return data[]
    }

    public static int quickSelect(int[] data, int k) {
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
    }
}
