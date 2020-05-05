package com.example.mapstruct.mapper.util;

import org.mapstruct.Named;
import org.springframework.util.StringUtils;

@Named("bookMapperUtil")
public class BookMapperUtil {

    @Named("capitalizeTitle")
    public String capitalizeTitle(String title){
        return StringUtils.capitalize(title);
    }
}
