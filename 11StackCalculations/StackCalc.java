import java.util.*;

public class StackCalc {
    public static double eval(String str) {
	String[] values = str.split(" ");
	Stack<String> stack = new Stack<String>();

	for (String element : values) {
	    if (isOp(element)) {
		String do1 = "" + stack.pop();
		String do2 = "" + stack.pop();
		double cal = calculate(element, Double.parseDouble(do1), Double.parseDouble(do2));
		stack.push(""+ cal);
	    }
	    else {
		stack.push(element);
	    }
	}
	return Double.parseDouble(stack.pop());
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
	    
