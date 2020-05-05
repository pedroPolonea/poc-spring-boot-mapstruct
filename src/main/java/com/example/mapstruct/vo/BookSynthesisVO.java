package com.example.mapstruct.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookSynthesisVO {

    private Long id;

    private String title;

    private String chargeVO;

}
