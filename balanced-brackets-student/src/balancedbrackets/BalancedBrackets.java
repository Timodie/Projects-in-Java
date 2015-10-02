package balancedbrackets;

import stack.ResizingArrayStack;
import stack.StackUnderflowException;

/**
 * BalancedBrackets contains a single public static utility method and should
 * not be instantiated. It is marked as abstract to prevent attempts to
 * instantiate it.
 */
public abstract class BalancedBrackets {
   
	
	/**
     * Return true if and only if the string s is well-formed with respect to
     * matching brackets
     *
     * @param s a string to check for well-formedness
     * @return true iff the string is well-formed
     */
    public static boolean isBalanced(String s) {
        // TODO
    	 ResizingArrayStack<Character> stack = new  ResizingArrayStack(10);
    	 int i=0;
    	 for(i =0; i<s.length(); i++){
    		if(s.charAt(i)=='['){
    			stack.push(s.charAt(i));
    		}
    		if(s.charAt(i)=='('){
    			stack.push(s.charAt(i));
    		}
    		if(s.charAt(i)=='{'){
    			stack.push(s.charAt(i));
    	 }
    		/*if(s.charAt(i)=='<'){
    			stack.push(s.charAt(i));
    		}*/
    		
   try{ 
    if(s.charAt(i)==']'){
    	if(stack.peek()=='['){
    	stack.pop();
    
    }
    	else{
    		return false;
    	}
    }
    if(s.charAt(i)==')'){
    	if(stack.peek()=='('){
    	stack.pop();
    
    }
    	else{
    		return false;
    	}
    }
    if(s.charAt(i)=='}'){
    	if(stack.peek()=='{'){
    	stack.pop();
    
    }
    	else{
    		return false;
    	}
    }
    /*if(s.charAt(i)=='>'){
    	if(stack.peek()=='<'){
    	stack.pop();
    
    }
    	else{
    		return false;
    	}
    }*/
        	 
    	 }
   catch(StackUnderflowException e){
    	 e.getMessage();
    	 return false;
   }
   
    	 
    }
    	 return stack.size()==0;
    }
    
}
