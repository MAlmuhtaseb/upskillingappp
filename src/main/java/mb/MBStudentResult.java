package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.Student;
import bean.StudentResult;
import bean.TrainingCourse;
import dao.StudentDAO;
import dao.StudentResultDAO;
import dao.TrainingCourseDAO;

@ViewScoped
@ManagedBean (name = "mbStudentResult")
public class MBStudentResult {
    private List<StudentResult> studentResultTable;
     private StudentResult selectedStudentResult;
     private StudentResultDAO studentResultDAO;
     private List<Student> studentTable;
     private List<TrainingCourse> trainingCourseTable;
     
     

    @PostConstruct
     public void init() {
	  studentResultDAO = new StudentResultDAO();
	  studentResultTable = studentResultDAO.selectAll();
	  selectedStudentResult = new StudentResult();
	  
	  
	  StudentDAO studentDAO = new StudentDAO();
	  studentTable = studentDAO.selectAll();
	  selectedStudentResult.setStudent(new Student());
	  
	  TrainingCourseDAO trainingCourseDAO = new TrainingCourseDAO();
	  trainingCourseTable = trainingCourseDAO.selectAll();
	  selectedStudentResult.setTrainingCourse(new TrainingCourse());
     }
     
     public String updateStudentResult() {
	 
	 studentResultDAO.update(getSelectedStudentResult());
	 studentResultTable = studentResultDAO.selectAll();
	 return null;
     }
     
     public String removeStudentResult() {
	studentResultDAO.delete(selectedStudentResult.getStudent().getStudentId());
	studentResultTable = studentResultDAO.selectAll();
	 return null;
	 
     }

    public List<StudentResult> getStudentResultTable() {
	return studentResultTable;
    }

    public void setStudentResultTable(List<StudentResult> studentResultTable) {
	this.studentResultTable = studentResultTable;
    }

    public StudentResult getSelectedStudentResult() {
	return selectedStudentResult;
    }

    public void setSelectedStudentResult(StudentResult selectedStudentResult) {
	this.selectedStudentResult = selectedStudentResult;
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
