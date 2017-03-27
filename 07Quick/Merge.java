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
    public static void mergeSort(int[] ary) {
	if (ary.length == 0) return;
	else {
	    int splitIndex = ary.length / 2;
	    int[] left = new int[splitIndex];
	    int[] right = new int[ary.length - splitIndex];
	    for (int l = 0;l < left.length;l++) left[l] = ary[l];
	    for (int r = 0;r < right.length;r++) right[r] = ary[l+r];
	    mergeSort(left);
	    mergeSort(right);
	    int[] newAry = mergeTwo(left, right);
	    ary = newAry;
	}
    }

    private static int[] mergeTwo(int[] left, int[] right) {
	int[] newAry = new int[left.length + right.length];
	int lessIndex = Math.min(left.length, right.length);
	int moreIndex = Math.max(left.length, right.length);
	int n = 0;
	while (n < lessIndex) {


	    n++;
	}
    }
}
