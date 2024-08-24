package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.event.EventInfo;
import catering.businesslogic.summaryDocument.SummaryDocument;

public class TestCatERing1c {
 public static void main(String[] args) {
  try {
           CatERing.getInstance().getUserManager().fakeLogin("Lidia");
      System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

           EventInfo event = CatERing.getInstance().getEventManager().getEventInfo().get(0);
      SummaryDocument sd = CatERing.getInstance().getSummaryDocumentManager()
          .createSummaryDocument("Foglio1_per_Compleanno", event); 
        System.out.println("SD1 : "+sd.toString());
      System.out.println("Test copy summary document");
      SummaryDocument sd2 = CatERing.getInstance().getSummaryDocumentManager().copySummaryDocument(sd);
      System.out.println("Summary Document Copied sd2: " + sd2.toString());
  } catch (Exception e){
    System.out.println("Errore di logica nello use case: " + e.getMessage());
  }
 } 
}
