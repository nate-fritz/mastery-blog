package org.wecancodeit.masteryblog.controllertest;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.wecancodeit.masteryblog.controllers.PostController;
import org.wecancodeit.masteryblog.models.Post;
import org.wecancodeit.masteryblog.repositories.PostRepository;

public class PostControllerTest {

	@InjectMocks
	private PostController underTest;
	
	@Mock
	private PostRepository postRepo;
	
	@Mock
	private Post post;
	
	@Mock
	private Post secondPost;
	
	@Mock
	private Model model;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void shouldAddAllPostsToModel() {
		Collection<Post> allPosts = Arrays.asList(post, secondPost);
		when(postRepo.findAll()).thenReturn(allPosts);
	}
	
    @Test
	public void shouldAddPostToModel() throws Exception {
		Long id = 1L;
		when(postRepo.findById(id)).thenReturn(Optional.of(post));
		
		underTest.getPost(id, model);
		
		verify(model).addAttribute("post", post);
	}

}
