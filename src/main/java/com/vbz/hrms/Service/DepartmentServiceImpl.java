package com.vbz.hrms.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vbz.hrms.Respositoy.DepartmentRespo;
import com.vbz.hrms.dto.DepartmentResponseDTO;

@Service
@Transactional(readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRespo departmentRespo;

    public DepartmentServiceImpl(DepartmentRespo departmentRespo) {
        this.departmentRespo = departmentRespo;
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {
        return departmentRespo.findAll()
                .stream()
                .map(d -> new DepartmentResponseDTO(
                        d.getId(),
                        d.getDepartmentName()))
                .collect(Collectors.toList());
    }
}
