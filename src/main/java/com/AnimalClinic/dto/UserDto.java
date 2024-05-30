package com.AnimalClinic.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private String name;
    private String surname;
    private String email;
    private Integer numberOfFollowers;
    private Integer numberOfFollowed;
    private String fullName;
    private String media;
}
