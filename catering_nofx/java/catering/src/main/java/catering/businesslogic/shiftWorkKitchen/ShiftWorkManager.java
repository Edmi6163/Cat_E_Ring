package catering.businesslogic.shiftWorkKitchen;

import catering.businesslogic.CatERing;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.billBoard.BillBoard;
import catering.businesslogic.employer.Employer;
import catering.businesslogic.task.*;
import catering.businesslogic.user.User;


import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;

public class ShiftWorkManager {
  private ShiftWorkManager istance;
  private Date startingDate;
  private Date endingDate;
  private String location;
  private Time lowerBoundInitShift;


  private Time upperBoundInitShift;
  private Boolean emergency;
  private shiftWorkKitchen shiftWork ;

  public ShiftWorkManager(Date startingDate, Date endingDate, String location, Time lowerBoundInitShift, Time upperBoundInitShift, Boolean emergency, shiftWorkKitchen shiftWork) {
    this.startingDate = startingDate;
    this.endingDate = endingDate;
    this.location = location;
    this.lowerBoundInitShift = lowerBoundInitShift;
    this.upperBoundInitShift = upperBoundInitShift;
    this.emergency = emergency;
    this.shiftWork = shiftWork;
  }

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

  public Boolean getEmergency() {
    return emergency;
  }

  public void setEmergency(Boolean emergency) {
    this.emergency = emergency;
  }

  public shiftWorkKitchen getShiftWork() {
    return shiftWork;
  }

  public void setShiftWork(shiftWorkKitchen shiftWork) {
    this.shiftWork = shiftWork;
  }

  @Override
  public String toString() {
    return "ShiftWorkManager{" +
            "startingDate=" + startingDate +
            ", endingDate=" + endingDate +
            ", location='" + location + '\'' +
            ", lowerBoundInitShift=" + lowerBoundInitShift +
            ", upperBoundInitShift=" + upperBoundInitShift +
            ", emergency=" + emergency +
            ", shiftWork=" + shiftWork.toString() +
            '}';
  }

  public ArrayList<Task> orderTaskByDate(ArrayList<Task> tasks) {
    return tasks;
  }

  public ArrayList<Task> assignTasks(Employer name, ArrayList<shiftWorkKitchen> shiftWorks, Task task) {
    BillBoard bb =BillBoard.getInstance();
    task.addTask(task);
    bb.addTaskAssogmed(task, name,"");
    return task.getTasks();
  }

  public ShiftWorkManager getShiftWorkManager() {
    if (istance == null) {
      istance = new ShiftWorkManager(startingDate, endingDate, location, lowerBoundInitShift, upperBoundInitShift, emergency, shiftWork);
    }
    return istance;
  }
}
