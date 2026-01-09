package com.vbz.hrms.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.vbz.hrms.Service.OnboardingService;
import com.vbz.hrms.dto.OnboardingRequestDTO;

@RestController
@RequestMapping("/api/onboarding")
public class OnboardingController {

    private final OnboardingService onboardingService;

    public OnboardingController(OnboardingService onboardingService) {
        this.onboardingService = onboardingService;
    }

    /**
     * Employee Onboarding API
     * Stores personal, job, bank, statutory and salary details
     */
    @PostMapping
    public ResponseEntity<String> onboardEmployee(
            @Validated @RequestBody OnboardingRequestDTO dto) {

        String response = onboardingService.empOnBoarding(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
