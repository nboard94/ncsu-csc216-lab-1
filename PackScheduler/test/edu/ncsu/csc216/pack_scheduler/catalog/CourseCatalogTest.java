package edu.ncsu.csc216.pack_scheduler.catalog;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;


/**
 * Tests CourseCatalog
 * @author James Ticatic
 */
public class CourseCatalogTest {
	/** Valid course records */
	private final String validTestFile = "test-files/actual_course_records.txt";
	
	/**
	 * Resets course_records.txt for use in other tests.
	 * @throws Exception if something fails during setup.
	 */
	@Before
	public void setUp() throws Exception {		
		//Reset student_records.txt so that it's fine for other needed tests
		Path sourcePath = FileSystems.getDefault().getPath("test-files", "expected_course_records.txt");
		Path destinationPath = FileSystems.getDefault().getPath("test-files", "student_record.txt");
		try {
			Files.deleteIfExists(destinationPath);
			Files.copy(sourcePath, destinationPath);
		} catch (IOException e) {
			fail("Unable to reset files");
		}
	}

	/**
	 * Tests CourseCatalog().
	 */
	@Test
	public void testCourseCatalog() {
		//Test that the StudentDirectory is initialized to an empty list
		CourseCatalog catalog = new CourseCatalog();
		assertEquals(0, catalog.getCourseCatalog().length);
	}

	/**
	 * Tests CourseCatalog.loadCoursesFromFile().
	 */
	@Test
	public void testLoadCoursesFromFile() {
		CourseCatalog catalog = new CourseCatalog();
				
		//Test valid file
		catalog.loadCoursesFromFile(validTestFile);
		assertEquals(3, catalog.getCourseCatalog().length);
		String [][] studentDirectory = catalog.getCourseCatalog();
		assertEquals("CSC116", studentDirectory[0][0]);
		assertEquals("CSC216", studentDirectory[1][0]);
		assertEquals("CSC216", studentDirectory[2][0]);
		
		//test invalid file
		try {
			catalog.loadCoursesFromFile("invalid");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Unable to read file invalid" , e.getMessage());
		}
	}
	
	/**
	 * Tests CourseCatalog.addCourseToCatalog().
	 */
	@Test
	public void testAddCourseToCatalog() {
		CourseCatalog catalog = new CourseCatalog();
		
		//Test valid Course
		catalog.addCourseToCatalog("CSC116", "Intro to Programming - Java", "003", 3, "spbalik", "MW", 1250, 1440);
		String [][] courseCatalog = catalog.getCourseCatalog();
		assertEquals(1, courseCatalog.length);
		assertEquals("CSC116", courseCatalog[0][0]);
		assertEquals("003", courseCatalog[0][1]);
		assertEquals("Intro to Programming - Java", courseCatalog[0][2]);
		
		//Test adding same course twice
		assertEquals(catalog.addCourseToCatalog("CSC116", "Intro to Programming - Java", "003", 3, "spbalik", "MW", 1250, 1440), false);
	}
	
	/**
	 * Tests CourseCatalog.removeCourseFromCatalog().
	 */
	@Test
	public void testRemoveCourseFromCatalog() {
		CourseCatalog catalog = new CourseCatalog();
				
		//Test valid remove
		catalog.loadCoursesFromFile(validTestFile);
		catalog.removeCourseFromCatalog("CSC116", "003");
		String [][] courseCatalog = catalog.getCourseCatalog();
		assertEquals(2, courseCatalog.length);
		assertEquals("CSC216", courseCatalog[0][0]);
		assertEquals("001", courseCatalog[0][1]);
		
		//Test invalid remove
		assertEquals(catalog.removeCourseFromCatalog("CSC116", "003"), false);
	}
	
	/**
	 * Tests CourseCatalo.saveCourseCatalog().
	 */
	@Test
	public void testSaveCourseCatalog() {
		CourseCatalog catalog = new CourseCatalog();
		
		//Tests valid save
		catalog.loadCoursesFromFile(validTestFile);
		assertEquals(3, catalog.getCourseCatalog().length);
		catalog.saveCourseCatalog("test-files/actual_course_records.txt");
		checkFiles("test-files/expected_course_records.txt", "test-files/actual_course_records.txt");
	}
	
	/**
	 * Helper method to compare two files for the same contents
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try {
			Scanner expScanner = new Scanner(new FileInputStream(expFile));
			Scanner actScanner = new Scanner(new FileInputStream(actFile));
			
			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}
			
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}

}
