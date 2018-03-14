package com.web.demo.dao;

import java.util.List;

import com.web.demo.pojo.Student;

interface StudentDao {
	void saveStudent(Student student);
	void deleteStudent(String number);
	void deleteStudent(Student student);
	void updateStudent(Student student);
	Student getStudentByNumber(String number);
	List<Student> getAllStudents();
}
