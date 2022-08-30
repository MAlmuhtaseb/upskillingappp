package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.Program;
import bean.School;
import bean.Student;
import bean.University;
import dao.ProgramDAO;
import dao.SchoolDAO;
import dao.StudentDAO;
import dao.UniversityDAO;

@ViewScoped
@ManagedBean (name = "mbStudent")
public class MBStudent {
    private List<Student> studentTable;
    private Student selectedStudent;
    private StudentDAO studentDAO;
    private List<University> universityTable;
    private List<School> schoolTable;
    private List<Program> programTable;
    
   

    @PostConstruct
    public void init() {
	studentDAO = new StudentDAO();
	studentTable = studentDAO.selectAll();
	selectedStudent = new Student();
	
	UniversityDAO universityDAO = new UniversityDAO();
	universityTable = universityDAO.selectAll();
	selectedStudent.setUniversity(new University());
	
	SchoolDAO schoolDAO = new SchoolDAO();
	schoolTable = schoolDAO.selectAll();
	selectedStudent.setSchool(new School());
	
	ProgramDAO programDAO = new ProgramDAO();
	programTable = programDAO.selectAll();
	selectedStudent.setProgram(new Program());
    }
    
    public String updateStudent() {
	studentDAO.update(selectedStudent);
	studentTable = studentDAO.selectAll();
	return null;
    }
    
    public String removeStudent() {
	studentDAO.delete(selectedStudent.getStudentId());
	studentTable = studentDAO.selectAll();
	return null;
    }
    
    
    
    public List<Student> getStudentTable() {
        return studentTable;
    }
    public void setStudentTable(List<Student> studentTable) {
        this.studentTable = studentTable;
    }
    public Student getSelectedStudent() {
        return selectedStudent;
    }
    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
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
