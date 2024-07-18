package catering.TestCompitiCucina;

import java.util.ArrayList;

import catering.businesslogic.CatERing;
import catering.businesslogic.employer.Employer;
import catering.businesslogic.shiftWorkKitchen.shiftWorkKitchen;
import catering.businesslogic.task.Task;
import java.util.Date;

public class TestCatERing8 {
  public static void main(String[] args) {
    try { 
           System.out.println("TEST FAKE LOGIN");
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println("After fake login:");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());


            System.out.println("Test assign task");
            Employer emp = new Employer("Francesco", "Mauro");
             ArrayList<shiftWorkKitchen> shiftWorks = new ArrayList<>();
            shiftWorks.add(new shiftWorkKitchen(new Date(2025-1900, 1, 1), new Date(2025-1900, 1, 2), "CucinaCorsoDuca", null, null,"Accendere il forno a 200 gradi"));
            Task task = new Task("Riccardo Oro ", true, 1, shiftWorks.get(0), 1);

            CatERing.getInstance().getTaskManager().assignTask(true,emp, emp, null, task);
    } catch (Exception e){
      System.out.println("Errore di logica nello use case: " + e.getMessage());
    }
  }
  
}
