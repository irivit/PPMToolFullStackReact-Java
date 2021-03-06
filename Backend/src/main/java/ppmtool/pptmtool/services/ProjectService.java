package ppmtool.pptmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppmtool.pptmtool.domain.Project;
import ppmtool.pptmtool.exceptions.ProjectIdException;
import ppmtool.pptmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "'already exists");
        }
    }

    public Project findProjectByIdentifier(String projectId){

        Project project = projectRepository.findByProjectIdentifier(projectId);

        if(project == null){
            throw new ProjectIdException("Project ID '"+projectId+"'doesn't exists");
        }
        return project;
    }

    public Iterable<Project> findAllProject(){

        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId){

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if (project == null){
            throw new ProjectIdException("Cannot Project with ID'"+projectId+"'. This project does not exist");
        }
        projectRepository.delete(project);
    }
}
