package lists;

import java.util.Iterator;

public class LLNode<T> implements Iterable<T> {
	private T info;
	private LLNode<T> next;
	
	public LLNode(T info) {
		this.info = info;
		setNext(null);
	}

	public T getInfo() {
		return info;
	}

	public LLNode<T> getNext() {
		return next;
	}

	public void setNext(LLNode<T> next) {
		this.next = next;
	}

	@Override
	public Iterator<T> iterator() {		
		return new ListIterator(this);
	}
	
	@Override
	public String toString() {
		String rest = "";
		if (getNext() != null) {
			rest = " " + getNext().toString();
		}		
		return this.getInfo().toString() + rest;
	}
	
	private class ListIterator implements Iterator<T> {
		private LLNode<T> node;
		ListIterator(LLNode<T> head) {
			node = head;
		}
		@Override
		public boolean hasNext() {
			return node != null;
		}
		@Override
		public T next() {
			T info = node.getInfo();
			node = node.getNext();
			return info;
		}
		
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
	}
}
