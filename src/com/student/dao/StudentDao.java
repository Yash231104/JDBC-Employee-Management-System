package com.student.dao;



import java.util.List;

import com.student.bean.Students;

public interface StudentDao {

	int saveStudent(Students s);
	int deleteStudent(int roll);
	int updateStudent(int roll,String a);
	List<Students>viewAllStudent();
	Students viewStudentByRollNo(int roll);
	
}
