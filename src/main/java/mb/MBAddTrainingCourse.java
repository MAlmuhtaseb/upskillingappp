package mb;

import javax.faces.bean.ManagedBean;

import bean.TrainingCourse;
import dao.TrainingCourseDAO;
import util.Message;

@ManagedBean (name = "mbAddTrainingCourse")
public class MBAddTrainingCourse {
    private TrainingCourse trainingCourse;
    
    
    public String add() {
	TrainingCourseDAO trainingCourseDAO = new TrainingCourseDAO();
	trainingCourseDAO.insert(trainingCourse);
	
	Message.addMessage("INFO", "Added", "Course added successfully");
	
	trainingCourse = new TrainingCourse();
	return null;
    }

    public TrainingCourse getTrainingCourse() {
	if (trainingCourse == null) {
	    trainingCourse = new TrainingCourse();
	}
	return trainingCourse;
    }

    public void setTrainingCourse(TrainingCourse trainingCourse) {
	this.trainingCourse = trainingCourse;
    }
    
    
    
}
