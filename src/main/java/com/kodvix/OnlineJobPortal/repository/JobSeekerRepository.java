package com.kodvix.OnlineJobPortal.repository;

import com.kodvix.OnlineJobPortal.entity.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {

}
