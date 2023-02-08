package com.example.springhw21.Controller;

import com.example.springhw21.ApiException.ApiException;
import com.example.springhw21.Model.Course;
import com.example.springhw21.Model.Student;
import com.example.springhw21.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


    //Get all Student
    @GetMapping("/get")
    public ResponseEntity getStudent(){
        List<Student> students=studentService.getStudent();
        return ResponseEntity.status(200).body(students);
    }
    //Add new Student
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student ){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student Added");
    }
    //Update Student
    @PutMapping("/update/{ID}")
    public ResponseEntity updateStudent(@PathVariable Integer ID,@Valid@RequestBody Student student){
        boolean isUpdate= studentService.updateStudent(ID,student);
        if(isUpdate) {
            return ResponseEntity.status(200).body("Student Updated");
        }
        throw new ApiException("Wrong Student Id");
    }
    //Delete Student
    @DeleteMapping("/delete/{ID}")
    public  ResponseEntity deleteStudent(@PathVariable Integer ID){
        boolean isDelete= studentService.deleteStudent(ID);
        if(isDelete) {
            return ResponseEntity.status(200).body("Student Deleted");
        }
        throw new ApiException("Wrong  Student Id");
    }
// assign course to student
    @PutMapping("/{course_id}/student/{student_id}")
    public ResponseEntity assignCourseToStudent(@PathVariable Integer course_id,@PathVariable Integer student_id){
        studentService.assignCourseToStudent(course_id,student_id);
        return ResponseEntity.status(200).body("Assign Done");
    }
//// change the student major and drop all the courses that the student attended to
    @PutMapping("/{student_id}/major/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer student_id,@PathVariable String major){
        studentService.changeMajor(student_id,major);
        return ResponseEntity.status(200).body("Done Change Major");
    }

}
