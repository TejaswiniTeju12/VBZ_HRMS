package com.vbz.hrms.Respositoy;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vbz.hrms.model.MonthlySalary;
import com.vbz.hrms.model.User;

public interface MonthlySalaryRepository extends JpaRepository<MonthlySalary, Long> {

    boolean existsByUserAndMonthAndYear(User user, Integer month, Integer year);

    List<MonthlySalary> findByUser(User user);

    List<MonthlySalary> findByMonthAndYear(Integer month, Integer year);
    
    Optional<MonthlySalary> findByUserAndMonthAndYear(
            User user, Integer month, Integer year);
}

