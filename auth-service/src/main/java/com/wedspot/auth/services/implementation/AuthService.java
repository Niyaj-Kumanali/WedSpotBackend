package com.wedspot.auth.services.implementation;

import com.wedspot.auth.Model.APIResponse;
import com.wedspot.auth.Model.LoginRequest;
import com.wedspot.auth.Model.RegisterRequest;
import com.wedspot.auth.services.IAuthService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService implements IAuthService {
    @Override
    public APIResponse login(LoginRequest request) {
        // Demo logic
        System.out.println("Login request: " + request.getEmail() + " / " + request.getPassword());
        Map<String, Object> response = new HashMap<>();
        response.put("token", "demo-jwt-token-12345");

        APIResponse apiResponse = new APIResponse();
        apiResponse.setData(response);
        apiResponse.setMessage("Login successful");
        return apiResponse;
    }

    @Override
    public APIResponse register(RegisterRequest request) {
        // Demo logic
        Map<String, Object> response = new HashMap<>();
        response.put("userEmail", request.getEmail());

        APIResponse apiResponse = new APIResponse();
        apiResponse.setData(response);
        apiResponse.setMessage("User registered successfully");
        return apiResponse;
    }
}
