package catering.TestCompitiCucina;

import java.util.ArrayList;

import catering.businesslogic.CatERing;
import catering.businesslogic.shiftWorkKitchen.ShiftWorkManager;
import catering.businesslogic.shiftWorkKitchen.shiftWorkKitchen;
import catering.businesslogic.task.Task;
import java.util.Date;

public class TestCatERing9 {
  public static void main(String[] args) {
    try {
      ShiftWorkManager shiftWorkManager = new ShiftWorkManager();
        ArrayList<shiftWorkKitchen> shiftWorks = new ArrayList<>();
            shiftWorks.add(new shiftWorkKitchen(new Date(2025-1900, 1, 1), new Date(2025-1900, 1, 2), "CucinaCorsoDuca", null, null,"ACCENDERE IL FORNO A 200 GRADI"));
            Task task = new Task("Riccardo Oro ", true, 1, shiftWorks.get(0), 1);
            CatERing.getInstance().getTaskManager().addTask(task);

            System.out.println("Test look up to kitchen work list");
            shiftWorkManager.assignTasks("Mettere in ordine la cucina", "Francesco", "Mauro", shiftWorks, task);
            shiftWorkManager.lookUpToKitchenShiftWorkList();
            System.out.println("Shift work manager look up result is: "+ shiftWorkManager.toString());
    } catch (Exception e){
      System.out.println("Errore di logica nello use case: " + e.getMessage());
    }
  }
  
}
