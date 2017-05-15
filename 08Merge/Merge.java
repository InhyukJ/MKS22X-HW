public class Merge {
    /*
    def mergesort(int[]ary)
    if ...base case...
    stop!
    else
    int[]left = copy of the left side;
    int[]right = copy of the right side;
    mergesort(left)
    mergesort(right)
    mergeTheTwoHalvesIntoTheOriginalArray
    */
    public static void mergesort(int[] ary) {
	if (ary.length <= 0) {
	    throw new IllegalStateException("The list is empty");
	}
	if (ary.length == 1) return;
	else {
	    int splitIndex = ary.length / 2;
	    int[] left = new int[splitIndex];
	    int[] right = new int[ary.length - splitIndex];
	    for (int l = 0;l < left.length;l++) left[l] = ary[l];
	    for (int r = 0;r < right.length;r++) right[r] = ary[left.length+r];
	    mergesort(left);
	    mergesort(right);
	    merge(left, right, ary);
	}
    }

    /*
    private static int[] mergeTwo(int[] left, int[] right) { //merging two sorted arrays
	int[] newAry = new int[left.length + right.length];
	int i = 0;
	int n = 0; //left Index
	int m = 0; //right Index
	while (n < left.length) {
	    if (m == right.length) {
		for (int a = n;a < left.length;a++) {
		    newAry[i] = left[a];
		    i++;
		}
	    }
	    else if (left[n] < right[m]) {
		newAry[i] = left[n];
		n++;
		i++;
	    }
	    
	    else {
		newAry[i] = right[m];
		m++;
		i++;
	    }
	}
	if (m < right.length) {
	    for (int b = m;b < right.length;b++) {
		newAry[i] = right[b];
		i++;
	    }
	}
	return newAry;
    }
    */

    public static void merge(int[] left, int[] right, int[] destination) {
	int i = 0;
	int n = 0; //left Index
	int m = 0; //right Index
	while (n < left.length) {
	    if (m == right.length) {
		for (int a = n;a < left.length;a++) {
		    destination[i] = left[a];
		    i++;
		}
	    }
	    else if (left[n] < right[m]) {
		destination[i] = left[n];
		n++;
		i++;
	    }
	    
	    else {
		destination[i] = right[m];
		m++;
		i++;
	    }
	}
	if (m < right.length) {
	    for (int b = m;b < right.length;b++) {
		destination[i] = right[b];
		i++;
	    }
	}
	return;
    }
}
