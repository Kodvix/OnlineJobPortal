package com.kodvix.OnlineJobPortal.service;

import com.kodvix.OnlineJobPortal.dto.FreelancerDto;
import com.kodvix.OnlineJobPortal.entity.Freelancer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FreelancerService {

    Freelancer save(FreelancerDto dto);

    void deleteById(Long id);

    void updateById(Long id, FreelancerDto freelancerDto);

    Freelancer getById(Long id);

    List<Freelancer> getAll();
}
