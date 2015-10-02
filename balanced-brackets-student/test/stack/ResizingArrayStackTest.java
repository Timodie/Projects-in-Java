package stack;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class ResizingArrayStackTest {
	@Rule
    public Timeout globalTimeout = new Timeout(2000); 

    @Test(expected = StackUnderflowException.class)
    public void testPopEmpty() {
        Stack<Integer> s = new ResizingArrayStack<Integer>(1);
        s.pop();
    }

    @Test(expected = StackUnderflowException.class)
    public void testPopEmptied() {
        Stack<Integer> s = new ResizingArrayStack<Integer>(1);
        for (int i = 0; i < 20; i++) {
            s.push(i);
        }
        for (int i = 0; i < 20; i++) {
            s.pop();
        }
        s.pop();
    }

    @Test(expected = StackUnderflowException.class)
    public void testPeekEmpty() {
        Stack<Boolean> s = new ResizingArrayStack<Boolean>(1);
        s.peek();
    }

    @Test(expected = StackUnderflowException.class)
    public void testPeekEmptied() {
        Stack<String> s = new ResizingArrayStack<String>(1);
        for (int i = 0; i < 20; i++) {
            s.push(Integer.toString(i));
        }
        for (int i = 0; i < 20; i++) {
            s.pop();
        }
        s.peek();
    }

    @Test
    public void testPop() throws Exception {
        Stack<Double> s = new ResizingArrayStack<Double>(1);
        s.push(0.0);
        assertEquals(0, (double) s.pop(), 10e-6);

        for (double d = 0; d < 10; d++) {
            s.push(d);
        }
        for (double d = 9; d >= 0; d--) {
            assertEquals(d, (double) s.pop(), 10e-6);
        }
    }

    @Test
    public void testPeek() throws Exception {
        Stack<Integer> s = new ResizingArrayStack<Integer>(1);
        s.push(0);
        assertEquals(0, (int) s.peek());
        for (int i = 1; i < 10; i++) {
            s.push(i);
            assertEquals(i, (int) s.peek());
        }
    }

    @Test
    public void testPush() throws Exception {
        Stack<String> s = new ResizingArrayStack<String>(1);
        for (int i = 0; i < 10000; i++) {
            s.push("foo");
        }
    }

    @Test
    public void testIsEmpty() throws Exception {
        Stack<Integer> s = new ResizingArrayStack<Integer>(1);
        assertTrue(s.isEmpty());

        s.push(0);
        assertFalse(s.isEmpty());

        s.pop();
        assertTrue(s.isEmpty());

        for (int i = 0; i < 10; i++) {
            s.push(0);
            assertFalse(s.isEmpty());
        }
        for (int i = 0; i < 10; i++) {
            assertFalse(s.isEmpty());
            s.pop();
        }
        assertTrue(s.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        Stack<Integer> s = new ResizingArrayStack<Integer>(1);
        assertEquals(0, s.size());

        s.push(1);
        assertEquals(1, s.size());

        s.pop();

        for (int i = 0; i < 10; i++) {
            assertEquals(i, s.size());
            s.push(0);
        }
    }

    @Test
    public void testCapacity() throws Exception {
        Stack<Integer> s = new ResizingArrayStack<Integer>(1);
        assertEquals(1, s.capacity());

        s.push(0);
        assertEquals(1, s.capacity());

        s.push(0);
        assertEquals(2, s.capacity());

        s.pop();
        assertEquals(2, s.capacity());

        s.pop();
        assertEquals(1, s.capacity());

        for (int i = 0; i < 10; i++) {
            s.push(0);
        }
        assertEquals(16, s.capacity());

        for (int i = 0; i < 6; i++) {
            s.pop();
        }
        assertEquals(8, s.capacity());

        for (int i = 0; i < 2; i++) {
            s.pop();
        }
        assertEquals(4, s.capacity());

        s.pop();
        assertEquals(2, s.capacity());

        s.pop();
        assertEquals(1, s.capacity());
    }
}