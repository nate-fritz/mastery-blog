package org.wecancodeit.masteryblog.jpamappingstest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.masteryblog.models.Author;

import org.wecancodeit.masteryblog.repositories.AuthorRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class AuthorJpaTest {
	
	@Resource
	private TestEntityManager entityManager;

	@Resource 
	private AuthorRepository authorRepo;
	
	@Test
	public void shouldSaveAndLoadAuthor() {
		Author author= authorRepo.save(new Author("JJ" ));
		
		Long authorId = author.getId();
		
		entityManager.persist(author);
		entityManager.flush(); 
		entityManager.clear();
		
		Optional<Author> authorToFind = authorRepo.findById(authorId);
		author = authorToFind.get();

		assertThat(author.getAuthor(), is("JJ"));
	}

}
