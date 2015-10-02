package sets;

import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedNodeIterator<E> implements Iterator<E> {
  // TODO (1) choose appropriate attributes
	private Iterator<E> iter;
	public LinkedNode<E> head;
	private LinkedNode<E> cur;
	private int size;
	
 
	// Constructors
	  public LinkedNodeIterator(LinkedNode<E> e){
		  this.head = e;
		  this.cur =head;
		  //this.iter =e;
	  }
		 
	 
  @Override
  public boolean hasNext() {
    // TODO (3)
    return cur!=null;
  }

  @Override
  public E next() {
    // TODO (4)
	  if(!hasNext())
    throw new NoSuchElementException();
	  
	E data = this.cur.getData();
      this.cur = cur.getNext();
      return data;
	  }

  // Leave this one alone.
  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}
