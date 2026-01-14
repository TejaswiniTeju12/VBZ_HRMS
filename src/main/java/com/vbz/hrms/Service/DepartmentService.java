package com.vbz.hrms.service;

import java.util.List;
import com.vbz.hrms.dto.DepartmentResponseDTO;

public interface DepartmentService {
    List<DepartmentResponseDTO> getAllDepartments();
}
