public class MyDeque {
    private ArrayList<String> deque;
    private int size, firstIndex, lastIndex;

    /*
    public MyDeque(ArrayList<Integer> ary) {
	while (ary.length > size) {
	    size += size;
	}
	for ()
	if (ary.length > size) {
	    size += size;
    */

    public MyDeque() {
	deque = new ArrayList<String>();
	size = 10;
	firstIndex = 0;
	lastIndex = 0;
    }

    public void addFirst(String str) {
	if (str == null) throw new NullPointerException();
	else {
	    if (firstIndex - 1 < 0 && deque[size-1] != null) {
		size += size;
		
