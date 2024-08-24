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
  private Date startingDate;
  private Date endingDate;
  private String location;
  private Time lowerBoundInitShift;
  private Time upperBoundInitShift;
  private Boolean emergency;
  private shiftWorkKitchen shiftWork ;

  public ShiftWorkManager(){
    this.shiftWork = new shiftWorkKitchen(null,null,null,null,null,null,null); // Initialize shiftWork
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

  public ArrayList<Task> assignTasks(Employer name, Employer surname, ArrayList<shiftWorkKitchen> shiftWorks, Task task) {
    BillBoard bb =BillBoard.getInstance();
    task.addTask(task);
    bb.addTaskAssogmed(task, name,surname);
    return task.getTasks();
  }
  public ArrayList<shiftWorkKitchen> setListShiftworkKitchen(ArrayList<shiftWorkKitchen>listShiftworkKitchen) {
    return shiftWork.setTasksList(listShiftworkKitchen);
  }

  public ArrayList<shiftWorkKitchen> lookUpToKitchenShiftWorkList() throws UseCaseLogicException{
    User user = CatERing.getInstance().getUserManager().getCurrentUser();
    if(!user.isChef()) {
      throw new UseCaseLogicException();
    }
    return  shiftWork.getLisSHiftWork();
  }

}
