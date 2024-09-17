package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.event.EventInfo;
import catering.businesslogic.summaryDocument.SummaryDocument;

public class TestCatEring1b {
  public static void main(String[] args) {
  try { 
       CatERing.getInstance().getUserManager().fakeLogin("Lidia");
      System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

      System.out.println("\nTest modify summary document title");
      EventInfo event = CatERing.getInstance().getEventManager().getEventInfo().get(0);
      SummaryDocument sd = CatERing.getInstance().getSummaryDocumentManager()
          .createSummaryDocument("Foglio1_per_Compleanno");
     CatERing.getInstance().getSummaryDocumentManager().updateTitle( "Foglio1_Scarabocchio");
            System.out.println("Summary Document Title Modified: " + sd.getTitle());

  } catch (Exception e) {
    System.out.println("Logic error in use case: " + e.getMessage());
  }
      
}
}
