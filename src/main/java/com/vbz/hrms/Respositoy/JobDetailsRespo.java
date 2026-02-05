package com.vbz.hrms.Respositoy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbz.hrms.model.JobDetails;
import com.vbz.hrms.model.User;

public interface JobDetailsRespo extends JpaRepository<JobDetails, Long> {

	Optional<JobDetails> findByUser(User user);

}
