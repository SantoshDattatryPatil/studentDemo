package com.springboot.StudentDemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private UUID id;
@NotEmpty(message = "first name does not empty")
    private String firstname;
    @NotEmpty(message = "Last name does not empty")
    private String lastname;
    @Email
    @Column(unique=true)
    private String email;
    @Column(unique=true)
    @Size(min=10,max = 10)
    private String mobile;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


}
