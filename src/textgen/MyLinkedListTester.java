/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// Test lower bounds
		try {
			list1.remove(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
		
		// Test upper bounds
		try {
			list1.remove(list1.size());
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		// Test adding to empty list
		emptyList.add(1);
		assertEquals("Add to empty: check size", 1, emptyList.size());
		assertEquals("Add to empty: check element", (Integer)1, emptyList.get(0));
		
		// Test adding to existing list
		shortList.add("C");
		assertEquals("Add to end: check size", 3, shortList.size());
		assertEquals("Add to end: check element", "C", shortList.get(2));
		
		// Test null element
		try {
			shortList.add(null);
			fail("Should throw NullPointerException");
		} catch (NullPointerException e) {
		}
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// Test empty list
		assertEquals("Size of empty list", 0, emptyList.size());
		
		// Test short list
		assertEquals("Size of shortList", 2, shortList.size());
		
		// Test longer list
		assertEquals("Size of longerList", LONG_LIST_LENGTH, longerList.size());
		
		// Test size after adding
		emptyList.add(1);
		assertEquals("Size after add", 1, emptyList.size());
		
		// Test size after removing
		shortList.remove(0);
		assertEquals("Size after remove", 1, shortList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		// Test adding at beginning
		list1.add(0, 99);
		assertEquals("Add at 0: check element", (Integer)99, list1.get(0));
		assertEquals("Add at 0: check size", 4, list1.size());
		
		// Test adding in middle
		list1.add(2, 88);
		assertEquals("Add at 2: check element", (Integer)88, list1.get(2));
		assertEquals("Add at 2: check size", 5, list1.size());
		
		// Test null element
		try {
			list1.add(0, null);
			fail("Should throw NullPointerException");
		} catch (NullPointerException e) {
		}
		
		// Test lower bounds
		try {
			list1.add(-1, 77);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
		
		// Test upper bounds
		try {
			list1.add(list1.size() + 1, 66);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		// Test set in short list
		String old = shortList.set(0, "X");
		assertEquals("Set: check old value", "A", old);
		assertEquals("Set: check new value", "X", shortList.get(0));
		assertEquals("Set: check size unchanged", 2, shortList.size());
		
		// Test set at end
		String old2 = shortList.set(1, "Y");
		assertEquals("Set at end: check old value", "B", old2);
		assertEquals("Set at end: check new value", "Y", shortList.get(1));
		
		// Test null element
		try {
			shortList.set(0, null);
			fail("Should throw NullPointerException");
		} catch (NullPointerException e) {
		}
		
		// Test out of bounds
		try {
			shortList.set(-1, "Z");
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
		
		try {
			shortList.set(10, "Z");
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
	}
	
	
	// TODO: Optionally add more test methods.
	
}
