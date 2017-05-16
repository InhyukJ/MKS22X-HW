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
    public static void merge(int[] left, int[] right, int[] destination) {
	int n = 0; //left Index
	int m = 0; //right Index
	int i = 0; //destination Index;

	while (i < destination.length) {
	    if (n == left.length) {
		while (m < right.length) {
		    destination[i] = right[m];
		    i++;
		    m++;
		}
	    }
	    else if (m == right.length) {
		while (n < left.length) {
		    destination[i] = left[n];
		    i++;
		    n++;
		}
	    }
	    else if (left[n] < right[m]) {
		destination[i] = left[n];
		i++;
		n++;
	    }
	    else if (right[m] < left[n]) {
		destination[i] = right[m];
		i++;
		m++;
	    }
	    else if (left[n] == right[m]) {
		destination[i] = left[n];
		n++;
		i++;
		destination[i] = right[m];
		m++;
		i++;
	    }
	}
    }
}
