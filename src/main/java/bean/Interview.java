package bean;

import java.util.Date;

public class Interview {
    private Student student;
    private Date interviewDate;
    private Date interviewTime;
    private int duration;

    public Interview() {

    }

    public Interview(Date interviewDate, Date time, int duration) {
	
	this.interviewDate = interviewDate;
	this.interviewTime = time;
	this.duration = duration;
    }

    public Student getStudent() {
	return student;
    }

    public void setStudent(Student student) {
	this.student = student;
    }

    public Date getInterviewDate() {
	return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
	this.interviewDate = interviewDate;
    }

    public Date getInterviewTime() {
	return interviewTime;
    }

    public void setInterviewTime(Date time) {
	this.interviewTime = time;
    }

    public int getDuration() {
	return duration;
    }

    public void setDuration(int duration) {
	this.duration = duration;
    }

    @Override
    public String toString() {
	return "Interview [student=" + student + ", interviewDate=" + interviewDate + ", time=" + interviewTime + ", duration="
		+ duration + "]";
    }

    
}
