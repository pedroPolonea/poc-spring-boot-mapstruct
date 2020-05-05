package com.example.mapstruct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author s2it_psilva
 * @version $Revision: $<br/>
 * $Id: $
 * @since 9/19/18 10:46 AM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Author {

    private Long id;

    private String firstName;

    private String lastName;


}
