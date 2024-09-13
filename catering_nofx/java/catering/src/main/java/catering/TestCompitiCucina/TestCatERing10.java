package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.event.EventInfo;
import catering.businesslogic.summaryDocument.SummaryDocument;
import catering.businesslogic.summaryDocument.SummaryDocumentManager;

public class TestCatERing10 {
  
  public static void main(String[] args) {
    try {
                  System.out.println("TEST FAKE LOGIN");
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println("After fake login:");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

                  CatERing.getInstance().getUserManager().fakeLogin("Lidia");
      System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());
      System.out.println("\nTest seleziona documento riepoilogativo");
      EventInfo event = CatERing.getInstance().getEventManager().getEventInfo().get(0);
      SummaryDocument sd = CatERing.getInstance().getSummaryDocumentManager()
          .createSummaryDocument("Foglio1_per_Compleanno");
      SummaryDocumentManager sdm = new SummaryDocumentManager();

            System.out.println("Look up summary document");
            sdm.lookUpToSummaryDocument(sd);
            System.out.println("Summary Document Looked Up: " + sd.toString());

    } catch(Exception e){
      System.out.println("Errore di logica nello use case: " + e.getMessage());
    }
  }
}
