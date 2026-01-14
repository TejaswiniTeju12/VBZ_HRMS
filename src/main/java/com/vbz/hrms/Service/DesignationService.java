package com.vbz.hrms.service;

import java.util.List;
import com.vbz.hrms.dto.DesignationResponseDTO;

public interface DesignationService {
    List<DesignationResponseDTO> getAllDesignations();
}
