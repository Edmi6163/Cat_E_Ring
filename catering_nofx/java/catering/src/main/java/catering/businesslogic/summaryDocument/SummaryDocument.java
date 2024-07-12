package catering.businesslogic.summaryDocument;

import java.util.ArrayList;

public class SummaryDocument {
  
  public String title; 
  public String shiftWork;
  public String menu;
  public String recipe;
  public boolean advancedPreparation;
  public Integer quantityForAdvancedPreparation;
  public ArrayList<SummaryDocument> listSummaryDocument;

  public SummaryDocument(String title, String shiftWork, String menu, String recipe, boolean advancedPreparation, Integer quantityForAdvancedPreparation) {
    this.title = title;
    this.shiftWork = shiftWork;
    this.menu = menu;
    this.recipe = recipe;
    this.advancedPreparation = advancedPreparation;
    this.quantityForAdvancedPreparation = quantityForAdvancedPreparation;
    this.listSummaryDocument = new ArrayList<>();
  }

  public static SummaryDocument createSummaryDocument(String title) {
    return new SummaryDocument(title, null, null, null, false, null);
  }

  public void modifieSummaryDocumentTitle(String newTitle) {
    this.title = newTitle;
  }

  public void addContext(WorkShift workshift, Recipe recipe, Task task) {
    if (workshift != null) {
      this.shiftWork = workshift.toString(); 
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
    return new SummaryDocument(this.title, this.shiftWork, this.menu, this.recipe, this.advancedPreparation, this.quantityForAdvancedPreparation);
  }

  public void moreSummaryDocument() {
  }

  public SummaryDocument getSummaryDocument() {
    return this;
  }

  public void addTask(Task task) {
  }

  public void assignTaskTo() {
  }

  public void add(SummaryDocument summaryDocument) {
    listSummaryDocument.add(summaryDocument);
  }

  public void remove(SummaryDocument summaryDocument) {
    listSummaryDocument.remove(summaryDocument);
  }
}