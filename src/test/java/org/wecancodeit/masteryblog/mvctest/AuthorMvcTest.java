package org.wecancodeit.masteryblog.mvctest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.masteryblog.controllers.AuthorController;
import org.wecancodeit.masteryblog.models.Author;
import org.wecancodeit.masteryblog.repositories.AuthorRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorMvcTest {

	@Resource
	private MockMvc mvc;

	@MockBean
	private AuthorRepository authorRepo;

	@Mock
	private Author author;

	@Test
	public void shouldRouteToSingleAuthorView() throws Exception {
		long empId = 1;
		when(authorRepo.findById(empId)).thenReturn(Optional.of(author));
		mvc.perform(get("/author?id=1")).andExpect(view().name(is("author")));
	}

	@Test
	public void shouldBeOkForSingleAuthor() throws Exception {
		long empId = 1;
		when(authorRepo.findById(empId)).thenReturn(Optional.of(author));
		mvc.perform(get("/author?id=1")).andExpect(status().isOk());
	}

	@Test
	public void shouldPutSingleAuthorIntoModel() throws Exception {
		when(authorRepo.findById(1L)).thenReturn(Optional.of(author));

		mvc.perform(get("/author?id=1")).andExpect(model().attribute("authors", is(author)));
	}
}