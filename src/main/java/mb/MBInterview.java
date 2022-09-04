package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.Interview;
import bean.Student;
import dao.InterviewDAO;
import dao.StudentDAO;
@ViewScoped
@ManagedBean (name = "mbInterview")
public class MBInterview {
    private List<Interview> interviewTable;
    private Interview selectedInterview;
    private InterviewDAO interviewDAO;
    private List<Student> studentTable;
    
    
    @PostConstruct
    public void init() {
	interviewDAO = new InterviewDAO();
	interviewTable = interviewDAO.selectAll();
	selectedInterview = new Interview();
	
	StudentDAO studentDAO = new StudentDAO();
	studentTable = studentDAO.selectAll();
	selectedInterview.setStudent(new Student());
    }
    
    public String updateInterview() {
	
	interviewDAO.update(selectedInterview);
	interviewTable = interviewDAO.selectAll();
	return null;
		
    }
    
public String removeInterview() {
	
	interviewDAO.delete(selectedInterview.getStudent().getStudentId());
	interviewTable = interviewDAO.selectAll();
	return null;
		
    }


    public List<Interview> getInterviewTable() {
        return interviewTable;
    }


    public void setInterviewTable(List<Interview> interviewTable) {
        this.interviewTable = interviewTable;
    }


    public Interview getSelectedInterview() {
        return selectedInterview;
    }


    public void setSelectedInterview(Interview selectedInterview) {
        this.selectedInterview = selectedInterview;
    }


    public List<Student> getStudentTable() {
        return studentTable;
    }


    public void setStudentTable(List<Student> studentTable) {
        this.studentTable = studentTable;
    }
    
    
}
