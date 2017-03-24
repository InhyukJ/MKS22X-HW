import java.util.Random;

public class Driver {
    public static void main(String[]args) {
	public static int[] randArray = new int[100];
	Random rand = new Random();
	for (int n : randArray) {
	    n = rand.nextInt();
