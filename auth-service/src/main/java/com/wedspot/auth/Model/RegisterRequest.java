package com.wedspot.auth.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}
