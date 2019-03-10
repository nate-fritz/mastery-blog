package org.wecancodeit.masteryblog.mvctest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.masteryblog.controllers.CategoryController;
import org.wecancodeit.masteryblog.models.Category;
import org.wecancodeit.masteryblog.repositories.CategoryRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryMvcTest {

	@Resource
	private MockMvc mvc;

	@MockBean
	private CategoryRepository categoryRepo;

	@Mock
	private Category category;

	@Test
	public void shouldRouteToSingleCategoryView() throws Exception {
		long empId = 1;
		when(categoryRepo.findById(empId)).thenReturn(Optional.of(category));
		mvc.perform(get("/category?id=1")).andExpect(view().name(is("category")));
	}

	@Test
	public void shouldBeOkForSingleCategory() throws Exception {
		long empId = 1;
		when(categoryRepo.findById(empId)).thenReturn(Optional.of(category));
		mvc.perform(get("/category?id=1")).andExpect(status().isOk());
	}

	@Test
	public void shouldPutSingleCategoryIntoModel() throws Exception {
		when(categoryRepo.findById(1L)).thenReturn(Optional.of(category));

		mvc.perform(get("/author?id=1")).andExpect(model().attribute("authors", is(category)));
	}
}