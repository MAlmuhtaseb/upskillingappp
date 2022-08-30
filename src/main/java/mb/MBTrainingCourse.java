package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.TrainingCourse;
import dao.TrainingCourseDAO;

@ViewScoped
@ManagedBean(name = "mbTrainingCourse")
public class MBTrainingCourse {
    private List<TrainingCourse> trainingCourseTable;
    private TrainingCourse selectedTrainingCourse;
    private TrainingCourseDAO trainingCourseDAO;

    @PostConstruct
    public void init() {
	trainingCourseDAO = new TrainingCourseDAO();
	trainingCourseTable = trainingCourseDAO.selectAll();
	selectedTrainingCourse = new TrainingCourse();
    }

    public String updateTrainingCourse() {
	trainingCourseDAO.update(selectedTrainingCourse);
	trainingCourseTable = trainingCourseDAO.selectAll();
	return null;
    }

    public String removeTrainingCourse() {
	trainingCourseDAO.delete(selectedTrainingCourse.getCourseId());
	trainingCourseTable = trainingCourseDAO.selectAll();
	return null;
    }

    public List<TrainingCourse> getTrainingCourseTable() {
	return trainingCourseTable;
    }

    public void setTrainingCourseTable(List<TrainingCourse> trainingCourseTable) {
	this.trainingCourseTable = trainingCourseTable;
    }

    public TrainingCourse getSelectedTrainingCourse() {
	return selectedTrainingCourse;
    }

    public void setSelectedTrainingCourse(TrainingCourse selectedTrainingCourse) {
	this.selectedTrainingCourse = selectedTrainingCourse;
    }
}
