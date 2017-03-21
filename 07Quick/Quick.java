public class Quick {
    public static void part(int[] data, int start, int end) {
	//This should make the array subdivided into 3 parts: less than pivot, equal to pivot, and greater than pivot, where lt and gt subdivisions are not sorted.
	int pivot = (int)(Math.random() * (end-start) + start);
	System.out.println("Pivot Element: "+data[pivot]);
	int lt = start;
	int i = start;
	int gt = end;
	while (i <= gt) {
	    if (data[i] == data[pivot]) {
		i++;
	    }
	    else if (data[i] < data[pivot]) {
		swap(data, i, lt);
		lt++;
		i++;
	    }
	    else {
		swap(data, i, gt); 
		gt--;
	    }
	}
    }
    
    private static void swap(int[] data, int index1, int index2) {
	int temp = data[index1];
	data[index1] = data[index2];
	data[index2] = temp;
    }
    
    public static int quickSelect(int[] data, int k) {
        
	return 0;
    }

    public static void main(String[]args) {
	int[] test1 = {1,4,7,5,3,2,4,5,4,8};
	//System.out.println("1 4 7 5 3 2 4 5 4 8");
	part(test1, 0, test1.length-1);
	String test1Str = "";
	for (int i : test1) {
	    test1Str += i + " ";
	}
	System.out.println(test1Str);
    }
}
