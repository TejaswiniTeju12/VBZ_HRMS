package com.vbz.hrms.service;

import org.springframework.stereotype.Service;
import com.vbz.hrms.dto.CreateUserRequest;
import com.vbz.hrms.entity.RoleMaster;
import com.vbz.hrms.entity.Users;
import com.vbz.hrms.repository.RoleMasterRepository;
import com.vbz.hrms.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleMasterRepository roleRepository;

    public UserService(UserRepository userRepository,
                       RoleMasterRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public Users createUser(CreateUserRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("User already exists");
        }
        
        RoleMaster role = roleRepository
                .findByRoleName(request.getRoleName())
                .orElseThrow(() ->
                        new RuntimeException("Role not found"));

        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(role);

        return userRepository.save(user);
    }

    public Users login(String username, String password) {

        return userRepository
                .findByUsernameAndPassword(username, password)
                .orElseThrow(() ->
                        new RuntimeException("Invalid username or password"));
    }
    
    public void changePassword(Long userId, String oldPassword, String newPassword) {

        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(oldPassword)) {
            throw new RuntimeException("Old password is incorrect");
        }

        user.setPassword(newPassword);
        userRepository.save(user);
    }
}
