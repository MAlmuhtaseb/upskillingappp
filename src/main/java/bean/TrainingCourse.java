package bean;

public class TrainingCourse{
    private int courseId;
    private int maxStudents;
    private String courseAName; 
    private String courseEName;
    private String shortDesc;
    private String detailedDesc;


    public TrainingCourse() {
    }


    public TrainingCourse(int courseId, int maxStudents, String courseAName, String courseEName, String shortDesc, String detailedDesc) {
        this.courseId = courseId;
        this.maxStudents = maxStudents;
        this.courseAName = courseAName;
        this.courseEName = courseEName;
        this.shortDesc = shortDesc;
        this.detailedDesc = detailedDesc;
    }



    public TrainingCourse(int courseId) {
	this.courseId = courseId;
    }


    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getMaxStudents() {
        return this.maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public String getCourseAName() {
        return this.courseAName;
    }

    public void setCourseAName(String courseAName) {
        this.courseAName = courseAName;
    }

    public String getCourseEName() {
        return this.courseEName;
    }

    public void setCourseEName(String courseEName) {
        this.courseEName = courseEName;
    }

    public String getShortDesc() {
        return this.shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getDetailedDesc() {
        return this.detailedDesc;
    }

    public void setDetailedDesc(String detailedDesc) {
        this.detailedDesc = detailedDesc;
    }


    @Override
    public String toString() {
        return "{" +
            " courseId='" + getCourseId() + "'" +
            ", maxStudents='" + getMaxStudents() + "'" +
            ", courseAName='" + getCourseAName() + "'" +
            ", courseEName='" + getCourseEName() + "'" +
            ", shortDesc='" + getShortDesc() + "'" +
            ", detailedDesc='" + getDetailedDesc() + "'" +
            "}";
    }

}