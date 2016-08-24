package edu.ncsu.csc216.pack_scheduler.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



import edu.ncsu.csc216.pack_scheduler.user.Student;

public class StudentRecordIO {

	public static ArrayList<Student> readStudentRecords(String fileName) throws FileNotFoundException {

		ArrayList<Student> md = new ArrayList<Student>();
		File file = new File(fileName);
		Scanner scan = new Scanner(file).useDelimiter(",");
		while (scan.hasNextLine()) {
			String firstName = scan.next();
			String lastName = scan.next();
			String id = scan.next();
			String email = scan.next();
			String hashPW = scan.next();
			int maxCredots = scan.nextInt();
			Student s = new Student(firstName,lastName,id,email,hashPW,maxCredots);
			md.add(s);
		}
		scan.close();
		
		return md;
	}

	public static void writeStudentRecords(String fileName, ArrayList<Student> studentDirectory) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
