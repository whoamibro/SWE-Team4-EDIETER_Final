package dao;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import sms.student.vo.Student;

public class StudentDAO {
	
	Connection con;
	
	public StudentDAO(Connection con) {
		this.con = con;
	}

	public int insertStudent(Student newStudent, Date birth) throws Exception{

		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO student VALUES (?,?,?,?,?,?);";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, newStudent.getStudent_no());
			pstmt.setString(2, newStudent.getStudent_name());
			pstmt.setInt(3, newStudent.getStudent_year());
			pstmt.setString(4, newStudent.getStudent_addr());
			pstmt.setString(5, newStudent.getStudent_tel());
			pstmt.setDate(6, birth);
			insertCount = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);			
		}

		return insertCount;
		
	}

	public ArrayList<Student> selectStudentList() throws Exception{

		ArrayList<Student> studentList = null;
		Student student = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student";

		try{
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()){
				studentList = new ArrayList<Student>();

				do{
					student = new Student(
							rs.getInt("student_no"),
							rs.getString("student_name"),
							rs.getInt("student_year"),
							rs.getString("student_addr"),
							rs.getString("student_tel"),
							rs.getDate("student_birth").toString());
					studentList.add(student);					
				}while(rs.next());
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}

		return studentList;
		
	}

	public Student selectStudent(int student_no) throws Exception{

		Student student = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student WHERE student_no = ?";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student_no);
			rs = pstmt.executeQuery();

			if(rs.next()){
				student = new Student(
						rs.getInt("student_no"),
						rs.getString("student_name"),
						rs.getInt("student_year"),
						rs.getString("student_addr"),
						rs.getString("student_tel"),
						rs.getDate("student_birth").toString());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}
		return student;
		
	}

	public ArrayList<Student> selectStudentByStudent_no(int student_no) {

		ArrayList<Student> searchStudentList = null;
		Student searchStudent = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student WHERE student_no like concat(?, '%')";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student_no);
			rs = pstmt.executeQuery();

			if(rs.next()){
				searchStudentList = new ArrayList<Student>();

				do{
					searchStudent = new Student(
							rs.getInt("student_no"),
							rs.getString("student_name"),
							rs.getInt("student_year"),
							rs.getString("student_addr"),
							rs.getString("student_tel"),
							rs.getDate("student_birth").toString());
					
					searchStudentList.add(searchStudent);
					
				}while(rs.next());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}
		
		return searchStudentList;
		
	}

	public ArrayList<Student> selectStudentListByStudent_name(String student_name) throws Exception{

		ArrayList<Student> searchStudentList = null;
		Student searchStudent = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student WHERE student_name like concat('%', ?, '%')";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student_name);
			rs = pstmt.executeQuery();

			if(rs.next()){
				searchStudentList = new ArrayList<Student>();

				do{
					searchStudent = new Student(
							rs.getInt("student_no"),
							rs.getString("student_name"),
							rs.getInt("student_year"),
							rs.getString("student_addr"),
							rs.getString("student_tel"),
							rs.getDate("student_birth").toString());


					searchStudentList.add(searchStudent);					

				}while(rs.next());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}

		return searchStudentList;
		
	}

	public ArrayList<Student> selectStudentListByStudent_year(int student_year) throws Exception {

		ArrayList<Student> searchStudentList = null;
		Student searchStudent = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student WHERE student_year = ?";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student_year);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				searchStudentList = new ArrayList<Student>();

				do{
					searchStudent = new Student(
							rs.getInt("student_no"),
							rs.getString("student_name"),
							rs.getInt("student_year"),
							rs.getString("student_addr"),
							rs.getString("student_tel"),
							rs.getDate("student_birth").toString());

					searchStudentList.add(searchStudent);					

				}while(rs.next());
			}
		}
		catch(Exception e) {
		}
		finally{
			close(rs);
			close(pstmt);
		}

		return searchStudentList;
		
	}

	public int deleteStudent(int student_no) throws Exception{

		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM grade WHERE student_no = ?";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student_no);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		sql = "DELETE FROM student WHERE student_no = ?";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student_no);
			deleteCount = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			close(pstmt);
		}

		return deleteCount;
		
	}


	public int updateStudent(Student changeStudent, Date birth) throws Exception{

		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE student SET student_name=?, student_year=?, student_addr=?, student_tel=?, student_birth=? WHERE student_no=?";

		try{
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, changeStudent.getStudent_name());
			pstmt.setInt(2, changeStudent.getStudent_year());
			pstmt.setString(3, changeStudent.getStudent_addr());
			pstmt.setString(4, changeStudent.getStudent_tel());
			pstmt.setDate(5, birth);
			pstmt.setInt(6, changeStudent.getStudent_no());

			updateCount = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			close(pstmt);
		}

		return updateCount;
		
	}
	
}
