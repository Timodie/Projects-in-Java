package search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * An abstraction over the idea of a search.
 *
 * @author liberato
 *
 * @param <T>
 */
public abstract class Searcher<T> {
	protected final SearchProblem<T> searchProblem;
	protected final List<T> visited;
	protected List<T> solution;
	public List<T> prob;
	//public Queue<T> queue;
	/**
	 * Instantiates a searcher.
	 * 
	 * @param searchProblem
	 *            the search problem for which this searcher will find and
	 *            validate solutions
	 */
	public Searcher(SearchProblem<T> searchProblem) {
		this.searchProblem = searchProblem;
		this.visited = new ArrayList<T>();
		this.prob = new ArrayList<T>();
	}

	/**
	 * Finds and return a solution to the problem, consisting of a list of
	 * states.
	 * 
	 * The list should start with the initial state of the underlying problem.
	 * Then, it should have one or more additional states. Each state should be
	 * a successor of its predecessor. The last state should be a goal state of
	 * the underlying problem.
	 * 
	 * If there is no solution, then this method should return an empty list.
	 * 
	 * @return a solution to the problem (or an empty list)
	 */
	public abstract List<T> findSolution();

	/**
	 * Checks that a solution is valid.
	 * 
	 * A valid solution consists of a list of states. The list should start with
	 * the initial state of the underlying problem. Then, it should have one or
	 * more additional states. Each state should be a successor of its
	 * predecessor. The last state should be a goal state of the underlying
	 * problem.
	 * 
	 * @param solution
	 * @return true iff this solution is a valid solution
	 *   @throws NullPointerException
	 *             if solution is null
	 */
	public final boolean isValidSolution(List<T> solution) {
		// TODO
		if(solution == null){
			throw new NullPointerException("Solution is null ");
		}
		
		
		//System.out.println(searchProblem.getSuccessors(searchProblem.getInitialState()));
		//store elements in search problem in a list, 
		//iterate over the list and over visited and compare next
		
//		while(prob.hasNext()){
//			System.out.println(prob.next());
//		}
		//OKAY so lets create a stack and push all the items of
		//search problem into it and then compare with visited by iteration
			
	
		//System.out.println("here"+visited.size());
//		Iterator<T> k = solution.iterator();
//		while(k.hasNext()){
//			visited.add(k.next());
//			
//			}
		
		
		prob.add(searchProblem.getInitialState());
		System.out.println(prob.size());
		
		Iterator<T> search =searchProblem.getSuccessors(searchProblem.getInitialState()).iterator();
			while(search.hasNext()){
				prob.add(search.next());
				}
			boolean states = false;
			
			Iterator<T> v = visited.iterator();
			Iterator<T> skip = prob.iterator();
			while(skip.hasNext()){
			System.out.println("prob"+skip.next());
				//System.out.println("vis"+v.next());
//				//System.out.println("v"+v.next());
//				//states=true;
			}
			//System.out.println(states);
			System.out.println("prob:"+prob.size());
			//System.out.println("visi:"+visited.size());
		
		T goalState =solution.get(solution.size()-1);
		boolean goal =searchProblem.isGoal(goalState);
//		Boolean skip =false;
//		if(visited.size()==prob.size()){
//			skip =true;
//		}
		
		for(int i=prob.size()-1;i>=0;i--){
			prob.remove(prob.get(i));
			
			System.out.println(prob.size());
			//i++;
		}
		
		
		if(!solution.get(0).equals(searchProblem.getInitialState())){
			return false;
			}
		else{
			for(int j =1;j<solution.size();j++){
				List<T> successors = searchProblem.getSuccessors(solution.get(j-1));
				
				if(!successors.contains(solution.get(j))) 
					return false;
				
				
			}
			
			
		
		if(goal)
			return true;
		else
			return false;
		} 
		//return false;
	}
}
