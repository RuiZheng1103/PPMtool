package com.rui.ppmtool.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rui.ppmtool.main.Project;
import com.rui.ppmtool.services.MapValidationErrorService;
import com.rui.ppmtool.services.ProjectServices;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectServices projectService;

    @Autowired
    
    private MapValidationErrorService mapValidationErrorService; 

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
    	ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
    	if (errorMap !=null) return errorMap;
    	Project project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }
}