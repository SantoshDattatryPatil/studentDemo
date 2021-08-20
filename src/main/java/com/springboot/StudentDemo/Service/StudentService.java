package com.springboot.StudentDemo.Service;

import com.springboot.StudentDemo.Controller.AddResponse;
import com.springboot.StudentDemo.Entity.Address;
import com.springboot.StudentDemo.Entity.Student;
import com.springboot.StudentDemo.Exception.StudentNotFoundException;
import com.springboot.StudentDemo.Repository.AddressRepository;
import com.springboot.StudentDemo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class StudentService {
@Autowired
StudentRepository studentRepository;
@Autowired
    AddressRepository addressRepository;
@Autowired
    AddResponse addResponse;
 @Transactional
public AddResponse UpdateStudent(UUID id,Student student){
    Student student1= studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found in this  id"));
    Address address=addressRepository.findById(student1.getAddress().getId()).get();
    student1.setFirstname(student.getFirstname());
    student1.setLastname(student.getLastname());
    student1.setEmail(student.getEmail());
    student1.setMobile(student.getMobile());
    address.setBuilding(student.getAddress().getBuilding());
    address.setCity(student.getAddress().getCity());
    address.setCountry(student.getAddress().getCountry());
    address.setState(student.getAddress().getState());
    address.setStreet(student.getAddress().getStreet());
    address.setZipcode(student.getAddress().getZipcode());
    addressRepository.save(address);
    studentRepository.save(student1);
addResponse.setMsg("Record Update Successfully");
addResponse.setId(student1.getId());
return addResponse;
}
}
