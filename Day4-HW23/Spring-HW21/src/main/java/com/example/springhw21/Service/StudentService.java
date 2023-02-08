package com.example.springhw21.Service;

import com.example.springhw21.ApiException.ApiException;
import com.example.springhw21.Model.Course;
import com.example.springhw21.Model.Student;
import com.example.springhw21.Repository.CourseRepository;
import com.example.springhw21.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    //Get all Student
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    //Add new Student
    public void addStudent(Student student){
        studentRepository.save(student);
    }

    //Update Student
    public boolean updateStudent(Integer ID,Student student){
        Student oldStudent=studentRepository.findStudentById(ID);
        if(oldStudent==null){
            return false;
        }


        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());


        studentRepository.save(oldStudent);
        return true;
    }
    //Delete Student
    public boolean deleteStudent(Integer ID){
        Student oldStudent=studentRepository.findStudentById(ID);
        if(oldStudent==null){
            return false;
        }
        studentRepository.delete(oldStudent);
        return true;
    }

    // assign course to student
    public void assignCourseToStudent(Integer course_id,Integer student_id){
        Course course=courseRepository.findCourseById(course_id);
        Student student=studentRepository.findStudentById(student_id);
        if(course==null||student==null){
            throw new ApiException("Wrong Data");
        }
//        for (int i=0;i<student.getCourses().size();i++){
//            if(student.getCourses().get(i)==course){
//                throw new ApiException("Course Already Assigned");
//            }
//        }

        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }
// change the student major and drop all the courses that the student attended to
    public void changeMajor (Integer student_id,String major){
        Student student=studentRepository.findStudentById(student_id);
        if(student==null){
            throw new ApiException("Wrong Student Id");
        }
     Course course =courseRepository.findCourseByStudentsId(student_id);
        course.getStudents().remove(student);
        student.getCourses().clear();
         student.setMajor(major);
        studentRepository.save(student);


    }
}
