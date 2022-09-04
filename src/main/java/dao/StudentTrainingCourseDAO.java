package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.TrainingCourse;
import bean.StudentTrainingCourse;
import database.Database;

public class StudentTrainingCourseDAO {

    private Database db;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private List<StudentTrainingCourse> studentTrainingCourseTable;
    private int row;

    public List<StudentTrainingCourse> selectAll() {

	try {
	    db = new Database();
	    studentTrainingCourseTable = new ArrayList<StudentTrainingCourse>();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		    "select student_id, course_id, priority from student_training_course order by student_id, course_id");
	    rs = ps.executeQuery();

	    while (rs.next()) {
		StudentTrainingCourse studentTrainingCourse = new StudentTrainingCourse();

		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.selectById(rs.getInt("student_id"));
		studentTrainingCourse.setStudent(student);

		TrainingCourseDAO trainingCourseDAO = new TrainingCourseDAO();
		TrainingCourse trainingCourse = trainingCourseDAO.selectById(rs.getInt("course_id"));
		studentTrainingCourse.setTrainingCourse(trainingCourse);

		studentTrainingCourse.setPriority(rs.getInt("priority"));

		studentTrainingCourseTable.add(studentTrainingCourse);

	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(rs);
	    Database.close(ps);
	    Database.close(connection);
	}

	return studentTrainingCourseTable;
    }

    public int insert(StudentTrainingCourse studentTrainingCourse) {

	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		    "insert into student_training_course (student_id, course_id, priority) values(?, ?, ?)");
	    int counter = 1;

	    ps.setInt(counter++, studentTrainingCourse.getStudent().getStudentId());
	    ps.setInt(counter++, studentTrainingCourse.getTrainingCourse().getCourseId());
	    ps.setInt(counter++, studentTrainingCourse.getPriority());

	    row = ps.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(ps);
	    Database.close(connection);
	}

	return row;
    }

    public int update(StudentTrainingCourse studentTrainingCourse) {

	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		    
		    "update student_training_course set course_id = ?, priority = ? where student_id = ?");

	    int counter = 1;
	    
	    ps.setInt(counter++, studentTrainingCourse.getTrainingCourse().getCourseId());
	    ps.setInt(counter++, studentTrainingCourse.getPriority());
	    ps.setInt(counter++, studentTrainingCourse.getStudent().getStudentId());
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
	    // Might be wrong, to check later
	    ps = connection.prepareStatement("delete student_training_course where student_id = ?");
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
