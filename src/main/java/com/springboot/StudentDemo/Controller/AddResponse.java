package com.springboot.StudentDemo.Controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Getter
@Setter
public class AddResponse {
private String msg;
private UUID id;

}
