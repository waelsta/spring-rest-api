package com.sta.springrest.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentErrorResponse {

    private String message;
    private Integer status;
    private long timestamp;
}
