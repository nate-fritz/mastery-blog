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
import org.wecancodeit.masteryblog.controllers.CategoryController;
import org.wecancodeit.masteryblog.models.Category;
import org.wecancodeit.masteryblog.repositories.CategoryRepository;

public class CategoryControllerTest {

	@InjectMocks
	private CategoryController underTest;
	
	@Mock
	private CategoryRepository categoryRepo;
	
	@Mock
	private Category category;
	
	@Mock
	private Category secondCategory;
	
	@Mock
	private Model model;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void shouldAddAllCategoriesToModel() {
		Collection<Category> allCategories = Arrays.asList(category, secondCategory);
		when(categoryRepo.findAll()).thenReturn(allCategories);
	}
	
    @Test
	public void shouldAddCategoryToModel() throws Exception {
		Long categoryId = 1L;
		when(categoryRepo.findById(categoryId)).thenReturn(Optional.of(category));
		
		underTest.getCategory(categoryId, model);
		
		verify(model).addAttribute("category", category);
	}

}

