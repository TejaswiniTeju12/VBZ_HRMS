package com.vbz.hrms.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.vbz.hrms.Service.DesignationService;
import com.vbz.hrms.dto.DesignationResponseDTO;

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
