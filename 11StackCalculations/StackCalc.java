import java.util.*;

public class StackCalc {
    private static boolean isOp(String str) {
	return (str.equals("+") ||
		str.equals("-") ||
		str.equals("/") ||
		str.equals("*") ||
		str.equals("%"));
    }

    private static double calc(String op, double do1, double do2) {
	if (op.equals("+")) return do2 + do1;
	else if (op.equals("-")) return do2 - do1;
	else if (op.equals("/")) return do2 / do1;
	else if (op.equals("*")) return do2 * do1;
	else return do2 % do1;
    }

    public static double eval(String str) {
	String[] values = str.split(" ");
	Stack<String> stk = new Stack<String>();

	for (String s : values) {
	    if (isOp(s)) {
		stk.push(calc(s, Double.parseDouble(stk.pop()), Double.parseDouble(stk.pop())) + "");
	    }
	    else {
		stk.push(s);
	    }
	}
	return Double.parseDouble(stk.pop());
    }

    public static void main(String[]args) {
	System.out.println(StackCalc.eval("108 212 + 525 -"));
	System.out.println(StackCalc.eval("108 212 +"));
	System.out.println(StackCalc.eval("310 525 -"));
	
    }
}
