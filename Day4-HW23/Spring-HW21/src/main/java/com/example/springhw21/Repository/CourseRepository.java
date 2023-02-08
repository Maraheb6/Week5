package com.example.springhw21.Repository;

import com.example.springhw21.Model.Course;
import com.example.springhw21.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    Course findCourseById(Integer id);
    Course findTeacherIdById(Integer id);

    Course findCourseByStudentsId(Integer id);



}
