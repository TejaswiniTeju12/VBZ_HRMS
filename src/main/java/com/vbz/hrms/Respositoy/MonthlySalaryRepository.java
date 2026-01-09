package com.vbz.hrms.Respositoy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbz.hrms.model.MonthlySalary;
import com.vbz.hrms.model.User;

public interface MonthlySalaryRepository
        extends JpaRepository<MonthlySalary, Long> {

    Optional<MonthlySalary> findByUser(User user);
}
