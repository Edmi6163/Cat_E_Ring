package catering.businesslogic.summaryDocument;

import catering.businesslogic.CatERing;
import catering.businesslogic.SummaryDocumentException;
import catering.businesslogic.menu.Menu;
import catering.businesslogic.preparation.Preparation;
import catering.businesslogic.preparation.PreparationManager;
import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.shiftWorkKitchen.shiftWorkKitchen;
import catering.businesslogic.task.Task;
import catering.businesslogic.user.User;
import catering.persistence.PersistenceManager;

import java.util.ArrayList;

public class SummaryDocument {

  private String title;
  private ArrayList<shiftWorkKitchen> shiftWork;
  private  Menu menu;
  private Recipe recipe;
  private  ArrayList<Menu>menuList = new ArrayList<>();

  public String getNote() {
    return note;
  }

  private String note;
  private ArrayList<SummaryDocument> listSummaryDocument;
  private boolean isUse;
  private Preparation preparation;
  private ArrayList<Preparation>preparationsList = new ArrayList<>();
  private ArrayList<Recipe>recepiList = new ArrayList<>();
  private User owner;
  private PreparationManager preparationMgr = new PreparationManager();
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  private int id;
  public SummaryDocument(String title,Menu menu, ArrayList<Menu> menuList, Recipe extraRecepi,Preparation preparation) {
    this.title = title;
    this.menu = menu;
    this.recipe = recipe;
    this.listSummaryDocument = new ArrayList<>();
    this.isUse = false;
    this.owner = CatERing.getInstance().getUserManager().getCurrentUser();  // Set the owner to the current user
    this.preparation = preparation;
    this.preparationsList = new ArrayList<>();
    this.recepiList = new ArrayList<>();
    this.menuList = new ArrayList<>();
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

  public ArrayList<Menu> getMenu() {
    return menuList;
  }

  public void setMenu(ArrayList<Menu> menu) {
    this.menuList = menu;
  }

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }



  public ArrayList<SummaryDocument> getListSummaryDocument() {
    return listSummaryDocument;
  }

  public void setListSummaryDocument(ArrayList<SummaryDocument> listSummaryDocument) {
    this.listSummaryDocument = listSummaryDocument;
  }


  public boolean isUsed() {
    return this.isUse;
  }

  public boolean isOwner(User u) {
    return this.owner != null && u != null && u.getId() == this.owner.getId();
  }

  public static SummaryDocument createSummaryDocument(String title) {
    return new SummaryDocument(title, null, null, null, null);
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
      this.recipe = recipe;
      recepiList.add(recipe);
    }

  }

  public SummaryDocument modifyContext(SummaryDocument summaryDocument) {
    this.shiftWork = summaryDocument.shiftWork;
    this.recipe = summaryDocument.recipe;
    return this;
  }

  public void deleteSummaryDocument(SummaryDocument summaryDocument) {
    String delTitle = "DELETE FROM SummaryDocument WHERE title = '" + summaryDocument.getTitle() + "'";
    PersistenceManager.executeUpdate(delTitle);

    // Assuming menu and shiftWork are foreign keys, adjust accordingly
    String delMenu = "DELETE FROM SummaryDocument WHERE id IN (SELECT id FROM SummaryDocument WHERE menu = '" + summaryDocument.getMenu() + "')";
    PersistenceManager.executeUpdate(delMenu);

    String delPreparation = "DELETE FROM SummaryDocument WHERE id IN (SELECT id FROM SummaryDocument WHERE shiftWork = '" + summaryDocument.getShiftWork() + "')";
    PersistenceManager.executeUpdate(delPreparation);

    String delRecipe = "DELETE FROM SummaryDocument WHERE recipe = '" + summaryDocument.getRecipe() + "'";
    PersistenceManager.executeUpdate(delRecipe);
    String delNote = "DELETE FROM SummaryDocument WHERE note = '" + summaryDocument.getNote() + "'";
  }

  public  void saveTitleModifie(SummaryDocument summaryDocument) {
    String updateTitle = "UPDATE SummaryDocument SET title = '" + summaryDocument.getTitle() + "' WHERE title = '" + summaryDocument.getTitle() + "'";
    PersistenceManager.executeUpdate(updateTitle);
  }
  public static void saveCreatedSummaryDocument(SummaryDocument summaryDocument) {
    String insertSummaryDocument = "INSERT INTO SummaryDocument (title, shiftWork, menu, recipe, advancedPreparation, quantityForAdvancedPreparation, listTasks) VALUES ('" + summaryDocument.getTitle() + "', '" + summaryDocument.getShiftWork() + "', '" + summaryDocument.getMenu() + "', '" + summaryDocument.getRecipe() + "')";
    PersistenceManager.executeUpdate(insertSummaryDocument);
  }
  public void removeExtraPreparation(Preparation extraPrep) {
    if(preparationsList.contains(extraPrep)) {
      preparationsList.remove(extraPrep);
    }
  }

