package com.example.springhw21.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter @Setter
public class Address {
    @Id
    private Integer id;
    @NotEmpty(message = "Area Should Not Be Empty")
    private  String area;
    @NotEmpty(message = "Street Should Not Be Empty")
    private String street;
    @NotNull(message = " Building Number Should Not Be Empty")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}

