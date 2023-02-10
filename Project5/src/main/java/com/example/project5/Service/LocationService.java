package com.example.project5.Service;

import com.example.project5.ApiException.ApiException;
import com.example.project5.DTO.LocationDTO;
import com.example.project5.Model.Location;
import com.example.project5.Model.Store;
import com.example.project5.Repository.LocationRepository;
import com.example.project5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;
    private  final StoreRepository storeRepository;


//    //Get all Location
//    public List<Location> getLocation(){
//        return locationRepository.findAll();
//    }

    //Add new Location
    public void addLocation(LocationDTO locationDTO){
        Store store=storeRepository.findStoreById(locationDTO.getId());
        if(store==null){
            throw new ApiException("Store Id Not Found");
        }

        Location location=new Location(null,locationDTO.getArea(),locationDTO.getStreet(),store);
        locationRepository.save(location);
    }

    //Update Location
    public boolean updateLocation(LocationDTO locationDTO){
      Location location=locationRepository.findLocationById(locationDTO.getId());
      if (location==null){
          throw new ApiException("Store Not Found");
      }
      location.setArea(locationDTO.getArea());
      location.setStreet(locationDTO.getStreet());
      locationRepository.save(location);
        return true;
    }
    //Delete Location
    public boolean deleteLocation(Integer ID){
        Location oldLocation=locationRepository.findLocationById(ID);
        if(oldLocation==null){
            return false;
        }
        locationRepository.delete(oldLocation);
        return true;
    }
}
