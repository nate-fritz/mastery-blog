package org.wecancodeit.masteryblog;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.masteryblog.models.Post;
import org.wecancodeit.masteryblog.models.Tag;
import org.wecancodeit.masteryblog.repositories.PostRepository;
import org.wecancodeit.masteryblog.repositories.TagRepository;

@Service
public class Initializer implements CommandLineRunner {

	@Resource
	PostRepository postRepo;

	@Resource
	TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception {
		Tag funny = tagRepo.save(new Tag("funny"));
		Tag sad = tagRepo.save(new Tag("sad"));
		Tag epic = tagRepo.save(new Tag("epic"));

	}	

	}
