package com.datacampus.biohealth2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;



@Getter
@Setter
@NoArgsConstructor
public class MemberFormDto {
    @NotBlank(message = "must input your name")
    private String name;
    @NotEmpty(message = "you must input your name")
    @Email(message = "please input email format")
    private String email;
    @NotEmpty(message = "you should input your password")
    @Length(min = 8, max = 20, message = "password should be over 8 and low 16")
    private String password;
@NotEmpty(message = "you must input your address")
    private String address;

}
