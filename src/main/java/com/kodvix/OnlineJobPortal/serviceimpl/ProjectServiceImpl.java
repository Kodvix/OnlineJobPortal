package com.kodvix.OnlineJobPortal.serviceimpl;

import com.kodvix.OnlineJobPortal.dto.ProjectRequestDto;
import com.kodvix.OnlineJobPortal.dto.ProjectResponseDto;
import com.kodvix.OnlineJobPortal.entity.Project;
import com.kodvix.OnlineJobPortal.entity.Recruiter;
import com.kodvix.OnlineJobPortal.repository.ProjectRepository;
import com.kodvix.OnlineJobPortal.repository.RecruiterRepository;
import com.kodvix.OnlineJobPortal.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Override
    public ProjectResponseDto createProject(ProjectRequestDto dto) {
        Recruiter recruiter = recruiterRepository.findById(dto.getRecruiterId())
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));

        Project project = new Project();
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setSkillsRequired(dto.getSkillsRequired());
        project.setBudget(dto.getBudget());
        project.setDuration(dto.getDuration());
        project.setRecruiter(recruiter);

        Project saved = projectRepository.save(project);

        return mapToDto(saved);
    }

    @Override
    public List<ProjectResponseDto> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectResponseDto getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        return mapToDto(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    private ProjectResponseDto mapToDto(Project project) {
        return new ProjectResponseDto(
                project.getId(),
                project.getTitle(),
                project.getDescription(),
                project.getSkillsRequired(),
                project.getBudget(),
                project.getDuration(),
                project.getRecruiter().getId(),
                project.getRecruiter().getCompanyName()
        );
    }
}
