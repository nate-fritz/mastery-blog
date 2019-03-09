package org.wecancodeit.masteryblog.jpamappingstest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Optional;

import javax.annotation.Resource;
import javax.swing.text.html.HTML.Tag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.masteryblog.repositories.TagRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class TagJpaTest {
	
	@Resource
	private TestEntityManager entityManager;

	@Resource 
	private TagRepository tagRepo;
	
	@Test
	public void shouldSaveAndLoadTag() {
		Tag tag= tagRepo.save(new Tag("funny" ));
		
		Long tagId = tag.getId();
		
		entityManager.persist(tag);
		entityManager.flush(); 
		entityManager.clear();
		
		Optional<Tag> tagToFind = tagRepo.findById(tagId);
		tag = tagToFind.get();

		assertThat(tag.getTagLabel(), is("Fiction"));
	}

}
