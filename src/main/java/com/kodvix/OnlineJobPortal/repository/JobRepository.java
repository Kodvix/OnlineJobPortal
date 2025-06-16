package com.kodvix.OnlineJobPortal.repository;

import com.kodvix.OnlineJobPortal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByRecruiterId(Long recruiterId);
}
