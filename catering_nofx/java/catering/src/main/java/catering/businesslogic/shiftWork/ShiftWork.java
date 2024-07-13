package catering.businesslogic.shiftWork;

import catering.businesslogic.task.Task;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class ShiftWork {
  public Date startingDate; 
  public Date endingDate;
  public String location;
  public Time lowerBoundInitShift; 
  public Time upperBoundInitShift;
  private ArrayList<Task>tasks;

  public ShiftWork(Date startingDate, Date endingDate, String location, Time lowerBoundInitShift, Time upperBoundInitShift) {
    this.startingDate = startingDate;
    this.endingDate = endingDate;
    this.location = location;
    this.lowerBoundInitShift = lowerBoundInitShift;
    this.upperBoundInitShift = upperBoundInitShift;
    this.tasks = new ArrayList<>();
  }
  public void addTask(Task task){
    tasks.add(task);
  }
  public void removeTask(Task task){
    tasks.remove(task);
  }

}
