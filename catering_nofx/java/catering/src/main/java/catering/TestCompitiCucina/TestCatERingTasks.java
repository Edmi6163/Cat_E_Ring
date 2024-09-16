package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.SummaryDocumentException;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.event.EventInfo;
import catering.businesslogic.preparation.Preparation;
import catering.businesslogic.summaryDocument.SummaryDocument;
import catering.businesslogic.task.Task;
import catering.businesslogic.shiftWorkKitchen.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

public class TestCatERingTasks {
    public static void main(String[] args) {
        try {
            ArrayList<Task>listTask = new ArrayList<>();
            System.out.println("TEST FAKE LOGIN");
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println("After fake login:");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

            System.out.println("\nTEST CREATE SUMMARY DOCUMENT");
            EventInfo event = CatERing.getInstance().getEventManager().getEventInfo().get(0);
            SummaryDocument sd = CatERing.getInstance().getSummaryDocumentManager().createSummaryDocument("Menu Pinco Pallino");
            System.out.println("Summary Document Created: " + sd);

            System.out.println("\nTEST CHOOSE SUMMARY DOCUMENT");
            CatERing.getInstance().getSummaryDocumentManager().chooseSummaryDocument(sd);
            System.out.println("Summary Document Selected: " + sd);

            System.out.println("\nTEST MODIFY SUMMARY DOCUMENT TITLE");
            CatERing.getInstance().getSummaryDocumentManager().updateTitle("Titolo Nuovo");
            System.out.println("Summary Document Title Modified: " + sd.getTitle());

            System.out.println("\nTEST MODIFY SUMMARY DOCUMENT CONTENT");
           Preparation pre = new Preparation("Cipolle a pezzi ");
            CatERing.getInstance().getSummaryDocumentManager().updateTitle("Si va a lettooo");

            CatERing.getInstance().getSummaryDocumentManager().modifySummaryDocumentContext(sd);
            System.out.println("Summary Document Content Modified: " + sd);

            System.out.println("\nTEST COPY SUMMARY DOCUMENT");
            SummaryDocument copysd = CatERing.getInstance().getSummaryDocumentManager().copySummaryDocument(sd);
            System.out.println("Summary Document Copied: " + copysd);

            System.out.println("\nTEST DELETE SUMMARY DOCUMENT");
            CatERing.getInstance().getSummaryDocumentManager().deleteSummaryDocument(sd);
            System.out.println("Summary Document Deleted");

            System.out.println("\nTEST ADD TASK");
            ArrayList<shiftWorkKitchen> shiftWorks = new ArrayList<>();
            shiftWorks.add(new shiftWorkKitchen("Cucina", true, false, true, "2021-12-31", "Note"));
            Task compito = new Task("Lidia", true, "Note",shiftWorks.get(0), listTask);
            CatERing.getInstance().getTaskManager().addTask(compito);
            System.out.println("Task Added: " + compito);


        } catch (UseCaseLogicException e) {
            System.out.println("Errore di logica nello use case: " + e.getMessage());
        } catch (SummaryDocumentException e) {
            System.out.println("Errore nel documento di riepilogo: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}