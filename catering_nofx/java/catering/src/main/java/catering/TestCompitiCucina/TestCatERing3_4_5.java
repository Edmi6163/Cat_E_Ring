package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.shiftWorkKitchen.shiftWorkKitchen;
import catering.businesslogic.task.Task;

import java.time.LocalTime;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class TestCatERing3_4_5 {
  public static void main(String[] args) {
    try {
      System.out.println("Test fake login");
      CatERing.getInstance().getUserManager().fakeLogin("Lidia");
      System.out.println("After fake login:");
      System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

      shiftWorkKitchen shiftWork = new shiftWorkKitchen(new Date(2025-1-3), new Date(2025- 1 -5), "CUCINA2", Time.valueOf(LocalTime.of(1, 0)), Time.valueOf(LocalTime.of(3, 0)), "PULIRE TUTTO", null);
      shiftWorkKitchen shiftWork2 = new shiftWorkKitchen(new Date(2025-2-3), new Date(2025- 2 -5), "CUCINA5", Time.valueOf(LocalTime.of(1, 0)), Time.valueOf(LocalTime.of(3, 0)), "Spegnere le lUCI", null);
      shiftWorkKitchen shiftWork3 = new shiftWorkKitchen(new Date(2025-1-6), new Date(2025- 1 -9), "CUCINA6", Time.valueOf(LocalTime.of(1, 0)), Time.valueOf(LocalTime.of(3, 0)), "DARE DA BERE ALLE PIANTE", null);
      shiftWorkKitchen shiftWork4 = new shiftWorkKitchen(new Date(2025-4-3), new Date(2025- 4-1), "CUCINA7", Time.valueOf(LocalTime.of(1, 0)), Time.valueOf(LocalTime.of(3, 0)), "PULIRE I TAGLIERI", null);

      ArrayList<Task> listToSort = CatERing.getInstance().getTaskManager().getTask();
      // Create some new random tasks, add them to listToSort
      Task task1 = new Task("Task1", true, 1, shiftWork, 4, Time.valueOf(LocalTime.of(1, 0)));
      Task task2 = new Task("Task2", true, 3, shiftWork3, 2, Time.valueOf(LocalTime.of(0, 30)));
      Task task3 = new Task("Task3", true, 2, shiftWork2, 3, Time.valueOf(LocalTime.of(5, 0)));
      Task task4 = new Task("Task4", true, 4, shiftWork4, 1, Time.valueOf(LocalTime.of(7, 1)));
      listToSort.add(task4);
      listToSort.add(task2);
      listToSort.add(task3);
      listToSort.add(task1);

      // Sorting by difficulty
      System.out.println("Sorting by difficulty");
      ArrayList<Task> sortedByDifficulty = CatERing.getInstance().getTaskManager().orderTaskByDifficulty(listToSort);
      for (Task task : sortedByDifficulty) {
        System.out.println(task.toString());
      }

      // Sorting by priority
      System.out.println("Sorting by priority");
      ArrayList<Task> sortedByPriority = CatERing.getInstance().getTaskManager().orderTaskByPriority(listToSort);
      for (Task task : sortedByPriority) {
        System.out.println(task.toString());
      }

      // Sorting by timing
      System.out.println("Sorting by timing");
      ArrayList<Task> sortedByTiming = CatERing.getInstance().getTaskManager().orderTaskByTiming(listToSort);
      for (Task task : sortedByTiming) {
        System.out.println(task.toString());
      }
    } catch (Exception e) {
      System.out.println("Errore di logica nello use case");
    }
  }
}