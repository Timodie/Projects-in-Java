package hanoi;

/**
 * A {@link ArrayBasedHanoiBoard} is a simple implementation of
 * {@link HanoiBoard}
 * 
 * @author jcollard
 * 
 */
public class ArrayBasedHanoiBoard implements HanoiBoard {
	private final HanoiPeg [] pegs;
	
	
	/**
	 * Creates a {@link ArrayBasedHanoiBoard} with three empty {@link HanoiPeg}s
	 * and {@code n} rings on peg 0.
	 * 
	 */
	public ArrayBasedHanoiBoard(int n) {
		
		//Pass -1 test
		if(n<0)
			throw new IllegalArgumentException("cannot be negative");
		pegs = new HanoiPeg[3];
		for(int i =0; i<pegs.length;i++){
			//Set all positions of the array to stackbased
			pegs[i]=new StackBasedHanoiPeg();
		}
		//add ring to postion 0
		while (n > 0){
			HanoiRing ring = new HanoiRing(n);
			pegs[0].addRing(ring);
			n--;
		}

	}

	@Override
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
		if (!isLegalMove(move)){ 
			throw new IllegalHanoiMoveException(
					"Could not perform illegal move.");
		}
			else{
			int prev = move.getFromPeg(); 
			int next = move.getToPeg(); 
			pegs[next].addRing(pegs[prev].remove());
		}
		
			
	}


	@Override
	public boolean isSolved() {
		
		//only peg2 should have rings  if the puzzle is solved
		return (!pegs[0].hasRings() && !pegs[1].hasRings());
	}



	@Override
	public boolean isLegalMove(HanoiMove move) {
		//Cannot make a null move
		if(move ==null ){
			throw new NullPointerException();
		}
		else{
			if (!pegs[move.getFromPeg()].hasRings()){
				return false;
			}
			if (pegs[move.getToPeg()].hasRings() && 
					pegs[move.getFromPeg()].getTopRing().getSize() >= pegs[move.getToPeg()].getTopRing().getSize()) {
				return false;
			}
		}
		return true;
	}
}	

