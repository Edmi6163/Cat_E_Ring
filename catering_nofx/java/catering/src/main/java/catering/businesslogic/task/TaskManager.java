package catering.businesslogic.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import catering.businesslogic.employer.Employer;
import catering.businesslogic.shiftWorkKitchen.shiftWorkKitchen;

public class TaskManager {
	String assignedTo;
	boolean typeTask;
	int difficulty;
	shiftWorkKitchen shiftWork;

	public TaskManager(String assignedTo, boolean typeTask, int difficulty, shiftWorkKitchen shiftWork) {
		this.assignedTo = assignedTo;
		this.typeTask = typeTask;
		this.difficulty = difficulty;
		this.shiftWork = shiftWork;
	}
	public TaskManager TaskManager() {
		return this;
	}

	public static ArrayList<Task> orderTaskByDifficulty(ArrayList<Task> tasks) {
		Collections.sort(tasks, Comparator.comparingInt(task -> task.getDifficulty()));
		return tasks;
	}

	public static ArrayList<Task> orderTaskByPriority(ArrayList<Task> tasks) {
		Collections.sort(tasks, Comparator.comparing(Task::isTypeTask).reversed());
		return tasks;
	}

	public static ArrayList<Task> orderTaskByTiming(ArrayList<Task> tasks) {
		Collections.sort(tasks, Comparator.comparing(task -> task.getShiftWork().getStartingDate())); // Ensure shiftWorkKitchen has getStartTime()
		return tasks;
	}

	public static ArrayList<Task> assignTask(boolean typeTask, Employer name, Employer surname, shiftWorkKitchen shiftWork, Task task) {
		ArrayList<Task> tasks = new ArrayList<>();
		String assignedTo = (name != null ? name.toString() : "") + " " + (surname != null ? surname.toString() : "").trim();
		task.setAssignedTo(assignedTo);
		task.setTypeTask(typeTask);
		task.setShiftWork(shiftWork);
		tasks.add(task);
		return tasks;
	}

	public TaskManager getTaskManager() {
		return this;
	}

	public void addTask(Task task) {
		task.addTask(task);
	}
}