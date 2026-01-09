package com.vbz.hrms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vbz.hrms.entity.RoleMaster;

public interface RoleMasterRepository extends JpaRepository<RoleMaster, Long> {

    boolean existsByRoleName(String roleName);
    Optional<RoleMaster> findByRoleName(String roleName);

}
