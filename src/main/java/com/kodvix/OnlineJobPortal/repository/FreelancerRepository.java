package com.kodvix.OnlineJobPortal.repository;

import com.kodvix.OnlineJobPortal.entity.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {

}
