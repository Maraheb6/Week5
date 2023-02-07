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
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private  final CourseRepository courseRepository;

//Get all teachers
    public List<Teacher> getTeacher(){
        return teacherRepository.findAll();
    }

//Add new teacher
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

//Update teacher
    public boolean updateTeacher(Integer ID,Teacher teacher){
       Teacher oldTeacher=teacherRepository.findTeacherById(ID);
        if(oldTeacher==null){
            return false;
        }


        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());

        teacherRepository.save(oldTeacher);
        return true;
    }
//Delete teacher
    public boolean deleteTeacher(Integer ID){
        Teacher oldTeacher=teacherRepository.findTeacherById(ID);
        if(oldTeacher==null){
            return false;
        }
        teacherRepository.delete(oldTeacher);
        return true;
    }
//endpoint that takes teacher id and return All teacher details
    public Teacher getTeacherDetails(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
       throw new ApiException("Teacher Id Not Found");
        }
        return teacher;
    }

    //take course id and return teacher name

    public String getTeacherName(Integer id){
        Course course=courseRepository.findCourseById(id);
            if(course==null){
                throw new ApiException("Course Id Not Found");
            }

        int teacherID= courseRepository.findTeacherIdById(id).getId();
            Teacher teacher=teacherRepository.findTeacherById(teacherID);
            return  teacher.getName();

    }

}
