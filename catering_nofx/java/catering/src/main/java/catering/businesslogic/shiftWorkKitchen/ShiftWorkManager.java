package catering.businesslogic.shiftWork;

import catering.businesslogic.CatERing;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.shiftWork.*;
import catering.businesslogic.summaryDocument.SummaryDocument;
import catering.businesslogic.summaryDocument.SummaryDocumentManager;
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
  private ShiftWork shiftWork;


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


  public void lookUpToKitchenShiftWorkList() throws UseCaseLogicException{
    User user = CatERing.getInstance().getUserManager().getCurrentUser();
    if(!user.isChef()) {
      throw new UseCaseLogicException();
    }
    shiftWork.getLisSHiftWork();
  }

}
