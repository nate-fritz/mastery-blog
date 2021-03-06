package org.wecancodeit.masteryblog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.masteryblog.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	
	Tag findByTagLabel(String tagLabel);

}
