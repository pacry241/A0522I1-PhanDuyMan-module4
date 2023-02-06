package com.codegym.demo.repository;

import com.codegym.demo.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IClassroomRepository extends JpaRepository<Classroom, Integer> {
}
