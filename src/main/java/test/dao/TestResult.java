package test.dao;

import bean.Student;
import bean.StudentResult;
import bean.TrainingCourse;
import dao.StudentResultDAO;

public class TestResult {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	StudentResultDAO dao = new StudentResultDAO();
	 
	    StudentResult studentResult = new StudentResult(4,5,1,"good");
	    studentResult.setStudent(new Student(5));
	    studentResult.setTrainingCourse(new TrainingCourse(2));
	    int row = dao.insert(studentResult);
	    System.out.println(row + " inserted");
    }

}
