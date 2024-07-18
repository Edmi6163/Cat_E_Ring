package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.billBoard.BillBoard;
import catering.businesslogic.task.Task;

public class TestCatERing7 {
 public static void main(String[] args) {
       System.out.println("TEST FAKE LOGIN");
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println("After fake login:");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());


      System.out.println("Test get billboard");
      BillBoard bb = CatERing.getInstance().getBillBoardManager();
      System.out.println("Billboard: " + bb.toString());

      bb.addTaskBillBoard(new Task("Francesco",false, 1, null, 1));
      bb.addTaskBillBoard(new Task("Riccardo",false, 1, null, 1));
      System.out.println("Billboard got is: " + bb.toString());
 } 
}
