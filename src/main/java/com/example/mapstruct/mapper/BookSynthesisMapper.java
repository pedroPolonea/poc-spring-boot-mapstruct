package com.example.mapstruct.mapper;

import com.example.mapstruct.entity.Book;
import com.example.mapstruct.vo.BookDefaultVO;
import com.example.mapstruct.vo.BookSynthesisVO;
import org.mapstruct.*;

import java.util.List;

/**
 * @author s2it_psilva
 * @version $Revision: $<br/>
 * $Id: $
 * @since 11/1/18 4:46 PM
 */
@Mapper(componentModel = "spring")
public interface BookSynthesisMapper {


    @Mappings({
            @Mapping(target = "title", source = "title", qualifiedByName = {"bookMapperUtil", "capitalizeTitle"} )
    })
    BookSynthesisVO bookToBookSynthesisVOExternalCapitalizeTitle(Book book);

    @Mappings({
            @Mapping(target = "title", source = "book", qualifiedByName = "mountTitle")
    })
    BookSynthesisVO bookToBookSynthesisVOQualifiedMountTitle(Book book);

    @Named("mountTitle")
    default String mountTitle(Book book) {
        final String titleFinal = book.getTitle().concat(" - ").concat(book.getIsbn());
        return titleFinal;
    }

    @Mappings({
            @Mapping(target = "chargeVO", defaultValue = "12/12/2018", dateFormat = "dd/MM/yyyy")
    })
    BookSynthesisVO bookToBookDefaultVODate(Book book);
}
