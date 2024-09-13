package catering.TestCompitiCucina;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

import catering.businesslogic.CatERing;
import catering.businesslogic.employer.Employer;
import catering.businesslogic.shiftWorkKitchen.shiftWorkKitchen;
import catering.businesslogic.task.Task;
import java.sql.Date;

public class TestCatERing8 {
  public static void main(String[] args) {
    try { 
           System.out.println("TEST FAKE LOGIN");
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println("After fake login:");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

            ArrayList<Task>listTask = new ArrayList<>();
            System.out.println("Test assign task");
            Employer emp = new Employer("Francesco", "Mauro");
             ArrayList<shiftWorkKitchen> shiftWorks = new ArrayList<>();
             shiftWorkKitchen shiftWork = new shiftWorkKitchen("Cucina del Barricata", true, false, true, "2021-12-31", "Note");
            shiftWorks.add(shiftWork);
            Task task = new Task("Riccardo Oro ", true, 1, shiftWorks.get(0), 1, Time.valueOf(LocalTime.of(1, 0)));

            CatERing.getInstance().getTaskManager().assignTask(true,emp, emp, shiftWork, task);
            System.out.println("Task assigned: " + task.toString() + " \nto: " + emp.toString() +"\nLIST: "+ task.toString() );
    } catch (Exception e){
      System.out.println("Errore di logica nello use case: " + e.getMessage());
    }
  }
  
}
