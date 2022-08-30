package bean;

public class University {

    private int universityId;
    private String universityEName;
    private String universityAName;
    private String website;

    public University() {

    }

    public University(int universityId, String universityEName, String universityAName, String website) {
	this.universityId = universityId;
	this.universityEName = universityEName;
	this.universityAName = universityAName;
	this.website = website;
    }

    public University(int universityId) {
	this.universityId = universityId;
    }

    public int getUniversityId() {
	return this.universityId;
    }

    public void setUniversityId(int universityId) {
	this.universityId = universityId;
    }

    public String getUniversityEName() {
	return this.universityEName;
    }

    public void setUniversityEName(String universityEName) {
	this.universityEName = universityEName;
    }

    public String getUniversityAName() {
	return this.universityAName;
    }

    public void setUniversityAName(String universityAName) {
	this.universityAName = universityAName;
    }

    public String getWebsite() {
	return this.website;
    }

    public void setWebsite(String website) {
	this.website = website;
    }

    @Override
    public String toString() {
	return "{" + " universityId='" + getUniversityId() + "'" + ", universityEName='" + getUniversityEName() + "'"
		+ ", universityAName='" + getUniversityAName() + "'" + ", website='" + getWebsite() + "'" + "}";
    }

}
