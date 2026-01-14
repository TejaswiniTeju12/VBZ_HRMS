package com.vbz.hrms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.vbz.hrms.dto.DepartmentResponseDTO;
import com.vbz.hrms.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<DepartmentResponseDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
}
