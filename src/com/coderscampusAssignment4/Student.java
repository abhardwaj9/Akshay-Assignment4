package com.coderscampusAssignment4;

public class Student {

	private int studentId;
	private String studentName;
	private String courseName;
	private int grade;

	public Student(int studentId, String studentName, String courseName, int grade) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseName = courseName;
		this.grade = grade;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
