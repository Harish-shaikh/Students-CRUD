package com.students.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.students.entity.Students;

public interface StudentsRepos extends JpaRepository<Students,Integer> {

}
