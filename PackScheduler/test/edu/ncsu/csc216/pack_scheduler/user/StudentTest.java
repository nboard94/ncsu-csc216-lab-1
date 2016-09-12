package edu.ncsu.csc216.pack_scheduler.user;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Student class.
 * 
 * getters are tested through other methods
 * 
 * @author James Ticatic and Nick Board
 */
public class StudentTest {

	
	/** Student first name  */
	private static final String FIRST_NAME = "first";
	/** Student last name  */
	private static final String LAST_NAME = "last";
	/** Student id  */
	private static final String ID = "id";
	/** Student email  */
	private static final String EMAIL = "email@ncsu.edu";
	/** Student hashed password  */
	private static final String HASH_PASSWORD = "hashpassword";
	/** Student max credits  */
	private static final int MAX_CREDITS = 15;




	
	/**
	 * Tests student constructor with all parameters
	 */
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
	
	/**Tests the validity of a student object based on the firstName, lastName,
	 * id, email, and hashPassword parameters.  These cannot be null
	 * or an empty string.
	 */
	@Test
	public void testInvalidStudentFirst () {
		Student s = null; //Initialize a student reference to null
		try {
		    s = new Student(null, LAST_NAME, ID, EMAIL, HASH_PASSWORD);
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
		
		try {
		    s = new Student("", LAST_NAME, ID, EMAIL, HASH_PASSWORD);
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
		
		try {
		    s = new Student(FIRST_NAME, null, ID, EMAIL, HASH_PASSWORD);
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
		
		try {
		    s = new Student(FIRST_NAME, "", ID, EMAIL, HASH_PASSWORD);
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
		
		try {
		    s = new Student(FIRST_NAME, LAST_NAME, null, EMAIL, HASH_PASSWORD);
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
		
		try {
		    s = new Student(FIRST_NAME, LAST_NAME, "", EMAIL, HASH_PASSWORD);
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
		    
		try {
		    s = new Student(FIRST_NAME, LAST_NAME, ID, null, HASH_PASSWORD);
		    fail();
		} catch (IllegalArgumentException e) {
		    assertNull(s);
		}
		
		try {
		    s = new Student(FIRST_NAME, LAST_NAME, ID, "", HASH_PASSWORD);
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

	/**Tests the proper construction of a Student object using
	 * firstName, lastName, id, email, and hashPassword
	 */
	@Test 
	public void testStudentStringStringStringStringString() {
		Student s1 = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASH_PASSWORD);
		assertEquals(FIRST_NAME, s1.getFirstName());
		assertEquals(LAST_NAME, s1.getLastName());
		assertEquals(ID, s1.getId());
		assertEquals(EMAIL, s1.getEmail());
		assertEquals(HASH_PASSWORD, s1.getPassword());
	}

	/**Tests to make sure a student's first name is not
	 * null or an empty string
	 */
	@Test
	public void testSetFirstName() {
		Student s = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASH_PASSWORD);
		try {
		    s.setFirstName(null);
		    fail(); 
		} catch (IllegalArgumentException e) {
		    assertEquals(FIRST_NAME, s.getFirstName());
		}	
		
		try {
			s.setFirstName("");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(FIRST_NAME, s.getFirstName());
		}
	}


	/**Tests to make sure a student's last name is not
	 * null or an empty string
	 */
	@Test
	public void testSetLastName() {
		Student s = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASH_PASSWORD);
		try {
		    s.setLastName(null);
		    fail(); 
		} catch (IllegalArgumentException e) {
		    assertEquals(LAST_NAME, s.getLastName());
		}	
		
		try {
		    s.setLastName("");
		    fail(); 
		} catch (IllegalArgumentException e) {
		    assertEquals(LAST_NAME, s.getLastName());
		}
	}
	
	//NEED TO SET setID() back to PRIVATE!!!
	/**Tests to make sure a student's id is not
	 * null or an empty string
	 */
	@Test
	public void testSetId() {
		Student s = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASH_PASSWORD);
		try {
		    s.setId(null);
		    fail(); 
		} catch (IllegalArgumentException e) {
		    assertEquals(ID, s.getId());
		}	
		
		try {
		    s.setId("");
		    fail(); 
		} catch (IllegalArgumentException e) {
		    assertEquals(ID, s.getId());
		}
	}
	
	/**Tests to make sure a student's email is not
	 * null or an empty string.  Also makes sure that there is both
	 * an "@" character, a "." character, and that the last "." is
	 * after the "@"
	 */
	@Test
	public void testSetEmail() {
		Student s = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASH_PASSWORD);
		try {
		    s.setEmail(null);
		    fail(); 
		} catch (IllegalArgumentException e) {
		    assertEquals(EMAIL, s.getEmail());
		}	
		
		try {
		    s.setEmail("");
		    fail(); 
		} catch (IllegalArgumentException e) {
		    assertEquals(EMAIL, s.getEmail());
		}
		
		try {
			s.setEmail("emailATncsu.edu");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(EMAIL, s.getEmail());
		}
		
		try {
			s.setEmail("email@ncsuDOTedu");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(EMAIL, s.getEmail());
		}
		
		try {
			s.setEmail("email.ncsu@edu");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(EMAIL, s.getEmail());
		}
	}
	

	/**Tests to make sure a student's password is not
	 * null or an empty string
	 */
	@Test
	public void testSetPassword() {
		Student s = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASH_PASSWORD);
		try {
		    s.setPassword(null);
		    fail(); 
		} catch (IllegalArgumentException e) {
		    assertEquals(HASH_PASSWORD, s.getPassword());
		}	
		
		try {
		    s.setPassword("");
		    fail(); 
		} catch (IllegalArgumentException e) {
		    assertEquals(HASH_PASSWORD, s.getPassword());
		}
	}

	/**Tests to make sure a student's credit hours is not
	 * less than 3 or greater than 18
	 */
	@Test
	public void testSetMaxCredits() {
		Student s = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASH_PASSWORD, MAX_CREDITS);
		try {
		    s.setMaxCredits(2);
		    fail(); 
		} catch (IllegalArgumentException e) {
		    assertEquals(MAX_CREDITS, s.getMaxCredits());
		}	
		
		try {
		    s.setMaxCredits(19);
		    fail(); 
		} catch (IllegalArgumentException e) {
		    assertEquals(MAX_CREDITS, s.getMaxCredits());
		}
	}

	/**Tests that two identical student objects are correctly
	 * valued as equal in both directions, and tests to make sure
	 * two Students are correctly invalid for each parameter
	 */
	@Test
	public void testEqualsObject() {
		Student s1 = new Student("first", "last", "id", "email@ncsu.edu", "hashedpassword", MAX_CREDITS);
		Student s2 = new Student("first", "last", "id", "email@ncsu.edu", "hashedpassword", MAX_CREDITS);
		Student s3 = new Student("first", "Different", "id", "email@ncsu.edu", "hashedpassword", MAX_CREDITS);
		Student s4 = new Student("first", "last", "Different", "email@ncsu.edu", "hashedpassword", MAX_CREDITS);
		Student s5 = new Student("first", "last", "id", "Different@ncsu.edu", "hashedpassword", MAX_CREDITS);
		Student s6 = new Student("first", "last", "id", "email@ncsu.edu", "Different", MAX_CREDITS);
		Student s7 = new Student("first", "last", "id", "email@ncsu.edu", "hashedpassword", 18);
		
		//Test for equality in both directions
		assertTrue(s1.equals(s2));
		assertTrue(s2.equals(s1));
		
		//Test for each of the fields
		assertFalse(s1.equals(s3));
		assertFalse(s1.equals(s4));
		assertFalse(s1.equals(s5));
		assertFalse(s1.equals(s6));
		assertFalse(s1.equals(s7));

	}

	/**Tests that two identical student objects has the same
	 * hashed passwords in both directions, and tests to make sure
	 * two Students have different hashed passwords for each parameter
	 */
	@Test
	public void testHashCode() {
		Student s1 = new Student("first", "last", "id", "email@ncsu.edu", "hashedpassword", MAX_CREDITS);
		Student s2 = new Student("first", "last", "id", "email@ncsu.edu", "hashedpassword", MAX_CREDITS);
		Student s3 = new Student("first", "Different", "id", "email@ncsu.edu", "hashedpassword", MAX_CREDITS);
		Student s4 = new Student("first", "last", "Different", "email@ncsu.edu", "hashedpassword", MAX_CREDITS);
		Student s5 = new Student("first", "last", "id", "Different@ncsu.edu", "hashedpassword", MAX_CREDITS);
		Student s6 = new Student("first", "last", "id", "email@ncsu.edu", "Different", MAX_CREDITS);
		Student s7 = new Student("first", "last", "id", "email@ncsu.edu", "hashedpassword", 18);
		
		//Test for the same hash code for the same values
		assertEquals(s1.hashCode(), s2.hashCode());
		
		//Test for each of the fields
		assertNotEquals(s1.hashCode(), s3.hashCode());
		assertNotEquals(s1.hashCode(), s4.hashCode());
		assertNotEquals(s1.hashCode(), s5.hashCode());
		assertNotEquals(s1.hashCode(), s6.hashCode());
		assertNotEquals(s1.hashCode(), s7.hashCode());
	}

	/**Tests to makes sure that the toString method produces the expected
	 * string output
	 */
	@Test
	public void testToString() {
		Student s1 = new Student("first", "last", "id", "email@ncsu.edu", "hashedpassword", MAX_CREDITS);
		String o1 = "first,last,id,email@ncsu.edu,hashedpassword,15";
		assertEquals(o1, s1.toString());

	}

}
