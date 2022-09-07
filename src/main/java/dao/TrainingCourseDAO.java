package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.TrainingCourse;
import database.Database;

public class TrainingCourseDAO {

    private Database db;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private List<TrainingCourse> trainingCourseTable;
    private int row;

    public List<TrainingCourse> selectAll() {

	trainingCourseTable = new ArrayList<TrainingCourse>();
	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		    "select course_id, max_students, course_ename, course_aname, short_desc, detailed_desc from training_course order by course_id");
	    rs = ps.executeQuery();

	    while (rs.next()) {
		TrainingCourse trainingCourse = new TrainingCourse(rs.getInt("course_id"), rs.getInt("max_students"),
			rs.getString("course_ename"), rs.getString("course_aname"), rs.getString("short_desc"),
			rs.getString("detailed_desc"));
		trainingCourseTable.add(trainingCourse);
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(rs);
	    Database.close(ps);
	    Database.close(connection);
	}

	return trainingCourseTable;

    }

    public TrainingCourse selectById(int id) {

	TrainingCourse trainingCourse = null;
	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		    "select course_id, max_students, course_ename,course_aname , short_desc, detailed_desc from training_course where course_id = ?");
	    ps.setInt(1, id);
	    rs = ps.executeQuery();

	    if (rs.next()) {
		trainingCourse = new TrainingCourse(rs.getInt("course_id"), rs.getInt("max_students"),
			rs.getString("course_ename"), rs.getString("course_aname"), rs.getString("short_desc"),
			rs.getString("detailed_desc"));

	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(rs);
	    Database.close(ps);
	    Database.close(connection);
	}

	return trainingCourse;

    }
    
    public int selectMaxId(Connection connection) {
	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		    "select nvl(max(course_id),0) AS course_id from training_course");
	    
	    rs = ps.executeQuery();

	    if (rs.next()) {
		return rs.getInt("course_id");
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(rs);
	   
	}
	return 0;
    }

    public int insert(TrainingCourse trainingCourse) {

	try {
	    db = new Database();
	    connection = db.getConnection();
	    int maxId = selectMaxId(connection);
	    ps = connection.prepareStatement(
		    "insert into training_course(course_id, course_ename, course_aname, max_students, short_desc, detailed_desc) values(?, ?, ?, ?, ?, ?)");

	    int counter = 1;
	    ps.setInt(counter++, maxId + 1);
	    ps.setString(counter++, trainingCourse.getCourseEName());
	    ps.setString(counter++, trainingCourse.getCourseAName());
	    ps.setInt(counter++, trainingCourse.getMaxStudents());
	    ps.setString(counter++, trainingCourse.getShortDesc());
	    ps.setString(counter++, trainingCourse.getDetailedDesc());

	    row = ps.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(ps);
	    Database.close(connection);
	}

	return row;

    }

    public int update(TrainingCourse trainingCourse) {

	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		    "update training_course set course_ename = ?, course_aname = ?, max_students = ?, short_desc = ?, detailed_desc = ?where course_id = ?");

	    int counter = 1;
	    ps.setString(counter++, trainingCourse.getCourseEName());
	    ps.setString(counter++, trainingCourse.getCourseAName());
	    ps.setInt(counter++, trainingCourse.getMaxStudents());
	    ps.setString(counter++, trainingCourse.getShortDesc());
	    ps.setString(counter++, trainingCourse.getDetailedDesc());
	    ps.setInt(counter++, trainingCourse.getCourseId());

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
	    ps = connection.prepareStatement("delete from training_course where course_id = ?");
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
