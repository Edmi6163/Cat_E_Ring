package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.event.EventInfo;
import catering.businesslogic.summaryDocument.SummaryDocument;

/* TEST FOR STEP 1 */
public class TestCatERing1 {
    public static void main(String[] args) {
        try {
            System.out.println("TEST FAKE LOGIN");
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println("After fake login:");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

            System.out.println("\nTEST CREATE SUMMARY DOCUMENT");
            EventInfo event = CatERing.getInstance().getEventManager().getEventInfo().get(0);
            SummaryDocument sd = CatERing.getInstance().getSummaryDocumentManager().createSummaryDocument("FOGLIOTESTO1");
            System.out.println("\nSummary Document Created: " + sd.toString());
            System.out.println("\n"+sd.toString());
        } catch (UseCaseLogicException e) {
            System.out.println("Errore di logica nello use case: " + e.getMessage());
        }
    }
}
