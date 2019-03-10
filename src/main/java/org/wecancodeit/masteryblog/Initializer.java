package org.wecancodeit.masteryblog;

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
		Tag funny = tagRepo.save(new Tag("Funny"));
		Tag sad = tagRepo.save(new Tag("Sad"));
		Tag epic = tagRepo.save(new Tag("Epic"));
		Tag helpful = tagRepo.save(new Tag("Helpful"));
		Tag unhelpful = tagRepo.save(new Tag("Unhelpful"));
		
		
		Category comics = categoryRepo.save(new Category("Comics"));
		Category movies = categoryRepo.save(new Category("Movies"));
		Category videoGames = categoryRepo.save(new Category("Video Games"));
		Category fishing = categoryRepo.save(new Category("Fishing"));
		
		Author jimJewell = authorRepo.save(new Author("Jim Jewell"));
		Author nateFritz = authorRepo.save(new Author("Nate Fritz"));
		
		Post testPost = postRepo.save(new Post("Black Ops 4", "I had to download this on PC because my son is always on the Xbox.  Last I checked, it was still downloading.", "Time", videoGames, jimJewell, funny, sad, epic));
		Post testPost2 = postRepo.save(new Post("Secret Warriors Omnibus Review", "This omnibus is worth every penny.  Collects the entire Secret Warriors run and tie-ins, with a plot that is more of a spy/thriller story than Marvel's typical super-hero stuff.  Highly recommend.", "Time", comics, nateFritz, epic));

	}	

	}
