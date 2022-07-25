package com.coderscampusAssignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class StudentService {

	protected Student[] students;
	protected Course[] courses;

	public void parseFile(String fileName) {

		this.students = null;
		BufferedReader bufferedReader = null;
		int studentLength = compStudentLength(fileName);

		if (studentLength > 0) {

			this.students = new Student[studentLength];
			try {
				bufferedReader = new BufferedReader(new FileReader(fileName));
				String line = null;
				String[] parsedString = null;
				int count = 0;

				bufferedReader.readLine();

				while (((line = bufferedReader.readLine()) != null) && (count < studentLength)) {

					parsedString = line.trim().split(",");
					this.students[count] = new Student(Integer.parseInt(parsedString[0]), parsedString[1],
							parsedString[2], Integer.parseInt(parsedString[3]));
					count++;
				}

			}

			catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			catch (IOException e) {
				e.printStackTrace();
			}

			finally {
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					}

					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		courseArrays();
	}

	private void courseArrays() {

		this.courses = new Course[3];
		this.courses[0] = new Course(this.students.length, "COMPSCI");
		this.courses[1] = new Course(this.students.length, "APMTH");
		this.courses[2] = new Course(this.students.length, "STAT");

		for (int count = 0; count < this.students.length; count++) {
			if (this.students[count].getCourseName().startsWith("COMPSCI")) {
				this.courses[0].setStudent(count,
						new Student(this.students[count].getStudentId(), this.students[count].getStudentName(),
								this.students[count].getCourseName(), this.students[count].getGrade()));
			}

			else if (this.students[count].getCourseName().startsWith("APMTH")) {
				this.courses[1].setStudent(count,
						new Student(this.students[count].getStudentId(), this.students[count].getStudentName(),
								this.students[count].getCourseName(), this.students[count].getGrade()));
			}

			else if (this.students[count].getCourseName().startsWith("STAT")) {
				this.courses[2].setStudent(count,
						new Student(this.students[count].getStudentId(), this.students[count].getStudentName(),
								this.students[count].getCourseName(), this.students[count].getGrade()));
			}

		}

		for (int count = 0; count < this.courses.length; count++)

		{
			Arrays.sort(this.courses[count].getStudent(), new Comparator<Student>() {

				@Override
				public int compare(Student student1, Student student2)

				{
					if (student1 == null && student2 == null) {
						return 0;
					} else if (student1 == null && student2 != null) {
						return 1;
					} else if (student1 != null && student2 == null) {
						return -1;
					} else {
						return student2.getGrade() - student1.getGrade();
					}

				}

			});
		}

		writeCoursesToFiles();

	}

	protected void writeCoursesToFiles() {

		BufferedWriter bufferedWriter = null;
		int courseCount = 0;
		String courseFileName = null;

		for (courseCount = 0; courseCount < this.courses.length; courseCount++) {

			courseFileName = "course" + (courseCount + 1) + ".csv";

			try {
				bufferedWriter = new BufferedWriter(new FileWriter(courseFileName));

				bufferedWriter.write("Student ID,Student Name,Course,Grade\n");

				for (int i = 0; i < this.students.length; i++) {
					if (this.courses[courseCount].getStudent()[i] != null) {
						bufferedWriter.write(String.valueOf(this.courses[courseCount].getStudent()[i].getStudentId())
								+ "," + this.courses[courseCount].getStudent()[i].getStudentName() + ","
								+ this.courses[courseCount].getStudent()[i].getCourseName() + ","
								+ this.courses[courseCount].getStudent()[i].getGrade() + "\n");
					}
				}
			}

			catch (IOException e) {
				e.printStackTrace();
			}

			finally {
				if (bufferedWriter != null) {
					try {
						bufferedWriter.close();
					}

					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private int compStudentLength(String fileName) {
		int length = 0;
		BufferedReader bufferedReader = null;

		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));

			bufferedReader.readLine();

			while (bufferedReader.readLine() != null) {
				length++;

			}

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				bufferedReader.close();
			}

			catch (IOException e) {
				e.printStackTrace();
			}
		}

		return length;
	}

}
