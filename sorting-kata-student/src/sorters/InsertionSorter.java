package sorters;

import java.util.Comparator;

import structures.SwapList;

public class InsertionSorter<T> extends AbstractSorter<T> {

	int startIndex;
	int endIndex;
	int count;
	public InsertionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
		startIndex =list.size()-list.size();
		endIndex =list.size()-1;
		count =1;
	}

	@Override
	public SwapList<T> sort() {
		// TODO
		//System.out.println(list.toString());
		//this.insertionSort();
//		for(int i=1;i<list.size();i++){
//			list.
		//}
			this.insertionSort();
				System.out.println(list.isSorted(comparator));
					return list;
			}	
		
		
		
	public void insertionSort(){
		
		int count =1;
		while( count<list.size()){
			
			insertElement(count,0);
			count++;
			
		}
		
	}
	
		private SwapList<T> insertElement(int current,int start){
		//System.out.println(current);
	if(list.size()==0||list.size()==1){
		return list;
	}
	//System.out.println(list.toString());
		boolean finished =false;
			//current =endIndex;
		boolean moreSearch =true;
		
		while(moreSearch & !finished){
			
			//System.out.println(current);
			if( (list.compare(current, current -1, comparator)<0)){
				list.swap(current,current-1);
				current--;
				moreSearch= (current!=startIndex);
			}
			else
				finished =true;
		}
		//System.out.println(list.toString());
		//System.out.println(list.isSorted(comparator));
		//this.insertionSort();
		//System.out.println("here");
		return list;
	}
	

}





