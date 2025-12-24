package com.vbz.hrms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vbz.hrms.entity.RoleMaster;
import com.vbz.hrms.service.RoleMasterService;

@RestController
@RequestMapping("/api/roles")
public class RoleMasterController {

    private final RoleMasterService roleMasterService;

    public RoleMasterController(RoleMasterService roleMasterService) {
        this.roleMasterService = roleMasterService;
    }

    @PostMapping("/create")
    public ResponseEntity<RoleMaster> createRole(@RequestBody RoleMaster roleMaster) {
        return ResponseEntity.ok(roleMasterService.createRole(roleMaster));
    }
}