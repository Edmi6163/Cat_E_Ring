package catering.TestCompitiCucina;

import catering.businesslogic.CatERing;
import catering.businesslogic.billBoard.BillBoard;
import catering.businesslogic.task.Task;

import java.sql.Time;
import java.time.LocalTime;

public class TestCatERing7 {
    public static void main(String[] args) {
        System.out.println("TEST FAKE LOGIN");
        CatERing.getInstance().getUserManager().fakeLogin("Lidia");
        System.out.println("After fake login:");
        System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

        System.out.println("Test get billboard");
        BillBoard bb = CatERing.getInstance().getBillBoardManager();
        System.out.println("Billboard: " + bb.toString());
        bb.addTaskBillBoard(new Task("Lidia", true, "Note", null, null));
        bb.addTaskBillBoard(new Task("Francesco", true, "Note", null, null));
        for (Task task : bb.getTaskList()) {
            System.out.println("TASK ADDED ON BILLBOARD: " + task.toString());
        }

        System.out.println("Billboard got is: " + bb.toString());
    }
}