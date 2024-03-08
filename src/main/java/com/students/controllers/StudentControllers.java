package com.students.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.students.playload.StudentsDto;
import com.students.service.StudentsService;

@RestController
@RequestMapping("/api")
public class StudentControllers {
	@Autowired
	private StudentsService studentsService;
	
	
	//post method
	@PostMapping("/")
	public ResponseEntity<StudentsDto> createStudents(@RequestBody StudentsDto studentsDto){
		StudentsDto saveStudents=this.studentsService.createStudents(studentsDto);
		return new ResponseEntity<StudentsDto>(saveStudents,HttpStatus.CREATED);
	}
	
	//update method
	@PutMapping("/update/{studentId}")
	public ResponseEntity<StudentsDto> updateStudents(@PathVariable("studentId") Integer studentId,@RequestBody StudentsDto studentsDto){
	
  StudentsDto updateStudent=this.studentsService.updateStudents(studentId, studentsDto);
  return new ResponseEntity<StudentsDto>(updateStudent,HttpStatus.OK);
	}
	
	//delete method
	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<StudentsDto> deleteStudents(@PathVariable("studentId") Integer studentId){
		this.studentsService.deleteStudents(studentId);
		return new ResponseEntity<StudentsDto>(HttpStatus.ACCEPTED);
		
	}
	
	//get method
	@GetMapping("/getstudent/{studentId}")
	public ResponseEntity<StudentsDto> getStudents(@PathVariable("studentId") Integer studentId,@RequestBody StudentsDto studentsDto){
		 StudentsDto getStudents=this.studentsService.getStudents(studentId);
		 return new ResponseEntity<StudentsDto>(getStudents,HttpStatus.OK);
	}
	//get method
  
	@GetMapping("/getallstudent")
	public ResponseEntity<List<StudentsDto>> getAllStudent(){
		return ResponseEntity.ok(this.studentsService.getStudents());
	}

}
