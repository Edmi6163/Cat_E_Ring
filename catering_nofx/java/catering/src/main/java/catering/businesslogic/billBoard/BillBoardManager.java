package catering.businesslogic.billBoard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import catering.businesslogic.CatERing;
import catering.businesslogic.UseCaseLogicException;
import catering.businesslogic.shiftWorkKitchen.shiftWorkKitchen;
import catering.businesslogic.summaryDocument.SummaryDocument;
import catering.businesslogic.task.Task;
import catering.businesslogic.user.User;

public class BillBoardManager {
    private static BillBoardManager billBoardManager = null; // this is needed to have the singleton
    private List<BillBoardReceiver> eventReceivers;
    private ArrayList<Task> billBoards;

    public BillBoardManager() {
        eventReceivers = new ArrayList<>();
        billBoards = new ArrayList<>();
    }

    /**
     * here we apply the singleton
     *
     * @return instance of billBoardManager
     */
    public static BillBoardManager getInstance() {
        if (billBoardManager == null) {
            billBoardManager = new BillBoardManager();
        }
        return billBoardManager;
    }

    /**
     *
     * @param task
     * @param name
     * @param surname
     * @param priority
     * @param shiftWork
     * @return the new array list with the last task added
     */
    public ArrayList<Task> add(Task task, String name, String surname, int priority, shiftWorkKitchen shiftWork) {
        BillBoard.BillBoardInit(task, shiftWork, name, surname, null); // Ensure BillBoard class is properly implemented
        BillBoard billBoard = BillBoard.getInstance(); // Ensure BillBoard class has getInstance method
        billBoards.add(task);
        notifyReceivers(task);
        return new ArrayList<>(billBoards);
    }

    private void taskSortedByDifficulty(ArrayList<Task> taskList) throws UseCaseLogicException {
        User user = CatERing.getInstance().getUserManager().getCurrentUser();
        if (!user.isChef()) {
            throw new UseCaseLogicException();
        }
        taskList.sort(Comparator.comparingInt(Task::getDifficulty));
    }

    private void notifyUpdateTask(SummaryDocument sd, Task task) {
        eventReceivers.forEach(receiver -> receiver.updateTask(task)); // Corrected method call
    }

    public ArrayList<Task> getBillBoard() {
        return new ArrayList<>(billBoards);
    }

    public void remove(Task task) {
        billBoards.removeIf(t -> t.equals(task)); // Corrected predicate for comparison
    }

    public void notifyTaskRearranged() {
        // Implementation needed if required
    }

    private void notifyReceivers(Task task) {
        for (BillBoardReceiver receiver : eventReceivers) {
            receiver.notifyTaskRearranged(task);
        }
    }
}