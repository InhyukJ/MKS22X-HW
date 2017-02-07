public class Recursion {
    public static String name() {
	return "Jun,Inhyuk";
    }
    
    public static double sqrt(double n) {
	if (n <= 0) {
	    throw new IllegalArgumentException("You cannot take a square root of a negative number!");
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
}
