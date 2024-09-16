
package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.SummaryDocumentException;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.billBoard.BillBoard;
import catering.businesslogic.employer.Employer;
import catering.businesslogic.event.EventInfo;
import catering.businesslogic.menu.Menu;
import catering.businesslogic.preparation.Preparation;
import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.summaryDocument.SummaryDocument;
import catering.businesslogic.task.Task;
import catering.businesslogic.shiftWorkKitchen.*;
import catering.businesslogic.task.TaskManager;

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
            SummaryDocument sd = CatERing.getInstance().getSummaryDocumentManager().createSummaryDocument("Foglio1_per_Compleanno");
            System.out.println("Summary Document Created: " + sd.toString());
            /* STEP 2 */

            System.out.println("\nTEST  UPDATE TITLE");
            CatERing.getInstance().getSummaryDocumentManager().updateTitle("NUOVO FOGLIO PER COMPLEANNO FILIPPO ");
            System.out.println("Title Updated: " + sd.toString());
            /* STEP 3 */
            SummaryDocument sd1 = CatERing.getInstance().getSummaryDocumentManager().createSummaryDocument("Titolo summaryDocument");
            Menu menu1 = CatERing.getInstance().getMenuManager().createMenu("Menu manhattan");
            String notes = "Aggiungere tavoli";
            System.out.println("TEST ADD EXTRAS INFO");
            sd1.addContentToSummaryDocument(menu1, null, null, notes);

            System.out.println("ADDED NEW MENU TITLE AND NOTES TO SUMMARY DOCUMENT MANAGER");
            System.out.println("Summary document manager updated: "  + sd1.getSummaryDocument());




            /* ---- */
            System.out.println("\nTEST ADD ITEM");
            Menu menu = CatERing.getInstance().getMenuManager().getCurrentMenu();
            ArrayList<Recipe>recepi = CatERing.getInstance().getRecipeManager().getRecipes();
            Preparation preparation = new Preparation("Grissini");
            CatERing.getInstance().getSummaryDocumentManager().addContentToSummaryDocument(menu,recepi.get(0),preparation," ");
            System.out.println("Item Added: " + sd.toString());
            /* STEP 5 */
            System.out.println("\nTEST GET RECIPE LIST");
            ArrayList<Recipe> recipes = CatERing.getInstance().getRecipeManager().getRecipes();
            for (Recipe r: recipes) {
                System.out.println(r);
            }
            /* STEP 6 */
            System.out.println("\nTEST GET BILLBOARD");
            BillBoard bb = CatERing.getInstance().getBillBoardManager().getBillBoard();
            System.out.println(bb.toString());
            /* STEP 7 */
            System.out.println("\nTEST ASSIGN TASK");
            ArrayList<Task>listTask = CatERing.getInstance().getTaskManager().getTask();
            shiftWorkKitchen shiftWorks = CatERing.getInstance().getShiftWorkManager().getShiftWork();
            Task task = new Task("Riccardo Oro ", true, null, shiftWorks, listTask);
            Task task2 = new Task("Francesco Mauro", true, "Spegnere la luce ", shiftWorks, listTask);
            ArrayList<Task>taskArrayList =CatERing.getInstance().getTaskManager().getTask();
            CatERing.getInstance().getTaskManager().addTask(task);
            Employer employer = new Employer("RICCARDO","ORO");
            CatERing.getInstance().getTaskManager().assignTask(shiftWorks,employer," ");
            System.out.println("Task Added: " + task.toString());
            /* STEP 8 */
            bb.addTaskAssogmed(task,employer," ");
            /* STEP 9*/
            System.out.println("\nTEST MODIFIY TASK ASSIGNMENT");
            CatERing.getInstance().getTaskManager().modifyAssignTask(shiftWorks,employer," ");
            System.out.println("Task Modified: " + task.toString());




        } catch (UseCaseLogicException e) {
            System.out.println("Errore di logica nello use case: " + e.getMessage());
            /*
        } catch (SummaryDocumentException e) {
            System.out.println("Errore nel documento di riepilogo: " + e.getMessage());
            *./
             */
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
