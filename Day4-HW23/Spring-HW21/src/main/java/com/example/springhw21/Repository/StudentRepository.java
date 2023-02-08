package com.example.springhw21.Repository;

import com.example.springhw21.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findStudentById(Integer id);

    Student findStudentByMajor(String major);
    List<Student> findAllByCoursesId(Integer id);


}
