package org.wecancodeit.masteryblog.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.masteryblog.models.Author;
import org.wecancodeit.masteryblog.models.Post;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
	
	Author findByAuthor(String author);
	
	Optional<Post> findById(Post id);
}
