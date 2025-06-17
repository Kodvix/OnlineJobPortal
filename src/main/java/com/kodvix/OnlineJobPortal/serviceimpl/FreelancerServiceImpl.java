package com.kodvix.OnlineJobPortal.serviceimpl;

import com.kodvix.OnlineJobPortal.dto.FreelancerDto;
import com.kodvix.OnlineJobPortal.entity.Freelancer;
import com.kodvix.OnlineJobPortal.entity.User;
import com.kodvix.OnlineJobPortal.repository.FreelancerRepository;
import com.kodvix.OnlineJobPortal.repository.UserRepository;
import com.kodvix.OnlineJobPortal.service.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreelancerServiceImpl implements FreelancerService {

    @Autowired
    FreelancerRepository freelancerRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Freelancer save(FreelancerDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Freelancer freelancer = new Freelancer();

        freelancer.setUser(user);
        //freelancer.setFreelancer_id(dto.getFreelancerId());
        freelancer.setFirstName(dto.getFirstName());
        freelancer.setLastName(dto.getLastName());
        freelancer.setEmail(dto.getEmail());
        freelancer.setPhoneNo(dto.getPhoneNo());
        freelancer.setUploadResume(dto.getUploadResume());
        freelancer.setDateOfBirth(dto.getDateOfBirth());
        freelancer.setSkills(dto.getSkills());
        freelancer.setEducation(dto.getEducation());
        freelancer.setExperience(dto.getExperience());
        freelancer.setAddress(dto.getAddress());

        return freelancerRepository.save(freelancer);
    }

    @Override
    public void deleteById(Long id) {
        freelancerRepository.deleteById(id);
    }

//    @Override
//    public void updateById(Long id, FreelancerDTO freelancerDto) {
//
//    }

    @Override
    public void updateById(Long id, FreelancerDto dto) {
        Freelancer freelancer = freelancerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Freelancer not found with ID: " + id));

        // Map updated user if userId is present
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            freelancer.setUser(user);
        }

        freelancer.setFirstName(dto.getFirstName());
        freelancer.setLastName(dto.getLastName());
        freelancer.setEmail(dto.getEmail());
        freelancer.setPhoneNo(dto.getPhoneNo());
        freelancer.setUploadResume(dto.getUploadResume());
        freelancer.setDateOfBirth(dto.getDateOfBirth());
        freelancer.setSkills(dto.getSkills());
        freelancer.setEducation(dto.getEducation());
        freelancer.setExperience(dto.getExperience());
        freelancer.setAddress(dto.getAddress());

        freelancerRepository.save(freelancer);
    }

    @Override
    public Freelancer getById(Long id) {
        return freelancerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Freelancer not found with ID: " + id));
    }

    @Override
    public List<Freelancer> getAll() {
        return freelancerRepository.findAll();
    }
}
