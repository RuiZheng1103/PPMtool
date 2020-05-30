package com.rui.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rui.ppmtool.main.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	
	@Override
	Iterable<Project> findAll();
	
	Project findByProjectIdentifier(String projectId);
	
	
}
