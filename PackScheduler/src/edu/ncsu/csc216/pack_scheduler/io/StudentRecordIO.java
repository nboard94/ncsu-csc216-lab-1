package edu.ncsu.csc216.pack_scheduler.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


import edu.ncsu.csc216.pack_scheduler.user.Student;

public class StudentRecordIO {

	public static ArrayList<Student> readStudentRecords(String fileName) throws FileNotFoundException {
		ArrayList<Student> md = new ArrayList<Student>();
		File file = new File(fileName);
		Scanner scan = new Scanner (file);
		try {
			while (scan.hasNextLine()) {
				md.add(processStudent(scan.nextLine()));
			}
		}
		catch (NoSuchElementException e) {
			scan.close();
			throw new IllegalArgumentException();
		}	
		scan.close();
		return md;
	}

	public static void writeStudentRecords(String fileName, ArrayList<Student> studentDirectory) throws IOException {
		File file = new File(fileName);
		FileWriter writ = new FileWriter(file);
		for (int i = 0; i <  studentDirectory.size(); i++) {
			writ.write(studentDirectory.toString());
		}
		writ.close();
		
	}

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
			throw new IllegalArgumentException();
		}
		scan.close();
		Student s = new Student(firstName,lastName,id,email,hashPW,maxCredits);
		return s;
	}
}
