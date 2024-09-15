
package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.SummaryDocumentException;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.billBoard.BillBoard;
import catering.businesslogic.employer.Employer;
import catering.businesslogic.event.EventInfo;
import catering.businesslogic.summaryDocument.SummaryDocument;
import catering.businesslogic.task.Task;
import catering.businesslogic.shiftWorkKitchen.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;


public class TestCatRingUc_SuccesSequence{
    public static void main(String[] args) {
        try {
            System.out.println("TEST FAKE LOGIN");
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println("After fake login:");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());
            /* STEP 1 */
            System.out.println("\nTEST CREATE SUMMARY DOCUMENT");
            EventInfo event = CatERing.getInstance().getEventManager().getEventInfo().get(0);
            SummaryDocument sd = CatERing.getInstance().getSummaryDocumentManager().createSummaryDocument("Foglio1_per_Compleanno");
            System.out.println("Summary Document Created: " + sd);
            /* STEP 1a.1 */
            System.out.println("\nTEST CHOOSE SUMMARY DOCUMENT");
            CatERing.getInstance().getSummaryDocumentManager().chooseSummaryDocument(sd);
            System.out.println("Summary Document Selected: " + sd);
            /* STEP 1b.1 */
            System.out.println("\nTEST MODIFY SUMMARY DOCUMENT TITLE");
            CatERing.getInstance().getSummaryDocumentManager().updateTitle( "Foglio1_Scarabocchio");
            System.out.println("Summary Document Title Modified: " + sd.getTitle());
            /* STEP 1c.1 */
            System.out.println("\nTEST COPY SUMMARY DOCUMENT CONTENT");
            SummaryDocument copysd = CatERing.getInstance().getSummaryDocumentManager().copySummaryDocument(sd);
            System.out.println("Summary Document Copied: " + copysd);
            /* STEP 1d.1 */
            System.out.println("\nTEST DELETE SUMMARY DOCUMENT");
            CatERing.getInstance().getSummaryDocumentManager().deleteSummaryDocument(sd);
            System.out.println("Summary Document Deleted");
            /* STEP 2*/
            System.out.println("\nTEST ADD TASK");
            ArrayList<shiftWorkKitchen> shiftWorks = new ArrayList<>();
            ArrayList<Task>listTask = new ArrayList<>();
            shiftWorks.add(new shiftWorkKitchen("Cucina", true, false, false, "2024-12-31", "Spegnere gas"));
            Task task = new Task("Riccardo Oro ", true, 1, shiftWorks.get(0), 1, Time.valueOf(LocalTime.of(1, 0)));
            CatERing.getInstance().getTaskManager().addTask(task);
            System.out.println("Task Added: " + task.toString());
            shiftWorks.add(new shiftWorkKitchen("Cucina Via pincoPallino 81", false, false, false, "2024-12-30", "Mettere preparazioni in frigo"));
            Task task2 = new Task("Filippo Di Angelo", true, 1, shiftWorks.get(0), 1,Time.valueOf(LocalTime.of(1, 0)));
            CatERing.getInstance().getTaskManager().addTask(task2);
            System.out.println("Task Added: " + task2.toString());
            System.out.println("LIST SIZE : " + CatERing.getInstance().getTaskManager().getTask().size());

            /* STEP 3 */
            System.out.println("\nTEST ORDER TASKS BY DIFFICULTY");
            ArrayList<Task> listTaskToOrder = CatERing.getInstance().getTaskManager().getTask();
            ArrayList<Task> orderedByDifficulty = CatERing.getInstance().getTaskManager().orderTaskByDifficulty(listTaskToOrder);
            System.out.println("Tasks Ordered by Difficulty: " + orderedByDifficulty);
            /* STEP 4 */
            System.out.println("\nTEST ORDER TASKS BY PRIORITY");
            ArrayList<Task> orderedByPriority = CatERing.getInstance().getTaskManager().orderTaskByPriority(listTaskToOrder);
            System.out.println("Tasks Ordered by Priority: " + orderedByPriority);
            /* STEP 5 */
            System.out.println("\nTEST ORDER TASKS BY DATE");
            ArrayList<Task> orderedByDate = CatERing.getInstance().getTaskManager().orderTaskByTiming(listTaskToOrder);
            System.out.println("Tasks Ordered by Date: " + orderedByDate);
            /* STEP 6 */
            System.out.println("\nMORE SUMMARY DOCUMENTS ");
            EventInfo event2 = CatERing.getInstance().getEventManager().getEventInfo().get(1);
            SummaryDocument sd2 = CatERing.getInstance().getSummaryDocumentManager().createSummaryDocument("FoglioPerCompleanno_3");
            System.out.println("Summary Document Created: " + sd2.getTitle());
            /* STEP 7 */
            System.out.println("\nGET BILLBOARD");
            BillBoard bb = CatERing.getInstance().getInstance().getBillBoardManager();
            System.out.println("BillBoard: " + bb.toString());
            System.out.println(bb.getName() + " " + bb.getTask() +bb.getShiftWork() + bb.getRecipe() + bb.getSurname() );
            /* STEP 8 */
            System.out.println("\nTEST ASSIGN TASK ");
            Employer pierino = new Employer("Pierino", "Paldo");
            CatERing.getInstance().getTaskManager().assignTask(true, pierino, pierino ,null, task);
            System.out.println("Task Assigned: " + task.getAssignedTo()  + " " + task.getShiftWork());
            /* STEP 9 */



        } catch (UseCaseLogicException e) {
            System.out.println("Errore di logica nello use case: " + e.getMessage());
        } catch (SummaryDocumentException e) {
            System.out.println("Errore nel documento di riepilogo: " + e.getMessage());
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
