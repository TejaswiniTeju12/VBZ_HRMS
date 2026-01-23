package com.vbz.hrms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.vbz.hrms.dto.JobDetailsDTO;
import com.vbz.hrms.dto.OnboardingRequestDTO;
import com.vbz.hrms.dto.OnboardingResponseDTO;
import com.vbz.hrms.service.OnboardingService;

@RestController
@RequestMapping("/onboarding")
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
    
    @GetMapping("/self/{userId}")
    public ResponseEntity<OnboardingResponseDTO> getSelfProfile(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                onboardingService.getSelfProfile(userId)
        );
    }
}
   
    


