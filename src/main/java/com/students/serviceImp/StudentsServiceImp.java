package com.students.serviceImp;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.students.entity.Students;
import com.students.exception.ResourceNotFoundException;
import com.students.playload.StudentsDto;
import com.students.repositries.StudentsRepos;
import com.students.service.StudentsService;

@Service
public class StudentsServiceImp implements StudentsService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private StudentsRepos studentsRepos;

	@Override
	public StudentsDto createStudents(StudentsDto studentsDto) {
		Students student=this.modelMapper.map(studentsDto,Students.class);
		Students saveStudent=this.studentsRepos.save(student);
		return this.modelMapper.map(saveStudent, StudentsDto.class);
		
	}

	@Override
	public StudentsDto updateStudents(Integer id, StudentsDto studentsDto) {
         Students student=this.studentsRepos.findById(id).orElseThrow(()-> new ResourceNotFoundException("students", "studentsId", id));
         student.setName(studentsDto.getName());
         student.setAddress(studentsDto.getAddress());
         student.setStd(studentsDto.getStd());
         student.setRollNo(studentsDto.getRollNo());
         student.setMobile(studentsDto.getMobile());
         
         Students updatestudents=this.studentsRepos.save(student);
         return this.modelMapper.map(updatestudents,StudentsDto.class);     

	}

	@Override
	public void deleteStudents(Integer id) {
		 Students student=this.studentsRepos.findById(id).orElseThrow(()-> new ResourceNotFoundException("students", "studentsId", id));
		 this.studentsRepos.delete(student);
		
	}

	@Override
	public StudentsDto getStudents(Integer id) {

		 Students student=this.studentsRepos.findById(id).orElseThrow(()-> new ResourceNotFoundException("students", "studentsId", id));
		 return this.modelMapper.map(student, StudentsDto.class);
	}

	@Override
	public List<StudentsDto> getStudents() {
List<Students> getStudents=this.studentsRepos.findAll();
List<StudentsDto> studentsDto=getStudents.stream().map(student->this.modelMapper.map(student, StudentsDto.class)).collect(Collectors.toList());
return studentsDto;


	}

}
