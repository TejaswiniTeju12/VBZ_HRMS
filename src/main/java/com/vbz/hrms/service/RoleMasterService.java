package com.vbz.hrms.service;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.vbz.hrms.entity.RoleMaster;
import com.vbz.hrms.repository.RoleMasterRepository;

@Service
public class RoleMasterService {

    private final RoleMasterRepository roleMasterRepository;

    public RoleMasterService(RoleMasterRepository roleMasterRepository) {
        this.roleMasterRepository = roleMasterRepository;
    }

    public RoleMaster createRole(RoleMaster roleMaster) {

        if (roleMasterRepository.existsByRoleName(roleMaster.getRoleName())) {
            throw new RuntimeException("Role already exists");
        }

        return roleMasterRepository.save(roleMaster);
    }
}

