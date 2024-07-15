package catering.businesslogic.shiftWorkKitchen;

import catering.businesslogic.task.Task;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class shiftWorkKitchen {
  public Date getStartingDate() {
    return startingDate;
  }

  public void setStartingDate(Date startingDate) {
    this.startingDate = startingDate;
  }

  public Date getEndingDate() {
    return endingDate;
  }

  public void setEndingDate(Date endingDate) {
    this.endingDate = endingDate;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Time getLowerBoundInitShift() {
    return lowerBoundInitShift;
  }

  public void setLowerBoundInitShift(Time lowerBoundInitShift) {
    this.lowerBoundInitShift = lowerBoundInitShift;
  }

  public Time getUpperBoundInitShift() {
    return upperBoundInitShift;
  }

  public void setUpperBoundInitShift(Time upperBoundInitShift) {
    this.upperBoundInitShift = upperBoundInitShift;
  }

  public Date startingDate;
  public Date endingDate;
  public String location;
  public Time lowerBoundInitShift;
  public Time upperBoundInitShift;
  private ArrayList<Task> tasks;

  public ArrayList<shiftWorkKitchen> getLisSHiftWork() {
    return lisSHiftWork;
  }

  public void setLisSHiftWork(ArrayList<shiftWorkKitchen> lisSHiftWork) {
    this.lisSHiftWork = lisSHiftWork;
  }

  private ArrayList<shiftWorkKitchen> lisSHiftWork;

  public shiftWorkKitchen(Date startingDate, Date endingDate, String location, Time lowerBoundInitShift, Time upperBoundInitShift) {
    this.startingDate = startingDate;
    this.endingDate = endingDate;
    this.location = location;
    this.lowerBoundInitShift = lowerBoundInitShift;
    this.upperBoundInitShift = upperBoundInitShift;
    this.tasks = new ArrayList<>();
    this.lisSHiftWork = new ArrayList<>();
  }

  public void addTask(Task task) {
    tasks.add(task);
  }

  public void removeTask(Task task) {
    tasks.remove(task);
  }
}

