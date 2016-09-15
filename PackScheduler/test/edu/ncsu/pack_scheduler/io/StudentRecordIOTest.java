package edu.ncsu.pack_scheduler.io;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.collections.list.SortedList;
import edu.ncsu.csc216.pack_scheduler.io.StudentRecordIO;
import edu.ncsu.csc216.pack_scheduler.user.Student;


/**
 * Tests the StudentRecordIOTest class
 * 
 * @author James Ticatic and Nick Board
 */
public class StudentRecordIOTest {
	
	/** Expected results for valid courses */
	private final String validCourse1 = "Zahir,King,zking,orci.Donec@ametmassaQuisque.com,pw,15";
	private final String validCourse2 = "Cassandra,Schwartz,cschwartz,semper@imperdietornare.co.uk,pw,4";
	private final String validCourse3 = "Shannon,Hansen,shansen,convallis.est.vitae@arcu.ca,pw,14";
	private final String validCourse4 = "Demetrius,Austin,daustin,Curabitur.egestas.nunc@placeratorcilacus.co.uk,pw,18";
	private final String validCourse5 = "Raymond,Brennan,rbrennan,litora.torquent@pellentesquemassalobortis.ca,pw,12";
	private final String validCourse6 = "Emerald,Frost,efrost,adipiscing@acipsumPhasellus.edu,pw,3";
	private final String validCourse7 = "Lane,Berg,lberg,sociis@non.org,pw,14";
	private final String validCourse8 = "Griffith,Stone,gstone,porta@magnamalesuadavel.net,pw,17";
	private final String validCourse9 = "Althea,Hicks,ahicks,Phasellus.dapibus@luctusfelis.com,pw,11";
	private final String validCourse10 = "Dylan,Nolan,dnolan,placerat.Cras.dictum@dictum.net,pw,5";
	
	/** Array to hold expected results */
	private final String [] validStudents = {validCourse1, validCourse2, validCourse3, validCourse4,
			validCourse5, validCourse6, validCourse7, validCourse8, validCourse9, validCourse10};

	private String hashPW;
	private static final String HASH_ALGORITHM = "SHA-256";

	/**Sets up the hash algorithm.
	 * Handles NoSuchAlgorithmException.
	 */
	@Before
	public void setUp() {
	    try {
	        String password = "pw";
	        MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
	        digest.update(password.getBytes());
	        hashPW = new String(digest.digest());
	        
	        for (int i = 0; i < validStudents.length; i++) {
	            validStudents[i] = validStudents[i].replace(",pw,", "," + hashPW + ",");
	        }
	    } catch (NoSuchAlgorithmException e) {
	        fail("Unable to create hash during setup");
	    }
	}
	
	/**test to make sure the method can read in from a file to
	 * the ArrayList of Students by using both correctly and incorrectly
	 * formatted files.  Checks to make sure the size of the arraylist is
	 * the expected size.  Handles the FileNotFound exception.
	 * 
	 */
	@Test
	public void testReadStudentRecords() {
		String validTestFile = "test-files/student_records.txt";
		String invalidTestFile = "test-files/invalid_student_records.txt";
		try {
			SortedList<Student> students = StudentRecordIO.readStudentRecords(validTestFile);
			assertEquals(10, students.size());

		} catch (FileNotFoundException e) {
			fail("Unexpected error reading " + validTestFile);
		}
		SortedList<Student> courses;
		try {
			courses = StudentRecordIO.readStudentRecords(invalidTestFile);
			assertEquals(0, courses.size());
		} catch (FileNotFoundException e) {
			fail("Unexpected FileNotFoundException");
		}
		try {
			courses = StudentRecordIO.readStudentRecords("Invalid");
			fail();
		} catch (FileNotFoundException e) {
			assertEquals("Invalid (No such file or directory)", e.getMessage());
		}
	}

	/**Tests to make sure the method can write from an arraylist to a file
	 * as expected.  
	 * Handles IOExceptions.
	 */
	@Test
	public void testWriteStudentRecords()  {
		SortedList<Student> students = new SortedList<Student>();
		students.add(new Student("Zahir", "King", "zking", "orci.Donec@ametmassaQuisque.com", hashPW, 15));
		setUp();
		
		try {
			StudentRecordIO.writeStudentRecords("test-files/actual_student_records.txt", students);
		} catch (IOException e) {
			fail("Cannot write to course records file");
		}
		
		checkFiles("test-files/expected_student_records.txt", "test-files/actual_student_records.txt");
	}
	
	/**Tests to make sure that you cannot write to a file without the 
	 * proper permission.
	 * Handles IOException
	 */
	@Test
	public void testWriteStudentRecordsNoPermissions() {
	    SortedList<Student> students = new SortedList<Student>();
	    students.add(new Student("Zahir", "King", "zking", "orci.Donec@ametmassaQuisque.com", hashPW, 15));
	    //Assumption that you are using a hash of "pw" stored in hashPW
	    
	    try {
	        StudentRecordIO.writeStudentRecords("/home/sesmith5/actual_student_records.txt", students);
	        fail("Attempted to write to a directory location that doesn't exist or without the appropriate permissions and the write happened.");
	    } catch (IOException e) {
	        assertEquals("/home/sesmith5/actual_student_records.txt (Permission denied)", e.getMessage());
	        //The actual error message on Jenkins!
	    }
	    
	    checkFiles("ts-test-files/expected_student_records.txt", "ts-test-files/actual_student_records.txt");
	}
	
	
	/**Compares the actual information in a file to the expected
	 * information to be contained in the file.
	 * Handles IOException
	 * @param expFile
	 * @param actFile
	 */
	private void checkFiles(String expFile, String actFile) {
	    try {
	        Scanner expScanner = new Scanner(new FileInputStream(expFile));
	        Scanner actScanner = new Scanner(new FileInputStream(actFile));
	        
	        while (expScanner.hasNextLine()  && actScanner.hasNextLine()) {
	            String exp = expScanner.nextLine();
	            String act = actScanner.nextLine();
	            assertEquals("Expected: " + exp + " Actual: " + act, exp, act);
	        }
	        if (expScanner.hasNextLine()) {
	            fail("The expected results expect another line " + expScanner.nextLine());
	        }
	        if (actScanner.hasNextLine()) {
	            fail("The actual results has an extra, unexpected line: " + actScanner.nextLine());
	        }
	        
	        expScanner.close();
	        actScanner.close();
	    } catch (IOException e) {
	        fail("Error reading files.");
	    }
	}
}
