package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import bean.Student;
import dao.StudentDAO;
import email.Email;

@ManagedBean (name = "mbEmail")
public class MBEmail {
    private Email email;
    private List<Student> studentTable;
    private String title;
    private String content;
    
    @PostConstruct
    public void init() {
	StudentDAO studentDAO = new StudentDAO();
	studentTable = studentDAO.selectAll();
	
    }
    
    public String sendEmail() {
	//Email.notifyUser("9971043545@htu.edu.jo",title , content);
	
	for (int i = 0; i < studentTable.size(); i++) {
	    Email.notifyUser(studentTable.get(i).getEmail(), title, content);
	}
	return null;
    }
    
    
    
    public Email getEmail() {
        return email;
    }
    public void setEmail(Email email) {
        this.email = email;
    }
    public List<Student> getStudentTable() {
        return studentTable;
    }
    public void setStudentTable(List<Student> studentTable) {
        this.studentTable = studentTable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
    
    
}
