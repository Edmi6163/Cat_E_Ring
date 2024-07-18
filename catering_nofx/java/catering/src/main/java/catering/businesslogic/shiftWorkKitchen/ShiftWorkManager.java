package catering.businesslogic.shiftWorkKitchen;

import catering.businesslogic.CatERing;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.billBoard.BillBoard;
import catering.businesslogic.employer.Employer;
import catering.businesslogic.task.*;
import catering.businesslogic.user.User;
import catering.businesslogic.*;


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
  private shiftWorkKitchen shiftWork;



  public ArrayList<Task> orderTaskByDate(ArrayList<Task> tasks) {
    return tasks;
  }

  public ArrayList<Task> assignTasks(String string, String string2, String string3, ArrayList<shiftWorkKitchen> shiftWorks, Task task) {
    BillBoard bb =BillBoard.getInstance();
    task.addTask(task);
    bb.addTaskAssogmed(task, string2,string3);
    return task.getTasks();
  }


  public ArrayList<shiftWorkKitchen>lookUpToKitchenShiftWorkList() throws UseCaseLogicException{
    User user = CatERing.getInstance().getUserManager().getCurrentUser();
    if(!user.isChef()) {
      throw new UseCaseLogicException();
    }
    return  shiftWork.getLisSHiftWork();
  }

}
