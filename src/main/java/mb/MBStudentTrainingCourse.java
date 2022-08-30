package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.Student;
import bean.StudentTrainingCourse;
import bean.TrainingCourse;
import dao.StudentDAO;
import dao.StudentTrainingCourseDAO;
import dao.TrainingCourseDAO;

@ViewScoped
@ManagedBean(name = "mbStudentTrainingCourse")
public class MBStudentTrainingCourse {
    private List<Student> studentTable;
    private List<TrainingCourse> trainingCourseTable;
    private List<StudentTrainingCourse> studentTrainingCourseTable;
    private StudentTrainingCourse selectedStudentTrainingCourse;
    private StudentTrainingCourseDAO studentTrainingCourseDAO;

    @PostConstruct
    public void init() {
	studentTrainingCourseDAO = new StudentTrainingCourseDAO();
	studentTrainingCourseTable = studentTrainingCourseDAO.selectAll();
	selectedStudentTrainingCourse = new StudentTrainingCourse();

	StudentDAO studentDAO = new StudentDAO();
	studentTable = studentDAO.selectAll();
	selectedStudentTrainingCourse.setStudent(new Student());

	TrainingCourseDAO trainingCourseDAO = new TrainingCourseDAO();
	trainingCourseTable = trainingCourseDAO.selectAll();
	selectedStudentTrainingCourse.setTrainingCourse(new TrainingCourse());
    }

    public String updateStudentTrainingCourse() {
	studentTrainingCourseDAO.update(selectedStudentTrainingCourse);
	studentTrainingCourseTable = studentTrainingCourseDAO.selectAll();
	return null;
    }
    
    public String removeStudentTrainingCourse() {
	studentTrainingCourseDAO.delete(selectedStudentTrainingCourse.getStudent().getStudentId());
	studentTrainingCourseTable = studentTrainingCourseDAO.selectAll();
	return null;
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

    public List<StudentTrainingCourse> getStudentTrainingCourseTable() {
	return studentTrainingCourseTable;
    }

    public void setStudentTrainingCourseTable(List<StudentTrainingCourse> studentTrainingCourseTable) {
	this.studentTrainingCourseTable = studentTrainingCourseTable;
    }

    public StudentTrainingCourse getSelectedStudentTrainingCourse() {
	return selectedStudentTrainingCourse;
    }

    public void setSelectedStudentTrainingCourse(StudentTrainingCourse selectedStudentTrainingCourse) {
	this.selectedStudentTrainingCourse = selectedStudentTrainingCourse;
    }

}
