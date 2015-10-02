package balancedbrackets;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
           
public class BalancedBracketsTest {
	@Rule
    public Timeout globalTimeout = new Timeout(2000); 
	
    @Test
    public void testIsBalancedNoBrackets() throws Exception {
        assertTrue(BalancedBrackets.isBalanced(""));
        assertTrue(BalancedBrackets.isBalanced("no brackets here!"));
        assertTrue(BalancedBrackets.isBalanced("<"));
        assertTrue(BalancedBrackets.isBalanced("><"));
        assertTrue(BalancedBrackets.isBalanced("<>"));
    }

    @Test
    public void testIsUnbalancedSimple() throws Exception {
         assertFalse(BalancedBrackets.isBalanced("]"));
        assertFalse(BalancedBrackets.isBalanced("{)"));
        assertFalse(BalancedBrackets.isBalanced("[[]"));
        assertFalse(BalancedBrackets.isBalanced(")("));
        assertFalse(BalancedBrackets.isBalanced("[(])"));
    }

    @Test
    public void testIsBalancedSimple() throws Exception {
        assertTrue(BalancedBrackets.isBalanced("()"));
        assertTrue(BalancedBrackets.isBalanced("([])"));
        assertTrue(BalancedBrackets.isBalanced("(((())))"));
        assertTrue(BalancedBrackets.isBalanced("({[]()[()]}([]{{}}))"));
    }

    @Test
    public void testIsBalancedText() throws Exception {
        assertTrue(BalancedBrackets.isBalanced("[Did you (yes, you {in the back}) check for [[]]{[]}?]"));
    }
}