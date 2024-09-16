package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.menu.Menu;
import catering.businesslogic.summaryDocument.SummaryDocument;

import java.util.ArrayList;

public class TestCatERing3c {
    public static void main(String[] args) {
        try {
            System.out.println("TEST FAKE LOGIN");
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println("After fake login:");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

            ArrayList<Menu> menuToRemove = new ArrayList<>();
            Menu menu = new Menu(CatERing.getInstance().getUserManager().getCurrentUser(),"Menu to remove", new String[]{"Primi", "Secondi", "Ammazzacaffe"});
            menuToRemove.add(menu);
            SummaryDocument sd = CatERing.getInstance().getSummaryDocumentManager().createSummaryDocument("Menu");
            sd.setMenu(menuToRemove);
            CatERing.getInstance().getSummaryDocumentManager().removeSummaryDocumentMenu(menu);
            System.out.println("Menu removed: " + sd.getMenu());


        } catch (UseCaseLogicException e) {
            e.printStackTrace();

        }
    }
}
