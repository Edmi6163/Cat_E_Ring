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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Task{")
				.append("assignedTo='").append(assignedTo).append('\'')
				.append(", typeTask=").append(typeTask)
				.append(", note='").append(note).append('\'')
				.append(", shiftWork=").append(shiftWork)
				.append(", tasks=");

		if (tasks != null) {
			sb.append("[");
			for (int i = 0; i < tasks.size() && i < 10; i++) {  // Limita il numero di task visualizzati
				sb.append(tasks.get(i).getAssignedTo());
				if (i < tasks.size() - 1) sb.append(", ");
			}
			if (tasks.size() > 3) {
				sb.append("...");
			}
			sb.append("]");
		} else {
			sb.append("null");
		}

		sb.append('}');
		return sb.toString();
	}


	public Task(String assignedTo, boolean typeTask, String note, shiftWorkKitchen shiftWork, ArrayList<Task> tasks) {
		this.assignedTo = assignedTo;
		this.typeTask = typeTask;
		this.note = note;
		this.shiftWork = shiftWork;
		this.tasks = tasks;
	}

	private String note;
	private shiftWorkKitchen shiftWork;
	private ArrayList<Task> tasks;


	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public shiftWorkKitchen getShiftWork() {
		return shiftWork;
	}

	public void setShiftWork(shiftWorkKitchen shiftWork) {
		this.shiftWork = shiftWork;
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