package com.example.springhw21.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter @Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name Should Not Be Empty")
    @Column(columnDefinition = "VARCHAR(8) not null")
    @Size(min = 3,max = 8,message = "Name Should Not Be Less Than 3 or More Than 8")
    private String name;
    @NotNull(message = "Age Should Not Be Empty")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @Email(message = "Not Valid Email")
    @NotEmpty(message = "Email Should Not Be Empty")
    @Column(columnDefinition = "VARCHAR(30) not null unique")
    private String email;
    @NotNull(message = "Salary Should Not Be Empty")
    @Column(columnDefinition = "int not null unique")
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;
}
