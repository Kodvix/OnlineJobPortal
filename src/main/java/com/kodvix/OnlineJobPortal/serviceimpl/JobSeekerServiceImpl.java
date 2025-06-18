package com.kodvix.OnlineJobPortal.serviceimpl;

import com.kodvix.OnlineJobPortal.dto.JobSeekerDto;
import com.kodvix.OnlineJobPortal.entity.JobSeeker;
import com.kodvix.OnlineJobPortal.entity.User;
import com.kodvix.OnlineJobPortal.repository.JobSeekerRepository;
import com.kodvix.OnlineJobPortal.repository.UserRepository;
import com.kodvix.OnlineJobPortal.service.JobSeekerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public JobSeeker save(JobSeekerDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        JobSeeker jobSeeker = modelMapper.map(dto, JobSeeker.class);
        jobSeeker.setUser(user);

        return jobSeekerRepository.save(jobSeeker);
    }

    @Override
    public void deleteById(Long id) {
        jobSeekerRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, JobSeekerDto dto) {
        JobSeeker jobSeeker = jobSeekerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("JobSeeker not found with ID: " + id));

        modelMapper.map(dto, jobSeeker);

        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            jobSeeker.setUser(user);
        }

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