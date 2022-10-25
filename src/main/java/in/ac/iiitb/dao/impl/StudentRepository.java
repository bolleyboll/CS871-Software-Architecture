package in.ac.iiitb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ac.iiitb.dao.StudentService;
import in.ac.iiitb.models.Student;
import in.ac.iiitb.dao.*;

public class StudentRepository {

	public String save(Student s) {
		String query = "INSERT INTO student(id, name, username, password) values ('" + s.getId() + "', '" + s.getName() +"', '" + s.getUsername() + "', '" + s.getPassword() + "')";
		Connection connection = DBConn.getUniqueInstance();
        PreparedStatement p = null;
  
        try {
			p = connection.prepareStatement(query);
            p.executeQuery();
			return "Saved";
        }
 
        catch (SQLException e) {
            System.out.println(e);
			return "Failed";
        }
	}

	@Override
	public Student findStudentByEmail(String email) {
		String query = "SELECT name FROM student WHERE email=" + email;
		Connection connection = DBConn.getUniqueInstance();
		Student s = new Student();
        PreparedStatement p = null;
        ResultSet rs = null;
  
        try {
			p = connection.prepareStatement(query);
            rs = p.executeQuery();
 			if (rs.next())
			{
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String em = rs.getString("email");
                String password = rs.getString("password");
				Student st = new Student(id, name, em, password);
				s = st;
            }
        }
 
        catch (SQLException e) {
            System.out.println(e);
        }
		return s;
	}

	public Student findStudentByUsername(String uname) {
		String query = "SELECT name FROM student WHERE uname=" + uname;
		Student s = new Student();
		s.setUsername(uname);
		return s;
	}
}