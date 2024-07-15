package catering.persistence;

import catering.businesslogic.menu.Menu;
import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.shiftWorkKitchen.shiftWorkKitchen;
import catering.businesslogic.summaryDocument.SummaryDocument;
import catering.businesslogic.summaryDocument.SummaryDocumentReceiver;
import catering.businesslogic.task.Task;

public class SummaryDocumentPersistance implements SummaryDocumentReceiver {
    @Override
    public  void   updateSummaryDocumentCreated(SummaryDocument sd)
    {
        updateSummaryDocumentCreated(sd);
    }
    @Override
    public  void updateSummaryDocumentDeleted(SummaryDocument sd)
    {
        updateSummaryDocumentDeleted(sd);
    }
    @Override
    public  void updateSummaryDocumentModifie(SummaryDocument sd)
    {
        updateSummaryDocumentModifie(sd);
    }
    @Override
    public  void updateTask(SummaryDocument sd, Task task){
    updateTaskAdded(task);
    }
    @Override
    public void updateShiftWorkAdded(shiftWorkKitchen ws){
        updateShiftWorkAdded(ws);
    }
    @Override
    public void updateMenuAdded(Menu mn){
    updateMenuAdded(mn);
    }
    @Override
    public void updateRecipeAdded(Recipe ri){
        updateRecipeAdded(ri);
}
        @Override
     public void updateTaskAdded(Task t){
        updateTaskAdded(t);
        }
    @Override
    public void updateSummaryDocumentRearranged(SummaryDocument sd){
        updateSummaryDocumentRearranged(sd);
    }


}
