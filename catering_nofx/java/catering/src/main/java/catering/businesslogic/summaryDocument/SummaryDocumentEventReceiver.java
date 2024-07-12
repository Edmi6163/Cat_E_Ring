package catering.businesslogic.summaryDocument;
import catering.businesslogic.menu.Menu;
import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.shiftWork.ShiftWork;
import catering.businesslogic.task.*;
public interface SummaryDocumentEventReceiver {
    void updateSummaryDocumentCreated(SummaryDocument sd);
    void updateSummaryDocumentDeleted(SummaryDocument sd);
    void updateSummaryDocumentModifie(SummaryDocument sd);
    void updateTask(SummaryDocument sd, Task task);

    void updateShiftWorkAdded(ShiftWork ws);

    void updateMenuAdded(Menu mn);

    void updateRecipeAdded(Recipe ri);

    void updateTaskAdded(Task t);

    void updateSummaryDocumentRearranged(SummaryDocument sd);
}