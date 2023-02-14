package com.fadi.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.fadi.sms.entity.Student;

/*
 * this interface make automatic all operation DB (CRUD)
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

}
