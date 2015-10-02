package structures;

import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T>{

	public Node<T> head =null;
	
	public int size =0;
	
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public ListInterface<T> insertFirst(T elem) {
		// TODO Auto-generated method stub
		//throw NPE if the incoming elem has a null value
		if(elem == null){
			throw new NullPointerException("Incoming element has null value");
		}
		//increase size if the elem can be added
		size++;
		//store the incoming elem which is the first node in a temp variable and point it to head
		
		Node<T>temp = new Node<T>(elem);
		
		temp.next=head;
		head=temp;
		return this;
	}

	@Override
	public ListInterface<T> insertLast(T elem) {
		// TODO Auto-generated method stub
		//simply use insertAt to put the elem at the the last postiton
		//which is the current size
		return this.insertAt(size,elem);
	}

	@Override
	public ListInterface<T> insertAt(int index, T elem) {
		// TODO Auto-generated method stub
		if(elem == null){
			throw new NullPointerException("Incoming element has null value");
		}
		//System.out.println(index);
		if( index <0 || index >size){
			throw new IndexOutOfBoundsException("index outta bounds");
		
		}
		//if the elem is 0,call insert first, to set the elem 
		//as the new head. the size will be increased as well
		if(index==0){
			return this.insertFirst(elem);
		}
		//if index ain't zero do the ff
		else{
			size++;
			//store incoming elem in a temp 
		
			Node<T>temp = new Node<T>(elem);
			//find previous Node
			//System.out.println(index);
			Node<T> prev = insertHelper(index-1,head);
			//set incoming node's link to previous node's link
			temp.next = prev.next;
			//set previous node's link to the incoming elem
			prev.next = temp;
			
		
		return this;
	}
	}
//to enable insertion at any node ,we need to find previous node
	//to set its next to the new elem
	public Node<T> insertHelper(int index,Node<T> found){
		if( index <0 || index >size){
			throw new IndexOutOfBoundsException("index outta bounds");
		}
		
		if(index==0){
			return found;
		}
		else{
			return this.insertHelper(index-1,found.next);
		}
	}
	
	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new IllegalStateException("Cannot remove from  empty list");
		}
		else{
			size--;
	
			T removed = head.getData();
			
			head= head.next;
			
			return removed;
		}
		
	}

	
	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		if(this.isEmpty()){
			throw new IllegalStateException();
	}
		else{
		
		return this.removeAt(size-1);
		}
	}
	@Override
	public T removeAt(int i) {
		// TODO Auto-generated method stub
		if(i<0 || i>=size){
			throw new IndexOutOfBoundsException("index outta bounds");
		}
		size--;
	//Should return the current head	
		if (i == 0) {
		
			T remove = head.data;
	
			head = head.next;
			
			return remove;
		}
		else{
			
			
			Node<T>prev = this.insertHelper(i - 1,head);
			
			Node<T>remove = prev.next;
			
			prev.next = remove.next;
			
			return remove.data;
				
			}
	}
	

	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		if(this.isEmpty()){
			throw new IllegalStateException("the list is empty");
		}
		else{
			
		
		return this.get(0);
	}
	}
	@Override
	public T getLast() {
		// TODO Auto-generated method stub
		if(this.isEmpty()){
			throw new IllegalStateException("the list is empty");
		}
		else{
		return this.get(size-1);
		}
	}
	@Override
	public T get(int i) {
	
		if(i<0 || i>=size){
			throw new IndexOutOfBoundsException("index outta bounds");
		}
		else{
		Node<T>target = this.insertHelper(i,head);
		
		return target.data;
		}
	}
	@Override
	public boolean remove(T elem) {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new NullPointerException("empty list");
		}
		int i= this.indexOf(elem);
		if(i==-1){
			return false;
		}
		else{
			removeAt(i);
		return true;
		}
	}
	@Override
	public int indexOf(T elem) {
		// TODO Auto-generated method stub
		if(elem == null){
			throw new NullPointerException(" element has null value");
		}
		else{
		
			return this.indexOfHelper(elem,0, head);
		}
	}
	private int indexOfHelper(T elem, int index, Node<T> node) {
		
		if (node == null)
			return -1;
		
		if (node.data.equals(elem))
			return index;
		else{

		return indexOfHelper(elem, index + 1, node.next);
		}
	
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head==null;
	}

	

	
}