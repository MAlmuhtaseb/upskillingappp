package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import bean.Student;
import bean.StudentTrainingCourse;
import bean.TrainingCourse;
import dao.StudentDAO;
import dao.StudentTrainingCourseDAO;
import dao.TrainingCourseDAO;
import util.Message;

@ManagedBean(name = "mbAddStudentTrainingCourse")
public class MBAddStudentTrainingCourse {
    private StudentTrainingCourse studentTrainingCourse;
    private List<Student> studentTable;
    private List<TrainingCourse> trainingCourseTable;

    @PostConstruct
    public void init() {
	StudentDAO studentDAO = new StudentDAO();
	studentTable = studentDAO.selectAll();

	TrainingCourseDAO trainingCourseDAO = new TrainingCourseDAO();
	trainingCourseTable = trainingCourseDAO.selectAll();
    }

    public String Add() {
	StudentTrainingCourseDAO studentTrainingCourseDAO = new StudentTrainingCourseDAO();
	studentTrainingCourseDAO.insert(studentTrainingCourse);

	Message.addMessage("INFO", "Added", "Added Successfully");

	studentTrainingCourse = new StudentTrainingCourse();
	studentTrainingCourse.setStudent(new Student());
	studentTrainingCourse.setTrainingCourse(new TrainingCourse());
	return null;
    }

    public StudentTrainingCourse getStudentTrainingCourse() {
	if (studentTrainingCourse == null) {
	    studentTrainingCourse = new StudentTrainingCourse();
	    studentTrainingCourse.setStudent(new Student());
	    studentTrainingCourse.setTrainingCourse(new TrainingCourse());

	}
	return studentTrainingCourse;
    }

    public void setStudentTrainingCourse(StudentTrainingCourse studentTrainingCourse) {
	this.studentTrainingCourse = studentTrainingCourse;
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
