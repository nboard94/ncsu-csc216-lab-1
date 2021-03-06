package edu.ncsu.csc216.collections.list;

import static org.junit.Assert.*;

import org.junit.Test;

/**Tests the SortedList collection type
 * @author NBoar and James Ticatic
 *
 */
public class SortedListTest {

	/**
	 * Tests the construction of a SortedList
	 */
	@Test
	public void testSortedList() {
		SortedList<String> list = new SortedList<String>();
		assertEquals(0, list.size());
		assertFalse(list.contains("apple"));
		
		// Test that the list grows by adding at least 11 elements
		//Remember the list's initial capacity is 10
		list.add("apple");
		list.add("banana");
		list.add("cherry");
		list.add("durian");
		list.add("fruit");
		list.add("grape");
		list.add("lemon");
		list.add("lime");
		list.add("melon");
		list.add("pineapple");
		list.add("strawberry");
		
		assertEquals(11, list.size());
		
		
	}

	/**
	 * Tests the add functionality of SortedList
	 */
	@Test
	public void testAdd() {
		SortedList<String> list = new SortedList<String>();
		
		list.add("banana");
		assertEquals(1, list.size());
		assertEquals("banana", list.get(0));
		
		// Test adding to the front, middle and back of the list
		list.add("apple");
		assertEquals(2, list.size());
		assertEquals("apple", list.get(0));
		
		list.add("avacado");
		assertEquals(3, list.size());
		assertEquals("avacado", list.get(1));
		
		list.add("cherry");
		assertEquals(4, list.size());
		assertEquals("cherry", list.get(3));
		
		// Test adding a null element
		try {
			list.add(null);
			fail();
		} catch (NullPointerException e) {
			assertEquals(4, list.size());
		}
		
		// Test adding a duplicate element
		try {
			list.add("apple");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(4, list.size());
		}
	}
	
	/**
	 * Tests the get functionality of SortedList
	 */
	@Test
	public void testGet() {
		SortedList<String> list = new SortedList<String>();
		
		//Since get() is used throughout the tests to check the
		//contents of the list, we don't need to test main flow functionality
		//here.  Instead this test method should focus on the error 
		//and boundary cases.
		
		// Test getting an element from an empty list
		try {
			list.get(0);
			fail();
		} catch (IndexOutOfBoundsException e){
			//intentionally left empty
		}
		// Add some elements to the list
		list.add("apple");
		list.add("banana");
		list.add("cherry");
		// Test getting an element at an index < 0
		try {
			list.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e){
			//intentionally left empty
		}
		// Test getting an element at size
		try {
			list.get(3);
			fail();
		} catch (IndexOutOfBoundsException e){
			//intentionally left empty
		}
	}
	
	/**
	 * Tests the remove functionality of SortedList
	 */
	@Test
	public void testRemove() {
		SortedList<String> list = new SortedList<String>();
		
		// Test removing from an empty list
		try {
			list.remove(0);
			fail();
		} catch (IndexOutOfBoundsException e){
			assertEquals(0, list.size());
		}
		
		// Add some elements to the list - at least 4
		list.add("apple");
		list.add("banana");
		list.add("cherry");
		list.add("pear");
		// Test removing an element at an index < 0
		try {
			list.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e){
			assertEquals(4, list.size());
		}
		// Test removing an element at size
		try {
			list.remove(4);
			fail();
		} catch (IndexOutOfBoundsException e){
			assertEquals(4, list.size());
		}
		// Test removing a middle element
		list.remove(2);
		assertEquals(3, list.size());
		// Test removing the last element
		list.remove(2);
		assertEquals(2, list.size());
		// Test removing the first element
		list.remove(0);
		assertEquals(1, list.size());
		// Test removing the last element
		list.remove(0);
		assertEquals(0, list.size());
	}
	
	/**
	 * Tests the IndexOf functionality of SortedList
	 */
	@Test
	public void testIndexOf() {
		SortedList<String> list = new SortedList<String>();
		
		// Test indexOf on an empty list
		assertEquals(-1, list.indexOf("Pineapple"));
		
		// Add some elements
		list.add("apple");
		list.add("banana");
		list.add("cherry");
		
		// Test various calls to indexOf for elements in the list
		//and not in the list
		assertEquals(0, list.indexOf("apple"));
		assertEquals(1, list.indexOf("banana"));
		assertEquals(2, list.indexOf("cherry"));
		
		assertEquals(-1, list.indexOf("Pineapple"));
		
		// Test checking the index of null
		try {
			list.indexOf(null);
		} catch (NullPointerException e) {
			assertEquals(3, list.size());
		}
		
	}
	
	/**
	 * Tests the clear functionality of SortedList
	 */
	@Test
	public void testClear() {
		SortedList<String> list = new SortedList<String>();

		// Add some elements
		list.add("apple");
		list.add("banana");
		list.add("cherry");
		
		// Clear the list
		list.clear();
		
		// Test that the list is empty
		assertEquals(0, list.size());
	}

	/**
	 * Tests the isEmpty functionality of SortedList
	 */
	@Test
	public void testIsEmpty() {
		SortedList<String> list = new SortedList<String>();
		
		// Test that the list starts empty
		assertEquals(true, list.isEmpty());		
		
		// Add at least one element
		list.add("apple");
		
		// Check that the list is no longer empty
		assertEquals(false, list.isEmpty());
	}

	/**
	 * Tests the contains functionality of SortedList
	 */
	@Test
	public void testContains() {
		SortedList<String> list = new SortedList<String>();
		
		// Test the empty list case
		assertEquals(false, list.contains("apple"));
		
		// Add some elements
		list.add("apple");
		list.add("banana");
		list.add("cherry");
		
		// Test some true and false cases
		assertEquals(true, list.contains("apple"));
		assertEquals(true, list.contains("banana"));
		assertEquals(true, list.contains("cherry"));
		
		assertEquals(false, list.contains("pineapple"));


	}
	
	/**
	 * Tests the equals functionality of sortedList
	 */
	@Test
	public void testEquals() {
		SortedList<String> list1 = new SortedList<String>();
		SortedList<String> list2 = new SortedList<String>();
		SortedList<String> list3 = new SortedList<String>();
		
		// Make two lists the same and one list different
		list1.add("apple");
		list1.add("banana");
		list1.add("cherry");
		
		list2.add("apple");
		list2.add("banana");
		list2.add("cherry");
		
		list3.add("not apple");
		list3.add("not banana");
		list3.add("not cherry");
		// Test for equality and non-equality
		assertEquals(true, list1.equals(list2));
		assertEquals(true, list2.equals(list1));
		
		assertEquals(false, list2.equals(list3));
		assertEquals(false, list3.equals(list2));
	}
	
	/**
	 * tests the hashCode functionality of SortedList
	 */
	@Test
	public void testHashCode() {
		SortedList<String> list1 = new SortedList<String>();
		SortedList<String> list2 = new SortedList<String>();
		SortedList<String> list3 = new SortedList<String>();
		
		// Make two lists the same and one list different
		list1.add("apple");
		list1.add("banana");
		list1.add("cherry");
		
		list2.add("apple");
		list2.add("banana");
		list2.add("cherry");
		
		list3.add("not apple");
		list3.add("not banana");
		list3.add("not cherry");
		// Test for the same and different hashCodes
		assertEquals(list1.hashCode(), list2.hashCode());
		assertNotEquals(list2.hashCode(), list3.hashCode());
		assertNotEquals(list1.hashCode(), list3.hashCode());
	}

}
 