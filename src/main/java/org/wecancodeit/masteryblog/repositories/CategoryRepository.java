package org.wecancodeit.masteryblog.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.masteryblog.models.Category;
import org.wecancodeit.masteryblog.models.Post;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	Category findByCategory(String category);
	
	Optional<Post> findById(Post id);
}
