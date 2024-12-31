package com.alphacode.task_sphere.service;

import com.alphacode.task_sphere.entity.Project;
import com.alphacode.task_sphere.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id){
        return projectRepository.findById(id);
    }

    public Project saveProject(Project Project){
        return projectRepository.save(Project);
    }

    public void deleteProject(Long id){
        projectRepository.deleteById(id);
    }

}
