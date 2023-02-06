package com.example.springhw21.DTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;
    @NotEmpty(message = "Area Should Not Be Empty")
    private  String area;
    @NotEmpty(message = "Street Should Not Be Empty")
    private String street;
    @NotNull(message = " Building Number Should Not Be Empty")
    private Integer buildingNumber;

}
