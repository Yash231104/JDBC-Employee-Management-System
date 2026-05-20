package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.student.bean.Students;
import com.student.util.InitConnection;

public class studentsDaoImpl implements StudentDao{

	
	
	Connection con=InitConnection.createConnection();
	@Override
	public int saveStudent(Students s) {
	int x=0;
	try {
		PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?)");
		ps.setInt(1,s.getRoll());
		ps.setString(2,s.getName());
		ps.setString(3,s.getAddress());
		ps.setFloat(4,s.getPer());
		
		x=ps.executeUpdate();	
	}catch(Exception e) 
	{System.out.println(e);
	}
	return x;
	}
	
	

	@Override
	public int deleteStudent(int roll) {
		int x=0;
		try {
			PreparedStatement ps=con.prepareStatement("delete from student where roll=?");
			ps.setInt(1,roll);
			x=ps.executeUpdate();
			
		}catch(Exception e) 
		{System.out.println(e);
	     }
		return x;
	}
	
	

	@Override
	public int updateStudent(int roll, String address) {
		int x=0;
		try {
			PreparedStatement ps=con.prepareStatement("update student set address=? where roll=?");
			ps.setString(1, address);
			ps.setInt(2, roll);
			x=ps.executeUpdate();
		}catch(Exception e) 
		{System.out.println(e);
		}
		return x;
	}
	
	
	

	@Override
	public List<Students> viewAllStudent() {
		List<Students> allstud=new ArrayList<Students>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from student");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				
				Students s=new Students();
		        s.setRoll(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setAddress(rs.getString(3));
				s.setPer(rs.getFloat(4));
				allstud.add(s);
			}
		 }catch(Exception e) 
		{System.out.println(e);
		}
		return allstud ;
	}
	
	
	
	
	@Override
	public Students viewStudentByRollNo(int roll) {
		Students s=new Students();
		try {
			PreparedStatement ps=con.prepareStatement("select * from student where roll=?");
			ps.setInt(1, roll);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int r=rs.getInt(1);
				s.setRoll(r);
				
				s.setName(rs.getString(2));
				s.setAddress(rs.getString(3));
				s.setPer(rs.getFloat(4));
			}
			}catch(Exception e) 
		{System.out.println(e);
        }
		return s;
	}

}
