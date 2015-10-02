package sorters;

import java.util.Comparator;

import structures.SwapList;

public class HeapSorter<T> extends AbstractSorter<T> {

	public HeapSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		// TODO
		this.heapSort();
		System.out.println(list.isSorted(comparator));
		System.out.println(list.toString());
		return list;
	
	}
	
	 void heapSort () {
int index ;
//System.out.println(list.toString());
for ( index = list.size() /2 -1 ; index >=0; index -=1) {
	
reheapDown ( index , list.size() ); 
}
System.out.println(list.toString());
for ( index = list.size() -1; index >= 1; index -=1) {
list.swap (0 , index );
reheapDown (0 , index ); } 
}
	
	
	 private void reheapDown ( int i , int size ) {
		//System.out.println(i);
		 
		 int l = 2 * i + 1;
		 int r = 2 * i + 2;
		 if ( l >= size) { 
	return ; 
}
int big = l ;
if ( r < size&&  list.compare( r ,l ,comparator)>0 )
{
  
big = r ;
//reheapDown(big,size);
}
if (  list.compare(i, big, comparator)<0 ) {
	list.swap ( big , i );
		reheapDown ( big , size );
}
}
	
	
}
