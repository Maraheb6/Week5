package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name Should not be Empty")
    private String name;
    @NotEmpty(message = "Phone Number Should not be Empty")
    private String phoneNumber;
    @NotEmpty(message = "Email Should not be Empty")
    @Email(message = "Not Valid Email")
    @Column(columnDefinition = " VARCHAR(30) not null unique")
    private String email;
    @ManyToMany
    @JsonIgnore

    private List<Store>stores;
}
