package com.vbz.hrms.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vbz.hrms.Respositoy.SalaryPercentageRepository;
import com.vbz.hrms.dto.SalaryPercentageDTO;
import com.vbz.hrms.model.SalaryPercentageMaster;

@Service
@Transactional
public class SalaryPercentageServiceImpl implements SalaryPercentageService {

    private final SalaryPercentageRepository repo;

    public SalaryPercentageServiceImpl(SalaryPercentageRepository repo) {
        this.repo = repo;
    }

    @Override
    public String savePercentage(SalaryPercentageDTO dto) {

        SalaryPercentageMaster config =
                repo.findAll().stream().findFirst()
                        .orElse(new SalaryPercentageMaster());

        config.setBasicPercent(dto.getBasicPercent());
        config.setHraPercent(dto.getHraPercent());
        config.setPfPercent(dto.getPfPercent());

        repo.save(config);

        return "Salary percentage configuration saved";
    }

    @Override
    public SalaryPercentageDTO getPercentage() {

        SalaryPercentageMaster config = repo.findAll().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Salary config not set"));

        SalaryPercentageDTO dto = new SalaryPercentageDTO();
        dto.setBasicPercent(config.getBasicPercent());
        dto.setHraPercent(config.getHraPercent());
        dto.setPfPercent(config.getPfPercent());
        return dto;
    }
}
