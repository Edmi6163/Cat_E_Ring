package catering.businesslogic.task;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import catering.businesslogic.employer.Employer;
import catering.businesslogic.shiftWorkKitchen.shiftWorkKitchen;

public class Task {
	private String assignedTo;
	private boolean typeTask;
	private int difficulty;
	private shiftWorkKitchen shiftWork;
	private int priority;
	private ArrayList<Task> tasks;
	private Time timing ;


	@Override
	public String toString() {
		return "Task [assignedTo=" + assignedTo + ", typeTask=" + typeTask + ", difficulty=" + difficulty + ", shiftWork="
				+ shiftWork + ", priority=" + priority + ", tasks=" + tasks + ", timing=" + timing + "]";
	}

	public Time getTiming() {
		return timing;
	}

	public void setTiming(Time timing) {
		this.timing = timing;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

	public Task(String assignedTo, boolean typeTask, int difficulty, shiftWorkKitchen shiftWork, int priority,Time timing) {
		this.assignedTo = assignedTo;
		this.typeTask = typeTask;
		this.difficulty = difficulty;
		this.shiftWork = shiftWork;
		this.priority = priority;
		this.tasks = new ArrayList<>();
		this.timing = timing;
	}

	// Getters and setters
	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public boolean isTypeTask() {
		return typeTask;
	}

	public void setTypeTask(boolean typeTask) {
		this.typeTask = typeTask;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public shiftWorkKitchen getShiftWork() {
		return shiftWork;
	}

	public void setShiftWork(shiftWorkKitchen shiftWork) {
		this.shiftWork = shiftWork;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	// Static methods for ordering tasks
	public static ArrayList<Task> orderTaskByDifficulty(ArrayList<Task> tasks) {
		Collections.sort(tasks, Comparator.comparingInt(Task::getDifficulty));
		return tasks;
	}

	public static ArrayList<Task> orderTaskByPriority(ArrayList<Task> tasks) {
		Collections.sort(tasks, Comparator.comparing(Task::isTypeTask).reversed());
		return tasks;
	}

	public static ArrayList<Task> orderTaskByTiming(ArrayList<Task> tasks) {
		Collections.sort(tasks, Comparator.comparing(task -> task.getShiftWork().getStartingDate()));
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

	public void addTask(Task task) {

		tasks.add(task);
	}

	public ArrayList<Task> getTasks() {
		return this.tasks;
	}
}