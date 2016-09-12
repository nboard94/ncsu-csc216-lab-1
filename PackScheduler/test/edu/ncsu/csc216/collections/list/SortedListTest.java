package edu.ncsu.csc216.collections.list;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortedListTest {

	@Test
	public void testSortedList() {
		SortedList<String> list = new SortedList<String>();
		assertEquals(0, list.size());
		assertFalse(list.contains("apple"));
		
		//TODO Test that the list grows by adding at least 11 elements
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

	@Test
	public void testAdd() {
		SortedList<String> list = new SortedList<String>();
		
		list.add("banana");
		assertEquals(1, list.size());
		assertEquals("banana", list.get(0));
		
		//TODO Test adding to the front, middle and back of the list
		list.add("apple");
		assertEquals(2, list.size());
		assertEquals("apple", list.get(0));
		
		list.add("avacado");
		assertEquals(3, list.size());
		assertEquals("avacado", list.get(1));
		
		list.add("cherry");
		assertEquals(4, list.size());
		assertEquals("cherry", list.get(3));
		
		//TODO Test adding a null element
		try {
			list.add(null);
			fail();
		} catch (NullPointerException e) {
			assertEquals(4, list.size());
		}
		
		//TODO Test adding a duplicate element
		try {
			list.add("apple");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(4, list.size());
		}
	}
	
	@Test
	public void testGet() {
		SortedList<String> list = new SortedList<String>();
		
		//Since get() is used throughout the tests to check the
		//contents of the list, we don't need to test main flow functionality
		//here.  Instead this test method should focus on the error 
		//and boundary cases.
		
		//TODO Test getting an element from an empty list
		try {
			list.get(0);
			fail();
		} catch (IndexOutOfBoundsException e){
			//intentionally left empty
		}
		//TODO Add some elements to the list
		list.add("apple");
		list.add("banana");
		list.add("cherry");
		//TODO Test getting an element at an index < 0
		try {
			list.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e){
			//intentionally left empty
		}
		//TODO Test getting an element at size
		try {
			list.get(3);
			fail();
		} catch (IndexOutOfBoundsException e){
			//intentionally left empty
		}
	}
	
	@Test
	public void testRemove() {
		SortedList<String> list = new SortedList<String>();
		
		//TODO Test removing from an empty list
		try {
			list.remove(0);
			fail();
		} catch (IndexOutOfBoundsException e){
			assertEquals(0, list.size());
		}
		
		//TODO Add some elements to the list - at least 4
		list.add("apple");
		list.add("banana");
		list.add("cherry");
		list.add("pear");
		//TODO Test removing an element at an index < 0
		try {
			list.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e){
			assertEquals(4, list.size());
		}
		//TODO Test removing an element at size
		try {
			list.remove(4);
			fail();
		} catch (IndexOutOfBoundsException e){
			assertEquals(4, list.size());
		}
		//TODO Test removing a middle element
		list.remove(2);
		assertEquals(3, list.size());
		//TODO Test removing the last element
		list.remove(2);
		assertEquals(2, list.size());
		//TODO Test removing the first element
		list.remove(0);
		assertEquals(1, list.size());
		//TODO Test removing the last element
		list.remove(0);
		assertEquals(0, list.size());
	}
	
	@Test
	public void testIndexOf() {
		SortedList<String> list = new SortedList<String>();
		
		//TODO Test indexOf on an empty list
		assertEquals(-1, list.indexOf("Pineapple"));
		
		//TODO Add some elements
		list.add("apple");
		list.add("banana");
		list.add("cherry");
		
		//TODO Test various calls to indexOf for elements in the list
		//and not in the list
		assertEquals(0, list.indexOf("apple"));
		assertEquals(1, list.indexOf("banana"));
		assertEquals(2, list.indexOf("cherry"));
		
		assertEquals(-1, list.indexOf("Pineapple"));
		
		//TODO Test checking the index of null
		try {
			list.indexOf(null);
		} catch (NullPointerException e) {
			assertEquals(3, list.size());
		}
		
	}
	
	@Test
	public void testClear() {
		SortedList<String> list = new SortedList<String>();

		//TODO Add some elements
		list.add("apple");
		list.add("banana");
		list.add("cherry");
		
		//TODO Clear the list
		list.clear();
		
		//TODO Test that the list is empty
		assertEquals(0, list.size());
	}

	@Test
	public void testIsEmpty() {
		SortedList<String> list = new SortedList<String>();
		
		//TODO Test that the list starts empty
		assertEquals(true, list.isEmpty());		
		
		//TODO Add at least one element
		list.add("apple");
		
		//TODO Check that the list is no longer empty
		assertEquals(false, list.isEmpty());
	}

	@Test
	public void testContains() {
		SortedList<String> list = new SortedList<String>();
		
		//TODO Test the empty list case
		assertEquals(false, list.contains("apple"));
		
		//TODO Add some elements
		list.add("apple");
		list.add("banana");
		list.add("cherry");
		
		//TODO Test some true and false cases
		assertEquals(true, list.contains("apple"));
		assertEquals(true, list.contains("banana"));
		assertEquals(true, list.contains("cherry"));
		
		assertEquals(false, list.contains("pineapple"));


	}
	
	@Test
	public void testEquals() {
		SortedList<String> list1 = new SortedList<String>();
		SortedList<String> list2 = new SortedList<String>();
		SortedList<String> list3 = new SortedList<String>();
		
		//TODO Make two lists the same and one list different
		
		//TODO Test for equality and non-equality
	}
	
	@Test
	public void testHashCode() {
		SortedList<String> list1 = new SortedList<String>();
		SortedList<String> list2 = new SortedList<String>();
		SortedList<String> list3 = new SortedList<String>();
		
		//TODO Make two lists the same and one list different
		
		//TODO Test for the same and different hashCodes
	}

}
 