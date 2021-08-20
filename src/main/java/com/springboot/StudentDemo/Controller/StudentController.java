package com.springboot.StudentDemo.Controller;

import com.springboot.StudentDemo.Entity.Address;
import com.springboot.StudentDemo.Entity.Student;
import com.springboot.StudentDemo.Exception.StudentNotFoundException;
import com.springboot.StudentDemo.Repository.AddressRepository;
import com.springboot.StudentDemo.Repository.StudentRepository;
import com.springboot.StudentDemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class StudentController {
@Autowired
    StudentRepository studentRepository;
@Autowired
    AddressRepository addressRepository;
@Autowired
    AddResponse addResponse;
@Autowired
    StudentService studentService;



    @GetMapping("/student")
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }
@PostMapping("/student/save")
        public ResponseEntity saveRecord(@Validated @RequestBody Student student){
    Student student1=studentRepository.save(student);
    HttpHeaders headers = new HttpHeaders();

    addResponse.setMsg("Student Added Successfully");
    addResponse.setId(student1.getId());
    return new ResponseEntity<AddResponse>(addResponse, HttpStatus.CREATED);
}

    @PutMapping("/student/{id}")
    public ResponseEntity updateStudent(@PathVariable("id") UUID id,@RequestBody Student student)
    {

        addResponse= studentService.UpdateStudent(id, student);
        return new ResponseEntity<AddResponse>(addResponse,HttpStatus.OK);
    }
    @GetMapping("/student/{id}")
    public Student findById(@PathVariable("id") UUID id)
    {
        Student student= studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found in this  id"));

    return student;
    }
    @DeleteMapping("student/delete/{id}")
    public ResponseEntity DeleteStudent(@PathVariable("id") UUID id){
    try{
studentRepository.deleteById(id);
addResponse.setMsg("Deleted Successfully");

    }catch (Exception e){
        throw new StudentNotFoundException("Record not deleted, Id is not found");
    }
return new ResponseEntity(addResponse,HttpStatus.CREATED);
    }
}


