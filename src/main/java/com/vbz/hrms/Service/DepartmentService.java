package com.vbz.hrms.Service;

import java.util.List;
import com.vbz.hrms.dto.DepartmentResponseDTO;

public interface DepartmentService {
    List<DepartmentResponseDTO> getAllDepartments();
}
