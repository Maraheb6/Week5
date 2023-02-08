package com.example.springhw21.Controller;

import com.example.springhw21.ApiException.ApiException;
import com.example.springhw21.Model.Course;
import com.example.springhw21.Model.Student;
import com.example.springhw21.Model.Teacher;
import com.example.springhw21.Repository.CourseRepository;
import com.example.springhw21.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;


    //Get all Course
    @GetMapping("/get")
    public ResponseEntity getCourse(){
        List<Course> course=courseService.getCourse();
        return ResponseEntity.status(200).body(course);
    }
    //Add new Course
    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course ){
       courseService.addCourse(course);
        return ResponseEntity.status(200).body("Course Added");
    }
    //Update Course
    @PutMapping("/update/{ID}")
    public ResponseEntity updateCourse(@PathVariable Integer ID,@Valid@RequestBody Course course){
        boolean isUpdate= courseService.updateCourse(ID,course);
        if(isUpdate) {
            return ResponseEntity.status(200).body("Course Updated");
        }
        throw new ApiException("Wrong Course Id");
    }
    //Delete Course
    @DeleteMapping("/delete/{ID}")
    public  ResponseEntity deleteCourse(@PathVariable Integer ID){
        boolean isDelete= courseService.deleteCourse(ID);
        if(isDelete) {
            return ResponseEntity.status(200).body("Course Deleted");
        }
        throw new ApiException("Wrong  Course Id");
    }
  @PutMapping("/{teacher_id}/course/{course_id}")
    public ResponseEntity assignCourseToTeacher(@PathVariable Integer teacher_id,@PathVariable Integer course_id){
        courseService.assignCourseToTeacher(teacher_id,course_id);
        return ResponseEntity.status(200).body("Don Assign Course To Teacher");
  }
//endpoint that takes course id and return the student list
  @GetMapping("/findall/{id}")
    public ResponseEntity getAllStudent(@PathVariable Integer id){
        List<Student> students=courseService.getAllStudent(id);
        return ResponseEntity.status(200).body(students);
  }
}
