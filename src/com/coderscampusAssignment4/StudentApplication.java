package com.coderscampusAssignment4;

public class StudentApplication {

	public static void main(String[] args) {

		String FILE = "student-master-list.csv";
		StudentService studentService = new StudentService();

		studentService.parseFile(FILE);

		System.out.println("Please Refresh!!");

	}

}
