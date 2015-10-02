package search;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Stack. This results in a
 * depth-first search.
 * 
 */
public class StackBasedDepthFirstSearcher<T> extends Searcher<T> {
	//protected UnweightedGraphInterface<String> graph;
    //protected GraphMarker<String> marker;
	public List<T> states;
	public List<T> predecessors;
	public Stack<T> stack;
	final List<T> path ;
	boolean visit;
	boolean cont;
	boolean status;
	boolean yi;
	
	public StackBasedDepthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
		stack = new Stack<T>();
		states =new ArrayList<T>();
		 predecessors = new ArrayList<T>();
		 path = new ArrayList<T>();
	}

	@Override
	public List<T> findSolution() {
		// TODO
		if (solution != null) 
			return solution;
		

		 
		// add the initial state to the list of states and predecessors
		states.add(searchProblem.getInitialState());
		stack.add(searchProblem.getInitialState());
		// initially it is marked as its own predecessor, but this is updated
		// in the recursive helper
		predecessors.add(searchProblem.getInitialState());
		
		//List<T> path = new ArrayList<T>();
		boolean empty =stack.isEmpty();
		while(!empty){
			T state = stack.pop();
		//path.add(state);
			boolean goal =searchProblem.isGoal(state);
			if(goal){
				//System.out.println("path here"+path.size());
				//System.out.println("stack here"+stack.size());
				stack.push(state);
				break;
			}
			 visit =visited.contains(state);
			if(!visit)
				visited.add(state);
			List<T> offspring =searchProblem.getSuccessors(state);
			for( T nxtdor : offspring){
			cont =visited.contains(nxtdor);
				if(!cont){
					 status = states.contains(nxtdor);
					if(!status){
						states.add(nxtdor);
						predecessors.add(nxtdor);
						
					stack.push(nxtdor);
			}
			predecessors.set(states.indexOf (nxtdor), state);
			
		}
		
		//return path;
	}

		}
	
	
	
			T first = stack.pop();
			
			
		 yi= searchProblem.isGoal(first);
		if(yi){
		
			path.add(first);
			
			while(!first.equals(searchProblem.getInitialState())){
				
				path.add(predecessors.get(states.indexOf(first)));
				first =predecessors.get(states.indexOf(first));
			}
			Collections.reverse(path);
		}
		
	if(path.size() >0){
			if(!isValidSolution(path)){
				throw new RuntimeException("searcher should never f"
						+ "ind an invalid solution!");
			}
		}
		return path;
	}
}
