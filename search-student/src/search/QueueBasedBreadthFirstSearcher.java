package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;
/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Queue. This results in a
 * breadth-first search.
 * 
 */
public class QueueBasedBreadthFirstSearcher<T> extends Searcher<T> {
public List<T> states;
	public List<T> predecessors;
	public Queue<T> qbfs;
	public List<T> path;
	boolean goal;
	boolean visit;
	boolean cont;
	boolean status;
	boolean yi;
	
	public QueueBasedBreadthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
		qbfs = new LinkedList<T>();
		states =new ArrayList<T>();
		 predecessors = new ArrayList<T>();
		  path = new ArrayList<T>();
	
	}
	
//	private final List<T> predecessors;

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findSolution() {
		// TODO
		if (solution != null) 
			return solution;
		

	//这是我的功课
		// add the initial state to the list of states and predecessors
		states.add(searchProblem.getInitialState());
		qbfs.add(searchProblem.getInitialState());
		// initially it is marked as its own predecessor, but this is updated
		// in the recursive helper
		predecessors.add(searchProblem.getInitialState());
		//这是我的功课
		boolean empty =qbfs.isEmpty();
		while(!empty){
			T state = qbfs.remove();
			//这是我的功课
			 goal =searchProblem.isGoal(state);
			if(goal){
				qbfs.add(state);
				break;
			}
			 visit =visited.contains(state);
			if(!visit)
				visited.add(state);
			//这是我的功课
			List<T> offspring =searchProblem.getSuccessors(state);
				for( T nxtdor : offspring){
				cont =visited.contains(nxtdor);
			if(!cont){
					 status = states.contains(nxtdor);
				if(status==false){
				states.add(nxtdor);
				//这是我的功课
				qbfs.add(nxtdor);
				//这是我的功课
				predecessors.add(nxtdor);

				//这是我的功课
				}
			int pred =0;
			int k=states.indexOf(state);
			
			if(k%2==1)
			
				pred =(k-1)/2;
			else
				pred = (k-2)/2;
			int s= states.indexOf(nxtdor);
			predecessors.set(s,state);
				}
			}
		}
		
		Collections.reverse((List<T>) qbfs);
		
			T first = qbfs.remove();
			yi= searchProblem.isGoal(first);
			if(yi ){
			
			path.add(first);
//			boolean top =first.equals(searchProblem.getInitialState());
			while(!first.equals(searchProblem.getInitialState())){
				
				int z = states.indexOf(first);
			
				path.add(predecessors.get(z));
				
				first =predecessors.get(z);
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
