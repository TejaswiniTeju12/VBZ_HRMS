package com.vbz.hrms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vbz.hrms.Respositoy.DesignationRespo;
import com.vbz.hrms.dto.DesignationResponseDTO;

@Service
@Transactional(readOnly = true)
public class DesignationServiceImpl implements DesignationService {

    private final DesignationRespo designationRespo;

    public DesignationServiceImpl(DesignationRespo designationRespo) {
        this.designationRespo = designationRespo;
    }

    @Override
    public List<DesignationResponseDTO> getAllDesignations() {
        return designationRespo.findAll()
                .stream()
                .map(d -> new DesignationResponseDTO(
                        d.getId(),
                        d.getDesignationName()))
                .collect(Collectors.toList());
    }
}
