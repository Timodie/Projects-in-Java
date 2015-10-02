package stack;

public class ResizingArrayStack<T> implements Stack<T> {
    private T[] stack;
    private int size ;
    private int topIndex = -1;
    private T[] current;
    private int pos =0;
    /**
     * Creates a new ResizingArrayStack.
     * @param initialCapacity the initial length of the backing array for the
     *        stack
     */
    @SuppressWarnings("unchecked")
	public ResizingArrayStack(int initialCapacity) {
    	// TODO 1
    	//this.topIndex=initialCapacity;
    	size =initialCapacity;
    	stack = (T []) new Object[size];   //changed from initial capacity
    }

	@Override
	public T pop() throws StackUnderflowException { // looks good but doesnt
													// work bcuz of push
		// TODO 2
		if (isEmpty()) {
			throw new StackUnderflowException("Pop attempted on an empty stack");

			
		}
		
		
		//System.out.print(topIndex+",");
	T temp = stack[topIndex];
	topIndex--;
//		System.out.println("size: "+size);
//		System.out.println("top: "+ topIndex);
		if (topIndex +1 == size / 4 && size>1) {
			int smallersize = size / 2;
			T stack3[] = (T[]) new Object[smallersize];
			//assert stack.length == size;
			for (int t = 0; t <= stack.length/4; t++) {
				stack3[t] = stack[t];
			}
			size = smallersize;
			stack = stack3;
		}
		
		//System.out.println(temp);
		return temp; //stack[temp];
	}
	public void printStack(){
		for(int i =0; i<stack.length; i++){
			System.out.print(stack[i]);
		}
	}
    @Override
    public T peek() throws StackUnderflowException { //works fine but requires push to pass other test
    	// TODO 3
    	if(isEmpty()){
    		throw new StackUnderflowException();
    	}
    	printStack();
    	return stack[topIndex];
    }

    @Override
    public void push(T element) {  // push is passing test but its not working
    	// TODO 4
    
    	
    	if(topIndex+1==size){
    		int biggersize = size *2;
    		T stack2 [] = (T []) new Object[biggersize];
    		for(int t=0; t<stack.length; t++){
    			stack2[t]=stack[t];
    		}
    		size = biggersize;
    		stack = stack2;
    	}
   topIndex++; 
    	
    stack[topIndex]=element;
    
    }

    @Override
    public boolean isEmpty() {
    	if(topIndex==-1)
    		return true;
    	else
    	return  false; //size()==0;//topIndex==-1;//size() == 0; //this is also returning true;
    }

    @Override
    public int size() {
//    	for(int t=0; t<stack.length; t++){
//    		if(stack[t]!=null){
//    			pos++;
//    	}
    	//}
    	return topIndex+1;
    }

    @Override
    public int capacity() {
    	// TODO 5
    	return stack.length;
    }
}
