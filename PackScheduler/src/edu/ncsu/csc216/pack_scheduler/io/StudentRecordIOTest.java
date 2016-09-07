package edu.ncsu.csc216.pack_scheduler.io;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.pack_scheduler.user.Student;


public class StudentRecordIOTest {
	private String hashPW;
	private static final String HASH_ALGORITHM = "SHA-256";
	
	@Before
	public void setUp() {
//	    try {
//	        String password = "pw";
//	        MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
//	        digest.update(password.getBytes());
//	        hashPW = new String(digest.digest());
//	        
//	        Object[] validStudents = null;
//			for (int i = 0; i < validStudents.length; i++) {
//	            validStudents[i] = ((String) validStudents[i]).replace(",pw,", "," + hashPW + ",");
//	        }
//	    } catch (NoSuchAlgorithmException e) {
//	        fail("Unable to create hash during setup");
//	    }
	}
	@Test
	public void testReadStudentRecords() {
		String validTestFile = "test-files/student_records.txt";
		String invalidTestFile = "test-files/invalid_student_records.txt";
		try {
			ArrayList<Student> students = StudentRecordIO.readStudentRecords(validTestFile);
			assertEquals(10, students.size());

		} catch (FileNotFoundException e) {
			fail("Unexpected error reading " + validTestFile);
		}
		ArrayList<Student> courses;
		try {
			courses = StudentRecordIO.readStudentRecords(invalidTestFile);
			assertEquals(0, courses.size());
		} catch (FileNotFoundException e) {
			fail("Unexpected FileNotFoundException");
		}
	}

	@Test
	public void testWriteStudentRecords() {
		fail("Not yet implemented");
	}
	
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
