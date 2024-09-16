package catering.TestCompitiCucina;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

import catering.businesslogic.CatERing;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.shiftWorkKitchen.shiftWorkKitchen;
import catering.businesslogic.task.Task;

public class TestCatERing2 {
  public static void main(String[] args) {
    try {
        ArrayList<Task>listTask = new ArrayList<>();

        System.out.println("TEST FAKE LOGIN");
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println("After fake login:");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

                  System.out.println("\nTEST ADD TASK");
            ArrayList<shiftWorkKitchen> shiftWorks = new ArrayList<>();
            shiftWorks.add(new shiftWorkKitchen("Cucina", true, false, true, "2021-12-31", "Note"));
            Task task = new Task("Riccardo Oro ", true, null, shiftWorks.get(0), listTask);
            CatERing.getInstance().getTaskManager().addTask(task);
            System.out.println("Task Added: " + task.toString());
            shiftWorks.add(new shiftWorkKitchen("Cucina", true, false, true, "2021-12-31", "Ricordarsi di spegnere la luce a fine turno"));
            Task task2 = new Task("Francesco Mauro", true, "Spegnere la luce ", shiftWorks.get(0), listTask);
            CatERing.getInstance().getTaskManager().addTask(task2);
            System.out.println("Task Added: " + task2.toString());
            System.out.println("LIST SIZE : " + CatERing.getInstance().getTaskManager().getTask().size());

    } catch(Exception e){
      System.out.println("UseCaseLogicException: " + e.getMessage());
    }
  }
  
}
