package catering.businesslogic.TEST;

import catering.businesslogic.CatERing;
import catering.businesslogic.task.*;
import java.util.ArrayList;


/**
 * Step 3,4,5
 * Sorting tasks by difficulty, priority and timing
 * TODO: check this better
 */
public class TestCatERingSorting {
  public static void main(String[] args) {
    // System.out.println("Test fake login");
    // CatERing.getInstance().getUserManager().fakeLogin("Lidia");
    // System.out.println("After fake login:");
    // System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());


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
    System.out.println("Tasks ordered by difficulty: " + sortedByPriority.toString());
    for(Task task : sortedByPriority){
      System.out.println(task.toString());
    }


    //Sorting by timing
    System.out.println("Sorting by timing");
    ArrayList<Task> sortedByTiming = CatERing.getInstance().getTaskManager().orderTaskByDifficulty(listToSort);
    System.out.println("Tasks ordered by timing: " + sortedByTiming);
    for(Task task : sortedByTiming){
      System.out.println(task.toString());
    }





    
  }
  
}
