package edu.ncsu.csc216.pack_scheduler.user;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest {

	private static final String FIRST_NAME = "first";
	private static final String LAST_NAME = "last";
	private static final String ID = "id";
	private static final String EMAIL = "email@ncsu.edu";
	private static final String HASH_PASSWORD = "hashpassword";
	private static final int MAX_CREDITS = 15;




	
	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test 
	public void testStudentStringStringStringStringStringInt() {
		Student s1 = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASH_PASSWORD, MAX_CREDITS);
		assertEquals(FIRST_NAME, s1.getFirstName());
		assertEquals(LAST_NAME, s1.getLastName());
		assertEquals(ID, s1.getId());
		assertEquals(EMAIL, s1.getEmail());
		assertEquals(HASH_PASSWORD, s1.getPassword());
		assertEquals(MAX_CREDITS, s1.getMaxCredits());
	}
	
	@Test
	public void testInvalidStudentFirst () {
		Student s = null; //Initialize a student reference to null
		try {
		    s = new Student(null, LAST_NAME, ID, EMAIL, "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
		
		try {
		    s = new Student("", LAST_NAME, ID, EMAIL, "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
		
		try {
		    s = new Student(FIRST_NAME, null, ID, EMAIL, "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
		
		try {
		    s = new Student(FIRST_NAME, "", ID, EMAIL, "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
		
		try {
		    s = new Student(FIRST_NAME, LAST_NAME, null, EMAIL, "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
		
		try {
		    s = new Student(FIRST_NAME, LAST_NAME, "", EMAIL, "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
		    
		try {
		    s = new Student(FIRST_NAME, LAST_NAME, ID, null, "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
		
		try {
		    s = new Student(FIRST_NAME, LAST_NAME, ID, "", "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
		
		try {
		    s = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, null);
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
		
		try {
		    s = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, "");
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
	}

	@Test 
	public void testStudentStringStringStringStringString() {
		Student s1 = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASH_PASSWORD);
		assertEquals(FIRST_NAME, s1.getFirstName());
		assertEquals(LAST_NAME, s1.getLastName());
		assertEquals(ID, s1.getId());
		assertEquals(EMAIL, s1.getEmail());
		assertEquals(HASH_PASSWORD, s1.getPassword());
	}

	@Test
	public void testSetFirstName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLastName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMaxCredits() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
