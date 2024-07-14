package catering.businesslogic.shiftWork;

import catering.businesslogic.shiftWork.*;
import catering.businesslogic.task.*;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;

public class ShiftWorkManager {
  private Date startingDate;
  private Date endingDate;
  private String location;
  private Time lowerBoundInitShift;
  private Time upperBoundInitShift;
  private Boolean emergency;


  public ArrayList<Task> orderTaskByDifficulty(ArrayList<Task> tasks) {
    return tasks;
  }

  public ArrayList<Task> orderTaskByPriority(ArrayList<Task> tasks) {
    return tasks;
  }

  public ArrayList<Task> orderTaskByDate(ArrayList<Task> tasks) {
    return tasks;
  }

  public ArrayList<Task> assignTasks(boolean typeTask,Employer name, Employer surname, ShiftWork shiftWork,Task task) {
    return tasks;
  }

  
}
