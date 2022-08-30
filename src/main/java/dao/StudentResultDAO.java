package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.StudentResult;
import bean.Student;
import bean.TrainingCourse;
import database.Database;

public class StudentResultDAO {

    private Database db;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private List<StudentResult> studentResultTable;
    private int row;

    public List<StudentResult> selectAll() {

	try {
	    db = new Database();
	    studentResultTable = new ArrayList<StudentResult>();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		    "select student_id, course_id, english_mark, interview_mark, accepted_flag, notes from student_result order by student_id, course_id");
	    rs = ps.executeQuery();

	    while (rs.next()) {
		StudentResult studentResult = new StudentResult();

		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.selectById(rs.getInt("student_id"));
		studentResult.setStudent(student);

		TrainingCourseDAO trainingCourseDAO = new TrainingCourseDAO();
		TrainingCourse trainingCourse = trainingCourseDAO.selectById(rs.getInt("course_id"));
		studentResult.setTrainingCourse(trainingCourse);

		studentResult.setEnglishMark(rs.getDouble("english_mark"));
		studentResult.setInterviewMark(rs.getDouble("interview_mark"));
		studentResult.setAcceptedFlag(rs.getInt("accepted_flag"));
		studentResult.setNotes(rs.getString("notes"));

		studentResultTable.add(studentResult);

	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(rs);
	    Database.close(ps);
	    Database.close(connection);
	}

	return studentResultTable;
    }

    public int insert(StudentResult studentResult) {

	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		    "insert into student_result (student_id, course_id, english_mark, interview_mark, accepted_flag, notes) values(?, ?, ?, ?, ?, ?)");
	    int counter = 1;

	    ps.setInt(counter++, studentResult.getStudent().getStudentId());
	    ps.setInt(counter++, studentResult.getTrainingCourse().getCourseId());
	    ps.setDouble(counter++, studentResult.getEnglishMark());
	    ps.setDouble(counter++, studentResult.getInterviewMark());
	    ps.setInt(counter++, studentResult.getAcceptedFlag());
	    ps.setString(counter++, studentResult.getNotes());

	    row = ps.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(ps);
	    Database.close(connection);
	}

	return row;
    }

    public int update(StudentResult studentResult) {

	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		   
		    "update student_result set  english_mark = ?, interview_mark = ?, accepted_flag = ?, notes = ? where student_id = ? and course_id = ?");

	    int counter = 1;

	    
	    ps.setDouble(counter++, studentResult.getEnglishMark());
	    ps.setDouble(counter++, studentResult.getInterviewMark());
	    ps.setInt(counter++, studentResult.getAcceptedFlag());
	    ps.setString(counter++, studentResult.getNotes());
	    ps.setInt(counter++, studentResult.getStudent().getStudentId());
	    ps.setInt(counter++, studentResult.getTrainingCourse().getCourseId());

	    row = ps.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(ps);
	    Database.close(connection);
	}

	return row;

    }

    public int delete(int studentId) {
	try {
	    db = new Database();
	    connection = db.getConnection();
	    
	    ps = connection.prepareStatement("delete student_result where student_id = ?");
	    ps.setInt(1, studentId);
	    
	    
	    row = ps.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(ps);
	    Database.close(connection);
	}

	return row;
    }

}
