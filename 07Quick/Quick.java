public class Quick {
    public static void part(int[] data, int start, int end) {
	//-Choose a random element to be a pivot, and partition the array around it. 
	//-Only partition the elements from start to end inclusive.
	//-When done returns the index of the final position of the pivot element.      
	//    (Should be from start to end inclusive)	
	int pivot = (int)(Math.random() * (end-start) + start);
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
	swap()
    }
    
    private void swap(int[] data, int index1, int index2) {
	int temp = data[index1];
	data[index1] = data[index2];
	data[index2] = temp;
    }
    
    public static int quickSelect(int[] data, int k) {
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
	return 0;
    }

    public static void main(String[]args) {
	int[] test1 = {0,3,6,2,2,4,1};
	System.out.println(part(test1,0,6));
	String test1Str = "";
	for (int i : test1) {
	    test1Str += i + ", ";
	}
	System.out.println(test1Str);
    }
}
