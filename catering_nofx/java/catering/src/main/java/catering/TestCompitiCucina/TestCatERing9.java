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
    try {
        System.out.println("TEST FAKE LOGIN");
        CatERing.getInstance().getUserManager().fakeLogin("Lidia");
        System.out.println("After fake login:");
        System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());
        ArrayList<Task>listTask = new ArrayList<>();

      ShiftWorkManager shiftWorkManager = new ShiftWorkManager();
        ArrayList<shiftWorkKitchen> shiftWorks = new ArrayList<>();
        shiftWorkKitchen swk =  new shiftWorkKitchen(new Date(2025-1900, 1, 1), new Date(2025-1900, 1, 2), "CucinaCorsoDuca", null, null,"ACCENDERE IL FORNO A 200 GRADI",listTask);
        shiftWorks.add(swk);
            Task task = new Task("Riccardo Oro ", true, 1, shiftWorks.get(0), 1, Time.valueOf(LocalTime.of(1, 0)));
            listTask.add(task);
            CatERing.getInstance().getTaskManager().addTask(task);


            System.out.println("Test look up to kitchen work list");
          Employer francesco = new Employer("francesco","Mauro");
           shiftWorkManager.assignTasks(francesco,francesco, shiftWorks, task);
          shiftWorkManager.lookUpToKitchenShiftWorkList();
            System.out.println("Shift work manager look up result is: "+ shiftWorkManager.toString());
    } catch ( UseCaseLogicException e){
      System.out.println("Errore di logica nello use case: " + e.getMessage());
    }
  }

}
