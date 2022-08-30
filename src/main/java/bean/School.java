package bean;

public class School{

private int schoolId;
private String schoolEName;
private String schoolAName;

public School(){

}


    public School(int schoolId, String schoolEName, String schoolAName) {
        this.schoolId = schoolId;
        this.schoolEName = schoolEName;
        this.schoolAName = schoolAName;
    }



    public School(int schoolId) {
	this.schoolId = schoolId;
    }


    public int getSchoolId() {
        return this.schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolEName() {
        return this.schoolEName;
    }

    public void setSchoolEName(String schoolEName) {
        this.schoolEName = schoolEName;
    }

    public String getSchoolAName() {
        return this.schoolAName;
    }

    public void setSchoolAName(String schoolAName) {
        this.schoolAName = schoolAName;
    }

    @Override
    public String toString() {
        return "{" +
            " schoolId='" + getSchoolId() + "'" +
            ", schoolEName='" + getSchoolEName() + "'" +
            ", schoolAName='" + getSchoolAName() + "'" +
            "}";
    }

}