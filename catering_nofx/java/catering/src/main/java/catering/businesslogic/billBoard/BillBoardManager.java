package catering.businesslogic.billBoard;

import java.util.ArrayList;
import java.util.List;

import catering.businesslogic.shiftWork.ShiftWork;
import catering.businesslogic.task.Task;

public class BillBoardManager {
 private static BillBoardManager billBoardManager = null; //this is needed to have the singleton 
 private List<BillBoardReceiver> eventReceivers;
 private List<BillBoard> billBoards;

 public BillBoardManager(){
  eventReceivers = new ArrayList<>();
  billBoards = new ArrayList<>();
 }

 /**
  * here we apply the singleton 
  * @return instance of billBoardManager 
  */
public static BillBoardManager getInstance(){
  if(billBoardManager == null){
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
 * @param shitWork
 * @return the new aray list with the last task added
 */ 
public ArrayList<BillBoard> add(Task task, String name, String surname,int priority,ShiftWork shiftWork){
  BillBoard.BillBoardInit(task, shiftWork,name,surname,null);
  BillBoard billBoard = BillBoard.getInstance();
  billBoards.add(task);
  notifyReceivers(task);
  return new ArrayList<>(billBoards); 
}

public ArrayList<BillBoard> getBillBoard(){
  return new ArrayList<>(billBoards);
} 

public void remove(Task task){
  billBoards.removeIf(t->t.getTask().equals(task)); // directly from ArrayList javadoc:  	removeIf(Predicate<? super E> filter) Removes all of the elements of this collection that satisfy the given predicate
}

private void notifyReceivers(Task task){
  for(BillBoardReceiver receiver : eventReceivers){
    receiver.notifyTaskRearranged(task);
  }
}

}
