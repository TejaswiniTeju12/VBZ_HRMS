package com.vbz.hrms.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vbz.hrms.service.MonthlySalaryService;
import com.vbz.hrms.dto.MonthlySalaryRequestDTO;
import com.vbz.hrms.dto.MonthlySalaryResponseDTO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/salary")
public class MonthlySalaryController {

    private final MonthlySalaryService salaryService;

    public MonthlySalaryController(MonthlySalaryService salaryService) {
        this.salaryService = salaryService;
    }
    @PostMapping("/generate")
    public ResponseEntity<String> generateSalary(
            @RequestBody MonthlySalaryRequestDTO dto,
            HttpSession session) {

        String result = salaryService.generateMonthlySalary(dto, session);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/salaryList")
    public ResponseEntity<List<MonthlySalaryResponseDTO>> getSalaryByMonthYear(
            @RequestParam Integer year,
            @RequestParam Integer month) {

        return ResponseEntity.ok(
                salaryService.getSalaryByMonthYear(year, month)
        );
    }

    @GetMapping("/my-salary")
    public ResponseEntity<List<MonthlySalaryResponseDTO>> mySalary(HttpSession session) {
        return ResponseEntity.ok(salaryService.mySalary(session));
    }
}
