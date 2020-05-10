package com.csprojideas.application;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.csprojideas.application.controller.IdeaController;
import com.csprojideas.application.models.Idea;

@ExtendWith(SpringExtension.class)
@WebMvcTest(IdeaController.class)
public class IdeaControllerTest {
	
	@MockBean
	private IdeaController ideaController;
	
	@Test
	public void getAllIdeas() throws Exception {
		Idea test = new Idea("TEST1");
		test.setDescription("TESTING A STRING");
		
		List<Idea> ideas= new ArrayList<>();
		ideas.add(test);
		
		when(ideaController.getAll()).thenReturn(ideas);
		
		List<Idea> result = ideaController.getAll();
		
		assertThat(result.size()==1);
		assertThat(result.get(0).getIdea().equals("TEST1"));
		assertThat(result.get(0).getDescription().equals("TESTING A STRING"));
	}

}
