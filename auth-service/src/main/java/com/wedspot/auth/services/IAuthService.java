package com.wedspot.auth.services;

import com.wedspot.auth.Model.APIResponse;
import com.wedspot.auth.Model.LoginRequest;
import com.wedspot.auth.Model.RegisterRequest;
import org.springframework.http.ResponseEntity;

public interface IAuthService {
    APIResponse login(LoginRequest request);
    APIResponse register(RegisterRequest request);

}
