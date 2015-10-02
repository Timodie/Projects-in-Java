package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

class NodeIterator<T> implements Iterator<T> {
//similar to iterator used in sets projects
	private Iterator<T> iter;
	public Node<T> head;
	private Node<T> cur;
	private int size;

	// Constructors
	public NodeIterator(Node<T> e) {
		this.head = e;
		this.cur = head;
		// this.iter =e;
	}

	@Override
	public boolean hasNext() {
		// TODO (3)
		return cur != null;
	}

	public T next() {
		// TODO (4)
		if (!hasNext())
			throw new NoSuchElementException();

		T data = this.cur.getData();
		this.cur = cur.getNext();
		return data;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
