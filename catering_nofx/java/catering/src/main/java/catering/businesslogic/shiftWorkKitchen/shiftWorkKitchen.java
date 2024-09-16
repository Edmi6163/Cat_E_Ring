package catering.businesslogic.shiftWorkKitchen;

import catering.businesslogic.task.Task;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class shiftWorkKitchen {

  public String location;
  public Boolean recurrent;
  public Boolean emergency = false;
  public Boolean availability;
  public String expirationAvailability;
  public String note;


  public shiftWorkKitchen(String location, Boolean recurrent, Boolean emergency, Boolean availability, String expirationAvailability, String note) {
    this.location = location;
    this.recurrent = recurrent;
    this.emergency = emergency;
    this.availability = availability;
    this.expirationAvailability = expirationAvailability;
    this.note = note;
  }



  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Boolean getRecurrent() {
    return recurrent;
  }

  public void setRecurrent(Boolean recurrent) {
    this.recurrent = recurrent;
  }

  public Boolean getEmergency() {
    return emergency;
  }

  public void setEmergency(Boolean emergency) {
    this.emergency = emergency;
  }

  public Boolean getAvailability() {
    return availability;
  }

  public void setAvailability(Boolean availability) {
    this.availability = availability;
  }

  public String getExpirationAvailability() {
    return expirationAvailability;
  }

  public void setExpirationAvailability(String expirationAvailability) {
    this.expirationAvailability = expirationAvailability;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
  public shiftWorkKitchen getShiftWork() {
    return this;
  }

 }

