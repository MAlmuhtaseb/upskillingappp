package testDAO;

import java.util.Date;

import bean.Student;
import dao.StudentDAO;

public class TestStudent {
    StudentDAO dao = new StudentDAO();
    Date now = new Date();
    
    Student student = new Student(1, "mohammed", "محمد","079", new Date(), 1, "moh.com", 1, 2, "good", 2020, 1);
    
    int row = dao.insert(student);
   
}