public  static void saveSummaryDocuemntNewTitle(SummaryDocument summaryDocument) {
    String updateTitle = "UPDATE SummaryDocument SET title = '" + summaryDocument.getTitle() + "' WHERE title = '" + summaryDocument.getTitle() + "'";
    PersistenceManager.executeUpdate(updateTitle);
  }
  public static void SavecopyDocument(SummaryDocument summaryDocument) {
    String copy = "INSERT INTO SummaryDocument (title, shiftWork, menu, recipe, advancedPreparation, quantityForAdvancedPreparation, listTasks) VALUES ('" + summaryDocument.getTitle() + "', '" + summaryDocument.getShiftWork() + "', '" + summaryDocument.getMenu() + ", " + summaryDocument.getRecipe()  + ")";
    PersistenceManager.executeUpdate(copy);
  }
  public static void SavemoreSummaryDocument(SummaryDocument summaryDocument) {
    String more = "INSERT INTO SummaryDocument (title, shiftWork, menu, recipe, advancedPreparation, quantityForAdvancedPreparation, listTasks) VALUES ('" + summaryDocument.getTitle() + "', '" + summaryDocument.getShiftWork() + ", " + summaryDocument.getMenu() + ", " + summaryDocument.getRecipe() + ")";
    PersistenceManager.executeUpdate(more);
  }
  public static void SavegetSummaryDocument(SummaryDocument summaryDocument) {
    String get = "INSERT INTO SummaryDocument (title, shiftWork, menu, recipe, advancedPreparation, quantityForAdvancedPreparation, listTasks) VALUES ('" + summaryDocument.getTitle() + "', '" + summaryDocument.getShiftWork() + "', '" + summaryDocument.getMenu() + "', '" + summaryDocument.getRecipe()+ ")";
    PersistenceManager.executeUpdate(get);
  }
    public static void SaveaddTask(Task task) {
        String add = "INSERT INTO SummaryDocument (title, shiftWork, menu, recipe, advancedPreparation, quantityForAdvancedPreparation, listTasks) VALUES ('"  + task.getShiftWork() + ","+ task.getAssignedTo()+")" ;
        PersistenceManager.executeUpdate(add);
    }
    public static void SaveremoveTask(Task task) {
        String remove = "DELETE FROM SummaryDocument WHERE task = '" + task.toString()+ "'";
        PersistenceManager.executeUpdate(remove);
    }
  public SummaryDocument copyDocument() {

      SummaryDocument copy = new SummaryDocument(this.title, this.menu, this.menuList, this.recipe, this.preparation);
      copy.owner = this.owner;  // Ensure the owner is copied over
      return copy;

  }

  public SummaryDocument moreSummaryDocument(SummaryDocument summaryDocument){
    if (summaryDocument != null) {
      if (summaryDocument.title != null) {
        this.title = summaryDocument.title;
      }
      this.shiftWork.addAll(summaryDocument.shiftWork);
      this.recipe = summaryDocument.recipe;
      this.menu = summaryDocument.menu;
      listSummaryDocument.add(summaryDocument);
    }
    return this;
  }
public SummaryDocument removeSummaryDocument(SummaryDocument summaryDocument)  {
    if (summaryDocument != null) {
      listSummaryDocument.remove(summaryDocument);
    }
    return this;
  }

  public SummaryDocument deleteNote(String note)  {
    if (note != null) {
      this.note.replace(note, "");
    }
    return this;
  }

  public SummaryDocument getSummaryDocument() {
    return this;
  }




  public void add(SummaryDocument summaryDocument) throws SummaryDocumentException {
    listSummaryDocument.add(summaryDocument);
  }

  public void remove(SummaryDocument summaryDocument)throws SummaryDocumentException {
    listSummaryDocument.remove(summaryDocument);
  }

  @Override
  public String toString() {
    return "SummaryDocument{" +
            "title='" + title + '\'' +
            ", shiftWork=" + shiftWork +
            ", menu=" + menu +
            ", recipe='" + recipe + '\'' +
            ", listSummaryDocument=" + listSummaryDocument +
            ",listPreparation=" + preparationsList +
            ",listRecipe=" + recepiList +
            ", isUse=" + isUse +
            ", owner=" + owner +
            '}';
  }


  public void setUsed(boolean isUse) {
    this.isUse = isUse;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public void deleteExtraRecepi(Recipe extraRecepi) {
    if(recepiList.contains(extraRecepi)) {
      recepiList.remove(extraRecepi);
    }
  }
  public void deleteExtraPreparation(Preparation extraPrep) {
   if(preparationsList.contains(extraPrep)) {
     preparationsList.remove(extraPrep);
   }

  }
  public void deleteExtraMenu(Menu extraMenu) {
    if(menuList.contains(extraMenu)) {
      menuList.remove(extraMenu);
    }
  }


  public  void saveSummaryDocument(SummaryDocument sd)
  {
    String upd = "UPDATE SummaryDocument IS Saved: " + sd.getTitle();
    PersistenceManager.executeUpdate(upd);
  }


  public void addContentToSummaryDocument(Menu mn, Recipe ri, Preparation prep, String note) {

    this.menu = mn;
    this.recepiList.add(ri);
    this.preparationsList.add(prep);
    this.note = note;

  }
}