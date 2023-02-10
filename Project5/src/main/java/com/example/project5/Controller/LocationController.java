package com.example.project5.Controller;

import com.example.project5.ApiException.ApiException;
import com.example.project5.DTO.LocationDTO;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Location;
import com.example.project5.Service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/location")
public class LocationController {
    private final LocationService locationService;

    //Get all Location
//    @GetMapping("/get")
//    public ResponseEntity getLocation(){
//        List<Location> locations=locationService.getLocation();
//        return ResponseEntity.status(200).body(locations);
//    }
    //Add new Location
    @PostMapping("/add")
    public ResponseEntity addLocation(@Valid @RequestBody LocationDTO locationDTO){
        locationService.addLocation(locationDTO);
        return ResponseEntity.status(200).body("Location Added");
    }
    //Update Location
    @PutMapping("/update")
    public ResponseEntity updateLocation(@Valid@RequestBody LocationDTO locationDTO){
        boolean isUpdate= locationService.updateLocation(locationDTO);
        if(isUpdate) {
            return ResponseEntity.status(200).body("Location Updated");
        }
        throw new ApiException("Wrong Location Id");
    }
    //Delete Location
    @DeleteMapping("/delete/{ID}")
    public  ResponseEntity deleteLocation(@PathVariable Integer ID){
        boolean isDelete= locationService.deleteLocation(ID);
        if(isDelete) {
            return ResponseEntity.status(200).body("Location Deleted");
        }
        throw new ApiException("Wrong Location Id");
    }
}
