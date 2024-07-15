package catering.businesslogic.billBoard;

import catering.businesslogic.employer.Employer;
import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.task.*;
import catering.businesslogic.shiftWorkKitchen.*;

import java.util.ArrayList;
import java.util.HashMap;

public class BillBoard {
  private Task task;
  private ArrayList<Task>taskList;
  private shiftWorkKitchen ShiftWork;
  private String name;
  private String surname;
  private Recipe recipe;
  private static BillBoard instance;

    public HashMap<Task, Employer> getTaskAssogmed() {
        return taskAssogmed;
    }

    public void setTaskAssogmed(HashMap<Task, Employer> taskAssogmed) {
        this.taskAssogmed = taskAssogmed;
    }
    public void addTaskAssogmed(Task task, Employer name,Employer surname){
        Employer employer = new Employer(name.getName(), surname.getSurname());
        taskAssogmed.put(task, employer);
    }
    private HashMap<Task, Employer> taskAssogmed;
  private BillBoard(){
        this.task = null;
        this.ShiftWork = null;
        this.name = "";
        this.surname = "";
        this.recipe = null;
        this.taskList = new ArrayList<>();
  }
    public static BillBoard getInstance(){
        if(instance == null)
        {
            instance = new BillBoard();
        }
        return instance;
    }

public void addTaskBillBoard(Task task) {
    taskList.add(task);
}


 public static void  BillBoardInit(Task task, shiftWorkKitchen shiftWork, String name, String surname, Recipe recipe){
    if(instance == null)
    {
        instance = new BillBoard();
    }
    instance.task = task;
    instance.ShiftWork = shiftWork;
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
    return ShiftWork;
  }

  public void setShiftWork(shiftWorkKitchen shiftWork) {
    ShiftWork = shiftWork;
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

 
}