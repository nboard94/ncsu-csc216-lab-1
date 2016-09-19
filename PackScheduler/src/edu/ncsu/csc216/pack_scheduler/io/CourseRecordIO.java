package edu.ncsu.csc216.pack_scheduler.io;


import java.io.*;
import java.util.*;

import edu.ncsu.csc216.collections.list.SortedList;
import edu.ncsu.csc216.pack_scheduler.course.Course;

/**
 * Reads Course records from text files.  Writes a set of CourseRecords to a file.
 * 
 * @author James Ticatic
 */
public class CourseRecordIO {

    /**
     * Reads course records from a file and generates a list of valid Courses.  Any invalid
     * Courses are ignored.  If the file to read cannot be found or the permissions are incorrect
     * a File NotFoundException is thrown.
     * @param fileName file to read Course records from
     * @return a list of valid Courses
     * @throws FileNotFoundException if the file cannot be found or read
     */
	public static SortedList<Course> readCourseRecords(String fileName) throws FileNotFoundException {
	    Scanner fileReader = new Scanner(new File(fileName));
	    SortedList<Course> courses = new SortedList<Course>();
	    while (fileReader.hasNextLine()) {
	        try {
	            Course course = readCourse(fileReader.nextLine());
	            boolean duplicate = false;
	            for (int i = 0; i < courses.size(); i++) {
	                Course c = courses.get(i);
	                if (course.getName().equals(c.getName()) &&
	                        course.getSection().equals(c.getSection())) {
	                    //it's a duplicate
	                    duplicate = true;
	                }
	            }
	            if (!duplicate) {
	                courses.add(course);
	            }
	        } catch (IllegalArgumentException e) {
	            //skip the line
	        }
	    }
	    fileReader.close();
	    return courses;
	}
	
	/**
	 * reads in each line of the file as an individual course
	 * @param nextLine the line being scanned
	 * @return c the course read in
	 */
	private static Course readCourse(String nextLine) {
		Scanner scan = new Scanner(nextLine);
		scan.useDelimiter(",");
		String name;
		String title;
		String section;
		int credits;
		String instructorId;
		String meetingDays;
		int startTime;
		int endTime;
		try {
			name = scan.next();
			title = scan.next();
			section = scan.next();
			credits = scan.nextInt();
			instructorId = scan.next();
			meetingDays = scan.next();
			if (meetingDays.equals("A") && !scan.hasNext()) {
				Course c = new Course(name, title, section, credits, instructorId, meetingDays);
				scan.close();
				return c;
			}
			else {
				startTime = scan.nextInt();
				endTime = scan.nextInt();
				Course c = new Course(name, title, section, credits, instructorId, meetingDays, startTime, endTime);
				scan.close();
				return c;
			}
		}
		catch (NoSuchElementException e) {
			scan.close();
			throw new IllegalArgumentException();
		}
	}

	/**
     * Writes the given list of Courses to a file
     * @param fileName the name of the file
     * @param catalog an arraylist of the courses
     * @throws IOException exception if file cannot be written
     */
    public static void writeCourseRecords(String fileName, SortedList<Course> catalog) throws IOException {
    	PrintStream fileWriter = new PrintStream(new File(fileName));

    	for (int i = 0; i < catalog.size(); i++) {
    	    fileWriter.println(catalog.get(i).toString());
    	}

    	fileWriter.close();
    }

}