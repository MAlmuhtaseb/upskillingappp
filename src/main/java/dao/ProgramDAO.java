package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Program;
import database.Database;
import bean.School;

public class ProgramDAO {

    private Database db;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private List<Program> programTable;
    private int row;

    public List<Program> selectAll() {

	
	try {
	    db = new Database();
	    programTable = new ArrayList<Program>();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		    "select program_id, program_ename, program_aname, school_id from program order by program_id");
	    rs = ps.executeQuery();

	    while (rs.next()) {
		Program program = new Program(rs.getInt("program_id"), rs.getString("program_ename"),
			rs.getString("program_aname"));

		SchoolDAO schoolDAO = new SchoolDAO();
		School school = schoolDAO.selectById(rs.getInt("school_id"));
		program.setSchool(school);

		programTable.add(program);
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(rs);
	    Database.close(ps);
	    Database.close(connection);
	}

	return programTable;

    }

    public Program selectById(int id) {

	Program program = null;
	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		    "select program_id, program_ename, program_aname, school_id from program where program_id = ?");
	    ps.setInt(1, id);
	    rs = ps.executeQuery();

	    if (rs.next()) {
		program = new Program(rs.getInt("program_id"), rs.getString("program_ename"),
			rs.getString("program_aname"));
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(rs);
	    Database.close(ps);
	    Database.close(connection);
	}

	return program;

    }

    public int insert(Program program) {

	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection
		    .prepareStatement("insert into program(program_id, program_ename, program_aname, school_ID) values(?, ?, ?, ?)");

	    int counter = 1;
	    ps.setInt(counter++, program.getProgramId());
	    ps.setString(counter++, program.getProgramEName());
	    ps.setString(counter++, program.getProgramAName());
	    ps.setInt(counter++, program.getSchool().getSchoolId());

	    row = ps.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(ps);
	    Database.close(connection);
	}

	return row;

    }

    public int update(Program program) {

	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection
		    .prepareStatement("update program set program_ename = ?, program_aname = ?, school_ID = ? where program_id = ?");

	    int counter = 1;
	    ps.setString(counter++, program.getProgramEName());
	    ps.setString(counter++, program.getProgramAName());
	    ps.setInt(counter++, program.getSchool().getSchoolId());
	    ps.setInt(counter++, program.getProgramId());
	    

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
	    ps = connection.prepareStatement("delete from program where program_id = ?");
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
