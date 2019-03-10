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
import org.wecancodeit.masteryblog.controllers.TagController;
import org.wecancodeit.masteryblog.models.Tag;
import org.wecancodeit.masteryblog.repositories.TagRepository;

public class TagControllerTest {

	@InjectMocks
	private TagController underTest;
	
	@Mock
	private TagRepository tagRepo;
	
	@Mock
	private Tag tag;
	
	@Mock
	private Tag secondTag;
	
	@Mock
	private Model model;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void shouldAddAllTagsToModel() {
		Collection<Tag> allTags = Arrays.asList(tag, secondTag);
		when(tagRepo.findAll()).thenReturn(allTags);
	}
	
    @Test
	public void shouldAddTagToModel() {
		Long tagId = 1L;
		when(tagRepo.findById(tagId)).thenReturn(Optional.of(tag));
		
		underTest.singleTag(tagId, model);
		
		verify(model).addAttribute("tag", tag);
	}

}

