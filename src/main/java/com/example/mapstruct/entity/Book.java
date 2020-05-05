package com.example.mapstruct.entity;


import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

    private Long id;

    private String title;

    private Integer numberPages;

    private String isbn;

    private Integer edition;

    private Integer yearOfPublication;

    private String publishingCompany;

    private List<Optional<Author>> authors;

    public Book(Long id){
        this.id = id;
    }
}
