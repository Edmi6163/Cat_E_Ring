package catering.businesslogic.summaryDocument;
import catering.businesslogic.task.*;
public interface SummaryDocumentEventReceiver {
    void updateSummaryDocumentCreated(SummaryDocument sd);
    void updateSummaryDocumentDeleted(SummaryDocument sd);
    void updateSummaryDocumentModifie(SummaryDocument sd);
    void updateTask(SummaryDocument sd, Task task);
}