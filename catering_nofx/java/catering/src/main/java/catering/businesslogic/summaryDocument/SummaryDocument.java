package catering.businesslogic.summaryDocument;

import catering.businesslogic.CatERing;
import catering.businesslogic.menu.Menu;
import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.shiftWorkKitchen.shiftWorkKitchen;
import catering.businesslogic.task.Task;
import catering.businesslogic.user.User;
import catering.persistence.PersistenceManager;

import java.util.ArrayList;

public class SummaryDocument {

  private String title;
  private ArrayList<shiftWorkKitchen> shiftWork;
  private ArrayList<Recipe> menu;
  private String recipe;
  private boolean advancedPreparation;
  private Integer quantityForAdvancedPreparation;
  private ArrayList<SummaryDocument> listSummaryDocument;
  private ArrayList<Task> listTasks;
  private boolean isUse;
  private User owner;

  public SummaryDocument(String title, ArrayList<shiftWorkKitchen> shiftWork, ArrayList<Recipe> menu, String recipe, boolean advancedPreparation, Integer quantityForAdvancedPreparation, ArrayList<Task> listTask) {
    this.title = title;
    this.shiftWork = shiftWork != null ? shiftWork : new ArrayList<>();
    this.menu = menu != null ? menu : new ArrayList<>();
    this.recipe = recipe;
    this.advancedPreparation = advancedPreparation;
    this.quantityForAdvancedPreparation = quantityForAdvancedPreparation;
    this.listSummaryDocument = new ArrayList<>();
    this.isUse = false;
    this.listTasks = listTask != null ? listTask : new ArrayList<>();
    this.owner = CatERing.getInstance().getUserManager().getCurrentUser();  // Set the owner to the current user
  }

  // Getters and setters
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ArrayList<shiftWorkKitchen> getShiftWork() {
    return shiftWork;
  }

  public void setShiftWork(ArrayList<shiftWorkKitchen> shiftWork) {
    this.shiftWork = shiftWork;
  }

  public ArrayList<Recipe> getMenu() {
    return menu;
  }

  public void setMenu(ArrayList<Recipe> menu) {
    this.menu = menu;
  }

  public String getRecipe() {
    return recipe;
  }

  public void setRecipe(String recipe) {
    this.recipe = recipe;
  }

  public boolean isAdvancedPreparation() {
    return advancedPreparation;
  }

  public void setAdvancedPreparation(boolean advancedPreparation) {
    this.advancedPreparation = advancedPreparation;
  }

  public Integer getQuantityForAdvancedPreparation() {
    return quantityForAdvancedPreparation;
  }

  public void setQuantityForAdvancedPreparation(Integer quantityForAdvancedPreparation) {
    this.quantityForAdvancedPreparation = quantityForAdvancedPreparation;
  }

  public ArrayList<SummaryDocument> getListSummaryDocument() {
    return listSummaryDocument;
  }

  public void setListSummaryDocument(ArrayList<SummaryDocument> listSummaryDocument) {
    this.listSummaryDocument = listSummaryDocument;
  }

  public ArrayList<Task> getListTasks() {
    return listTasks;
  }

  public void setListTasks(ArrayList<Task> listTasks) {
    this.listTasks = listTasks;
  }

  public boolean isUsed() {
    return this.isUse;
  }

  public boolean isOwner(User u) {
    return this.owner != null && u != null && u.getId() == this.owner.getId();
  }

  public static SummaryDocument createSummaryDocument(String title) {
    return new SummaryDocument(title, null, null, null, false, null, null);
  }

  public SummaryDocument modifySummaryDocumentTitle(String newTitle) {
    this.title = newTitle;
    return this;
  }

  public void addContext(ArrayList<shiftWorkKitchen> shiftWork, Recipe recipe, Task task) {
    if (shiftWork != null) {
      this.shiftWork = shiftWork;
    }
    if (recipe != null) {
      this.recipe = recipe.toString();
    }
    if (task != null) {
      listTasks.add(task);
    }
  }

  public SummaryDocument modifyContext(SummaryDocument summaryDocument) {
    this.shiftWork = summaryDocument.shiftWork;
    this.recipe = summaryDocument.recipe;
    return this;
  }

  public static void deleteSummaryDocument(SummaryDocument summaryDocument) {
    String delTitle = "DELETE FROM SummaryDocument WHERE title = '" + summaryDocument.getTitle() + "'";
    PersistenceManager.executeUpdate(delTitle);

    // Assuming menu and shiftWork are foreign keys, adjust accordingly
    String delMenu = "DELETE FROM SummaryDocument WHERE id IN (SELECT id FROM SummaryDocument WHERE menu = '" + summaryDocument.getMenu() + "')";
    PersistenceManager.executeUpdate(delMenu);

    String delShiftList = "DELETE FROM SummaryDocument WHERE id IN (SELECT id FROM SummaryDocument WHERE shiftWork = '" + summaryDocument.getShiftWork() + "')";
    PersistenceManager.executeUpdate(delShiftList);

    String delRecipe = "DELETE FROM SummaryDocument WHERE recipe = '" + summaryDocument.getRecipe() + "'";
    PersistenceManager.executeUpdate(delRecipe);
  }

  public SummaryDocument copyDocument() {

      SummaryDocument copy = new SummaryDocument(this.title, new ArrayList<>(this.shiftWork), new ArrayList<>(this.menu), this.recipe, this.advancedPreparation, this.quantityForAdvancedPreparation, new ArrayList<>(this.listTasks));
      copy.owner = this.owner;  // Ensure the owner is copied over
      return copy;

  }

  public SummaryDocument moreSummaryDocument(SummaryDocument summaryDocument) {
    if (summaryDocument != null) {
      if (summaryDocument.title != null) {
        this.title = summaryDocument.title;
      }
      this.listTasks.addAll(summaryDocument.listTasks);
      this.shiftWork.addAll(summaryDocument.shiftWork);
      this.recipe = summaryDocument.recipe;
      this.menu.addAll(summaryDocument.menu);
      listSummaryDocument.add(summaryDocument);
    }
    return this;
  }

  public SummaryDocument getSummaryDocument() {
    return this;
  }

  public ArrayList<Task> addTask(Task task) {
    User user = CatERing.getInstance().getUserManager().getCurrentUser();
    if (user != null) {
      listTasks.add(task);
    }
    return listTasks;
  }

  public void removeTask(Task task) {
    listTasks.remove(task);
  }

  public void add(SummaryDocument summaryDocument) {
    listSummaryDocument.add(summaryDocument);
  }

  public void remove(SummaryDocument summaryDocument) {
    listSummaryDocument.remove(summaryDocument);
  }

  @Override
  public String toString() {
    return "SummaryDocument{" +
            "title='" + title + '\'' +
            ", shiftWork=" + shiftWork +
            ", menu=" + menu +
            ", recipe='" + recipe + '\'' +
            ", advancedPreparation=" + advancedPreparation +
            ", quantityForAdvancedPreparation=" + quantityForAdvancedPreparation +
            ", listSummaryDocument=" + listSummaryDocument +
            ", listTasks=" + listTasks +
            ", isUse=" + isUse +
            ", owner=" + owner +
            '}';
  }
}