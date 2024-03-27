package com.example.LabCycle09;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/student")
public class StudentWeb {
	@Autowired
	StudentService ss;
	
	@GetMapping("/get")
	public List<Student> display(){
		return ss.display();
	}
	
	@PostMapping("/post")
	public void insertStudent(@RequestBody Student s) {
		ss.insertStudent(s.getName(),s.getAddress(),s.getUsn(),s.getTotalmarks());
		System.out.println(" inserted successfully");	
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable int id ) {
		ss.remove(id);	
	}
}