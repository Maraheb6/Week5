package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Location {
    @Id
    private Integer id;
    @NotEmpty(message = "Area Should not be Empty")
    private String area;
    @NotEmpty(message = "Street Should not be Empty")
    private String street;
   @OneToOne
   @MapsId
   @JsonIgnore
    private Store store;
}
