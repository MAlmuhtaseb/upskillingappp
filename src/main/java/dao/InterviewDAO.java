package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Interview;

import database.Database;

import bean.Student;

public class InterviewDAO {

    private Database db;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private List<Interview> interviewTable;
    private int row;

    public List<Interview> selectAll() {

	
	try {
	    db = new Database();
	    interviewTable = new ArrayList<Interview>();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		    "select student_id, interview_date, time, duration from interview order by student_id");
	    rs = ps.executeQuery();

	    while (rs.next()) {
		Interview interview = new Interview(rs.getDate("interview_date"), rs.getDate("time"), rs.getInt("duration"));

		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.selectById(rs.getInt("student_id"));
		
		interview.setStudent(student);
		interviewTable.add(interview);
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(rs);
	    Database.close(ps);
	    Database.close(connection);
	}

	return interviewTable;

    }

   
    public int insert(Interview interview) {

	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection
		    .prepareStatement("insert into interview(student_id, interview_date, time, duration) values(?, ?, ?, ?)");

	    int counter = 1;
	    ps.setInt(counter++, interview.getStudent().getStudentId());
	    ps.setDate(counter++, new Date(interview.getInterviewDate().getTime()));
	    ps.setDate(counter++, new Date(interview.getInterviewTime().getTime()));
	    ps.setInt(counter++, interview.getDuration());

	    row = ps.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(ps);
	    Database.close(connection);
	}

	return row;

    }

    public int update(Interview interview) {

	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection
		    .prepareStatement("update interview set interview_date = ?, time = ?, duration = ? where student_id = ?");

	    int counter = 1;
	    ps.setDate(counter++, new Date(interview.getInterviewDate().getTime()));
	    ps.setDate(counter++, new Date(interview.getInterviewTime().getTime()));
	    ps.setInt(counter++, interview.getDuration());
	    ps.setInt(counter++, interview.getStudent().getStudentId());
	    

	    row = ps.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(ps);
	    Database.close(connection);
	}

	return row;

    }

    public int delete(int id) {

	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection.prepareStatement("delete from interview where student_id = ?");
	    ps.setInt(1, id);
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
