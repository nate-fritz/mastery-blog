package org.wecancodeit.masteryblog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.masteryblog.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
	
	Author findByAuthor(String author);
	

}
