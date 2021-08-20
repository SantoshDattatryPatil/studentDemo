package com.springboot.StudentDemo.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue
    private Long id;
        private String building;
    private String street;
    private String city;
    private String state;
    private String country;
    private int zipcode;

}
