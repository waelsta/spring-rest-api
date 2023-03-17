package com.sta.springrest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
