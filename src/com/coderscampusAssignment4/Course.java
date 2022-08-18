package com.coderscampusAssignment4;

//a comment

public class Course {

	private String courseName;
	private Student[] student;

	public Course(int maxNumbOfStudents, String courseName) {
		this.courseName = courseName;
		this.student = new Student[maxNumbOfStudents];
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Student[] getStudent() {
		return student;
	}

	public void setStudent(Student[] student) {
		this.student = student;
	}

	public void setStudent(int count, Student student) {

		this.student[count] = student;

	}

}
