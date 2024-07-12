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

 public BillBoard(Task task, ShiftWork shiftWork, String name, String surname, Recipe recipe){
    this.task = task;
    this.ShiftWork = shiftWork;
    this.name = name;
    this.surname = surname;
    this.recipe = recipe;
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