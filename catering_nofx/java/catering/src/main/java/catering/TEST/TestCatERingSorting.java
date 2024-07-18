package catering.TEST;

import catering.businesslogic.CatERing;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.menu.MenuException;
import catering.businesslogic.task.*;
import java.util.ArrayList;


/**
 * Step 3,4,5
 * Sorting tasks by difficulty, priority and timing
 */
public class TestCatERingSorting {
  public static void main(String[] args) {
    try { 
    System.out.println("Test fake login");
    CatERing.getInstance().getUserManager().fakeLogin("Lidia");
    System.out.println("After fake login:");
    System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());


    ArrayList<Task> listToSort = CatERing.getInstance().getTaskManager().getTask();
    //creatae some new random task, add it to listToSort 
    Task task1 = new Task("Task1", true, 1, null, 4);
    Task task2 = new Task("Task2", true, 3, null, 2);
    Task task3 = new Task("Task3", true, 2, null, 3);
    Task task4 = new Task("Task4", true, 4, null, 1);
    listToSort.add(task4);
    listToSort.add(task2);
    listToSort.add(task3);
    listToSort.add(task1);


    //Sorting by difficulty
    System.out.println("Sorting by difficulty");
    ArrayList<Task> sortedByDifficulty = CatERing.getInstance().getTaskManager().orderTaskByDifficulty(listToSort);
    for(Task task : sortedByDifficulty){
      System.out.println(task.toString());
    }


    //Sorting by priority
    System.out.println("Sorting by priority");
    ArrayList<Task> sortedByPriority = CatERing.getInstance().getTaskManager().orderTaskByPriority(listToSort);
    for(Task task : sortedByPriority){
      System.out.println(task.toString());
    }


    //Sorting by timing
    System.out.println("Sorting by timing");
    ArrayList<Task> sortedByTiming = CatERing.getInstance().getTaskManager().orderTaskByDifficulty(listToSort);
    for(Task task : sortedByTiming){
      System.out.println(task.toString());
    }





    
  } catch(Exception e) {
      System.out.println("Errore di logica nello use case");
  }
  
}
}
