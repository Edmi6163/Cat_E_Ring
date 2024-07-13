package catering.businesslogic.summaryDocument;

import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.shiftWork.ShiftWork;
import catering.businesslogic.task.Task;

import java.util.ArrayList;

public class SummaryDocument {
  
  private String title; 
  private String shiftWork;
  private  String menu;
  private String recipe;
  private boolean advancedPreparation;
  private Integer quantityForAdvancedPreparation;
  private  ArrayList<SummaryDocument> listSummaryDocument;
  private ArrayList<Task>listTasks;

  public SummaryDocument(String title, String shiftWork, String menu, String recipe, boolean advancedPreparation, Integer quantityForAdvancedPreparation,ArrayList<Task>listTask) {
    this.title = title;
    this.shiftWork = shiftWork;
    this.menu = menu;
    this.recipe = recipe;
    this.advancedPreparation = advancedPreparation;
    this.quantityForAdvancedPreparation = quantityForAdvancedPreparation;
    this.listSummaryDocument = new ArrayList<>();
    if(listTasks ==null)
    {
      this.listTasks = new ArrayList<Task>();
    }
    this.listTasks = listTask;
  }

  public static SummaryDocument createSummaryDocument(String title) {
    return new SummaryDocument(title, null, null, null, false, null,null);
  }

  
  public void modifySummaryDocumentTitle(String newTitle) {
    this.title = newTitle;
  }

  public void addContext(ShiftWork shiftWork, Recipe recipe, Task task) {
    if (shiftWork!= null) {
      this.shiftWork = shiftWork.toString();
    }
    if (recipe != null) {
      this.recipe = recipe.toString(); 
    }
  }

  public void modifieContext(SummaryDocument summaryDocument) {
  }

  public void deleteSummaryDocument(SummaryDocument summaryDocument) {
    listSummaryDocument.remove(summaryDocument);
  }

  public SummaryDocument copyDocument() {
    return new SummaryDocument(this.title, this.shiftWork, this.menu, this.recipe, this.advancedPreparation, this.quantityForAdvancedPreparation,this.listTasks);
  }

  public void moreSummaryDocument() {
  }

  public SummaryDocument getSummaryDocument() {
    return this;
  }

  public void addTask(Task task) {
    listTasks.add(task); 
  }
  public void removeTask(Task task)
  {
    listTasks.remove(task);
  }

  public void add(SummaryDocument summaryDocument) {
    listSummaryDocument.add(summaryDocument);
  }

  public void remove(SummaryDocument summaryDocument) {
    listSummaryDocument.remove(summaryDocument);
  }
}