package com.vbz.hrms.Service;

import java.util.List;
import com.vbz.hrms.dto.DesignationResponseDTO;

public interface DesignationService {
    List<DesignationResponseDTO> getAllDesignations();
}
