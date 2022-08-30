package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.School;

import dao.SchoolDAO;


@ViewScoped
@ManagedBean(name = "mbSchool")

public class MBSchool {
    private List<School> schoolTable;
    private School selectedSchool;
    private SchoolDAO schoolDAO;
   

    @PostConstruct
    public void init() {
	schoolDAO = new SchoolDAO();
	schoolTable = schoolDAO.selectAll();
	selectedSchool = new School();
	
    }

    public String updateSchool() {
	schoolDAO.update(selectedSchool);
	schoolTable = schoolDAO.selectAll();
	return null;
    }

    public String removeSchool() {
	schoolDAO.delete(selectedSchool.getSchoolId());
	schoolTable = schoolDAO.selectAll();
	return null;
    }

    

    public List<School> getSchoolTable() {
	return schoolTable;
    }

    public void setSchoolTable(List<School> schoolTable) {
	this.schoolTable = schoolTable;
    }

    public School getSelectedSchool() {
	return selectedSchool;
    }

    public void setSelectedSchool(School selectedSchool) {
	this.selectedSchool = selectedSchool;
    }

    

}