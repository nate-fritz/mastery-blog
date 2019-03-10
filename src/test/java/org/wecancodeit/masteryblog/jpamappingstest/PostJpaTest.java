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
import org.wecancodeit.masteryblog.models.Category;
import org.wecancodeit.masteryblog.models.Post;
import org.wecancodeit.masteryblog.models.Tag;
import org.wecancodeit.masteryblog.repositories.PostRepository;
import org.wecancodeit.masteryblog.repositories.TagRepository;
import org.wecancodeit.masteryblog.repositories.AuthorRepository;
import org.wecancodeit.masteryblog.repositories.CategoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class PostJpaTest {
	
	@Resource
	private TestEntityManager entityManager;

	@Resource 
	private PostRepository postRepo;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@Resource
	private AuthorRepository authorRepo;
	
	@Resource
	private TagRepository tagRepo;
	
	@Test
	public void shouldSaveAndLoadPost() {
		Category testCategory = categoryRepo.save(new Category("category"));
		Author testAuthor = authorRepo.save(new Author("author"));
		Tag testTag = tagRepo.save(new Tag("tag"));
		Post post = postRepo.save(new Post("title", "body", testCategory, testAuthor, testTag ));
		
		Long postId = post.getId();
		
		entityManager.persist(post);
		entityManager.flush(); 
		entityManager.clear();
		
		Optional<Post> postToFind = postRepo.findById(postId);
		post = postToFind.get();

		assertThat(post.getTitle(), is("title"));
	}

}
