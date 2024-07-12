import businesslogic.task.*;
public interface SummaryDocumentReceiver {
	void updateSummaryDocumentCreated(SummaryDocument sd);
	void updateSummaryDocumentDeleted(SummaryDocument sd);
	void updateSummaryDocumentModified(SummaryDocument sd);
	void updateTask(SummaryDocument sd, Task task);
}