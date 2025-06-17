package com.kodvix.OnlineJobPortal.repository;

import com.kodvix.OnlineJobPortal.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
