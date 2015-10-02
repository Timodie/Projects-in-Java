package lists;

public class List<T> {
	private LLNode<T> head;

	/**
	 * Add a node containing elem to the end of this list.
	 * @param elem
	 */
	public void addToTail(T elem) {
		LLNode<T> newTail = new LLNode<T>(elem);
		head = addToTailHelper(newTail, head);
	}

	/**
	 * Returns a reference to lst, with newTail appended.
	 * 
	 * @param newTail
	 * @param lst
	 * @return
	 */
	private LLNode<T> addToTailHelper(LLNode<T> newTail, LLNode<T> lst) {
		if (lst == null) {
			return newTail;
		}
		else {
			LLNode<T> first = lst;
			LLNode<T> rest = addToTailHelper(newTail, lst.getNext());
			first.setNext(rest);
			return first;
		}
	}

	/**
	 * Reverses this list.
	 */
	public void reverse() {
		head = reverseHelper(head);
	}

	/**
	 * Returns a reference to the reversed version of lst.
	 * 
	 * This method destructively modifies lst!
	 * 
	 * @param lst the list to reverse
	 * @param rev the partially-reversed list
	 * @return a reference to the fully reversed list
	 */
	private LLNode<T> reverseHelper(LLNode<T> lst) {
		if (lst == null) {
			return null;
		}
		LLNode<T> first = lst;
		LLNode<T> rest = lst.getNext();
		first.setNext(null);
		return addToTailHelper(first, reverseHelper(rest));
	}

	@Override
	public String toString() {
		if (head == null) {
			return "empty!";
		}
		return head.toString();
	}

	public static void main(String[] args) {
		List<Integer> l = new List<Integer>();
		System.out.println(l);

		l.addToTail(1);
		l.addToTail(2);
		l.addToTail(3);
		System.out.println(l);

		l.reverse();
		System.out.println(l);
	}

}
