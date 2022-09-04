package test.dao;

import java.util.Date;

import bean.Interview;
import bean.Student;
import dao.InterviewDAO;

public class TestInterview {

    public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	StudentResultDAO dao = new StudentResultDAO();
//	 
//	    StudentResult studentResult = new StudentResult(4,5,1,"good");
//	    studentResult.setStudent(new Student(5));
//	    studentResult.setTrainingCourse(new TrainingCourse(2));
//	    int row = dao.insert(studentResult);
//	    System.out.println(row + " inserted");
	
	Date now = new Date();
	
	InterviewDAO dao = new InterviewDAO();
	
	Interview interview = new Interview(new Date(), new Date(), 15);
	interview.setStudent(new Student(2));
	int row = dao.insert(interview);
	System.out.println(row + " inserted");
    }

}
