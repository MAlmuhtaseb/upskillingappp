package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import bean.Interview;
import bean.Student;
import dao.InterviewDAO;
import dao.StudentDAO;
import util.Message;

@ManagedBean(name = "mbAddInterview")
public class MBAddInterview {
    private Interview interview;
    private List<Student> studentTable;
    
    
    @PostConstruct
    public void init() {
	StudentDAO studentDAO = new StudentDAO();
	studentTable = studentDAO.selectAll();
    }
    
    public String add() {
	InterviewDAO interviewDAO = new InterviewDAO();
	interviewDAO.insert(interview);
	
	Message.addMessage("INFO", "Added", "Added sucessfully");
	interview = new Interview();
	interview.setStudent(new Student());
	return null;
    }


    public Interview getInterview() {
        if (interview == null) {
	    interview = new Interview();
	    interview.setStudent(new Student());
	}
        return null;
    }


    public void setInterview(Interview interview) {
        this.interview = interview;
    }


    public List<Student> getStudentTable() {
        return studentTable;
    }


    public void setStudentTable(List<Student> studentTable) {
        this.studentTable = studentTable;
    }
    
    
}
