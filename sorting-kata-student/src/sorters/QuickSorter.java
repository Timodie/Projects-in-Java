package sorters;

import java.util.Comparator;

import structures.SwapList;

public class QuickSorter<T> extends AbstractSorter<T> {

	int startIndex;
	int endIndex;
	
	public QuickSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
		startIndex =list.size()-list.size();
		endIndex =list.size()-1;
	
	}

	@Override
	public SwapList<T> sort() {
		// TODO
		System.out.println(list.toString());
		if(list.size()<2){
			return list;
		}
		/*
		 * Note: When choosing a pivot, choose the element in the middle of
		 * the sub-array. That is,
		 * 
		 * pivotIndex = (firstIndex + lastIndex) / 2;
		 */
		//System.out.println(list.toString());
		//this.split(startIndex, endIndex);
		this.quickSort(startIndex,endIndex);
		//System.out.println(list.isSorted(comparator));
		System.out.println(list.toString());
		//System.out.println();
		//System.out.println(list.isSorted(comparator));
	//this.split(startIndex, endIndex);
		System.out.println(list.isSorted(comparator));
		return list;
		}

//	private void quickSort(int lowerIndex, int higherIndex) {
//        
//        int i = lowerIndex;
//        int j = higherIndex;
//        // calculate pivot number, I am taking pivot as middle index number
//        int pivot = lowerIndex+(higherIndex-lowerIndex)/2;
//        // Divide into two arrays
//        while (i <= j) {
//            /**
//             * In each iteration, we will identify a number from left side which
//             * is greater then the pivot value, and also we will identify a number
//             * from right side which is less then the pivot value. Once the search
//             * is done, then we exchange both numbers.
//             */
//            while ((list.compare(i , pivot,comparator)<0)) {
//                i++;
//            }
//            while ((list.compare(i , pivot,comparator)>=0)) {
//                j--;
//            }
//            if (i <= j) {
//                list.swap(i, j);
//                //move index to next position on both sides
//                i++;
//                j--;
//            }
//        }
//        // call quickSort() method recursively
//        if (lowerIndex < j)
//            quickSort(lowerIndex, j);
//        if (i < higherIndex)
//            quickSort(i, higherIndex);
//    }
//- See more at: http://www.java2novice.com/java-sorting-algorithms/quick-sort/#sthash.ncUMlAaV.dpuf

 private void quickSort ( int first , int last ) {
if ( first < last ) {
	int splitPoint = split ( first , last );
	quickSort ( first , splitPoint - 1);
		quickSort ( splitPoint + 1 , last ); 
}
 }

 	private int split(int first,int last){
 		int pivot =(last+first)/2;
 		
 		list.swap(pivot,last);
 		pivot = last;
 		int nSwap =first;
 		for(int i=first; i< last;i++)
 			if(list.compare(i,pivot,comparator)<=0){
 				list.swap(i,nSwap);
 				nSwap++;
 			}
 			
 			list.swap(nSwap, last);
 			System.out.println("im here");
 	return nSwap;
 	}
/*
  static int split(int[] array, firstIndex, lastIndex) {
  // note about choice
  int splitIndex = firstIndex + lastIndex / 2;
  int splitValue = array[splitIndex];
  
  // move splitValue out of the way
  swap(array, splitIndex, lastIndex);
  
  // move all values smaller than the splitValue to the
  // front of the array
  int nextSwapIndex = firstIndex;
  for (int i = firstIndex; i < lastIndex; i++) {
    if (array[i] <= splitValue) {
      swap(array, i, nextSwapIndex);
      nextSwapIndex++;
    }
  }
  
  // return the splitValue to the space right after the
  // values smaller than it
  swap(array, nextSwapIndex, lastIndex);
  
  // and tell the caller where the splitValue ended up
  return nextSwapIndex;
}
 */
 	
//private int split ( int first , int last ) {
//
////	for(int i=0;i<list.toString().length()-1;i++){
////	if(i==0){
////		first =list.toString().charAt(i);
////	}
////}
//	int splitV =first;//(first+last)/2;
//	 int saveF = first;//(first+last)/2 ;
//	
//	first++;
//	//list.swap(splitV, first);
//	
//
//	do {
//			//correct = true;
//	while ( first <= last &&list.compare(first,splitV,comparator)<=0){
//			first++;
//				//list.swap(first, saveF);
//		
//			
//	}
// 
//	while (first <= last &&list.compare(first,splitV,comparator)>=0){
//		last--;
//	}
////			if(list.compare(last, splitV,comparator)<=0)  /*values [ last ]list.compare( first,splitV,comparator)>=0 */ 
////				correct =false;
////			else{
////				last--;
////				correct =(first <=last);
////			}
//	//System.out.println(list.toString());
//		
//if ( first <=last ) {
////System.out.println(list.toString());
//	list.swap ( first , last );
//
//	first ++;
//
//	last --; 
//	}
//}
//	while ( first <= last );
////System.out.println(list.toString());
//	list.swap ( saveF , last );
//	//System.out.println();
//	splitV =last;
//	
//return last ; 
//}







}