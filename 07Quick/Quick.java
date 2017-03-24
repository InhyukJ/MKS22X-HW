public class Quick {
    public static void quickSort(int[] ary) {
	qSortH(ary, 0, ary.length-1);
    }

    public static int quickSelect(int[] ary, int k) {
	quickSort(ary);
	return ary[k];
    }

    public static void qSortH(int[] data, int start, int end) {
	if (start == end) return;
	int pivot = (int)(Math.random() * (end-start) + start + 1);
	int v = data[pivot];
	//System.out.println("Pivot Element: "+data[pivot]);
	int lt = start;
	int i = start;
	int gt = end;
	swap (data, pivot, end);
	while (i <= gt) {
	    if (data[i] == v) {
		i++;
	    }
	    else if (data[i] < v) {
		swap(data, i, lt);
		lt++;
		i++;
	    }
	    else {
		swap(data, i, gt); 
		gt--;
	    }
	}
	if (lt != 0) qSortH(data, start, lt-1);
	if (gt != data.length-1) qSortH(data, gt, end);
    }

    private static void swap(int[] data, int index1, int index2) {
	int temp = data[index1];
	data[index1] = data[index2];
	data[index2] = temp;
    }
    
    /*
    public static int[] part(int[] data, int start, int end) {
	//This should make the array subdivided into 3 parts: less than pivot, equal to pivot, and greater than pivot, where lt and gt subdivisions are not sorted.
	int pivot = (int)(Math.random() * (end-start) + start);
	int v = data[pivot];
	System.out.println("Pivot Element: "+data[pivot]);
	int lt = start;
	int i = start;
	int gt = end;
	//if (start == end) return;
	swap (data, pivot, end);
	while (i <= gt) {
	    if (data[i] == v) {
		i++;
	    }
	    else if (data[i] < v) {
		swap(data, i, lt);
		lt++;
		i++;
	    }
	    else {
		swap(data, i, gt); 
		gt--;
	    }
	}
	int[] ans = new int[2];
	ans[0] = lt;
	ans[1] = gt;
	return ans;
    }
    */
    public static void main(String[]args) {
	int[] test1 = {1,4,7,5,3,2,4,5,4,8};
	qSortH(test1, 0, test1.length-1);
	String test1Str = "";
	for (int i : test1) {
	    test1Str += i + " ";
	}
	System.out.println(test1Str);
    }
}
