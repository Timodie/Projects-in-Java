package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImplementation<T> implements ListInterface<T>  {

	private Node<T>head= null;
	private Node<T>tail =null;
	public int size=0;
	Node<T>current;
	
//	public ListImplementation(T t) {
//		// TODO Auto-generated constructor stub
//	head = new Node<T>(t,null);
//	}
//	private ListImplementation(Node<T>head){
//		this.head = head;
//	}
//	
	
	@Override
	
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return tail==null;
	}

	@Override
	public T get(int n) throws NoSuchElementException {
		// TODO Auto-generated method stub
		//int j=0;
		if(n>=size || n<0)
			throw new NoSuchElementException();
		
		else
			current=head;
//			while(current!=null){
//				current = current.getNext();
//				System.out.println(current.getData());
//				j++;
//				
//		if(j==n){
//				
//		return current.getData();
//			}
			
		for(int j = 0; j <= n;j++){
			
			
			if(j==n){
				//current = current.getNext();
				return current.getData();
			}
			current = current.getNext();
		}
		return current.getData();
	}
		

	@Override
	public ListInterface<T> append(T elem) {
		// TODO Auto-generated method stub
		//tail = new Node<T>(elem,null);
		Node<T>temp =new Node<T>(elem,null);
		if(elem ==null){
			throw new NullPointerException();
		}
		else if(head == null){
		//temp.setNext(head);
		head = temp;
		tail = temp;
		size++;
		}
			else{
				
//				Node<T>last = new Node<T>(elem,null);
//				Node<T>current = head;
//				while(current.getNext()!=null){
//					current =current.getNext();
//				}
//				//head.setNext(last);
//				current.setNext(last);
				tail.setNext(temp);
				tail =temp;
				size++;
			}
//	//Iterator<T>iter = ((ListInterface<T>) temp).iterator();
//		//while(iter.hasNext())
//	Node<T>current = head;
//	while(current!=null){
//		current = current.getNext();
//	}
//	current.setData(temp.getData());
		
	return this;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new NodeIterator<T>(head);
	}

}
