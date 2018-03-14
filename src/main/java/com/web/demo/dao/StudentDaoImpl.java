package com.web.demo.dao;

import java.util.List;

import com.web.demo.pojo.Student;

public class StudentDaoImpl implements StudentDao{

	@Override
	public void saveStudent(Student student) {
		
	}

	@Override
	public void deleteStudent(String number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		deleteStudent(student.getNumber());
	}

	@Override
	public void updateStudent(Student student) {
		
	}

	@Override
	public Student getStudentByNumber(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
