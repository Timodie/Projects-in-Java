package structures;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;






public class UnboundedQueueInterfaceTest {
	@Test
	public void testCopyConstructorEmpty() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		r = new Queue<Integer>(q);
		assertTrue(r.isEmpty());
		assertTrue(q.isEmpty());		
	}

	@Test
	public void testCopyConstructorEmptyNotAliased() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		r = new Queue<Integer>(q);
		assertTrue(r.isEmpty());
		assertTrue(q.isEmpty());		

		q.enqueue(1);
		q.enqueue(2);
		assertEquals(2, q.size());
		assertTrue(r.isEmpty());
				
		r.enqueue(3);
		r.enqueue(4);
		r.enqueue(5);
		assertEquals(2, q.size());
		assertEquals(3, r.size());
		
		r.dequeue();
		r.dequeue();
		r.dequeue();
		assertTrue(r.isEmpty());
		assertEquals(2, q.size());
		
		q.dequeue();
		q.dequeue();
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void testCopyConstructorOneElement() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		q.enqueue(1);
		r = new Queue<Integer>(q);
		
		assertEquals(1, q.size());
		q.printQueue();
		
		assertEquals(1, r.size());
	}

	@Test
	public void testCopyConstructorOneElementNotAliased() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		q.enqueue(1);
		r = new Queue<Integer>(q);

		q.enqueue(2);
		
	
		assertEquals(1, (int)r.dequeue());
		assertTrue(r.isEmpty());
		//q.printQueue();
		
		assertEquals(2, q.size());
	}

	@Test
	public void testCopyConstructorTwoElements() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		q.enqueue(1);
		q.enqueue(2);
		r = new Queue<Integer>(q);
		
		assertEquals(2, q.size());
		assertEquals(2, r.size());
	}

	@Test
	public void testCopyConstructorTwoElementsNotAliased() throws Exception  {
		Queue<Integer> q = new Queue<Integer>();
		UnboundedQueueInterface<Integer> r;
		q.enqueue(1);
		q.enqueue(2);
		r = new Queue<Integer>(q);

		q.enqueue(3);
		assertEquals(1, (int)r.dequeue());
		assertEquals(3, q.size());
		assertEquals(1, r.size());
	}
	 @Test
	   public void testisEmpty() throws Exception{
	        Queue<Integer> s = new Queue <Integer>();
	        assertTrue(s.isEmpty());
	       
	        s.enqueue(0);
	        assertFalse(s.isEmpty());

	        s.dequeue();
	        assertTrue(s.isEmpty());

	        for (int i = 0; i < 10; i++) {
	            s.enqueue(0);
	            assertFalse(s.isEmpty());
	        }
	        for (int i = 0; i < 10; i++) {
	            assertFalse(s.isEmpty());
	            s.dequeue();
	        }
	        assertTrue(s.isEmpty());
	 }
	//since testsize is not being read,its been added to testisEmpty()
	@Test
	       public void testsize() throws Exception {
		 Queue<Integer> s = new Queue <Integer>();
	        assertEquals(0, s.size());

	        s.enqueue(1);
	        assertEquals(1, s.size());

	        s.dequeue();

	        for (int i = 0; i < 10; i++) {
	            assertEquals(i, s.size());
	            s.enqueue(i);
	            s.printQueue();
	        }
	    }
	  @Test
	    public void testPeek() throws Exception {
		  Queue<Integer> s = new Queue <Integer>();
	       // s.enqueue(0);
	       // assertEquals(0, (int) s.peek());
	        for(int i=1 ; i <5; i++){
            s.enqueue(i);
           // s.printQueue();
           // s.peek();}
	        //    assertEquals(i, (int) s.);
	        }
	  for(int i=1 ; i<5; i++){
		// s.printQueue();
		  assertEquals(i,(int) s.dequeue());
	  }
	  }
	  @Test(expected = NoSuchElementException.class)
	  public void testPeekEmptied() {
	        Queue<String> s = new Queue<String>();
	        for (int i = 0; i < 20; i++) {
	            s.enqueue(Integer.toString(i));
	        }
	        for (int i = 0; i < 20; i++) {
	            s.dequeue();
	        }
	        s.peek();
	    }
	  @Test
	    public void testDequeue() throws Exception {
	        Queue<Double> s = new Queue <Double>();
	        s.enqueue(0.0);
	        assertEquals(0, (double) s.dequeue(), 10e-6);

	        for (double d = 0; d < 10; d++) {
	            s.enqueue(d);
	        }
	        s.printQueue();
        for (double d = 0; d < 10; d++) {
	            assertEquals(d, (double) s.dequeue(), 10e-6);
	        }
	    }
	  @Test(timeout = 500)
		public void testQueueUnbounded() {
		  Queue<Integer> s = new Queue <Integer>();
		  for (int i = 1; i < 5000; i++) {
			  s.enqueue(i);
			  assertEquals(i, s.size());
			//s.printQueue();
				
				//s.printQueue();
			}
		}
	  @Test(timeout = 500)
		public void testQueue() {
		  Queue<Integer> s = new Queue <Integer>();
		  assertEquals("Newly constructed queue should have size 0", 0,
					s.size());
			
					s.enqueue(5);
			assertEquals("Size should now be 1.", 1, s.size());
			s.enqueue(6);
			s.enqueue(7);
			s.enqueue(8);
			assertEquals("Size should now be 4.", 4, s.size());
			assertEquals("First element should be 5.", new Integer(5), s.peek());
			//s.reversed();
			//s.printQueue();
			
	  }
	  @Test(timeout = 500*2)
		public void testReversed() {
		  Queue<Integer> s = new Queue <Integer>();
		    assertEquals("Newly constructed queue should have size 0", 0,
					s.size());
			
					s.enqueue(5);
			assertEquals("Size should now be 1.", 1, s.size());
			s.enqueue(6);
			s.enqueue(7);
			s.enqueue(8);
			assertEquals("Size should now be 4.", 4, s.size());
			Queue<Integer> newQ = new Queue<Integer>((Queue<Integer>) s.reversed());
			//newQ.reversed();
			newQ.printQueue();
			
			//newQ
			//Queue<Integer> r= s.reversed();
			//s.printQueue();
		assertEquals("last element should be 5.", new Integer(5), newQ.tail());
			//s.printQueue();
			//s.printQueue();
			
	  } 
	  
}
