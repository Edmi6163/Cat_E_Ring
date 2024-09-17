package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.SummaryDocumentException;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.preparation.*;
import catering.businesslogic.summaryDocument.SummaryDocument;

public class TestCatERing3b {
    public static void main(String[] args) {
        try {
            //remove an extra preparation from a summary document
            System.out.println("TEST FAKE LOGIN");
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println("After fake login:");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

            System.out.println("\nTEST REMOVE EXTRA PREPARATION");
            SummaryDocument sd = CatERing.getInstance().getSummaryDocumentManager().createSummaryDocument("Menu with preparation extra to remove");
            Preparation preparation = new Preparation("Sfumare con il vino");
            CatERing.getInstance().getSummaryDocumentManager().deleteExtraPreparation(preparation);
            System.out.println("EXTRA PREPARATION REMOVED: ");

        } catch (UseCaseLogicException e) {
            e.printStackTrace();
        }

    }
}
