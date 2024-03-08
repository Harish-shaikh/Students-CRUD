package com.students.service;

import java.util.List;
import com.students.playload.StudentsDto;

public interface StudentsService {

	 StudentsDto createStudents(StudentsDto studentsDto);
	 StudentsDto updateStudents(Integer id,StudentsDto studentsDto);
	  void deleteStudents(Integer id);
	  StudentsDto getStudents(Integer id);
		List<StudentsDto> getStudents();

	
}
