package com.library.management.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorDTO {

    private Long id;

    private String name;

}
