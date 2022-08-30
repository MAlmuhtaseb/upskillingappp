package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.University;
import dao.UniversityDAO;

@ViewScoped
@ManagedBean(name = "mbUniversity")
public class MBUniversity {

    private List<University> universityTable;
    private University selectedUniversity;
    private UniversityDAO universityDAO;

    @PostConstruct
    public void init() {
	universityDAO = new UniversityDAO();
	universityTable = universityDAO.selectAll();
	selectedUniversity = new University();

    }

    public String updateUniversity() {
	universityDAO.update(selectedUniversity);
	universityTable = universityDAO.selectAll();
	return null;
    }

    public String removeUniversity() {
	universityDAO.delete(selectedUniversity.getUniversityId());
	universityTable = universityDAO.selectAll();
	return null;
    }

    public List<University> getUniversityTable() {
	return universityTable;
    }

    public void setUniversityTable(List<University> universityTable) {
	this.universityTable = universityTable;
    }

    public University getSelectedUniversity() {
	return selectedUniversity;

    }

    public void setSelectedUniversity(University selectedUniversity) {
	this.selectedUniversity = selectedUniversity;
    }

}
