package com.kodvix.OnlineJobPortal.service;

import com.kodvix.OnlineJobPortal.dto.ProjectRequestDto;
import com.kodvix.OnlineJobPortal.dto.ProjectResponseDto;

import java.util.List;

public interface ProjectService {
    ProjectResponseDto createProject(ProjectRequestDto dto);
    List<ProjectResponseDto> getAllProjects();
    ProjectResponseDto getProjectById(Long id);
    void deleteProject(Long id);
}
