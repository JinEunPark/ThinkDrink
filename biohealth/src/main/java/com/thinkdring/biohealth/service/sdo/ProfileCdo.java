package com.thinkdring.biohealth.service.sdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProfileCdo {

    private String userName;
    private String userId;//user가 설정한 ID
    private String password;
    private String email;
}
