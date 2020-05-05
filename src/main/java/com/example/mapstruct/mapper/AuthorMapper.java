package com.example.mapstruct.mapper;

import com.example.mapstruct.entity.Author;
import com.example.mapstruct.vo.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author s2it_psilva
 * @version $Revision: $<br/>
 * $Id: $
 * @since 11/1/18 4:46 PM
 */
@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDefaultVO authorToAuthorDefaultVO(Author author);

    Author authorDefaultVOToAuthor(AuthorDefaultVO authorDefaultVO);

    @Mappings({
            @Mapping(target="idAuthor", source="author.id"),
            @Mapping(target="firstNameAuthor", source="author.firstName")
    })
    AuthorDifferentAttributesVO authorToAuthorDifferentAttributesVO(Author author);


    @InheritInverseConfiguration
    Author authorDifferentAttributesVOToAuthor(AuthorDifferentAttributesVO authorDifferentAttributesVO);

    @Mappings({
            @Mapping(target="name", expression = "java(author.getFirstName().concat(\" \").concat(author.getLastName()))")
    })
    AuthorSynthesisVO authorToAuthorSynthesisVO(Author author);

    @InheritInverseConfiguration
    Author authorSynthesisVOToAuthor(AuthorSynthesisVO authorSynthesisVO);

    @Mappings({
            @Mapping(target="name", expression = "java(org.springframework.util.StringUtils.isEmpty(author.getFirstName())?author.getLastName():author.getFirstName())")
    })
    AuthorSynthesisExpressionJavaVO authorToAuthorSynthesisExpressionJavaVO(Author author);

    @Mappings({
            @Mapping(target="id", source="author.id"),
            @Mapping(target="firstName", source="author.firstName", defaultValue = "Default"),
            @Mapping(target="lastName", source="author.lastName", defaultValue = "Default"),
    })
    AuthorDefaultVO authorNullToAuthorDefaultVO(Author author);

    AuthorSynthesisExpressionImplicitVO authorToAuthorSynthesisExpressionImplicitVO(Author author);
}
