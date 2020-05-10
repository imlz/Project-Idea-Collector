package com.csprojideas.application.models;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Ideas")
public class Idea {
	
	@Id 
	@GeneratedValue()
	private int id;
	private String idea;
	private String description;
	
	@ElementCollection
	@CollectionTable(name="TAGS", joinColumns = @JoinColumn(name="id"))
	private List<String> tags;

	public Idea() {
	}

	public Idea(String idea) {
		this.idea = idea;
	}

	public Idea(String idea, String description) {
		this.idea=idea;
		this.description=description;
	}
	
	public String getIdea() {
		return idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
}
