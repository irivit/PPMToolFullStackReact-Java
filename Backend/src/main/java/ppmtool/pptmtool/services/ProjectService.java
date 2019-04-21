package ppmtool.pptmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppmtool.pptmtool.domain.Project;
import ppmtool.pptmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        //logic here

        return projectRepository.save(project);
    }
}
