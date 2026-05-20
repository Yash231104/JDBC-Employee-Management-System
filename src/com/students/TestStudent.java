package com.students;

import java.util.List;
import java.util.Scanner;

import com.student.bean.Students;
import com.student.dao.StudentDao;
import com.student.dao.studentsDaoImpl;
import com.student.util.InitConnection;

public class TestStudent {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	do {
		System.out.println("press 1:Save");
		System.out.println("press 2:Update");
		System.out.println("press 3:Delete");
		System.out.println("press 4:View All Students");
		System.out.println("press 5:View Student by RollNo");
		System.out.println("press 6:Exit");
		
		int ch =sc.nextInt();
		
		StudentDao sd=new studentsDaoImpl();
		switch(ch) {
		
		
		case 1:
			System.out.println("Enter the Roll,Name,Address and percentage");
			Students stud=new Students(sc.nextInt(),sc.next(),sc.next(),sc.nextFloat());
			int res=sd.saveStudent(stud);
			if(res>0) {
				System.out.println("Student inserted successfully!!!");
			}
			else {
				System.out.println("Error occured in insertion");
			}
		break;
		
		
		
		case 2:
			System.out.println("Enter the roll and updated address");
			int r=sc.nextInt();
			String a=sc.next();
			res =sd.updateStudent(r, a);
			if(res>0) {
				System.out.println("student updated successfully!!!");
			}else {
				System.out.println("error in updation");
			}
			break;
			
			
			
		case 3:
			System.out.println("Enter the roll ");
			r=sc.nextInt();
			res=sd.deleteStudent(r);
			if(res>0) {
				System.out.println("student deleted successfully!!!");
			}else {
				System.out.println("error in deletion");
			}
			break;
		case 4:
			List<Students>all =sd.viewAllStudent();
			for(Students ss:all) {
				System.out.println(ss);
			}
			break;
		case 5:
			System.out.println("Enter the roll");
			r=sc.nextInt();
			Students s1=sd.viewStudentByRollNo(r);
			System.out.println(s1);
			break;
		case 6:try {
			InitConnection.createConnection().close();
			System.exit(0);
		}catch(Exception e) {
			System.out.println(e);
		}
			break;
		}
	}while(true);
}
}
