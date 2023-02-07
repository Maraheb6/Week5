package com.example.springhw21.Service;

import com.example.springhw21.ApiException.ApiException;
import com.example.springhw21.DTO.AddressDTO;
import com.example.springhw21.Model.Address;
import com.example.springhw21.Model.Teacher;
import com.example.springhw21.Repository.AddressRepository;
import com.example.springhw21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    private final TeacherRepository teacherRepository;
//Add teacher address
    public void addAddress(AddressDTO addressDTO){
        Teacher teacher=teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(teacher==null){
            throw new ApiException("Teacher Id Not Found");
        }

        Address address=new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }
    //Update teacher address

    public boolean updateAddress(AddressDTO addressDTO) {
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (address == null) {
            return false;
        }

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);
        return true;

    }
//Delete teacher address
    public boolean deleteAddress(Integer id) {
        Address address = addressRepository.findAddressById(id);
        if (address == null) {
            return false;
        }

        addressRepository.delete(address);

        return true;
    }




}
