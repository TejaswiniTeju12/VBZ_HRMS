package com.vbz.hrms.Respositoy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbz.hrms.model.Department;
import com.vbz.hrms.model.User;

public interface DepartmentRespo extends JpaRepository<Department, Long> {

	boolean existsByDepartmentName(String departmentName);

	Optional<Department> findByDepartmentName(String departmentName);
}
