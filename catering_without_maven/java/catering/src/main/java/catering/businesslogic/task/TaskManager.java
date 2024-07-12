import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import businesslogic.task.*;
import businesslogic.shiftWork.*;

public class TaskManager {
	String assignedTo;
	boolean typeTask; 
	int difficulty;
	ShiftWork shiftWork; 

	// Constructor
	public TaskManager(String assignedTo, boolean typeTask, int difficulty, ShiftWork shiftWork) {
		this.assignedTo = assignedTo;
		this.typeTask = typeTask;
		this.difficulty = difficulty;
		this.shiftWork = shiftWork;
	}

	public static ArrayList<Task> orderTaskByDifficulty(ArrayList<Task> tasks) {
		Collections.sort(tasks, Comparator.comparingInt(task -> task.difficulty));
		return tasks;
	}

	public static ArrayList<Task> orderTaskByPriority(ArrayList<Task> tasks) {
		Collections.sort(tasks, (task1, task2) -> Boolean.compare(task2.typeTask, task1.typeTask)); // Assuming higher boolean value has higher priority
		return tasks;
	}

	public static ArrayList<Task> orderTaskByTiming(ArrayList<Task> tasks) {
		Collections.sort(tasks, Comparator.comparing(task -> task.shiftWork)); 
		return tasks;
	}

	// Assign task to an employee
	public static ArrayList<Task> assignTask(boolean typeTask, Employer name, Employer surname, ShiftWork shiftWork, Task task) {
		ArrayList<Task> tasks = new ArrayList<>();
		String assignedTo = (name != null ? name.toString() : "") + " " + (surname != null ? surname.toString() : "").trim();
		task.assignedTo = assignedTo;
		task.typeTask = typeTask;
		task.shiftWork = shiftWork;
		tasks.add(task);
		return tasks;
	}
}