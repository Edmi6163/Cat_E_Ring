package catering.businesslogic.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import catering.businesslogic.employer.Employer;
import catering.businesslogic.shiftWorkKitchen.shiftWorkKitchen;

public class TaskManager {
	private static TaskManager singleInstance = null;
	private ArrayList<Task> tasks;

	// Private constructor for singleton
	private TaskManager() {
		tasks = new ArrayList<>();
	}

	// Singleton pattern implementation
	public static TaskManager getTaskManager() {
		if (singleInstance == null) {
			singleInstance = new TaskManager();
		}
		return singleInstance;
	}

	// Order tasks by difficulty
	public static ArrayList<Task> orderTaskByDifficulty(ArrayList<Task> tasks) {
		Collections.sort(tasks, Comparator.comparingInt(Task::getDifficulty));
		return tasks;
	}

	// Order tasks by priority
	public static ArrayList<Task> orderTaskByPriority(ArrayList<Task> tasks) {
		Collections.sort(tasks, Comparator.comparing(Task::isTypeTask).reversed());
		return tasks;
	}

	// Order tasks by timing
	public static ArrayList<Task> orderTaskByTiming(ArrayList<Task> tasks) {
		Collections.sort(tasks, Comparator.comparing(task -> task.getShiftWork().getStartingDate())); // Ensure shiftWorkKitchen has getStartingDate()
		return tasks;
	}

	// Assign task to an employer
	public static ArrayList<Task> assignTask(boolean typeTask, Employer name, Employer surname, shiftWorkKitchen shiftWork, Task task) {
		ArrayList<Task> tasks = new ArrayList<>();
		String assignedTo = (name != null ? name.toString() : "") + " " + (surname != null ? surname.toString() : "").trim();
		task.setAssignedTo(assignedTo);
		task.setTypeTask(typeTask);
		task.setShiftWork(shiftWork);
		tasks.add(task);
		return tasks;
	}

	// Add task to the task manager
	public void addTask(Task task) {
		tasks.add(task);
	}

	public ArrayList<Task> getTask() {
		return tasks;
	}
}