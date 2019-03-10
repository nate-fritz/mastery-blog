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
import org.wecancodeit.masteryblog.controllers.AuthorController;
import org.wecancodeit.masteryblog.models.Author;
import org.wecancodeit.masteryblog.repositories.AuthorRepository;

public class AuthorControllerTest {

	@InjectMocks
	private AuthorController underTest;
	
	@Mock
	private AuthorRepository authorRepo;
	
	@Mock
	private Author author;
	
	@Mock
	private Author secondAuthor;
	
	@Mock
	private Model model;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void shouldAddAllAuthorsToModel() {
		Collection<Author> allAuthors = Arrays.asList(author, secondAuthor);
		when(authorRepo.findAll()).thenReturn(allAuthors);
	}
	
    @Test
	public void shouldAddAuthorToModel() {
		Long authorId = 1L;
		when(authorRepo.findById(authorId)).thenReturn(Optional.of(author));
		
		underTest.getAuthor(authorId, model);
		
		verify(model).addAttribute("author", author);
	}

}
