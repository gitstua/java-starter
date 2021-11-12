//thanks: https://techblogstation.com/spring-boot/spring-boot-rest-api-with-examples/
package com.myapp.root.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myapp.models.StudentPOJO;
import com.myapp.repository.StudentDAO;



@RestController
@RequestMapping(path = "/")
public class StudentController
{
    @Autowired
    private StudentDAO studentDAO;
    
    //Http Get method to get the student list in JSON format
    @GetMapping(path="/", produces = "application/json")
    public StudentPOJO getStudentList()
    {
        return studentDAO.getAllStudents();
    }
    
    //Http Post method to add the student in the student list
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addStudent(@RequestBody StudentPOJO student)
    {
        Integer id = studentDAO.getAllStudents().getStudentList().size() + 1;
        student.setId(id);
         
        studentDAO.addStudent(student);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(student.getId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
}