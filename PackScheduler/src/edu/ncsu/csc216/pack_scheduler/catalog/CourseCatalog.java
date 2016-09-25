package edu.ncsu.csc216.pack_scheduler.catalog;

import java.io.FileNotFoundException;
import java.io.IOException;


import edu.ncsu.csc216.collections.list.SortedList;
import edu.ncsu.csc216.pack_scheduler.course.Course;
import edu.ncsu.csc216.pack_scheduler.io.CourseRecordIO;

/**
 * Course Catalog creates a sortedlist of courses and provides methods for adding courses, loading them from files
 * getting courses from catalog, and saving a catalog
 * @author James Ticatic
 *
 */
public class CourseCatalog {

	/** List of students in the directory */
	private SortedList<Course> catalog;
	
	/**
	 * Constructor for course catalogs
	 */
	public CourseCatalog() {
		newCourseCatalog();
	}

	/**
	 * Creates an empty new course catalog
	 */
	public void newCourseCatalog(){
		catalog = new SortedList<Course>();
	}
	
	/**
	 * Constructs the course catalog by reading in student information
	 * from the given file.  Throws an IllegalArgumentException if the 
	 * file cannot be found.
	 * @param fileName file containing list of students
	 */
	public void loadCoursesFromFile(String fileName) {
		try {
			catalog = CourseRecordIO.readCourseRecords(fileName);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to read file " + fileName);
		}
	}
	
	/**
	 * Adds a course to catalog by manually entering fields
	 * @param name name of course
	 * @param title title of course
	 * @param section section number of course
	 * @param credits number of credits course counts for
	 * @param instructorId the courses instructors unity id
	 * @param meetingDays the days the course meets
	 * @param startTime the time the course starts
	 * @param endTime the time the course ends
	 * @return true if course is added successfully
	 */
	public boolean addCourseToCatalog(String name, String title, String section, int credits, String instructorId, String meetingDays,
									  int startTime, int endTime) {
		Course course = new Course(name, title, section, credits, instructorId, meetingDays, startTime, endTime);

		for (int i = 0; i < catalog.size(); i++) {
			Course checkCourse = catalog.get(i);
			if (checkCourse.getName().equals(name) && checkCourse.getSection().equals(section)) {
				return false;	
			}
		}
		
		return catalog.add(course);
	}
	
	/**
	 * Removes the course from the catalog if possible.
	 * @param name name of course
	 * @param section course's section number
	 * @return true if removed
	 */
	public boolean removeCourseFromCatalog(String name, String section) {
		for (int i = 0; i < catalog.size(); i++) {
			Course c = catalog.get(i);
			if (c.getName().equals(name) && c.getSection().equals(section)) {
				catalog.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Turns the course catalog into an abbreviated string array
	 * @return CourseCatalog a 2d string array of the courses in the catalog
	 */
	public String[][] getCourseCatalog() {
		String [][] courseCatalog = new String [catalog.size()][4];
		if (catalog.isEmpty()) {
			return courseCatalog;
		}
		for (int i = 0; i < catalog.size(); i++) {
			courseCatalog[i][0] = catalog.get(i).getName(); 
			courseCatalog[i][1] = catalog.get(i).getSection();
			courseCatalog[i][2] = catalog.get(i).getTitle();
			courseCatalog[i][3] = catalog.get(i).getMeetingString();
		}
		return courseCatalog;
	}
	
	/**
	 * retrieves a course from the catalog if it exists
	 * @param name the name of the course
	 * @param section the courses section
	 * @return the course
	 */
	public Course getCourseFromCatalog(String name, String section) {
		for (int i = 0; i < catalog.size(); i++) {
			if (catalog.get(i).getName().equals(name) && catalog.get(i).getSection().equals(section)) {
				return catalog.get(i);
			}
		}
		return null;
	}
	
	/**
	 * saves the file to filename
	 * @param fileName the name of the file
	 */
	public void saveCourseCatalog(String fileName) {
		try {
			CourseRecordIO.writeCourseRecords(fileName, catalog);
		} catch (IOException e) {
			throw new IllegalArgumentException("The file cannot be saved");
		}
	}
}
