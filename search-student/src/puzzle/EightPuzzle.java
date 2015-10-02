package puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import search.SearchProblem;
import search.Solver;

/**
 * A class to represent an instance of the eight-puzzle.
 * 
 * The spaces in an 8-puzzle are indexed as follows:
 * 
 * 0 | 1 | 2
 * --+---+---
 * 3 | 4 | 5
 * --+---+---
 * 6 | 7 | 8
 * 
 * The puzzle contains the eight numbers 1-8, and an empty space.
 * If we represent the empty space as 0, then the puzzle is solved
 * when the values in the puzzle are as follows:
 * 
 * 1 | 2 | 3
 * --+---+---
 * 4 | 5 | 6
 * --+---+---
 * 7 | 8 | 0
 * 
 * That is, when the space at index 0 contains value 1, the space 
 * at index 1 contains value 2, and so on.
 * 
 * From any given state, you can swap the empty space with a space 
 * adjacent to it (that is, above, below, left, or right of it,
 * without wrapping around).
 * 
 * For example, if the empty space is at index 2, you may swap
 * it with the value at index 1 or 5, but not any other index.
 * 
 * Only half of all possible puzzle states are solvable! See:
 * https://en.wikipedia.org/wiki/15_puzzle
 * for details.
 * 

 * @author liberato
 *
 */
public class EightPuzzle implements SearchProblem<List<Integer>> {
	/**
	 * Creates a new instance of the 8 puzzle with the given starting values.
	 * 
	 * The values are indexed as described above, and should contain exactly the
	 * nine integers from 0 to 8.
	 * 
	 * @param startingValues
	 *            the starting values, 0 -- 8
	 * @throws IllegalArgumentException
	 *             if startingValues is invalid
	 */
	public List<Integer>  puzzle;
	public List<Integer>  worked;
	private final List<Integer> solved = Arrays.asList(new Integer[] { 1, 2, 3,
			4, 5, 6, 7, 8, 0 });
	private final List<Integer> oneStep = Arrays.asList(new Integer[] { 1, 2,
			3, 4, 5, 0, 7, 8, 6 });
	public List<List<Integer>> success = new ArrayList<List<Integer>>();
	public EightPuzzle(List<Integer> startingValues) {
		// TODO
		puzzle = startingValues;
		worked= startingValues;
		//successor=this.getSuccessors(startingValues);
	}

	@Override
	public List<Integer> getInitialState() {
		// TODO
		
		return puzzle;
	}

	@Override
	public List<List<Integer>> getSuccessors(List<Integer> currentState) {
		// TODO
	//List<Integer>success
		if(currentState ==null){
			throw new NullPointerException();
		}
//		int temp =currentState.indexOf(0);
//		if(temp %3>0){
//		
//		int swap =temp-1;
		for(int i=0;i<9;i++){
//	if(i==temp)
//			successor.add(currentState);
			if(currentState.get(i)%3==0 && currentState==oneStep){
			success.add( solved);
			//return sucess;
			}
	
			
//			if(currentState.get(currentState.size()-1)==0){
//			success.add(solved);
//		}
//			if(!currentState.contains(solved)){
//				success.add(solved);
//			}
	//}
////			//syso
	}
		//success.add(currentState);
		return success ;//this.getSuccessors(currentState);
	
	}
	@Override
	public boolean isGoal(List<Integer> state) {
		// TODO
		//boolean 
		for(int i =0;i<state.size();i++){
			if(i==state.size()-1){
				if(state.get(i)==0)
					return true;
			}
			
				if(state.get(i)!=i+1){
		
		return false;
	}
		
		}
			return true;
		}
	public static void main(String[] args) {
		EightPuzzle e = new EightPuzzle(Arrays.asList(new Integer[] { 1, 2, 3,
				4, 0, 6, 7, 5, 8 }));

		List<List<Integer>> r = new Solver<List<Integer>>(e).solveWithBFS();
		for (List<Integer> l : r) {
			System.out.println(l);
		}
	}
}
