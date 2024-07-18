package catering.TestCompitiCucina;

import java.sql.Date;
import java.util.ArrayList;

import catering.businesslogic.CatERing;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.shiftWorkKitchen.shiftWorkKitchen;
import catering.businesslogic.task.Task;

public class TestCatERing2 {
  public static void main(String[] args) {
    try {
            System.out.println("TEST FAKE LOGIN");
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println("After fake login:");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

                  System.out.println("\nTEST ADD TASK");
            ArrayList<shiftWorkKitchen> shiftWorks = new ArrayList<>();
            shiftWorks.add(new shiftWorkKitchen(new Date(2025-1900, 1, 1), new Date(2025-1900, 1, 2), "CucinaCorsoDuca", null, null,"Accendere il forno a 200 gradi"));
            Task task = new Task("Riccardo Oro ", true, 1, shiftWorks.get(0), 1);
            CatERing.getInstance().getTaskManager().addTask(task);
            System.out.println("Task Added: " + task.toString());
            shiftWorks.add(new shiftWorkKitchen(new Date(2025-1900, 1, 1), new Date(2025-1900, 1, 2), "Cucina sotto le stelle", null, null,"Fare la maionese"));
            Task task2 = new Task("Francesco Mauro", true, 1, shiftWorks.get(0), 1);
            CatERing.getInstance().getTaskManager().addTask(task2);
            System.out.println("Task Added: " + task2.toString());
            System.out.println("LIST SIZE : " + CatERing.getInstance().getTaskManager().getTask().size());

    } catch(Exception e){
      System.out.println("UseCaseLogicException: " + e.getMessage());
    }
  }
  
}
