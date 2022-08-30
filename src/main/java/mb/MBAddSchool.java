package mb;

import javax.faces.bean.ManagedBean;

import bean.School;
import dao.SchoolDAO;
import util.Message;

@ManagedBean (name = "mbAddSchool")
public class MBAddSchool {
    private School school;
    
    public String add() {
	SchoolDAO schoolDAO = new SchoolDAO();
	schoolDAO.insert(school);
	
	Message.addMessage("INFO", "Added", "School added successfully");
	school = new School();
	return null;
    }

    public School getSchool() {
	if (school == null) {
	    school = new School();
	}
	return school;
    }

    public void setSchool(School school) {
	this.school = school;
    }
    
    
    
}
