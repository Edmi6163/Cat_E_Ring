package catering.businesslogic.billBoard;

import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.task.*;
import catering.businesslogic.shiftWork.*;

public class BillBoard {
  private Task task;
  private ShiftWork ShiftWork;
  private String name;
  private String surname;
  private Recipe recipe;
  private static BillBoard instance;
  private BillBoard(){
        this.task = null;
        this.ShiftWork = null;
        this.name = "";
        this.surname = "";
        this.recipe = null;
  }
    public static BillBoard getInstance(){
        if(instance == null)
        {
            instance = new BillBoard();
        }
        return instance;
    }




 public static void  BillBoardInit(Task task, ShiftWork shiftWork, String name, String surname, Recipe recipe){
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

  public ShiftWork getShiftWork() {
    return ShiftWork;
  }

  public void setShiftWork(ShiftWork shiftWork) {
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