package com.vbz.hrms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.vbz.hrms.dto.DesignationResponseDTO;
import com.vbz.hrms.service.DesignationService;

@RestController
@RequestMapping("/api/designations")
public class DesignationController {

    private final DesignationService designationService;

    public DesignationController(DesignationService designationService) {
        this.designationService = designationService;
    }

    @GetMapping
    public List<DesignationResponseDTO> getAllDesignations() {
        return designationService.getAllDesignations();
    }
}
