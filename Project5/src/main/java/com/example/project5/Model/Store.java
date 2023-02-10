package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name Should not be Empty")
    private String name;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "store")
    @PrimaryKeyJoinColumn
    private Location location;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "store")
    private List<Book> books;
    @ManyToMany(mappedBy = "stores")
    private List<Customer>customers;
}
