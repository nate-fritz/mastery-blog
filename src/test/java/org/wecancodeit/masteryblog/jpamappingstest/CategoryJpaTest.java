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
import org.wecancodeit.masteryblog.models.Category;
import org.wecancodeit.masteryblog.repositories.CategoryRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CategoryJpaTest {
	
	@Resource
	private TestEntityManager entityManager;

	@Resource 
	private CategoryRepository categoryRepo;
	
	@Test
	public void shouldSaveAndLoadCategory() {
		Category category= categoryRepo.save(new Category("Fiction" ));
		
		Long categoryId = category.getId();
		
		entityManager.persist(category);
		entityManager.flush(); 
		entityManager.clear();
		
		Optional<Category> categoryToFind = categoryRepo.findById(categoryId);
		category = categoryToFind.get();

		assertThat(category.getName(), is("Fiction"));
	}

}
