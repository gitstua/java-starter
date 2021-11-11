package com.myapp.models;

import java.util.ArrayList;
import java.util.List;

public class StudentPOJO {
private List<StudentPOJO> studentList;

public StudentPOJO() {}

//Constructor to store data in the instance variables
public StudentPOJO(Integer id, String firstName, String lastName) {
super();
this.id = id;
this.firstName = firstName;
this.lastName = lastName;
}

//Method to retrieve the students
public List<StudentPOJO> getStudentList() {
if (studentList == null) {
studentList = new ArrayList<StudentPOJO>();
}
return studentList;
}

//Method for Addition of student
public void setEmployeeList(List<StudentPOJO> studentList) {
this.studentList = studentList;
}

//Variables
private Integer id;
private String firstName;
private String lastName;

@Override
public String toString() {
return "Student [id=" + id + ", firstName=" + firstName + ",lastName=" + lastName + "]";
}

//Setters and Getters
public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getFirstName() {
return firstName;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}

public String getLastName() {
return lastName;
}

public void setLastName(String lastName) {
this.lastName = lastName;
}

}