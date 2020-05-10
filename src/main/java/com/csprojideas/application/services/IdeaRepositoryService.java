package com.csprojideas.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csprojideas.application.models.Idea;
import com.csprojideas.application.repository.IdeaRepository;

@Service
public class IdeaRepositoryService {

	@Autowired
	private IdeaRepository ideaRepository;
	
	public void add(Idea idea) {
		ideaRepository.save(idea);
	}
	
	public void add(List<Idea> ideas) {
		ideas.forEach(idea -> ideaRepository.save(idea));
	}
	
	/**
	 * Retries a list of all saved ideas
	 * @return List a list of all ideas
	 */
	public List<Idea> getIdeas() {
		List<Idea> ideaList = new ArrayList<Idea>();
		ideaRepository.findAll().forEach(ideaList::add);
		
		return ideaList;
	}
	
	/**
	 * 
	 * @param list of tags to search for
	 * @return a list of Idea with the associated tags
	 */
	public List<Idea> findByTag(List<String> tags) {
		return ideaRepository.findDistinctByTagsIn(tags);
	}
	
	/**
	 * Picks a random Idea then returns it
	 * @return an Idea
	 */
	public Idea random() {
		List<Idea> ideaList = new ArrayList<Idea>();
		ideaRepository.findAll().forEach(ideaList::add);
		
		if(ideaList.size()==0)
			return null;
		
		Random random = new Random();
		return ideaList.get( random.nextInt(ideaList.size()) );
	}
	
}
