package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.summaryDocument.SummaryDocument;
import catering.businesslogic.summaryDocument.SummaryDocumentManager;

public class TestCatERing3d {
    public static void main(String[] args) {
        try {
            //remove a note from a summary document
            System.out.println("TEST FAKE LOGIN");
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println("After fake login:");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

            SummaryDocument sd = CatERing.getInstance().getSummaryDocumentManager().createSummaryDocument("Menu");
            System.out.println("Summary Document Created: " + sd);
            CatERing.getInstance().getSummaryDocumentManager().deleteNote("Note to remove");
            System.out.println("Note removed: " + sd);
            System.out.println("DELETED NOTE IN SUMMARY DOCUMENT: ");




        } catch (UseCaseLogicException e) {
            e.printStackTrace();
        }
    }
}
