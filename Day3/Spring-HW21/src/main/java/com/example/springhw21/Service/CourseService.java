package com.example.springhw21.Service;

import com.example.springhw21.ApiException.ApiException;
import com.example.springhw21.Model.Course;
import com.example.springhw21.Model.Teacher;
import com.example.springhw21.Repository.CourseRepository;
import com.example.springhw21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    //Get all Course
    public List<Course> getCourse(){
        return courseRepository.findAll();
    }

    //Add new Course
    public void addCourse(Course course){
        courseRepository.save(course);
    }

    //Update Course
    public boolean updateCourse(Integer ID,Course course){
       Course oldCourse=courseRepository.findCourseById(ID);
        if(oldCourse==null){
            return false;
        }

        oldCourse.setName(course.getName());


        courseRepository.save(oldCourse);
        return true;
    }
    //Delete Course
    public boolean deleteCourse(Integer ID){
        Course oldCourse=courseRepository.findCourseById(ID);
        if(oldCourse==null){
            return false;
        }
        courseRepository.delete(oldCourse);
        return true;
    }

    public  void assignCourseToTeacher(Integer teacher_id,Integer course_id){

        Teacher teacher=teacherRepository.findTeacherById(teacher_id);
        Course course=courseRepository.findCourseById(course_id);
        if(teacher==null || course==null){
            throw new ApiException("Wrong id");
        }
        course.setTeacher(teacher);
      courseRepository.save(course);
    }
}
