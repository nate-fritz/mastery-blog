package org.wecancodeit.masteryblog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.masteryblog.models.Post;

@Repository
public interface CategoryRepository extends CrudRepository<Post, Long> {

}
