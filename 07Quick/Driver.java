public class Driver {
    public static String print(int[] array) {
	String ans = "[";
	for (int n = 0;n < array.length;n++) {
	    if (n == array.length-1) return ans += array[n] + "]";
	    else {ans += array[n] + ", ";}
	}
	return ans;
    }
    
    public static void main(String[]args) {
	//Random Array
	int[] randAry1 = new int[1000];
	for (int n = 0;n < randAry1.length;n++) {
	    randAry1[n] = ;
	}

	Quick.quickSort(randAry1);
	System.out.println(print(randAry1));

    }
}

	
