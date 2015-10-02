package stacks;

public class LinkedListStack<T> implements Stack<T> {
    LLNode<T> head;

    public LinkedListStack() {
        head = null;
    }

    @Override
    public T pop() throws StackUnderflowException {
       if(head==null)throw new StackUnderflowException();
    	  T tim = head.getInfo();
       		head=head.getLink();
       
    	return tim;
    }

    @Override
    public T peek() throws StackUnderflowException {
       if(head==null)new StackUnderflowException();
    	T t = head.getInfo();
    	
       return t;
    	
    }

    @Override
    public void push(T element) {
    	if(head==null){
    		head.setInfo(element);
    	}
    	else{
    	LLNode<T> node = new LLNode<T>(element);
    	node.setLink(head);
    	//head= new LLNode<T>(element);
    	//head.setLink(node);
    	head = node;
    }
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }
}
