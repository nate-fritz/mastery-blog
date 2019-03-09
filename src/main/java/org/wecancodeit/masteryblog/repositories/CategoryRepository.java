package org.wecancodeit.masteryblog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.masteryblog.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	Category findByCategoryName(String categoryName);
}
