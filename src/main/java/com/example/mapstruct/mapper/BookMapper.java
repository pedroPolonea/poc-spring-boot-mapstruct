package com.example.mapstruct.mapper;

import com.example.mapstruct.entity.Author;
import com.example.mapstruct.entity.Book;
import com.example.mapstruct.vo.*;
import org.mapstruct.*;

import java.util.List;

/**
 * @author s2it_psilva
 * @version $Revision: $<br/>
 * $Id: $
 * @since 11/1/18 4:46 PM
 */
@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDefaultVO bookToBookDefaultVO(Book book);

    @InheritInverseConfiguration(name = "bookToBookDefaultVO")
    Book bookDefaultVOToBook(BookDefaultVO bookDefaultVO);

    void updateBookDefaultVO(Book book, @MappingTarget BookDefaultVO bookDefaultVO);

    List<BookDefaultVO> bookListToBookDefaultVOList(List<Book> books);

}
