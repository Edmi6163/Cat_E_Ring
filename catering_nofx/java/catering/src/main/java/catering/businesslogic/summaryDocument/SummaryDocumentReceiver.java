public interface SummaryDocumentReceiver {
    void updateSummaryDocumentCreated(SummaryDocument sd);
    void updateSummaryDocumentDeleted(SummaryDocument sd);
    void updateSummaryDocumentModifie(SummaryDocument sd);
    void updateTask(SummaryDocument sd, Task task);
}