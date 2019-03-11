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
		Tag funny = tagRepo.save(new Tag("Funny"));
		Tag sad = tagRepo.save(new Tag("Sad"));
		Tag epic = tagRepo.save(new Tag("Epic"));
		Tag interesting = tagRepo.save(new Tag("Interesting"));
		Tag helpful = tagRepo.save(new Tag("Helpful"));
		Tag unhelpful = tagRepo.save(new Tag("Unhelpful"));
		
		Category comics = categoryRepo.save(new Category("Comics"));
		Category movies = categoryRepo.save(new Category("Movies"));
		Category videoGames = categoryRepo.save(new Category("Video Games"));
		Category fishing = categoryRepo.save(new Category("Fishing"));
		Category sports = categoryRepo.save(new Category("Sports"));
		Category technology = categoryRepo.save(new Category("Technology"));
				

		Author jimJewell = authorRepo.save(new Author("Jim Jewell"));
		Author nateFritz = authorRepo.save(new Author("Nate Fritz"));
		Author jackHandey = authorRepo.save(new Author("Jack Handey"));
		
		Post testPost1 = postRepo.save(new Post("Deep Thoughts I", "Don't ever get your speedometer confused with your clock, like I did once, because the faster you go, the later you think you are", "1999", sports, jackHandey, funny, epic ));
        Post testPost2 = postRepo.save(new Post("Deep Thoughts II", "Before you criticize someone, you should walk a mile in their shoes. That way when you criticize them, you are a mile away from them and you have their shoes.", "1990", movies, jackHandey, funny));
        Post testPost3 = postRepo.save(new Post("Deep Thoughts III", "Sometimes it's hard to tell if something is actually a memory, or you just dreamed it. So I asked my boss if I called him a lying, stinking thief, or I just dreamed it, and he said I just dreamed it. Whew, that was close!", "1985", comics, jackHandey, funny));
        Post testPost4 = postRepo.save(new Post("Deep Thoughts IV", "During the Middle Ages, probably one of the biggest mistakes was not putting on your armor because you were just going down to the corner.", "time", technology, jackHandey, funny, sad));
        Post testPost5 = postRepo.save(new Post("Deep Thoughts V", "If we all just switched to cursive and stick shift cars, we could cripple an entire generation", "time", comics, jackHandey, funny, epic, helpful));
        Post testPost6 = postRepo.save(new Post("Fishing Trip", "Jim likes to fish.", "time", fishing, jimJewell, unhelpful));
        Post testPost7 = postRepo.save(new Post("Video Games", "I used to play video games, but then I enrolled into WCCI.", "time", videoGames, nateFritz, interesting, helpful));

	}	

	}
