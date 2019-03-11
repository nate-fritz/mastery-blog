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
import org.wecancodeit.masteryblog.controllers.TagController;
import org.wecancodeit.masteryblog.models.Tag;
import org.wecancodeit.masteryblog.repositories.TagRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(TagController.class)
public class TagMvcTest {

	@Resource
	private MockMvc mvc;

	@MockBean
	private TagRepository tagRepo;

	@Mock
	private Tag tag;

	@Test
	public void shouldRouteToSingleTagView() throws Exception {
		long empId = 1;
		when(tagRepo.findById(empId)).thenReturn(Optional.of(tag));
		mvc.perform(get("/author?id=1")).andExpect(view().name(is("author")));
	}

	@Test
	public void shouldBeOkForSingleTag() throws Exception {
		long empId = 1;
		when(tagRepo.findById(empId)).thenReturn(Optional.of(tag));
		mvc.perform(get("/author?id=1")).andExpect(status().isOk());
	}

	@Test
	public void shouldPutSingleTagIntoModel() throws Exception {
		when(tagRepo.findById(1L)).thenReturn(Optional.of(tag));

		mvc.perform(get("/tag?id=1")).andExpect(model().attribute("tags", is(tag)));
	}
}