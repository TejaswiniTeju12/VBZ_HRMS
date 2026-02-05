package com.vbz.hrms.service;


import com.vbz.hrms.dto.OnboardingRequestDTO;
import com.vbz.hrms.dto.OnboardingResponseDTO;

public interface OnboardingService {

    String empOnBoarding(OnboardingRequestDTO dto); // Save(Post)
    
        OnboardingResponseDTO getSelfProfile(Long userId); //To fetch
    }