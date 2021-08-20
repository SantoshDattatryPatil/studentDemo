package com.springboot.StudentDemo.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
@AllArgsConstructor
@Setter
@Getter
public class ErrorDetails {
    private Date timestamp;
    private String ErrorMessage;
    private String Details;


}
