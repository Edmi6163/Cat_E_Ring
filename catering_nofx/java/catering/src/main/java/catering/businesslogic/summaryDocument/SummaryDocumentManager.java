package catering.businesslogic.summaryDocument;

import catering.businesslogic.CatERing;
import catering.businesslogic.SummaryDocumentException;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.billBoard.BillBoard;
import catering.businesslogic.event.Event;
import catering.businesslogic.event.EventInfo;
import catering.businesslogic.menu.Menu;
import catering.businesslogic.preparation.Preparation;
import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.shiftWorkKitchen.shiftWorkKitchen;
import catering.businesslogic.task.Task;
import catering.businesslogic.user.User;

import java.util.ArrayList;

public class SummaryDocumentManager {
    private ArrayList<SummaryDocumentReceiver> receivers = new ArrayList<>();
    private SummaryDocument currentSummaryDocument;

    public void addReceiver(SummaryDocumentReceiver er) {
        receivers.add(er);
    }

    public void removeReceiver(SummaryDocumentReceiver er) {
        receivers.remove(er);
    }



    private void notifyMenuAdded(Menu mn) {
        receivers.forEach(receiver -> receiver.updateMenuAdded(mn));
    }

    private void notifyRecipeAdded(Recipe ri) {
        receivers.forEach(receiver -> receiver.updateRecipeAdded(ri));
    }

    private void notifyTaskAdded(Task t) {
        receivers.forEach(receiver -> receiver.updateTaskAdded(t));
    }

    private void notifySummaryDocumentCreated(SummaryDocument sd) {
        receivers.forEach(receiver -> receiver.updateSummaryDocumentCreated(sd));
    }

    private void notifySummaryDocumentDeleted(SummaryDocument sd) {
        receivers.forEach(receiver -> receiver.updateSummaryDocumentDeleted(sd));
    }


    private void notifySummaryDocumentModifie(SummaryDocument sd) {
        receivers.forEach(receiver -> receiver.updateSummaryDocumentModifie(sd));
    }

    public SummaryDocument createSummaryDocument(String title) throws UseCaseLogicException{
        User user = CatERing.getInstance().getUserManager().getCurrentUser();
        if(!user.isChef()) {
            throw new UseCaseLogicException();
        }
        SummaryDocument sd = new  SummaryDocument(title,null,null, null,null);
        this.setCurrentSummaryDocument(sd);
        this.notifySummaryDocumentCreated(sd);
        return sd;
    }
    public SummaryDocument moreSummaryDocument(String title) throws UseCaseLogicException{
        User user = CatERing.getInstance().getUserManager().getCurrentUser();
        if(!user.isChef()) {
            throw new UseCaseLogicException();
        }
        if(title!=null) {
          return createSummaryDocument(title);

        }
        return createSummaryDocument(" ");
    }
    public void deleteSummaryDocument(SummaryDocument sd)throws UseCaseLogicException ,SummaryDocumentException  {
        User user = CatERing.getInstance().getUserManager().getCurrentUser();
        if(!user.isChef()) {
            throw new UseCaseLogicException();
        }
     if(sd.isUsed() || !sd.isOwner(user)) {
         throw new SummaryDocumentException();
     }

        this.notifySummaryDocumentDeleted(sd);
    }
    public void setCurrentSummaryDocument(SummaryDocument sd) {
        this.currentSummaryDocument = sd;
    }
    public void updateTitle(String newTitle) {
        this.currentSummaryDocument.modifySummaryDocumentTitle(newTitle);
        notifySummaryDocumentModifie(this.currentSummaryDocument);
    }
    public void removeSummaryDocumentMenu( Menu mn) {
        this.currentSummaryDocument.deleteExtraMenu(mn);
        notifySummaryDocumentModifie(this.currentSummaryDocument);
    }
    public void deleteExtraRecipe( Recipe extraRi) {
        this.currentSummaryDocument.deleteExtraRecepi(extraRi);
        notifySummaryDocumentModifie(this.currentSummaryDocument);
    }
    public void deleteNote( String note) {
        this.currentSummaryDocument.deleteNote(note);
        notifySummaryDocumentModifie(this.currentSummaryDocument);
    }
    public void deleteExtraPreparation( Preparation extraPrep) {
        this.currentSummaryDocument.deleteExtraPreparation(extraPrep);
        notifySummaryDocumentModifie(this.currentSummaryDocument);
    }
    public void addContentToSummaryDocument(Menu mn, Recipe ri, Preparation prep, String note) {
        this.currentSummaryDocument.addContentToSummaryDocument(mn, ri, prep, note);
        notifySummaryDocumentModifie(this.currentSummaryDocument);
    }
public SummaryDocument selectSummaryDocumentForModify(SummaryDocument sd) throws UseCaseLogicException,SummaryDocumentException {
    User user = CatERing.getInstance().getUserManager().getCurrentUser();
    if(!user.isChef()) {
        throw new UseCaseLogicException();
    }
    if(sd.isUsed() || !sd.isOwner(user)) {
        throw new SummaryDocumentException();
    }
    return sd;
}
public SummaryDocument orderedSD() throws UseCaseLogicException,SummaryDocumentException {
return currentSummaryDocument;
}
    public SummaryDocument copySummaryDocument(SummaryDocument sd) throws UseCaseLogicException,SummaryDocumentException{
        User user = CatERing.getInstance().getUserManager().getCurrentUser();
        if(!user.isChef()) {
            throw new UseCaseLogicException();
        }
        if(sd.isUsed() || !sd.isOwner(user)) {
            throw new SummaryDocumentException();

        }

        SummaryDocument newSd = sd.copyDocument();
        notifySummaryDocumentCreated(newSd);
        return newSd;
    }

