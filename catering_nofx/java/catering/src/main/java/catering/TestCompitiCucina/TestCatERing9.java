package catering.TestCompitiCucina;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

import catering.businesslogic.CatERing;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.employer.Employer;
import catering.businesslogic.shiftWorkKitchen.ShiftWorkManager;
import catering.businesslogic.shiftWorkKitchen.shiftWorkKitchen;
import catering.businesslogic.task.Task;
import java.sql.Date;

public class TestCatERing9 {
  public static void main(String[] args) {
      System.out.println("TEST FAKE LOGIN");
      CatERing.getInstance().getUserManager().fakeLogin("Lidia");
      System.out.println("After fake login:");
      System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());
      ArrayList<Task>listTask = new ArrayList<>();

      ArrayList<shiftWorkKitchen> shiftWorks = new ArrayList<>();
      shiftWorkKitchen swk =  new shiftWorkKitchen("Cucina di Corso Svizzera", true, false, true, "2021-12-31", "Note");
      ShiftWorkManager shiftWorkManager = new ShiftWorkManager(Date.valueOf("2024-12-31"),Date.valueOf("2024-12-31"),"Cucina di corso svizzera", Time.valueOf(LocalTime.of(0, 30)), Time.valueOf(LocalTime.of(1, 0)), Boolean.FALSE, swk);
      shiftWorks.add(swk);
      Task task = new Task("Riccardo Oro ", true, 1, shiftWorks.get(0), 1, Time.valueOf(LocalTime.of(1, 0)));
      listTask.add(task);
      CatERing.getInstance().getTaskManager().addTask(task);


      System.out.println("Test look up to kitchen work list");
      Employer francesco = new Employer("francesco","Mauro");
      shiftWorkManager.assignTasks(francesco,francesco, shiftWorks, task);
//          shiftWorkManager.lookUpToKitchenShiftWorkList();
      System.out.println("Shift work manager look up result is: "+ shiftWorkManager.toString());
  }

}
