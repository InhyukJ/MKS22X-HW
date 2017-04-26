import java.util.*;

public class StackCalc {
    public static double eval(String str) {
	String[] values = str.split(" ");
	Stack<String> stack = new Stack<String>();
	double ans = 0.0;

	for (String element : values) {
	    if (isOp(element)) {
		String do1 = "" + stack.pop();
		String do2 = "" + stack.pop();
		ans += calculate(element, Double.parseDouble(do1), Double.parseDouble(do2));
	    }
	    else {
		stack.push(element);
	    }
	}
	return ans;
    }

    private static boolean isOp(String str) {
	return (str == "+" ||
		str == "-" ||
		str == "*" ||
		str == "/" ||
		str == "%");
    }

    private static double calculate(String op, double do1, double do2) {
	if (op == "+") return do1 + do2;
	else if (op == "-") return do1 - do2;
	else if (op == "*") return do1 * do2;
	else if (op == "/") return do1 / do2;
	else return do1 % do2;
    }
}
	    
