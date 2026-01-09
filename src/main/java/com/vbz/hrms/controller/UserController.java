package com.vbz.hrms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vbz.hrms.dto.ChangePassword;
import com.vbz.hrms.dto.CreateUserRequest;
import com.vbz.hrms.entity.Users;
import com.vbz.hrms.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<Users> createUser(
            @RequestBody CreateUserRequest request) {

        Users savedUser = userService.createUser(request);

        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody Users request,
            HttpSession session) {

        Users user = userService.login(
                request.getUsername(),
                request.getPassword()
        );

        session.setAttribute("userId", user.getId());
        session.setAttribute("username", user.getUsername());

        return ResponseEntity.ok("Login successful");
    }
    
    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(
            @RequestBody ChangePassword request,
            HttpSession session) {
    	
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return ResponseEntity.status(401).body("Login Required");
        }

        userService.changePassword(
                userId,
                request.getOldPassword(),
                request.getNewPassword()
        );

        return ResponseEntity.ok("Password changed successfully");
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session){
    	session.invalidate();
    	return ResponseEntity.ok("Successfully logged out");
    }
    		
}
