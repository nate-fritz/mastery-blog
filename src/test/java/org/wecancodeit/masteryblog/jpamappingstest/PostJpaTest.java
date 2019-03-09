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
import org.wecancodeit.masteryblog.models.Post;
import org.wecancodeit.masteryblog.repositories.PostRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class PostJpaTest {
	
	@Resource
	private TestEntityManager entityManager;

	@Resource 
	private PostRepository postRepo;
	
	@Test
	public void shouldSaveAndLoadPost() {
		Post post = postRepo.save(new Post("Bootcamp", 10, "Once upon a time at WCCI", "wcci.com" ));
		
		Long postId = post.getId();
		
		entityManager.persist(post);
		entityManager.flush(); 
		entityManager.clear();
		
		Optional<Post> postToFind = postRepo.findById(postId);
		post = postToFind.get();

		assertThat(post.getTitle(), is("Bootcamp"));
	}

}
