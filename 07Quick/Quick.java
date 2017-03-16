public class Quick {
    public static int part(int[] data, int start, int end) {
	//-Choose a random element to be a pivot, and partition the array around it. 
	//-Only partition the elements from start to end inclusive.
	//-When done returns the index of the final position of the pivot element.      
	//    (Should be from start to end inclusive)
	//int pivot = (int)(Math.random() * (end-start) + start);
	int pivot = (int)(Math.random() * data.length);
	int pivotElement = data[pivot];
	int pIndexS = start; //partitionedIndex for SMALLER
	int pIndexE = end; //partitionedIndex for LARGER
	for (int n = start;start <= end;n++) {
	    if (PivotElement == data[n]) continue;
	    if (PivotElement < data[n]) {
		if (n < pivot) {
		    pIndexS++;
		    continue;
		}
		else {
		    int temp = data[pIndexS];
		    data[pIndexS] = data[pIndexE];
		    data[pIndexE] = temp;
		    pIndexS++;
		    pIndexE--;
		}
	    if (pivotElement > data[n]) {
		int temp = data[pIndexE];
		data[pIndexE] = data[n];
		data[n] = temp;
		pIndexE--;
	    }
	}
	return data[]
    }

    public static int quickSelect(int[] data, int k) {
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
    }
}
