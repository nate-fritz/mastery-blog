package org.wecancodeit.masteryblog;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.masteryblog.models.Author;
import org.wecancodeit.masteryblog.models.Category;
import org.wecancodeit.masteryblog.models.Post;
import org.wecancodeit.masteryblog.models.Tag;
import org.wecancodeit.masteryblog.repositories.AuthorRepository;
import org.wecancodeit.masteryblog.repositories.CategoryRepository;
import org.wecancodeit.masteryblog.repositories.PostRepository;
import org.wecancodeit.masteryblog.repositories.TagRepository;

@Service
public class Initializer implements CommandLineRunner {

	@Resource
	PostRepository postRepo;

	@Resource
	TagRepository tagRepo;
	
	@Resource
	CategoryRepository categoryRepo;
	
	@Resource
	AuthorRepository authorRepo;

	@Override
	public void run(String... args) throws Exception {
		Tag funny = tagRepo.save(new Tag("funny"));
		Tag sad = tagRepo.save(new Tag("sad"));
		Tag epic = tagRepo.save(new Tag("epic"));
		
		
		Category testCategory = categoryRepo.save(new Category("Test Category"));
		
		Author testAuthor = authorRepo.save(new Author("Test Author"));
		
		LocalDateTime dateTime = LocalDateTime.now();
		
		Post testPost = postRepo.save(new Post("String title", "String body", testCategory, testAuthor,   sad));

	}	

	}
