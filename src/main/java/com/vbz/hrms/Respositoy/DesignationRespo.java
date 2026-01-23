package com.vbz.hrms.Respositoy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbz.hrms.model.Designation;

public interface DesignationRespo extends JpaRepository<Designation, Long> {

	boolean existsByDesignationName(String designationName);
	Optional<Designation> findByDesignationName(String designationName);


}
