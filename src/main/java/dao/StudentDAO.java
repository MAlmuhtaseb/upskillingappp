package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.University;
import bean.Program;
import bean.School;
import database.Database;

public class StudentDAO {

    private Database db;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private List<Student> studentTable;
    private int row;

    public List<Student> selectAll() {

	try {
	    db = new Database();
	    studentTable = new ArrayList<Student>();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		    "select student_id, student_ename, student_aname, mobile, birthdate, sex, email, university_id, school_id, program_id, final_average, max_Average, rate, graduate_year, graduate_sem from student order by student_id");
	    rs = ps.executeQuery();

	    while (rs.next()) {
		Student student = new Student();

		student.setStudentId(rs.getInt("student_id"));
		student.setStudentEName(rs.getString("student_ename"));
		student.setStudentAName(rs.getString("student_aname"));
		student.setMobile(rs.getString("mobile"));
		student.setBirthDate(rs.getDate("birthdate"));
		student.setGender(rs.getInt("sex"));
		student.setEmail(rs.getString("email"));

		UniversityDAO universityDAO = new UniversityDAO();
		University university = universityDAO.selectById(rs.getInt("university_id"));
		student.setUniversity(university);
		SchoolDAO schoolDAO = new SchoolDAO();
		School school = schoolDAO.selectById(rs.getInt("school_id"));
		student.setSchool(school);
		ProgramDAO programDAO = new ProgramDAO();
		Program program = programDAO.selectById(rs.getInt("program_id"));
		student.setProgram(program);

		student.setFinalAverage(rs.getDouble("final_Average"));
		student.setMaxAverage(rs.getDouble("max_average"));
		student.setRate(rs.getString("rate"));
		student.setGraduateYear(rs.getInt("graduate_year"));
		student.setGraduateSemester(rs.getInt("graduate_sem"));

		studentTable.add(student);

	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(rs);
	    Database.close(ps);
	    Database.close(connection);
	}

	return studentTable;
    }

    public Student selectById(int id) {

	Student student = null;
	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		    "select student_id, student_ename, student_aname, mobile, birthdate, sex, email, university_id, school_id, program_id, final_average, max_Average, rate, graduate_year, graduate_sem from student where student_id = ?");

	    ps.setInt(1, id);
	    rs = ps.executeQuery();

	    if (rs.next()) {
		student = new Student();

		student.setStudentId(rs.getInt("student_id"));
		student.setStudentEName(rs.getString("student_ename"));
		student.setStudentAName(rs.getString("student_aname"));
		student.setMobile(rs.getString("mobile"));
		student.setBirthDate(rs.getDate("birthdate"));
		student.setGender(rs.getInt("sex"));
		student.setEmail(rs.getString("email"));

		UniversityDAO universityDAO = new UniversityDAO();
		University university = universityDAO.selectById(rs.getInt("university_id"));
		student.setUniversity(university);
		SchoolDAO schoolDAO = new SchoolDAO();
		School school = schoolDAO.selectById(rs.getInt("school_id"));
		student.setSchool(school);
		ProgramDAO programDAO = new ProgramDAO();
		Program program = programDAO.selectById(rs.getInt("program_id"));
		student.setProgram(program);

		student.setFinalAverage(rs.getDouble("final_Average"));
		student.setMaxAverage(rs.getDouble("max_average"));
		student.setRate(rs.getString("rate"));
		student.setGraduateYear(rs.getInt("graduate_year"));
		student.setGraduateSemester(rs.getInt("graduate_sem"));
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(rs);
	    Database.close(ps);
	    Database.close(connection);
	}

	return student;

    }
    
    public int selectMaxId(Connection connection) {
	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		    "select nvl(max(student_id),0) AS student_id from student");
	    
	    rs = ps.executeQuery();

	    if (rs.next()) {
		return rs.getInt("student_id");
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(rs);
	   
	}
	return 0;
    }

    public int insert(Student student) {

	try {
	    db = new Database();
	    connection = db.getConnection();
	    int maxId = selectMaxId(connection);
	    ps = connection.prepareStatement(
		    "insert into student (student_id, student_ename, student_aname, mobile, birthdate, sex, email, final_average, max_Average, rate, graduate_year, graduate_sem , university_id, school_id, program_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	    int counter = 1;
	    ps.setInt(counter++, maxId + 1);
	    ps.setString(counter++, student.getStudentEName());
	    ps.setString(counter++, student.getStudentAName());
	    ps.setString(counter++, student.getMobile());
	    ps.setDate(counter++, new Date(student.getBirthDate().getTime()));
	    ps.setInt(counter++, student.getGender());
	    ps.setString(counter++, student.getEmail());
	    ps.setDouble(counter++, student.getFinalAverage());
	    ps.setDouble(counter++, student.getMaxAverage());
	    ps.setString(counter++, student.getRate());
	    ps.setInt(counter++, student.getGraduateYear());
	    ps.setInt(counter++, student.getGraduateSemester());
	    
	    ps.setInt(counter++, student.getUniversity().getUniversityId());
	    ps.setInt(counter++, student.getSchool().getSchoolId());
	    ps.setInt(counter++, student.getProgram().getProgramId());

	    row = ps.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    Database.close(ps);
	    Database.close(connection);
	}

	return row;
    }

    public int update(Student student) {

	try {
	    db = new Database();
	    connection = db.getConnection();
	    ps = connection.prepareStatement(
		    "update student set  student_ename = ?, student_aname = ?, mobile = ?, birthdate = ?, sex = ?, email = ?, university_id = ?, school_id = ?, program_id = ?, final_average = ?, max_Average = ?, rate = ?, graduate_year = ?, graduate_sem = ? where student_id = ?");

	    int counter = 1;
	    ps.setString(counter++, student.getStudentEName());
	    ps.setString(counter++, student.getStudentAName());
	    ps.setString(counter++, student.getMobile());
	    ps.setDate(counter++, new Date(student.getBirthDate().getTime()));
	    ps.setInt(counter++, student.getGender());
	    ps.setString(counter++, student.getEmail());
	    ps.setInt(counter++, student.getUniversity().getUniversityId());
	    ps.setInt(counter++, student.getSchool().getSchoolId());
	    ps.setInt(counter++, student.getProgram().getProgramId());
	    ps.setDouble(counter++, student.getFinalAverage());
	    ps.setDouble(counter++, student.getMaxAverage());
	    ps.setString(counter++, student.getRate());
	    ps.setInt(counter++, student.getGraduateYear());
	    ps.setInt(counter++, student.getGraduateSemester());
	    ps.setInt(counter++, student.getStudentId());

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
	    ps = connection.prepareStatement("delete student where student_id = ?");
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
