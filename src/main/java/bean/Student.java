package bean;

import java.util.Date;



public class Student{


    private int studentId;
    private String studentEName;
    private String studentAName;
    private String mobile;
    private Date birthDate;
    private int gender;
    private String email;
    private double finalAverage;
    private double maxAverage;
    private String rate;
    private int graduateYear;
    private int graduateSemester;
    private University university;
    private School school;
    private Program program;



    public Student() {
    }



    public Student(int studentId, String studentEName, String studentAName, String mobile, Date birthDate, int gender, String email, double finalAverage, double maxAverage, String rate, int graduateYear, int graduateSemester) {
        this.studentId = studentId;
        this.studentEName = studentEName;
        this.studentAName = studentAName;
        this.mobile = mobile;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.finalAverage = finalAverage;
        this.maxAverage = maxAverage;
        this.rate = rate;
        this.graduateYear = graduateYear;
        this.graduateSemester = graduateSemester;
    }

    

    public Student(int studentId) {
	this.studentId = studentId;
    }



    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentEName() {
        return this.studentEName;
    }

    public void setStudentEName(String studentEName) {
        this.studentEName = studentEName;
    }

    public String getStudentAName() {
        return this.studentAName;
    }

    public void setStudentAName(String studentAName) {
        this.studentAName = studentAName;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getFinalAverage() {
        return this.finalAverage;
    }

    public void setFinalAverage(double finalAverage) {
        this.finalAverage = finalAverage;
    }

    public double getMaxAverage() {
        return this.maxAverage;
    }

    public void setMaxAverage(double maxAverage) {
        this.maxAverage = maxAverage;
    }

    public String getRate() {
        return this.rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getGraduateYear() {
        return this.graduateYear;
    }

    public void setGraduateYear(int graduateYear) {
        this.graduateYear = graduateYear;
    }

    public int getGraduateSemester() {
        return this.graduateSemester;
    }

    public void setGraduateSemester(int graduateSemester) {
        this.graduateSemester = graduateSemester;
    }



    public University getUniversity() {
        return this.university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public School getSchool() {
        return this.school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Program getProgram() {
        return this.program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }



    @Override
    public String toString() {
        return "{" +
            " studentId='" + getStudentId() + "'" +
            ", studentEName='" + getStudentEName() + "'" +
            ", studentAName='" + getStudentAName() + "'" +
            ", mobile='" + getMobile() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", gender='" + getGender() + "'" +
            ", email='" + getEmail() + "'" +
            ", finalAverage='" + getFinalAverage() + "'" +
            ", maxAverage='" + getMaxAverage() + "'" +
            ", rate='" + getRate() + "'" +
            ", graduateYear='" + getGraduateYear() + "'" +
            ", graduateSemester='" + getGraduateSemester() + "'" +
            "}";
    }



}