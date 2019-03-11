package org.wecancodeit.masteryblog.jpamappingstest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.masteryblog.repositories.TagRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class TagJpaTest {
	
	@Resource
	private TestEntityManager entityManager;

	@Resource 
	private TagRepository tagRepo;
	
	@Test
	public void shouldSaveAndLoadTag() {
	}
	}

