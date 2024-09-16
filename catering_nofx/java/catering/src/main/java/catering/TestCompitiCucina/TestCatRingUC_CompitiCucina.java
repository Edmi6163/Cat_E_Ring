
    package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.SummaryDocumentException;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.event.EventInfo;
import catering.businesslogic.menu.Menu;
import catering.businesslogic.summaryDocument.SummaryDocument;
import catering.businesslogic.task.Task;
import catering.businesslogic.shiftWorkKitchen.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;


public class TestCatRingUC_CompitiCucina {
        public static void main(String[] args) {
            try {
                System.out.println("TEST FAKE LOGIN");
                CatERing.getInstance().getUserManager().fakeLogin("Lidia");
                System.out.println("After fake login:");
                System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

                System.out.println("\nTEST CREATE SUMMARY DOCUMENT");
                EventInfo event = CatERing.getInstance().getEventManager().getEventInfo().get(0);
                SummaryDocument sd = CatERing.getInstance().getSummaryDocumentManager().createSummaryDocument( "Pinco Pallino");
                System.out.println("Summary Document Created: " + sd.toString());

                System.out.println("\nTEST CHOOSE SUMMARY DOCUMENT");
                CatERing.getInstance().getSummaryDocumentManager().chooseSummaryDocument(sd);
                System.out.println("Summary Document Selected: " + sd.toString());

                System.out.println("\nTEST MODIFY SUMMARY DOCUMENT TITLE");
                CatERing.getInstance().getSummaryDocumentManager().updateTitle("Matrimonio");
                System.out.println("Summary Document Title Modified: " + sd.getTitle());

                System.out.println("\nTEST MODIFY SUMMARY DOCUMENT CONTENT");
                Menu menu = new Menu(CatERing.getInstance().getUserManager().getCurrentUser(),"Menu matrimonio", new String[]{"Primi", "Secondi", "Ammazzacaffe"});

                SummaryDocument updatedSd = new SummaryDocument("Menu divorzio",menu ,null, null,null);
                CatERing.getInstance().getSummaryDocumentManager().modifySummaryDocumentContext(updatedSd);
                System.out.println("Summary Document Content Modified: " + sd.toString());

                System.out.println("\nTEST COPY SUMMARY DOCUMENT");
                SummaryDocument copysd = CatERing.getInstance().getSummaryDocumentManager().copySummaryDocument(sd);
                System.out.println("Summary Document Copied: " + copysd.getTitle() + " " + copysd.getSummaryDocument() + " " + copysd.getMenu() + "\n");

                System.out.println("\nTEST DELETE SUMMARY DOCUMENT");
                CatERing.getInstance().getSummaryDocumentManager().deleteSummaryDocument(sd);
                System.out.println("Summary Document Deleted");



            } catch (UseCaseLogicException e) {
                System.out.println("Error USE CASE LOGIC :  " + e.getMessage());
            } catch (SummaryDocumentException e) {
                System.out.println("Error summaryDOCUMENT: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    