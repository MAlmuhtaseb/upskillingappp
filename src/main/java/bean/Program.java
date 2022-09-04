package bean;

public class Program {

    private int programId;
    private String programAName;
    private String programEName;
    private School school;

    public Program() {
    }

    public Program(int programId, String programEName, String programAName) {
	
	this.programId = programId;
	this.programEName = programEName;
	this.programAName = programAName;
	
    }

    public Program(int programId) {
	this.programId = programId;
    }

    public int getProgramId() {
	return this.programId;
    }

    public void setProgramId(int programId) {
	this.programId = programId;
    }

    public String getProgramAName() {
	return this.programAName;
    }

    public void setProgramAName(String programAName) {
	this.programAName = programAName;
    }

    public String getProgramEName() {
	return this.programEName;
    }

    public void setProgramEName(String programEName) {
	this.programEName = programEName;
    }

    public School getSchool() {
	return this.school;
    }

    public void setSchool(School school) {
	this.school = school;
    }

    @Override
    public String toString() {
	return "{" + " programId='" + getProgramId() + "'" + ", programAName='" + getProgramAName() + "'"
		+ ", programEName='" + getProgramEName() + "'" + "}";
    }

}