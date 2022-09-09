package com.datacampus.biohealth2.dto;

import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private String error;
    private List<Object> data;
}
