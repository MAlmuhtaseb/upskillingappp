package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import database.Database;

public class SchoolDAO {

    private Database db;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private List<School> schoolTable;
    private int row;

    public List<School> selectAll() {

	schoolTable = new ArrayList<School>();
	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection
		    .prepareStatement("select school_id, school_ename, school_aname from school order by school_id");
	    rs = ps.executeQuery();

	    while (rs.next()) {
		School school = new School(rs.getInt("school_id"), rs.getString("school_ename"),
			rs.getString("school_aname"));
		schoolTable.add(school);
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(rs);
	    Database.close(ps);
	    Database.close(connection);
	}

	return schoolTable;

    }

    public School selectById(int id) {
	
	School school = null;
	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection
		    .prepareStatement("select school_id, school_ename, school_aname from school where school_id = ?");
	    ps.setInt(1, id);
	    rs = ps.executeQuery();

	    if (rs.next()) {
		school = new School(rs.getInt("school_id"), rs.getString("school_ename"), rs.getString("school_aname"));
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(rs);
	    Database.close(ps);
	    Database.close(connection);
	}

	return school;

    }

    public int insert(School school) {

	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection.prepareStatement("insert into school(school_id, school_ename, school_aname) values(?, ?, ?)");

	    int counter = 1;
	    ps.setInt(counter++, school.getSchoolId());
	    ps.setString(counter++, school.getSchoolEName());
	    ps.setString(counter++, school.getSchoolAName());

	    row = ps.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(ps);
	    Database.close(connection);
	}

	return row;

    }

    public int update(School school) {

	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection
		    .prepareStatement("update school set school_aname = ?, school_ename = ? where school_id = ?");

	    int counter = 1;
	    ps.setString(counter++, school.getSchoolAName());
	    ps.setString(counter++, school.getSchoolEName());
	    ps.setInt(counter++, school.getSchoolId());

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
	    ps = connection.prepareStatement("delete from school where school_id = ?");
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
