package catering.businesslogic.billBoard;

import catering.businesslogic.employer.Employer;
import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.task.*;
import catering.businesslogic.shiftWorkKitchen.*;

import java.util.ArrayList;
import java.util.HashMap;

public class BillBoard {
    private Task task;
    private ArrayList<Task> taskList;
    private shiftWorkKitchen shiftWork;
    private String name;
    private String surname;
    private Recipe recipe;
    private static BillBoard instance;
    private HashMap<Task, Employer> taskAssogmed;

    public HashMap<Task, Employer> getTaskAssogmed() {
        return taskAssogmed;
    }

    public void setTaskAssogmed(HashMap<Task, Employer> taskAssogmed) {
        this.taskAssogmed = taskAssogmed;
    }

    public void addTaskAssogmed(Task task, Employer employer,String note) {
        if(note!=null) {
            task.setAssignedTo(employer.getName() + " " + employer.getSurname() + " " + note);
        }
        taskAssogmed.put(task, employer);
    }

    private BillBoard() {
        this.task = null;
        this.shiftWork = null;
        this.name = "";
        this.surname = "";
        this.recipe = null;
        this.taskList = new ArrayList<>();
        this.taskAssogmed = new HashMap<>();
    }

    public static BillBoard getInstance() {
        if (instance == null) {
            instance = new BillBoard();
        }
        return instance;
    }

    public void addTaskBillBoard(Task task) {
        taskList.add(task);
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public static void BillBoardInit(Task task, shiftWorkKitchen shiftWork, String name, String surname, Recipe recipe) {
        if (instance == null) {
            instance = new BillBoard();
        }
        instance.task = task;
        instance.shiftWork = shiftWork;
        instance.name = name;
        instance.surname = surname;
        instance.recipe = recipe;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public shiftWorkKitchen getShiftWork() {
        return shiftWork;
    }

    public void setShiftWork(shiftWorkKitchen shiftWork) {
        this.shiftWork = shiftWork;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    public BillBoard getBillBoard() {
        return instance;
    }
}