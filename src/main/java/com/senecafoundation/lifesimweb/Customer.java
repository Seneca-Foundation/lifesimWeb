package com.senecafoundation.lifesimweb;

import org.springframework.data.annotation.Id;

public class Customer {

  @Id
  public String id;

  private String firstName;
  private String lastName;

  public Customer() {}

  public Customer(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public void setFirstName(String firstName) {
      this.firstName = firstName;
  }

  public String getFirstName() {
      return firstName;
  }

  public void setLastName(String lastName) {
      this.lastName = lastName;
  }

  public String getLastName() {
      return lastName;
  }

  @Override
  public String toString() {
    return String.format(
        "Customer[id=%s, firstName='%s', lastName='%s']",
        id, firstName, lastName);
  }

}