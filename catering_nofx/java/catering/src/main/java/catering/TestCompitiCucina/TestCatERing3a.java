package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.summaryDocument.SummaryDocument;


public class TestCatERing3a {
    public static void main(String[] args) {
        try {
        //remove extra recipe from a summary document
        System.out.println("TEST FAKE LOGIN");
        CatERing.getInstance().getUserManager().fakeLogin("Lidia");
        System.out.println("After fake login:");
        System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

        System.out.println("\nTEST REMOVE EXTRA RECIPE");
        SummaryDocument sd = CatERing.getInstance().getSummaryDocumentManager().createSummaryDocument("Menu with recipe extra to remove");
        Recipe recipeToRemove = new Recipe("Paccheri");
        sd.deleteExtraRecepi(recipeToRemove);
            System.out.println("EXTRA RECIPE REMOVED ");

    } catch(UseCaseLogicException e){
            e.printStackTrace();

        }
    }
}
