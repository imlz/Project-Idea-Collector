package com.csprojideas.application.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.csprojideas.application.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long>{
	
	List<Idea> findDistinctByTagsIn(List<String> tags);

}
