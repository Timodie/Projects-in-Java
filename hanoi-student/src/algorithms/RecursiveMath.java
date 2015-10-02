package algorithms;

/**
 * A class that implements some basic mathematical functions using recursion.
 * 
 * YOU MUST USE RECURSION, NOT ITERATION, TO IMPLEMENT THESE FUNCTIONS!
 *
 * @author jcollard
 */
public class RecursiveMath {

	/**
	 * Returns {@code true} if {@code val} is even and {@code false} otherwise.
	 *
	 * @param val
	 * @return {@code true} if {@code val} is even and {@code false} otherwise.
	 */
	public boolean isEven(int val) {
		// Without recursion this could be: return val % 2 == 0;
		//turns val into positve
		if(val<0){
			val= val*-1;
		}
		if(val==2){
			return true;
		}
		if(val ==1){
			return false;
		}
		return isEven(val-2);
	}

	/**
	 * Returns {@code true} if {@code val} is odd and {@code false} otherwise.
	 * 
	 * @param val
	 * @return {@code true} if {@code val} is odd and {@code false} otherwise.
	 */
	public boolean isOdd(int val) {
		// Without recursion this could be: return val % 2 == 1;
//		simply calls the opposite of isEven();
	return !isEven(val);
	}
	/**
	 * Returns the sum of all values between 0 and n.
	 * 
	 * @param n
	 * @return the sum of all values between 0 and n.
	 * @throws IllegalArgumentException
	 *             if n is less than 0.
	 */
	public int sumN(int n) {
		
		
		if(n<0 ){
		throw new IllegalArgumentException();

		}
		else if(n==0)
			return 0;
		else
		return (n + sumN(n-1));
		
	
	}	

	/**
	 * Returns the multiplication of all values between 1 and n.
	 * 
	 * @param n
	 * @return the multiplication of all values between 1 and n.
	 * @throws IllegalArgumentException
	 *             if n is less than 1.
	 */
	public int factorial(int n) {
		if(n<1)
			throw new IllegalArgumentException("less than 1");
			
			else if (n==1)
		return 1;
			else
		return (n * factorial(n-1));
	}

	/**
	 * Returns 2 to the nth power. (2^n)
	 * 
	 * @param n
	 * @return 2 to the nth power.
	 * @throws IllegalArgumentException
	 *             if n is less than 0.
	 */
	public int biPower(int n) {
		if(n<0)
			throw new IllegalArgumentException("less than 0");
			
		else if(n==0)
			return 1;
		else
		return 2 * power(n-1,2); //calling power
	}
	
	public static int power(int exp, int no) { //used by biPower to enable to arguments
	    if (exp < 1) 
	        return 1; 
	    else
	        return no * power(exp-1, no) ;
	}

	
	
}
