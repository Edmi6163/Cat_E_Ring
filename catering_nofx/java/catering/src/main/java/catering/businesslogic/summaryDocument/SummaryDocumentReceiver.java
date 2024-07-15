package catering.businesslogic.summaryDocument;
import catering.businesslogic.menu.Menu;
import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.shiftWorkKitchen.shiftWorkKitchen;
import catering.businesslogic.task.*;
public interface SummaryDocumentReceiver {
    public void updateSummaryDocumentCreated(SummaryDocument sd);
    public  void updateSummaryDocumentDeleted(SummaryDocument sd);
    public void updateSummaryDocumentModifie(SummaryDocument sd);
    public void updateTask(SummaryDocument sd, Task task);

    public  void updateShiftWorkAdded(shiftWorkKitchen ws);

    public void updateMenuAdded(Menu mn);

    public  void updateRecipeAdded(Recipe ri);

    public void updateTaskAdded(Task t);

    public void updateSummaryDocumentRearranged(SummaryDocument sd);
}