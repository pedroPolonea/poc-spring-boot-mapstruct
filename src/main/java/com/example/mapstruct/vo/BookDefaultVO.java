package com.example.mapstruct.vo;


import com.example.mapstruct.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDefaultVO {

    private Long id;

    private String title;

    private Integer numberPages;

    private String isbn;

    private Integer edition;

    private Integer yearOfPublication;

    private String publishingCompany;

}
