package org.wecancodeit.masteryblog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.masteryblog.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

	Post findByTitle(String title);

	
	

}
