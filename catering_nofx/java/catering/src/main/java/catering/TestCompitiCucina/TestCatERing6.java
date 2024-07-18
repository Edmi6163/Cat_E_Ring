package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.event.EventInfo;
import catering.businesslogic.summaryDocument.SummaryDocument;

public class TestCatERing6 {
  public static void main(String[] args) {
    try {
           System.out.println("TEST FAKE LOGIN");
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println("After fake login:");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

            System.out.println("Test more summary document");
                  EventInfo event2 = CatERing.getInstance().getEventManager().getEventInfo().get(1);
            SummaryDocument sd2 = CatERing.getInstance().getSummaryDocumentManager().createSummaryDocument("FoglioPerCompleanno_3", event2);
            System.out.println("Summary document created: " + sd2.toString());
    } catch (Exception e){
      System.out.println("Errore di logica nello use case: " + e.getMessage());{
    }
  }
}
}
