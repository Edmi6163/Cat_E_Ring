package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.SummaryDocumentException;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.event.EventInfo;
import catering.businesslogic.summaryDocument.SummaryDocument;

public class TestCatERing1d {
  public static void main(String[] args) {
    try {
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
      System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

            EventInfo event = CatERing.getInstance().getEventManager().getEventInfo().get(0);
      SummaryDocument sd = CatERing.getInstance().getSummaryDocumentManager()
          .createSummaryDocument("Foglio1_per_Compleanno");

      System.out.println("Test delete summary document");
       CatERing.getInstance().getSummaryDocumentManager().deleteSummaryDocument(sd);
            System.out.println("Summary Document Deleted: " + sd.toString());

    } catch(UseCaseLogicException | SummaryDocumentException e){
      System.out.println("Errore di logica nello use case: " + e.getMessage());
    }
  }
  
}
