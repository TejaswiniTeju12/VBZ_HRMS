package com.vbz.hrms.Controller;

import org.springframework.web.bind.annotation.*;

import com.vbz.hrms.dto.MonthlySalaryRequestDTO;
import com.vbz.hrms.dto.MonthlySalaryResponseDTO;
import com.vbz.hrms.Service.MonthlySalaryService;

@RestController
@RequestMapping("/api/monthly-salary")
public class MonthlySalaryController {

    private final MonthlySalaryService service;

    public MonthlySalaryController(MonthlySalaryService service) {
        this.service = service;
    }

    @PostMapping
    public MonthlySalaryResponseDTO calculateAndSave(
            @RequestBody MonthlySalaryRequestDTO dto) {

        return service.calculateAndSave(dto);
    }
}


