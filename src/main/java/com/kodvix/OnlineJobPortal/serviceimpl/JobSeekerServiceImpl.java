package com.kodvix.OnlineJobPortal.serviceimpl;

import com.kodvix.OnlineJobPortal.dto.JobSeekerDto;
import com.kodvix.OnlineJobPortal.entity.JobSeeker;
import com.kodvix.OnlineJobPortal.entity.User;
import com.kodvix.OnlineJobPortal.repository.JobSeekerRepository;
import com.kodvix.OnlineJobPortal.repository.UserRepository;
import com.kodvix.OnlineJobPortal.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {

    @Autowired
    JobSeekerRepository jobSeekerRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public JobSeeker save(JobSeekerDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        JobSeeker jobSeeker = new JobSeeker();

        jobSeeker.setUser(user);
        //jobSeeker.setJobSeeker_id(dto.getJobSeekerId());
        jobSeeker.setFirstName(dto.getFirstName());
        jobSeeker.setLastName(dto.getLastName());
        jobSeeker.setEmail(dto.getEmail());
        jobSeeker.setPhoneNo(dto.getPhoneNo());
        jobSeeker.setUploadResume(dto.getUploadResume());
        jobSeeker.setDateOfBirth(dto.getDateOfBirth());
        jobSeeker.setSkills(dto.getSkills());
        jobSeeker.setEducation(dto.getEducation());
        jobSeeker.setExperience(dto.getExperience());
        jobSeeker.setAddress(dto.getAddress());

        return jobSeekerRepository.save(jobSeeker);
    }

    @Override
    public void deleteById(Long id) {
        jobSeekerRepository.deleteById(id);
    }

//    @Override
//    public void updateById(Long id, JobSeekerDTO jobSeekerDto) {
//
//    }

    @Override
    public void updateById(Long id, JobSeekerDto dto) {
        JobSeeker jobSeeker = jobSeekerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("JobSeeker not found with ID: " + id));

        // Map updated user if userId is present
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            jobSeeker.setUser(user);
        }

        jobSeeker.setFirstName(dto.getFirstName());
        jobSeeker.setLastName(dto.getLastName());
        jobSeeker.setEmail(dto.getEmail());
        jobSeeker.setPhoneNo(dto.getPhoneNo());
        jobSeeker.setUploadResume(dto.getUploadResume());
        jobSeeker.setDateOfBirth(dto.getDateOfBirth());
        jobSeeker.setSkills(dto.getSkills());
        jobSeeker.setEducation(dto.getEducation());
        jobSeeker.setExperience(dto.getExperience());
        jobSeeker.setAddress(dto.getAddress());

        jobSeekerRepository.save(jobSeeker);
    }

    @Override
    public JobSeeker getById(Long id) {
        return jobSeekerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("JobSeeker not found with ID: " + id));
    }

    @Override
    public List<JobSeeker> getAll() {
        return jobSeekerRepository.findAll();
    }
}
