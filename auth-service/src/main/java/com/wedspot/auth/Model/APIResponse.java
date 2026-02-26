package com.wedspot.auth.Model;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class APIResponse {
    public Object data;
    public LocalDateTime timestamp = LocalDateTime.now();
    public String message;
    public int statusCode = HttpStatus.OK.value();
    public boolean success = true;
}
