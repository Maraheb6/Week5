package com.example.springhw21.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    @NotEmpty(message = "Name Should Not Be Empty")
    private String name;
    @NotNull(message = "Age Should Not Be Empty")
    private Integer age;
    @NotEmpty(message = "Major Should Not Be Empty")
    private String major;

@ManyToMany(mappedBy = "students")
private List<Course>courses;
}
