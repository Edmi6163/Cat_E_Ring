package catering.businesslogic.employer;

import catering.businesslogic.task.Task;

public class Employer {
  private String name;
  private String surname;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getSurname() {
    return surname;
  }
  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Employer(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }


@Override
public String toString() {
    return name + " " + surname;
  }
  
}
