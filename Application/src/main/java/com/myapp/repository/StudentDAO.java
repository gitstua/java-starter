package com.myapp.repository;

import org.springframework.stereotype.Repository;

import com.myapp.models.StudentPOJO;

@Repository
public class StudentDAO
{
private static StudentPOJO list = new StudentPOJO();

//In below static block, we are adding three students
static
{
list.getStudentList().add(new StudentPOJO(1, "Tech", "Blog"));
list.getStudentList().add(new StudentPOJO(2, "Rachel", "Green"));
list.getStudentList().add(new StudentPOJO(3, "Chandler", "Bing"));
}

//method to return the student list
public StudentPOJO getAllStudents()
{
return list;
}

//method to add the student in the list
public void addStudent(StudentPOJO student) {
list.getStudentList().add(student);
}
}