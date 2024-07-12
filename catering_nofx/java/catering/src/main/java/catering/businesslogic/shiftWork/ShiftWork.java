package catering.businesslogic.shiftWork;

import java.util.Date;

public class ShiftWork {
  public Date startingDate; 
  public Date endingDate;
  public String location;
  public Date lowerBoundInitShift; 
  public Date upperBoundInitShift; 

  public ShiftWork(Date startingDate, Date endingDate, String location, Date lowerBoundInitShift, Date upperBoundInitShift) {
    this.startingDate = startingDate;
    this.endingDate = endingDate;
    this.location = location;
    this.lowerBoundInitShift = lowerBoundInitShift;
    this.upperBoundInitShift = upperBoundInitShift;
  }
}
