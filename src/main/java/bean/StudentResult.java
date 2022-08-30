package bean;

public class StudentResult {

    private Student student;
    private TrainingCourse TrainingCourse;
    private double englishMark;
    private double interviewMark;
    private int acceptedFlag;
    private String notes;

    public StudentResult() {
    }

    public StudentResult(Student student, TrainingCourse TrainingCourse, double englishMark, double interviewMark,
            int acceptedFlag, String notes) {
        this.student = student;
        this.TrainingCourse = TrainingCourse;
        this.englishMark = englishMark;
        this.interviewMark = interviewMark;
        this.acceptedFlag = acceptedFlag;
        this.notes = notes;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public TrainingCourse getTrainingCourse() {
        return this.TrainingCourse;
    }

    public void setTrainingCourse(TrainingCourse TrainingCourse) {
        this.TrainingCourse = TrainingCourse;
    }

    public double getEnglishMark() {
        return this.englishMark;
    }

    public void setEnglishMark(double englishMark) {
        this.englishMark = englishMark;
    }

    public double getInterviewMark() {
        return this.interviewMark;
    }

    public void setInterviewMark(double interviewMark) {
        this.interviewMark = interviewMark;
    }

    public int getAcceptedFlag() {
        return this.acceptedFlag;
    }

    public void setAcceptedFlag(int acceptedFlag) {
        this.acceptedFlag = acceptedFlag;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "{" +
                " student='" + getStudent() + "'" +
                ", TrainingCourse='" + getTrainingCourse() + "'" +
                ", englishMark='" + getEnglishMark() + "'" +
                ", interviewMark='" + getInterviewMark() + "'" +
                ", acceptedFlag='" + getAcceptedFlag() + "'" +
                ", notes='" + getNotes() + "'" +
                "}";
    }

}