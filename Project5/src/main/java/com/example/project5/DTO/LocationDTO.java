package com.example.project5.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class LocationDTO {


    private Integer id;
    @NotEmpty(message = "Area Should not be Empty")
    private String area;
    @NotEmpty(message = "Street Should not be Empty")
    private String street;
}
