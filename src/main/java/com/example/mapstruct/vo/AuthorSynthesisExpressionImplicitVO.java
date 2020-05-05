package com.example.mapstruct.vo;

import com.example.mapstruct.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.StringUtils;


/**
 * @author s2it_psilva
 * @version $Revision: $<br/>
 * $Id: $
 * @since 11/1/18 4:44 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthorSynthesisExpressionImplicitVO {
    private Long id;

    private String name;

    public void setFirstName(String firstName){
        if (StringUtils.isEmpty(firstName)) {
           this.name = firstName;
        }
    }

    public void setLastName(String lastName){
        if (StringUtils.isEmpty(this.name)) {
            this.name = lastName;
        }
    }
}
