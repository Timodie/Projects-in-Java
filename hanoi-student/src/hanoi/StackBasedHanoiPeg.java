package hanoi;

import structures.LinkedStack;

/**
 * A {@link StackBasedHanoiPeg} is an implementation of {@link HanoiPeg}.
 * 
 * @author jcollard
 */
public class StackBasedHanoiPeg implements HanoiPeg {
	//create a null peg
	LinkedStack<HanoiRing> hanoi =null;
	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 */
	public StackBasedHanoiPeg() {
		//now lets initialize this baby:)
		hanoi = new LinkedStack<HanoiRing>();
	}

	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
		//checks if the current element is null
		if(ring ==null){
			throw new NullPointerException("Incoming ring is null");
		}
		//checks if the peg is empty
//checks if the size of the incoming current ring is bigger than the topmost ring
			else{
		if(! hanoi.isEmpty() &&ring.getSize() >= hanoi.peek().getSize()) {
		throw new IllegalHanoiMoveException("this ring is not smaller than the topmost");
		}
			}
		hanoi.push(ring);
		}
		

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
		//if the peg is empty,an exception thrown
		if(hanoi.isEmpty())
		{
			throw new IllegalHanoiMoveException("cant remove from empty peg");
		}
		
		return hanoi.pop();
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
	if(hanoi.isEmpty())
	{
		throw new IllegalHanoiMoveException("hanoi is empty");
	}
		
		return hanoi.peek();
	}
	
	@Override
	public boolean hasRings() {
	//checks if the peg is not empty or the size is not zero	
	return !(hanoi.isEmpty()||hanoi.getSize()==0);
}
	}
