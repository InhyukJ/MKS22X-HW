import java.util.*;

public class Quiz2Redux{  
    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help(words, s, "",  0);
	Collections.sort(words);
	return words;
    }
    
    private static void help(ArrayList<String> words, String str, String temp, int index){
	if (index >= str.length()) {
	    if (words.indexOf(temp) == -1) words.add(temp);
	    if (words.indexOf(str) == -1) words.add(str);
	    return;
	}
	if (words.indexOf(temp) == -1) words.add(temp);
	help(words, str, temp + str.charAt(index), index+1);
	help(words, str, temp, index+1);
    }
    /*
    public static void main(String[]args) {
	ArrayList<String> test1 = combinations("kji");
	int count = 0;
	for (String str : test1) {
	    System.out.print(str + " ");
	    count++;
	}
	System.out.println(count);
    }
    */
}
