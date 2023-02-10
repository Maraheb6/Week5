package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @NotEmpty(message = "Name Should not be Empty")
    private String name;
    @NotNull(message = "Book Count  Should not be Empty")
    private Integer bookCount;
    @Pattern(regexp = "^(Drama||Comedy||Romantic||Horror||Action||Fiction)$",message = "Genre should be :\n" +
            "1-Drama\n" +
            "2-Comedy\n" +
            "3-Romantic\n" +
            "4-Horror\n" +
            "5-Action\n" +
            "6-Fiction")

    @NotEmpty(message = "Name Should not be Empty")
    private String genre;
    @ManyToOne
    @JoinColumn(name = "store_id",referencedColumnName = "id")
    @JsonIgnore
    private Store store;
}
