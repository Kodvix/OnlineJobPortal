package com.kodvix.OnlineJobPortal.service;

import com.kodvix.OnlineJobPortal.dto.JobSeekerDto;
import com.kodvix.OnlineJobPortal.entity.JobSeeker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobSeekerService {

    JobSeeker save(JobSeekerDto dto);

    void deleteById(Long id);

    void updateById(Long id, JobSeekerDto jobSeekerDto);

    JobSeeker getById(Long id);

    List<JobSeeker> getAll();

}
