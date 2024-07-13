package catering.businesslogic.shiftWork;

import java.sql.Date;
import java.sql.Time;

public class ShiftWork {
  public Date startingDate; 
  public Date endingDate;
  public String location;
  public Time lowerBoundInitShift; 
  public Time upperBoundInitShift; 

  public ShiftWork(Date startingDate, Date endingDate, String location, Time lowerBoundInitShift, Time upperBoundInitShift) {
    this.startingDate = startingDate;
    this.endingDate = endingDate;
    this.location = location;
    this.lowerBoundInitShift = lowerBoundInitShift;
    this.upperBoundInitShift = upperBoundInitShift;
  }
}
