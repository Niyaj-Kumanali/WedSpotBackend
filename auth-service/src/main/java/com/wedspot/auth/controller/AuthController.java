package com.wedspot.auth.controller;

import com.wedspot.auth.Model.LoginRequest;
import com.wedspot.auth.Model.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        // Demo logic
        System.out.println("Login request: " + request.getEmail() + " / " + request.getPassword());
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Login successful");
        response.put("token", "demo-jwt-token-12345");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody RegisterRequest request) {
        // Demo logic
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "User registered successfully");
        response.put("userEmail", request.getEmail());
        return ResponseEntity.ok(response);
    }
}
