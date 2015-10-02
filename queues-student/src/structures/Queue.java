package structures;

import java.util.NoSuchElementException;

public class Queue<T> implements UnboundedQueueInterface<T> {
	
	protected  int DEFCAP = 100;
	protected T [] queue;
	protected int origCAP;
	protected int numElements =0;
	protected int front =0;
	protected int rear = -1;
	protected T [] reversed;
	protected T [] copy;
	protected Queue<T> clone;
	protected int count=0; 
	
	
	
	@SuppressWarnings("unchecked")
	public Queue() {
		// TODO 1
		queue = (T[]) new Object [DEFCAP];
		reversed = (T[]) new Object [queue.length];
		copy = (T[]) new Object [queue.length];
		rear = DEFCAP-1;
		origCAP = DEFCAP;
		
		//reversed = queue;
	}
	

	@SuppressWarnings("unchecked")
	public Queue(Queue<T> other) {
		// TODO 2
		// Hint: Maybe save this one until after you finish enqueue()/dequeue()
		queue = (T[]) new Object [other.queue.length];
		for(int i=0; i<other.queue.length;i++){
			queue[i]=other.queue[i];
		}
		front = other.front;
		rear = other.rear;
		numElements = other.numElements;
		//this.tail()=other.tail();

	}
	public void Copythis (){
		for(int i=0; i<queue.length;i++){
			copy[i]=queue[i];
		}
	}
	
	
	@Override
	public boolean isEmpty() {
		// TODO 3
		return  numElements==0; //queue.length ==0;
				
	}
	public void printQueue(){
		for(int i =0; i <queue.length;i++){
			System.out.print(queue[i]);
		}
	}

	@Override
	public int size() {
		// TODO 4
		if(numElements==0){
			return numElements;
		}
		return  numElements;//(queue.length + rear - front + 1) % queue.length;//numElements; //queue.length;
	}
	
	public void enlarge(){
		//increments the capacity of the queue by an amount
		//equal to the original amount
		
		//create the larger array
		@SuppressWarnings("unchecked")
		T[] larger = (T[]) new Object [queue.length *2];
		
		//copy contents from smaller array into the larger array
		int currSmaller = front;
		for(int currlarger=0; currlarger <numElements; currlarger++){
			larger[currlarger] =queue[currSmaller];
			currSmaller = (currSmaller +1) % queue.length;
			//the above line should be equiv to:
			//curSmaller++;
		}
		queue = larger;
		front =0;
		rear = numElements -1;
		
	}
	
	@Override
	public void enqueue(T element) {
		// TODO 5;
//		if(rear+1==queue.length){
//    		int biggersize = queue.length *2;
//    		@SuppressWarnings("unchecked")
//			T queue2 [] = (T []) new Object[biggersize];
//    		for(int t=0; t<queue.length; t++){
//    			queue2[t]=queue[t];
//    		}
//    		DEFCAP = biggersize;
//    		queue = queue2;
//    	}
//   rear++; 
//    	
//    queue[rear]=element;
//    numElements++;
		if(numElements == queue.length)
				enlarge();
		//rear++;
		rear = (rear + 1) % queue.length;
		queue[rear]=element;
		//reversed=queue;
		numElements= numElements+1;
		
		//this.printQueue();
	
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		// TODO 6;
		if(isEmpty()){
			throw new NoSuchElementException("Dequeue attempted on empty queue");	
		}
			else{
			T dequed = queue[front];
			queue[front] =null;
			front = (front+1)% queue.length;
			numElements = numElements -1;
			return dequed;
		}
	}

	@Override
	public T peek() throws NoSuchElementException {
		// TODO 7
		if(isEmpty()){
			throw new NoSuchElementException("Can't peek on empty queue");
		}
		else
			//this.printQueue();
			return queue[front];
	}

	public T tail() throws NoSuchElementException {
		// TODO 7
		if(isEmpty()){
			throw new NoSuchElementException("Can't peek on empty queue");
		}
		else
			//this.printQueue();
			return queue[queue.length-1];
	}
	
	
	
	
	@Override
	public UnboundedQueueInterface<T> reversed() {
		// TODO 8
		// Hint: Maybe save this one until after you finish enqueue()/dequeue()
	//copy queue contents into reversed 
		Queue<T> newQ = new Queue<T>(this);
		newQ.front =queue.length-1;
		newQ.rear = -1;
//		for(int i=0; i< queue.length;i++){
//		
//			//if(queue[i]!=null)
//			reversed[i]=queue[i];	
//	}
		//this.reversed=queue;
		for (int k = 0; k < newQ.queue.length/2; k++) {
	            T temp =newQ.queue[k];
	            newQ.queue[k] = newQ.queue[newQ.queue.length-(1+k)];
	            newQ.queue[newQ.queue.length-(1+k)] = temp;
	          }
//		for(int z =0; z <reversed.length;z++){
//			System.out.print(reversed[z]);
//		}
//		if(reversed[reversed.length-1]==queue[0]){
//			return this.reversed
	//	}
		//System.out.print(clone.);
		
		//newQ.printQueue();
		
		return newQ;//.reversed();  //.reversed();
	}
}

