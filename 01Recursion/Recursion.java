public class Recursion {
    public static String name() {
	return "Jun,Inhyuk";
    }
    
    public static double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException("You cannot take a square root of a negative number!");
	}
	if (n == 0.0) {
	    return 0.0;
	}
	return sqrtHelper(n, 1.0);
    }
    
    private static double sqrtHelper(double n, double guess) {
	if (isCloseEnough((guess * guess), n)) {
	    return guess;
	}
	else {
	    double better_guess = (n / guess + guess) / 2;
	    return sqrtHelper(n, better_guess);
	}
    }
    
    private static boolean isCloseEnough(double a, double b) {
        double difference = Math.abs(a - b);
	double average = (a + b) / 2;	
	double perDifference = difference / average;
	return (perDifference < 0.00000001); //10^-8%
    }

    /* Tested code
    public static void main(String[]args) {
	System.out.println(name());

	double[] squares = {1.0, 4.0, 9.0, 16.0, 25.0, 36.0, 49.0, 64.0};
	for (double square : squares) {
	    System.out.println(sqrt(square));
	}

	System.out.println("\n");
	
	for (double n = 1.0;n < 10.0;n += 1.0) {
	    System.out.println(sqrt(n));
	}

	System.out.println(sqrt(0.0));
	//System.out.println(sqrt(-1.0));

	System.out.println("\n");

	for (double n = 0.0;n < 1.0;n += 0.1) {
	    System.out.println(sqrt(n));
	}
    }
    */
}
