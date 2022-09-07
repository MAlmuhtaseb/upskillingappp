package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import bean.Student;
import bean.StudentResult;
import bean.TrainingCourse;
import dao.StudentDAO;
import dao.StudentResultDAO;
import dao.TrainingCourseDAO;
import util.Message;

@ManagedBean (name = "mbAddStudentResult")
public class AddStudentResult {
    private StudentResult studentResult;
    private List<Student> studentTable;
    private List<TrainingCourse> trainingCourseTable;
  
    
    @PostConstruct
    public void init() {
	
	
	
	StudentDAO studentDAO = new StudentDAO();
	studentTable = studentDAO.selectAll();
	
	
	TrainingCourseDAO trainingCourseDAO = new TrainingCourseDAO();
	trainingCourseTable = trainingCourseDAO.selectAll();
	
    }
    
    public String add() {
	StudentResultDAO studentResultDAO = new StudentResultDAO();
	studentResultDAO.insert(studentResult);
	
	Message.addMessage("INFO", "Added", "Student result added successfully");
	studentResult = new StudentResult();
	studentResult.setStudent(new Student());
	studentResult.setTrainingCourse(new TrainingCourse());
	return null;
    }
    
//    public StudentResult getStudentResult() {
//	return studentResult;
//    }
    
    
    
    public StudentResult getStudentResult() {
        if (studentResult == null ) {
	    studentResult = new StudentResult();
	    studentResult.setStudent(new Student());
	    studentResult.setTrainingCourse(new TrainingCourse());
	}
        return studentResult;
    }
    public void setStudentResult(StudentResult studentResult) {
        this.studentResult = studentResult;
    }
    public List<Student> getStudentTable() {
        return studentTable;
    }
    public void setStudentTable(List<Student> studentTable) {
        this.studentTable = studentTable;
    }
    public List<TrainingCourse> getTrainingCourseTable() {
        return trainingCourseTable;
    }
    public void setTrainingCourseTable(List<TrainingCourse> trainingCourseTable) {
        this.trainingCourseTable = trainingCourseTable;
    }
}
