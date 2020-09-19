package com.jsp.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDbUtil {

	public static List<Student> getStudents() throws Exception {

		List<Student> students = new ArrayList<Student>();
		Connection con = null;
		Statement stmt = null;
		ResultSet myRs = null;
		try {

			con = Db.getCon();
			String sql = "select * from student order by first_name";
			stmt = con.createStatement();
			myRs = stmt.executeQuery(sql);

			while (myRs.next()) {
				int id = myRs.getInt("id");
				String fname = myRs.getString("first_Name");
				String lname = myRs.getString("last_Name");
				String email = myRs.getString("email");
				Student student = new Student(id, fname, lname, email);
				students.add(student);
			}
			return students;
		} finally {
			close(con, myRs, stmt);
		}

	}

	private static void close(Connection con, ResultSet myRs, Statement stmt) {
		try {
			if (con != null) {
				con.close();
			}
			if (myRs != null) {
				myRs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addStudent(Student student) throws Exception {
		Connection con = null;
		PreparedStatement psmt = null;
		try {
			con = Db.getCon();
			String sql = " insert into student (first_name,last_name,email) values (?,?,?) ";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, student.getFirstName());
			psmt.setString(2, student.getLastName());
			psmt.setString(3, student.getEmail());
			psmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, null, psmt);
		}

	}

	public static Student getStudent(String id) throws Exception {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet myRs = null;
		Student theStudent = null;
		int stid;

		try {
			stid = Integer.parseInt(id);
			con = Db.getCon();
			String sql = " select * from student where id=? ";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, stid);
			myRs = psmt.executeQuery();

			if (myRs.next()) {
				String fname = myRs.getString("first_Name");
				String lname = myRs.getString("last_Name");
				String email = myRs.getString("email");
				theStudent = new Student(stid, fname, lname, email);
			} else {
				throw new Exception("Could not find student id : " + stid);
			}
			return theStudent;
		} finally {
			close(con, myRs, psmt);
		}

	}

	public static void updateStudent(Student student) throws Exception {
		Connection con = null;
		PreparedStatement psmt = null;
		try {
			con = Db.getCon();
			String sql = " update student set first_name=?, last_name=?, email=? where id=? ";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, student.getFirstName());
			psmt.setString(2, student.getLastName());
			psmt.setString(3, student.getEmail());
			psmt.setInt(4, student.getId());
			psmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, null, psmt);
		}
	}

	public static void deleteStudent(int id) throws Exception {
		Connection con = null;
		PreparedStatement psmt = null;
		try {
			con = Db.getCon();
			String sql = " delete from student where id=? ";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, null, psmt);
		}
	}
}
