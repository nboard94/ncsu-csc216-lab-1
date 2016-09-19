/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.course;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests that conflict exceptions have the right messages
 * @author James Ticatic
 */
public class ConflictExceptionTest {

	/**
	 * Test method for the constructor for ConflictException with a string parameter representing the exception 
	 * message
	 */
	@Test
	public void testConflictExceptionString() {
		ConflictException ce = new ConflictException("Custom exception message");
	    assertEquals("Custom exception message", ce.getMessage());
	}

	/**
	 * Test method for the constructor for ConflictException with no parameters
	 */
	@Test
	public void testConflictException() {
		ConflictException ce = new ConflictException();
	    assertEquals("Schedule conflict.", ce.getMessage());
	}

}
