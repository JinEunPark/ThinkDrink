package com.datacampus.biohealth2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDto {
    private Long id;

    private String name;

    private String email;

    private String password;

    private String address;
}
