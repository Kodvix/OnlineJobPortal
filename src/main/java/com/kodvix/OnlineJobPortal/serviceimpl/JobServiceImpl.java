package com.kodvix.OnlineJobPortal.serviceimpl;

import com.kodvix.OnlineJobPortal.dto.JobRequestDto;
import com.kodvix.OnlineJobPortal.dto.JobResponseDto;
import com.kodvix.OnlineJobPortal.entity.Job;
import com.kodvix.OnlineJobPortal.entity.Recruiter;

import com.kodvix.OnlineJobPortal.repository.JobRepository;
import com.kodvix.OnlineJobPortal.repository.RecruiterRepository;
import com.kodvix.OnlineJobPortal.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final RecruiterRepository recruiterRepository;

    public JobServiceImpl(JobRepository jobRepository, RecruiterRepository recruiterRepository) {
        this.jobRepository = jobRepository;
        this.recruiterRepository = recruiterRepository;
    }

    @Override
    public JobResponseDto postJob(JobRequestDto dto) {
        Recruiter recruiter = recruiterRepository.findById(dto.getRecruiterId())
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));

        // Manual mapping instead of modelMapper to avoid ID conflicts
        Job job = new Job();
        job.setTitle(dto.getTitle());
        job.setDescription(dto.getDescription());
        job.setLocation(dto.getLocation());
        job.setJobType(dto.getJobType());
        job.setSalary(dto.getSalary());
        job.setExperienceLevel(dto.getExperienceLevel());
        job.setRecruiter(recruiter);

        Job savedJob = jobRepository.save(job);

        return convertToResponseDto(savedJob);
    }

    @Override
    public List<JobResponseDto> getAllJobs() {
        return jobRepository.findAll()
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<JobResponseDto> getJobsByRecruiter(Long recruiterId) {
        return jobRepository.findByRecruiterId(recruiterId)
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteJob(Long jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));
        jobRepository.delete(job);
    }

    // -------------------- Helper Methods --------------------

    private JobResponseDto convertToResponseDto(Job job) {
        JobResponseDto dto = new JobResponseDto();
        dto.setId(job.getId());
        dto.setTitle(job.getTitle());
        dto.setDescription(job.getDescription());
        dto.setLocation(job.getLocation());
        dto.setJobType(job.getJobType());
        dto.setSalary(job.getSalary());
        dto.setExperienceLevel(job.getExperienceLevel());

        dto.setRecruiterName(job.getRecruiter().getUser().getFirstName());
        dto.setRecruiterCompany(job.getRecruiter().getCompanyName());
        return dto;
    }
}
