package edu.ncsu.csc216.pack_scheduler.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


import edu.ncsu.csc216.pack_scheduler.user.Student;

/**
 * Handles input and outputs 
 * @author James Ticatic
 * @author Nicholas Board

 */
public class StudentRecordIO {

	/**
	 * Reads in a file of student records
	 * @param fileName the name of the file
	 * @return md the array list of students
	 */
	public static ArrayList<Student> readStudentRecords(String fileName) throws FileNotFoundException {
		ArrayList<Student> md = new ArrayList<Student>();
		Scanner scan = new Scanner (new FileInputStream(fileName));
		while (scan.hasNextLine()) {
			try {
				md.add(processStudent(scan.nextLine()));
			}
			catch (NoSuchElementException e) {
				scan.close();
			}
		}
		scan.close();
		return md;
	}

	/**
	 * Writes student records into directory
	 * @param fileName the name of the file 
	 * @param studentDirectory the array list of students
	 */
	public static void writeStudentRecords(String fileName, ArrayList<Student> studentDirectory) throws IOException {
		File file = new File(fileName);
		FileWriter writ = new FileWriter(file);
		for (int i = 0; i <  studentDirectory.size(); i++) {
			writ.write(studentDirectory.get(i).toString());
		}
		writ.close();
		
	}

	/**
	 * Processes each individual student in the file
	 * @param line the current line of the student being read in
	 */
	private static Student processStudent(String line) {
		Scanner scan = new Scanner(line).useDelimiter(",");
		String firstName = null;
		String lastName = null;
		String id = null;
		String email = null;
		String hashPW = null;
		int maxCredits = 0;
		try {
			firstName = scan.next();
			lastName = scan.next();
			id = scan.next();
			email = scan.next();
			hashPW = scan.next();
			maxCredits = scan.nextInt();	
		}
		catch (NoSuchElementException e) {
			scan.close();
		}
		scan.close();
		Student s = new Student(firstName, lastName, id, email, hashPW, maxCredits);
		return s;
	}
}
