package bean;

public class StudentTrainingCourse{

    private Student student;
    private TrainingCourse trainingCourse;
    private int priority;


    public StudentTrainingCourse() {
    }


    public StudentTrainingCourse(Student student, TrainingCourse trainingCourse, int priority) {
        this.student = student;
        this.trainingCourse = trainingCourse;
        this.priority = priority;
    }


    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public TrainingCourse getTrainingCourse() {
        return this.trainingCourse;
    }

    public void setTrainingCourse(TrainingCourse trainingCourse) {
        this.trainingCourse = trainingCourse;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


    @Override
    public String toString() {
        return "{" +
            " student='" + getStudent() + "'" +
            ", trainingCourse='" + getTrainingCourse() + "'" +
            ", priority='" + getPriority() + "'" +
            "}";
    }


}