  public void chooseSummaryDocument(SummaryDocument sd)throws UseCaseLogicException ,SummaryDocumentException {
      User user = CatERing.getInstance().getUserManager().getCurrentUser();
      if(!user.isChef()) {
          throw new UseCaseLogicException();
      }
      if(sd.isUsed() || !sd.isOwner(user)) {
          throw new SummaryDocumentException();

      }

        this.currentSummaryDocument = sd;
    }


    public void modifySummaryDocumentContext(SummaryDocument sd) throws UseCaseLogicException ,SummaryDocumentException {
        User user = CatERing.getInstance().getUserManager().getCurrentUser();
        if(!user.isChef()) {
            throw new UseCaseLogicException();
        }
        if(sd.isUsed() || !sd.isOwner(user)) {
            throw new SummaryDocumentException();
        }
        currentSummaryDocument.setTitle(sd.getTitle());
        currentSummaryDocument.setMenu(sd.getMenu());
        currentSummaryDocument.setRecipe(sd.getRecipe());
        currentSummaryDocument.setShiftWork(sd.getShiftWork());

        this.notifySummaryDocumentModifie(sd);
    }

    public SummaryDocument lookUpToSummaryDocument(SummaryDocument sd) throws UseCaseLogicException{
        User user = CatERing.getInstance().getUserManager().getCurrentUser();
        if(!user.isChef()) {
            throw new UseCaseLogicException();
        }
        return  currentSummaryDocument.getSummaryDocument();
    }

    /**
     * NOTE: bill board is a singleton
     */
    public BillBoard getBillBoard() throws UseCaseLogicException{
        User user = CatERing.getInstance().getUserManager().getCurrentUser();
        if(!user.isChef()) {
            throw new UseCaseLogicException();
        }
        return BillBoard.getInstance();
    }

   private void notifyTaskAdded(SummaryDocument sd, Task task) {
        receivers.forEach(receiver -> receiver.updateTask(sd, task));
    }

    public void remove(SummaryDocument sd) {
        this.currentSummaryDocument.removeSummaryDocument(sd);
        this.notifySummaryDocumentDeleted(sd);
    }
}