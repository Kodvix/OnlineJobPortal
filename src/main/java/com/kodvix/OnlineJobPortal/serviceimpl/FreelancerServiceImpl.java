package com.kodvix.OnlineJobPortal.serviceimpl;

import com.kodvix.OnlineJobPortal.dto.FreelancerDto;
import com.kodvix.OnlineJobPortal.entity.Freelancer;
import com.kodvix.OnlineJobPortal.entity.User;
import com.kodvix.OnlineJobPortal.repository.FreelancerRepository;
import com.kodvix.OnlineJobPortal.repository.UserRepository;
import com.kodvix.OnlineJobPortal.service.FreelancerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreelancerServiceImpl implements FreelancerService {

    @Autowired
    private FreelancerRepository freelancerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Freelancer save(FreelancerDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Freelancer freelancer = modelMapper.map(dto, Freelancer.class);
        freelancer.setUser(user);

        return freelancerRepository.save(freelancer);
    }

    @Override
    public void deleteById(Long id) {
        freelancerRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, FreelancerDto dto) {
        Freelancer freelancer = freelancerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Freelancer not found with ID: " + id));

        modelMapper.map(dto, freelancer); // update fields from dto to entity

        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            freelancer.setUser(user);
        }

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