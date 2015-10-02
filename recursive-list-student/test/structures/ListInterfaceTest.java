package structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListInterfaceTest {

	private ListInterface<String> list;
	
	@Before
	public void setup(){
          list = new RecursiveList<String>();
	}
	
	@Test (timeout = 500)
	public void testInsertFirstIsEmptySizeAndGetFirst1() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		assertEquals("Insert First should return instance of self", list, list.insertFirst("hello"));
		assertFalse("List should now have elements.", list.isEmpty());
		assertEquals("List should now have 1 element.", 1, list.size());
		assertEquals("First element should .equals \"hello\".", "hello", list.getFirst());
		list.insertFirst("world");
		assertEquals(2, list.size());
		list.insertFirst("foo");
		assertEquals(3, list.size());
		assertEquals("First element should .equals \"foo\".", "foo", list.getFirst());
	}

	@Test (timeout = 500)
	public void testInsertLastEmptySizeGetLast(){
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		assertEquals("Insert last should return instance of self", list, list.insertLast("Yo"));
		assertFalse("List should now have elements.", list.isEmpty());
		assertEquals("List should now have 1 element.", 1, list.size());
		assertEquals("Last element should .equals \"Yo\".", "Yo", list.getLast());
		list.insertLast("world");
		assertEquals(2, list.size());
		list.insertLast("foo");
		assertEquals(3, list.size());
		assertEquals("Last element should .equals \"foo\".", "foo", list.getLast());
		
}	
	@Test(timeout = 500)
	public void testInsertAtGetAt(){
		assertEquals("Insertion into list with InsertAt should return the list",this.list,list.insertAt(0, "tim"));
		assertEquals("the first elem should now be tim","tim",list.get(0));
		list.insertAt(1, "addai");
		assertEquals("Elem at postion 5 should be addai","addai",list.get(1));
		
		for(int i=2; i<2000;i++){
			list.insertAt(i, Integer.toString(i));
		assertEquals("point in loop",Integer.toString(i),list.get(i));
		}
		assertEquals("position2 should be value 2","2",list.get(2));
		
		}
	@Test(timeout = 500*2)
	public void testSize(){
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		list.insertFirst("the list");
		assertEquals("size should be 1",1,list.size());
		for(int i=1; i<2000;i++){
			list.insertAt(i, Integer.toString(i));
	assertEquals("size should increase with the loop",i+1,list.size());
		}
	}
		@Test(timeout =500)
		public void testRemoveFirst(){
			assertTrue("Newly constructed list should be empty",list.isEmpty());
			list.insertFirst("tim");
			assertFalse("list should not be empty now",list.isEmpty());
			assertEquals("removing first should return tim","tim" ,list.removeFirst());
			assertTrue("list should now be empty",list.isEmpty());
			
		}
		@Test(timeout =500)
		public void testRemoveLast(){
			assertTrue("Newly constructed list should be empty",list.isEmpty());
			list.insertLast("tim");
			assertFalse("list should not be empty now",list.isEmpty());
			assertEquals("removing first should return tim","tim" ,list.removeLast());
			assertTrue("list should now be empty",list.isEmpty());
			
		}
		@Test(timeout= 500)
		public void testRemoveAt(){
			assertEquals("Newly constructed list should be size 0.", 0, list.size());
			list.insertFirst("the list");
			assertEquals("size should be 1",1,list.size());
			for(int i=1; i<500;i++){
				list.insertAt(i, Integer.toString(i));
			}
			for(int i=499;i>0;i--){
		assertEquals("removed item should be i",i,Integer.parseInt(list.removeAt(i)));
			}
		}
		@Test (timeout = 500)
		public void testIndexOf(){
			assertEquals("Newly constructed list should be size 0.", 0, list.size());
			list.insertAt(0, "this");
			list.insertAt(1,"is");
			list.insertAt(2,"a");
			list.insertAt(3, "junit");
			list.insertAt(4, "test");
			assertEquals("this is at pos 0",0,list.indexOf("this"));
			assertEquals("is is at pos 1",1,list.indexOf("is"));
			list.removeAt(1);
			assertEquals("a should be a pos 1 now",1,list.indexOf("a"));
			assertEquals("test should be at pos 3 now",3,list.indexOf("test"));
			assertEquals("size should be 4",4,list.size());
			//System.out.println(list.size()+"printed");
			for(int i=4; i<500;i++){
				list.insertAt(i, Integer.toString(i));
			}
			//System.out.println(list.size()+"printed");
			assertEquals("last position  should have 499",Integer.toString(499),list.getLast());
			//System.out.println(list.size());
			assertEquals("last postion ie 504 should 499", 499,list.indexOf(Integer.toString(499)));
			assertTrue("junit removed",list.remove("junit"));
			assertEquals("last position 498 has value 499",498,list.indexOf(Integer.toString(499)));
			assertEquals("test should now be at positon2",2,list.indexOf("test"));
		}
		@Test (timeout = 500)
		public void testisEmpty(){
			assertTrue("Newly constructed list should be empty",list.isEmpty());
			for(int i=0; i<500;i++){
				list.insertAt(i, Integer.toString(i));
			}
			assertFalse("list shouldn't be empty",list.isEmpty());
			for(int i=499;i>=0;i--){
				list.removeAt(i);
			}
			//System.out.print(list.size());
			assertTrue("list should now be empty",list.isEmpty());
		
		}
	
		
		
		
		
}
	
