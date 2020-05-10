package com.csprojideas.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csprojideas.application.models.Idea;
import com.csprojideas.application.services.IdeaRepositoryService;

@RestController
@RequestMapping("/ideas")
public class IdeaController {

	@Autowired
	IdeaRepositoryService ideaService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST) 
	public void addIdea(@RequestBody Idea idea){
		ideaService.add(idea);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST) 
	public void addIdea(@RequestBody List<Idea> idea){
		ideaService.add(idea);
	}
	
	@RequestMapping("/all")
	public List<Idea> getAll() { 
		return ideaService.getIdeas();
	}
	
	@RequestMapping("/find")
	public List<Idea> findByTags(List<String> tags) {
		return ideaService.findByTag(tags);
	}
	
	@RequestMapping("/random")
	public Idea random() {
		return ideaService.random();
	}
}
