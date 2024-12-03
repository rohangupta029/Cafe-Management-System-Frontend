package com.in.cafe.service;

import com.in.cafe.wrapper.UserWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
    public ResponseEntity<String> signUp(Map<String, String> requestMap);

    public ResponseEntity<String> login(Map<String, String> requestMap);

    public ResponseEntity<List<UserWrapper>> getAllUser();

    public ResponseEntity<String> update(Map<String, String> requestMap);

    public ResponseEntity<String> checkToken();

    public  ResponseEntity<String> changePassword(Map<String, String> requestMap);

    public  ResponseEntity<String> forgotPassword(Map<String, String> requestMap);

}
