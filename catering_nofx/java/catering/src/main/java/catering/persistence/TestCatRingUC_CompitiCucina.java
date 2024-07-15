
    package catering;

import catering.businesslogic.CatERing;
import catering.businesslogic.SummaryDocumentException;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.event.EventInfo;
import catering.businesslogic.summaryDocument.SummaryDocument;
import catering.businesslogic.task.Task;
import catering.businesslogic.shiftWorkKitchen.*;

import java.sql.Date;
import java.util.ArrayList;


public class TestCatRingUC_CompitiCucina {
        public static void main(String[] args) {
            try {
                System.out.println("TEST FAKE LOGIN");
                CatERing.getInstance().getUserManager().fakeLogin("Lidia");
                System.out.println("After fake login:");
                System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

                System.out.println("\nTEST CREATE SUMMARY DOCUMENT");
                EventInfo event = CatERing.getInstance().getEventManager().getEventInfo().get(0);
                SummaryDocument sd = CatERing.getInstance().getSummaryDocumentManager().createSummaryDocument("Menu Pinco Pallino", event);
                System.out.println("Summary Document Created: " + sd);

                System.out.println("\nTEST CHOOSE SUMMARY DOCUMENT");
                CatERing.getInstance().getSummaryDocumentManager().chooseSummaryDocument(sd);
                System.out.println("Summary Document Selected: " + sd);

                System.out.println("\nTEST MODIFY SUMMARY DOCUMENT TITLE");
                CatERing.getInstance().getSummaryDocumentManager().modifySummaryDocumentTitle(sd, "Titolo Nuovo");
                System.out.println("Summary Document Title Modified: " + sd.getTitle());

                System.out.println("\nTEST MODIFY SUMMARY DOCUMENT CONTENT");
                SummaryDocument updatedsd = new SummaryDocument("Titolo Aggiornato", sd.getShiftWork(), sd.getMenu(), sd.getRecipe(), sd.isAdvancedPreparation(), sd.getQuantityForAdvancedPreparation(), sd.getListTasks());
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
                shiftWorks.add(new shiftWorkKitchen(new Date(2025-1900, 1, 1), new Date(2025-1900, 1, 2), "CucinaCorsoDuca", null, null));
                Task compito = new Task("Filippo Rossi", true, 1, shiftWorks.get(0), 1);
                CatERing.getInstance().getTaskManager().addTask(compito);
                System.out.println("Task Added: " + compito);
                System.out.println("\nTEST ORDER TASKS BY DIFFICULTY");
                ArrayList<Task> listTaskToOrder = CatERing.getInstance().getTaskManager().getTask();
                ArrayList<Task> orderedByDifficulty = CatERing.getInstance().getTaskManager().orderTaskByDifficulty(listTaskToOrder);
                System.out.println("Tasks Ordered by Difficulty: " + orderedByDifficulty);
                System.out.println("\nTEST ORDER TASKS BY PRIORITY");
                ArrayList<Task> orderedByPriority = CatERing.getInstance().getTaskManager().orderTaskByPriority(listTaskToOrder);
                System.out.println("Tasks Ordered by Priority: " + orderedByPriority);
                System.out.println("\nTEST ORDER TASKS BY TIMING");
                ArrayList<Task> orderedByTiming = CatERing.getInstance().getTaskManager().orderTaskByTiming(listTaskToOrder);
                System.out.println("Tasks Ordered by Timing: " + orderedByTiming);
                System.out.println("\nTEST CREATE MORE SUMMARY DOCUMENTS");
                EventInfo event2 = CatERing.getInstance().getEventManager().getEventInfo().get(1);
                SummaryDocument sd2 = CatERing.getInstance().getSummaryDocumentManager().createSummaryDocument("FOGLIO  Pinco Pallino", event2);
                System.out.println("Summary Document Created: " + sd2);
                System.out.println("\nTEST CREATE MORE SUMMARY DOCUMENTS");
                EventInfo event3 = CatERing.getInstance().getEventManager().getEventInfo().get(2);
                SummaryDocument sd5 = CatERing.getInstance().getSummaryDocumentManager().createSummaryDocument("FOGLIO ZEB89_EVENT_ACEGAMER", event2);
                System.out.println("Summary Document Created: " + sd5); System.out.println("\nTEST CREATE MORE SUMMARY DOCUMENTS");
                EventInfo event5 = CatERing.getInstance().getEventManager().getEventInfo().get(1);
                SummaryDocument sd6 = CatERing.getInstance().getSummaryDocumentManager().createSummaryDocument("FOGLIO_EVENTO_VEGANO", event2);
                System.out.println("Summary Document Created: " + sd6);
                System.out.println("\nTEST DELETE SUMMARY DOCUMENT");
                CatERing.getInstance().getSummaryDocumentManager().deleteSummaryDocument(sd2);
                System.out.println("Summary Document Deleted");
                System.out.println("\nTEST DELETE SUMMARY DOCUMENT");
                CatERing.getInstance().getSummaryDocumentManager().deleteSummaryDocument(sd5);
                System.out.println("Summary Document Deleted");
                System.out.println("\nTEST ADD TASK");
                ArrayList<shiftWorkKitchen> shiftWorks2 = new ArrayList<>();
                shiftWorks2.add(new shiftWorkKitchen(new Date(2025-1900, 1, 1), new Date(2025-1900, 1, 2), "CucinaCorsoDuca", null, null));
                Task compito2 = new Task("Filippo Rossi", true, 1, shiftWorks2.get(0), 1);
                CatERing.getInstance().getTaskManager().addTask(compito2);
                System.out.println("Task Added: " + compito2);
                System.out.println("\nTEST ADD TASK");
                ArrayList<shiftWorkKitchen> shiftWorks3 = new ArrayList<>();
                shiftWorks3.add(new shiftWorkKitchen(new Date(2025-1900, 1, 1), new Date(2025-1900, 1, 2), "CucinaCorsoDuca", null, null));
                Task compito3 = new Task("Filippo Rossi", true, 1, shiftWorks3.get(0), 1);
                CatERing.getInstance().getTaskManager().addTask(compito3);
                System.out.println("Task Added: " + compito3);
                System.out.println("\nTEST MODIFY SUMMARY DOCUMENT TITLE");
                CatERing.getInstance().getSummaryDocumentManager().modifySummaryDocumentTitle(sd6, "TEST_TITOLO_FIERO");
                System.out.println("Summary Document Title Modified: " + sd6.getTitle());



            } catch (UseCaseLogicException e) {
                System.out.println("Errore di logica nello use case: " + e.getMessage());
            } catch (SummaryDocumentException e) {
                System.out.println("Errore nel documento di riepilogo: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
