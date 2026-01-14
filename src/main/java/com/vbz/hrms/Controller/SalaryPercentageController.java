package com.vbz.hrms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vbz.hrms.dto.SalaryPercentageDTO;
import com.vbz.hrms.service.SalaryPercentageService;

@RestController
@RequestMapping("/salary-config")
public class SalaryPercentageController {

    private final SalaryPercentageService service;

    public SalaryPercentageController(SalaryPercentageService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody SalaryPercentageDTO dto) {
        return ResponseEntity.ok(service.savePercentage(dto));
    }

    @GetMapping("/get")
    public ResponseEntity<SalaryPercentageDTO> get() {
        return ResponseEntity.ok(service.getPercentage());
    }
}
