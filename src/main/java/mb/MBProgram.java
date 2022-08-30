package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.Program;
import bean.School;
import dao.ProgramDAO;
import dao.SchoolDAO;

@ViewScoped
@ManagedBean(name = "mbProgram")
public class MBProgram {
    private List<Program> programTable;
    private Program selectedProgram;
    private ProgramDAO programDAO;
    private List<School> schoolTable;
    private School school;
    
    
    @PostConstruct
    public void init() {
	programDAO = new ProgramDAO();
	programTable = programDAO.selectAll();
	selectedProgram = new Program();
	
	SchoolDAO schoolDAO = new SchoolDAO();
	schoolTable = schoolDAO.selectAll();
	selectedProgram.setSchool(new School());
    }
    
    public String updateProgram() {
	programDAO.update(selectedProgram);
	programTable = programDAO.selectAll();
	
	return null;
    }
    
    public String removeProgram(){
	programDAO.delete(selectedProgram.getProgramId());
	programTable = programDAO.selectAll();
	return null;
    }
    
   

    public List<Program> getProgramTable() {
	return programTable;
    }

    public void setProgramTable(List<Program> programTable) {
	this.programTable = programTable;
    }

    public Program getSelectedProgram() {
	return selectedProgram;
    }

    public void setSelectedProgram(Program selectedProgram) {
	this.selectedProgram = selectedProgram;
    }

   

    public List<School> getSchoolTable() {
	return schoolTable;
    }

    public void setSchoolTable(List<School> schoolTable) {
	this.schoolTable = schoolTable;
    }

    public School getSchool() {
	return school;
    }

    public void setSchool(School school) {
	this.school = school;
    }
}
