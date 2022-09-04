package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import bean.Program;
import bean.School;
import bean.Student;
import bean.University;
import dao.ProgramDAO;
import dao.SchoolDAO;
import dao.StudentDAO;
import dao.UniversityDAO;
import util.Message;



@ManagedBean (name = "mbAddStudent")
public class MBAddStudent {
    private Student student;
    private List<University> universityTable;
    private List<School> schoolTable;
    private List<Program> programTable;
    private StudentDAO studentDAO;
    
    @PostConstruct
    public void init() {
	studentDAO = new StudentDAO();
	
	UniversityDAO universityDAO = new UniversityDAO();
	universityTable = universityDAO.selectAll();
	
	
	SchoolDAO schoolDAO = new SchoolDAO();
	schoolTable = schoolDAO.selectAll();
	
	
	ProgramDAO programDAO = new ProgramDAO();
	programTable = programDAO.selectAll();
	
	
	
    }
    
    
    public String add() {
	
	studentDAO.insert(student);
	
	Message.addMessage("INFO", "added", "added successfully");
	student = new Student();
	student.setUniversity(new University());
	student.setSchool(new School());
	student.setProgram(new Program());
	return null;
    }
    
    public Student getStudent() {
	if (student == null) {
	    student = new Student();
	    student.setUniversity(new University());
	    student.setSchool(new School());
	    student.setProgram(new Program());
		return null;
	}
	return student;
    }

    public void setStudent(Student student) {
	this.student = student;
    }

    public List<University> getUniversityTable() {
        return universityTable;
    }

    public void setUniversityTable(List<University> universityTable) {
        this.universityTable = universityTable;
    }

    public List<School> getSchoolTable() {
        return schoolTable;
    }

    public void setSchoolTable(List<School> schoolTable) {
        this.schoolTable = schoolTable;
    }

    public List<Program> getProgramTable() {
        return programTable;
    }

    public void setProgramTable(List<Program> programTable) {
        this.programTable = programTable;
    }
    
    
}
