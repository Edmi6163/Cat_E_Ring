import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Task {
    String assignedTo;
    boolean typeTask; 
    int difficulty;
    ShiftWork shiftWork;

    public Task(String assignedTo, boolean typeTask, int difficulty, ShiftWork shiftWork) {
        this.assignedTo = assignedTo;
        this.typeTask = typeTask;
        this.difficulty = difficulty;
        this.shiftWork = shiftWork;
    }

    public static ArrayList<Task> orderTaskByDifficulty(ArrayList<Task> tasks) {
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return Integer.compare(t1.difficulty, t2.difficulty);
            }
        });
        return tasks;
    }

    public static ArrayList<Task> orderTaskByPriority(ArrayList<Task> tasks) {
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return Boolean.compare(t1.typeTask, t2.typeTask);
            }
        });
        return tasks;
    }

    public static ArrayList<Task> orderTaskByTiming(ArrayList<Task> tasks) {
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.shiftWork.compareTo(t2.shiftWork); 
            }
        });
        return tasks;
    }

    public static ArrayList<Task> assignTask(boolean typeTask, Employer name, Employer surname, ShiftWork shiftWork, Task task) {
        ArrayList<Task> tasks = new ArrayList<>();
        String assignedTo = (name != null ? name.toString() : "") + " " + (surname != null ? surname.toString() : "");
        task.assignedTo = assignedTo.trim();
        task.typeTask = typeTask;
        task.shiftWork = shiftWork;
        tasks.add(task);
        return tasks;
    }
}