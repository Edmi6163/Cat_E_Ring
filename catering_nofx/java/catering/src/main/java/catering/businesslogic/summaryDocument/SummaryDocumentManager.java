package catering.businesslogic.summaryDocument;

import catering.businesslogic.summaryDocument.*;

import java.util.ArrayList;

public class SummaryDocumentManager {
    private ArrayList<SummaryDocumentEventReceiver> receivers = new ArrayList<>();

    public void addReceiver(SummaryDocumentEventReceiver er) {
        receivers.add(er);
    }

    public void removeReceiver(SummaryDocumentEventReceiver er) {
        receivers.remove(er);
    }

    private void notifyShiftWorkAdded(WorkShift ws) {
        receivers.forEach(receiver -> receiver.updateShiftWorkAdded(ws));
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

    private void notifySummaryDocumentRearranged(SummaryDocument sd) {
        receivers.forEach(receiver -> receiver.updateSummaryDocumentRearranged(sd));
    }

    private void notifySummaryDocumentModifie(SummaryDocument sd) {
        receivers.forEach(receiver -> receiver.updateSummaryDocumentModifie(sd));
    }

    public SummaryDocument createSummaryDocument(String title, Event event) {
        SummaryDocument sd = new  SummaryDocument(title,event, null, null, null, false, null);
        notifySummaryDocumentCreated(sd);
        return sd;
    }

    public void modifieSummaryDocumentTitle(SummaryDocument sd, String newTitle) {
        sd.setTitle(newTitle);
        notifySummaryDocumentModifie(sd);
    }

    public void modifieSummaryDocumentContex(SummaryDocument sd) {
        notifySummaryDocumentModifie(sd);
    }

    public void addItem(SummaryDocument sd, Task task) {
        notifyTaskAdded(task);
    }

    public SummaryDocument copySummaryDocument(SummaryDocument sd) {
        SummaryDocument newSd = sd.copy();
        notifySummaryDocumentCreated(newSd);
        return newSd;
    }

    public void deleteSummaryDocument(SummaryDocument sd) {
        notifySummaryDocumentDeleted(sd);
    }

    /**
     * bill board is a singleton 
     */
    public BillBoard getBillBoard() {
        return BillBoard.getInstance();
    }

    public void add(SummaryDocument sd) {
    }

    public void remove(SummaryDocument sd) {
    }
}