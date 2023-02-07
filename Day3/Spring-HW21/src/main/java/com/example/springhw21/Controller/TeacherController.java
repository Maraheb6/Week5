package com.example.springhw21.Controller;

import com.example.springhw21.ApiException.ApiException;
import com.example.springhw21.DTO.AddressDTO;
import com.example.springhw21.Model.Teacher;
import com.example.springhw21.Service.AddressService;
import com.example.springhw21.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    private final AddressService addressService;

    //Get all teachers
    @GetMapping("/get")
    public ResponseEntity getTeacher() {
        List<Teacher> teachers = teacherService.getTeacher();
        return ResponseEntity.status(200).body(teachers);
    }

    //Add new teacher
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher) {

        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher Added");
    }

    //Update teacher
    @PutMapping("/update/{ID}")
    public ResponseEntity updateTeacher(@PathVariable Integer ID, @Valid @RequestBody Teacher teacher) {
        boolean isUpdate = teacherService.updateTeacher(ID, teacher);
        if (isUpdate) {
            return ResponseEntity.status(200).body("Teacher Updated");
        }
        throw new ApiException("Wrong Teacher Id");
    }

    //Delete teacher
    @DeleteMapping("/delete/{ID}")
    public ResponseEntity deleteTeacher(@PathVariable Integer ID) {
        boolean isDelete = teacherService.deleteTeacher(ID);
        if (isDelete) {
            return ResponseEntity.status(200).body("Teacher Deleted");
        }
        throw new ApiException("Wrong  Teacher Id");
    }

    //Add teacher address
    @PostMapping("/addressadd")
    public ResponseEntity addAddress(@RequestBody AddressDTO addressDTO) {
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body("Address Added ");
    }

    //Update teacher address
    @PutMapping("/addressupdate")
    public ResponseEntity updateAddress(@RequestBody AddressDTO addressDTO) {
        boolean isUpdated = addressService.updateAddress(addressDTO);
        if (isUpdated) {
            return ResponseEntity.status(200).body("Address updated ");
        }
        throw new ApiException("Wrong Address Id");
    }

    //Delete teacher address
    @DeleteMapping("/addressdelete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id) {
        boolean isUpdated = addressService.deleteAddress(id);
        if (isUpdated) {
            return ResponseEntity.status(200).body("Address deleted");
        }
        throw new ApiException("Wrong Address Id");
    }

    //endpoint that takes teacher id and return All teacher details
    @GetMapping("/teacherdatails/{id}")
    public ResponseEntity getTeacherDetails(@PathVariable Integer id) {
        Teacher teacher = teacherService.getTeacherDetails(id);
        return ResponseEntity.status(200).body(teacher);
    }

    //take course id and return teacher name
    @GetMapping("/getName/{id}")
    public ResponseEntity getTeacherName(@PathVariable Integer id){
        String name=teacherService.getTeacherName(id);
        return ResponseEntity.status(200).body(name);
    }
}
