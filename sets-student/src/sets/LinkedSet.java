package sets;

import java.util.Iterator;

public class LinkedSet<E> implements Set<E> {
  private LinkedNode<E> head = null;
  private int size;
  private int count;
  private Set<E> set;
  private Set<E> temp;
  private Set<E> that;
  Iterator<E> iter = this.iterator();
  // Constructors
  public LinkedSet() {
	   
  }
  

  public LinkedSet(E e) {
    head = new LinkedNode<E>(e ,null );
  }

  private LinkedSet(LinkedNode<E> head) {
    this.head = head;
  
  }

  
  
  @Override
  public int size() {
    // TODO (1)
	
	 for(E e : this){
	size++;
  if(size >= Integer.MAX_VALUE)
	  return Integer.MAX_VALUE;
	 }
	 
	 
	    return size;
  }
	  

  @Override
  public boolean isEmpty() {
    // TODO (2)
	  /*if(set.equals(null)){
		  return true;
	  }*/
    
	  return head==null;
  }

  @Override
  public Iterator<E> iterator() {
    return new LinkedNodeIterator<E>(this.head);
  }

  @Override
  public boolean contains(Object o) {
    // TODO (3)
	  
	  LinkedNode<E>current = head;
	  while(current!=null){
		 if(current.getData().equals(o)){
			 return true;
		 }
		 current = current.getNext();
	  }
	  
		 return false;
  } 
	 
	  
	 
 @Override
  public boolean isSubset(Set<E> that) {
    // TODO (4)
	 if((this.size() > that.size())){
		 return false;
	 }
	 for(E e :this){
			
		  if((!that.contains(e)))
			  return false;
	  }
			  
			  return true;
  }

  @Override
  public boolean isSuperset(Set<E> that) {
    // TODO (5)
	  if((this.size() < that.size())){
			 return false;
		 }
		 for(E e :that){
				
			  if((!this.contains(e)))
				  return false;
		  }
				  
				  return true;
	  }
	
   
  

  @Override
  public Set<E> adjoin(E e) {
    // TODO (6)

	
		LinkedNode<E>element = new LinkedNode<E>(e,head);
		
		set =new LinkedSet<E>(element);
	  
	  
    return set;
  }

  @Override
  public Set<E> union(Set<E> that) {
    // TODO (7)
	 LinkedSet<E>append = new LinkedSet<E>(head);
	 
	  for(E t : that){
		  if(!this.contains(t)){
			  append =(LinkedSet<E>) append.adjoin(t);
		  }
			  
	  }
	  return append;
  }
	  /*LinkedNode<E>current = head;
	  while(current!=null){
		  append.adjoin(current.getData());
		  current = current.getNext();
	  }
	  Iterator<E>union = that.iterator();
	  while(union.hasNext())
	  append.adjoin(union.next());
	  return append;*/
	  

  @Override
  public Set<E> intersect(Set<E> that) {
    // TODO (8)
	  LinkedSet<E> temp = new LinkedSet<E>();
	  
	  for(E e : that) {
		  if(this.contains(e))
			temp= (LinkedSet<E>) temp.adjoin(e); 
	  }
	  return temp;
	  }
	  
	  
	

  @Override
  public Set<E> subtract(Set<E> that) {
	  LinkedSet<E>append = new LinkedSet<E>(head);
		 
	  for(E t : that){
		  if(append.contains(t)){
			  append =(LinkedSet<E>) append.remove(t);
		  }
			  
	  }
	  return append;
  }
	  
    // TODO (9)
	  /*LinkedSet<E> temp = new LinkedSet<E>();
	  LinkedSet<E> mysect = new LinkedSet<E>();
	  LinkedSet<E> subtract =new LinkedSet<E>();
	  LinkedNode<E>current = head;
	  while(current!=null){
		  temp.adjoin(current.getData());
		  current = current.getNext();
	  }
	  Iterator<E>common = that.iterator();
	  while(common.hasNext()){
		  mysect.adjoin(common.next());
		  }
	  
	  Iterator<E> one = temp.iterator();
	  Iterator<E> two = mysect.iterator();
	  while(one.hasNext()){
	  	while(two.hasNext())
		  if(!one.next().equals(two.next())){
			  
			  subtract.adjoin(two.next());
		  }*/
		  
	

  @Override
  public Set<E> remove(E e) {
    // TODO (10)
	  LinkedSet<E>remove = new LinkedSet<E>();
	  for(E del : this)
		  if(!del.equals(e))
			  remove =(LinkedSet<E>) remove.adjoin(del);
    return remove;
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    if (! (o instanceof Set)) {
      return false;
    }
    Set<E> that = (Set<E>)o;
    return this.isSubset(that) && that.isSubset(this);
  }

  @Override
    public int hashCode() {
    int result = 0;
    for (E e : this) {
      result += e.hashCode();
    }
    return result;
  }
}
