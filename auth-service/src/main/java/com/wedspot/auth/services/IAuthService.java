package com.wedspot.auth.services.implementation;

import com.wedspot.auth.Model.LoginRequest;
import com.wedspot.auth.Model.RegisterRequest;
import org.springframework.http.ResponseEntity;

public interface IAuthService {
    public ResponseEntity Login(LoginRequest request);
    public ResponseEntity Register(RegisterRequest request);
}
