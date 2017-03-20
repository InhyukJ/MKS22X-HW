public class Partition {
    public static int part(int[] data, int start, int end) {
	int pivotElement = data[(int)(Math.random() * (end - start) + start)];
	int pIndexS = start;
	int pIndexE = end;
	boolean isDone = false;
	while (pIndexS != pIndexE) {
	    while (data[pIndexS] < pivotElement) pIndexS++;
	    while (data[pIndexE] >= pivotElement) pIndexE--;
	    swap(data, pIndexS, pIndexE);
	    pIndexS++;
	    pIndexE--;
	}
	return pIndexS;
    }

    private static void swap(int[] data, int index1, int index2) {
	int temp = data[index1];
	data[index1] = data[index2];
	data[index2] = temp;
    }
}
