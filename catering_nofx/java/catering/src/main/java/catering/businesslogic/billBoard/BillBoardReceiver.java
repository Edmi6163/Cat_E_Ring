package catering.businesslogic.billBoard;

import catering.businesslogic.task.*;

public interface BillBoardReceiver {
  void notifyTaskRearranged(Task task);
  void updateTask(Task task);
}
