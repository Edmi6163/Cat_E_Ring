package catering.businesslogic.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import catering.businesslogic.CatERing;
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

	// Assign task to an employer
	public ArrayList<Task> assignTask(shiftWorkKitchen shiftWork, Employer employer, String note) {
		ArrayList<Task> tasks = CatERing.getInstance().getTaskManager().getTask();
		String assignedTo = employer.getName() + " " + employer.getSurname();
		for (Task task : this.tasks) {
			if (task.getShiftWork().equals(shiftWork) && task.getAssignedTo().equals("")) {
				task.setAssignedTo(assignedTo);
				tasks.add(task);
			}
		}
		return tasks;
	}

	public ArrayList<Task> modifyAssignTask(shiftWorkKitchen shiftWork, Employer employer, String note) {
		ArrayList<Task> tasksToChange = CatERing.getInstance().getTaskManager().getTask();
		for (Task task : this.tasks) {
			if (task.getShiftWork().equals(shiftWork) && task.getAssignedTo().equals(employer.getName() + " " + employer.getSurname())) {
				task.setAssignedTo(employer.getName() + " " + employer.getSurname() + " " + note);
				tasksToChange.add(task);
			}

		}
		return tasksToChange;

	}



	// Add task to the task manager
	public void addTask(Task task) {
		tasks.add(task);
	}

	public ArrayList<Task> getTask() {
		return tasks;
	}
}