package com.sumit.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sumit.graphql.dao.AuthorDao;
import com.sumit.graphql.dao.TutorialDao;
import com.sumit.graphql.entities.Author;
import com.sumit.graphql.entities.Tutorial;

public class TutorialResolver implements GraphQLResolver<Tutorial> {

	/*
	 * For complex fields like author in Tutorial, we have to resolve the value of
	 * those fields. TutorialResolver implements GraphQLResolver interface and has
	 * getAuthor() method.
	 */
	
	@Autowired
	private AuthorDao author;
	@Autowired
	private TutorialDao tutorials;
	
	public Author getAuthor(Tutorial tutorial) {
		return author.findById(tutorial.getAuthor().getId()).get();
	}
	
}
