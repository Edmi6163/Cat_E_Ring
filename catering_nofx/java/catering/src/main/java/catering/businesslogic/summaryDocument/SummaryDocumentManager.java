package catering.businesslogic.summaryDocument;

import catering.businesslogic.CatERing;
import catering.businesslogic.SummaryDocumentException;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.billBoard.BillBoard;
import catering.businesslogic.event.Event;
import catering.businesslogic.event.EventInfo;
import catering.businesslogic.menu.Menu;
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
        SummaryDocument sd = new  SummaryDocument(title, new ArrayList<>(), null, null);
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
    public void modifySummaryDocumentTitle(SummaryDocument sd, String newTitle) {
        sd.modifySummaryDocumentTitle(newTitle);
        notifySummaryDocumentModifie(sd);
    }
    public void removeSummaryDocumentMenu(SummaryDocument sd, Menu mn) {
        sd.removeSummaryDoumentMenù(mn);
        notifySummaryDocumentModifie(sd);
    }
    public void removeSummaryDocumentRecipe(SummaryDocument sd, Recipe extraRi) {
        sd.removeSummaryDocumentRecepi(extraRi);
        notifySummaryDocumentModifie(sd);
    }
    public void removeSummaryDocumentNote(SummaryDocument sd, String note) {
        sd.removeSummaryDocumentNote(note);
        notifySummaryDocumentModifie(sd);
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
    }
}