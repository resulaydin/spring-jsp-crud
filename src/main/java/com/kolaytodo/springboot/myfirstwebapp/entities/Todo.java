package com.kolaytodo.springboot.myfirstwebapp.entities;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
	
	private int id;
	private String username;
	@Size(min=10,message="at least 10 character needed")
	private String description;
	private LocalDate targetDate;
	private boolean done;
	

}
