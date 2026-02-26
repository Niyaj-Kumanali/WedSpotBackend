package com.wedspot.auth.controller;

import com.wedspot.auth.Model.APIResponse;
import com.wedspot.auth.Model.LoginRequest;
import com.wedspot.auth.Model.RegisterRequest;
import com.wedspot.auth.services.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<APIResponse> login(@RequestBody LoginRequest request) {
        APIResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<APIResponse> register(@RequestBody RegisterRequest request) {
        APIResponse response = authService.register(request);
        return ResponseEntity.ok(response);
    }
}
