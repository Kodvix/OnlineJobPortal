package com.kodvix.OnlineJobPortal.controller;

import com.kodvix.OnlineJobPortal.dto.JobRequestDto;
import com.kodvix.OnlineJobPortal.dto.JobResponseDto;
import com.kodvix.OnlineJobPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
     JobService jobService;

//    public JobController(JobService jobService) {
//        this.jobService = jobService;
//    }

    @PostMapping
    public ResponseEntity<JobResponseDto> postJob(@RequestBody JobRequestDto dto) {
        return ResponseEntity.ok(jobService.postJob(dto));
    }

    @GetMapping
    public ResponseEntity<List<JobResponseDto>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("/recruiter/{recruiterId}")
    public ResponseEntity<List<JobResponseDto>> getJobsByRecruiter(@PathVariable Long recruiterId) {
        return ResponseEntity.ok(jobService.getJobsByRecruiter(recruiterId));
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long jobId) {
        jobService.deleteJob(jobId);
        return ResponseEntity.noContent().build();
    }
}
