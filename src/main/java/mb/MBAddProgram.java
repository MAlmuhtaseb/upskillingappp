package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import bean.Program;
import bean.School;
import dao.ProgramDAO;
import dao.SchoolDAO;
import util.Message;

@ManagedBean (name = "mbAddProgram")
public class MBAddProgram {
    private Program program;
    private List<School> schoolTable;
  
    
    @PostConstruct
    public void init() {
	
	
	SchoolDAO schoolDAO = new SchoolDAO();
	schoolTable =  schoolDAO.selectAll();
    }
    
    
    public String add() {
	ProgramDAO programDAO = new ProgramDAO();
	programDAO.insert(program);
	
	Message.addMessage("INFO", "Added", "Program Added Successfully");
	program = new Program();
	program.setSchool(new School());
	return null;
    }

    public Program getProgram() {
	if (program == null) {
	    program = new Program();
	    program.setSchool(new School());
	}
	return program;
    }

    public void setProgram(Program program) {
	this.program = program;
    }

    public List<School> getSchoolTable() {
	return schoolTable;
    }

    public void setSchoolTable(List<School> schoolTable) {
	this.schoolTable = schoolTable;
    }
    
    
}
