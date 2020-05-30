package com.rui.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rui.ppmtool.exceptions.ProjectIdException;
import com.rui.ppmtool.main.Project;
import com.rui.ppmtool.repositories.ProjectRepository;

@Repository
public class ProjectServices {
	@Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

    	try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
        }
    }
}
