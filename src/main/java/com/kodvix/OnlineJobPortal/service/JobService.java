package com.kodvix.OnlineJobPortal.service;

import com.kodvix.OnlineJobPortal.dto.JobRequestDto;
import com.kodvix.OnlineJobPortal.dto.JobResponseDto;
import java.util.List;

public interface JobService {
    JobResponseDto postJob(JobRequestDto dto);
    List<JobResponseDto> getAllJobs();
    List<JobResponseDto> getJobsByRecruiter(Long recruiterId);
    void deleteJob(Long jobId);
}
